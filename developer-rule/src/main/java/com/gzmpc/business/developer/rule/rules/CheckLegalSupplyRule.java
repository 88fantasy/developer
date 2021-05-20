package com.gzmpc.business.developer.rule.rules;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.entity.ZxCompanyLoseLicense;
import com.gzmpc.business.developer.rule.rules.entity.ZxSupplyLicense;
import com.gzmpc.business.developer.rule.rules.mapper.*;
import com.gzmpc.business.developer.rule.util.FactsUtil;
import io.swagger.models.auth.In;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author yjf
 * @version 创建时间：2021年5月7日 下午5:27:37
 * 检查是否有法人委托书，检查是否存在有效期内的法人委托书，有委托书且在有效期内通过
 */

@RuleProperties(input = " supplyid 或 conpanyid", tags = {"证照"})
@Rule(name = "检查是否有法人委托书和证照是否过期", description = "1检查是否有法人委托书。2检查是否存在有效期内的法人委托书，有委托书且在有效期内通过。3 检查30日内过期的证照 判断过期的证照中是否有与货品关联的证照 。4 有不关联货品的证照失效，判断是否需要限制，需要限制且过期则不通过。")
public class CheckLegalSupplyRule {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PubSupplyerMapper pubSupplyerMapper;

    @Autowired
    SuCheckMapper suCheckMapper;

    @Autowired
    ZxSupplyLicenseMapper zxSupplyLicenseMapper;

    @Autowired
    FactsUtil factsUtil;

    @Autowired
    ZxCompanyLoseLicenseMapper zxCompanyLoseLicenseMapper;

    @Autowired
    PubCompanyLicenseMapper pubCompanyLicenseMapper;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map<String, Object> map = facts.asMap();
        if (map.containsKey("supplyid")) {
            Long supplyid = (Long) map.get("supplyid");

            Integer flag = zxSupplyLicenseMapper.selectCount(Wrappers.<ZxSupplyLicense>lambdaQuery()
                    .eq(ZxSupplyLicense::getLicenseid, 35)
                    .eq(ZxSupplyLicense::getCompanyid, supplyid));
            if (flag == 0) {
                factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, "该供应商无符合的法人委托书及受托人身份证的证照，不能做进货合同");
                return false;
            } else {
                //检查是否存在有效期内的法人委托书
                Integer invalidFlag = zxSupplyLicenseMapper.selectCount(Wrappers.<ZxSupplyLicense>lambdaQuery()
                        .eq(ZxSupplyLicense::getLicenseid, 35)
                        .eq(ZxSupplyLicense::getCompanyid, supplyid).ge(ZxSupplyLicense::getLicenseend, LocalDate.now()));
                if (invalidFlag > 0) {
                    factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, "该品种最新的法人委托书及受托人身份证，已过证照有效日期，不能做进货合同");
                    return false;
                }
            }

            Integer noChkLicenseId = -1;
            Integer companyType = 1;
            //以单位证照检查结果为依据
            Integer rowcount = zxCompanyLoseLicenseMapper.selectCount(Wrappers.<ZxCompanyLoseLicense>lambdaQuery()
                    .eq(ZxCompanyLoseLicense::getCompanyid, supplyid).eq(ZxCompanyLoseLicense::getCompanyflag, companyType).ne(ZxCompanyLoseLicense::getLicenseid, noChkLicenseId));


            //30日内过期的证照 add by gzw 20141208
            Integer rowcount2 = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>query().eq("companyid", supplyid)
                    .notIn("licenseid", Arrays.asList(35, 52))
                    .ne("licenseid", noChkLicenseId).le("trunc(nvl(licenseinvalidate,sysdate-1))", LocalDate.now().plusDays(30)));

            Integer rowcount3 = zxSupplyLicenseMapper.selectCount(Wrappers.<ZxSupplyLicense>query().eq("companyid", supplyid)
                    .in("licenseid", Arrays.asList(35, 52))
                    .ne("licenseid", noChkLicenseId).between("(trunc(licenseinvalidate))", LocalDate.now().plusDays(-180), LocalDate.now().plusDays(30)));


            //判断过期的证照中是否有与货品关联的证照
            Integer noGoodsFlag = pubCompanyLicenseMapper.countValidLicenseNum(supplyid, companyType, noChkLicenseId);

            if (rowcount > 0 || rowcount2 > 0 || rowcount3 > 0) {
                List<Long> licenseIds = pubCompanyLicenseMapper.getCheckLicenseId(supplyid, companyType, noChkLicenseId);
                List licenseInfo = licenseIds != null && licenseIds.size() > 0 ? pubCompanyLicenseMapper.getCheckLicenseInfo(supplyid, licenseIds) : null;
                facts.put("licenseInvalidInfo",licenseInfo);
            }

        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {
        logger.debug("成立");
    }
}
