package com.gzmpc.business.developer.rule.rules;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.entity.ZxSupplyLicense;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerMapper;
import com.gzmpc.business.developer.rule.rules.mapper.SuCheckMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxSupplyLicenseMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
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
@Rule(name = "检查是否有法人委托书", description = "检查是否有法人委托书，检查是否存在有效期内的法人委托书，有委托书且在有效期内通过")
public class CheckLegalSupply  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PubSupplyerMapper pubSupplyerMapper;

    @Autowired
    SuCheckMapper suCheckMapper;

    @Autowired
    ZxSupplyLicenseMapper zxSupplyLicenseMapper;

    @Autowired
    FactsUtil factsUtil;

    @Condition
    public boolean isInvalid(Facts facts) {
        Map<String, Object> map = facts.asMap();
        if (map.containsKey("supplyid")) {
            Long supplyid = (Long) map.get("supplyid");

            Integer flag = zxSupplyLicenseMapper.selectCount(Wrappers.<ZxSupplyLicense>lambdaQuery()
                    .eq(ZxSupplyLicense::getLicenseid, 35)
                    .eq(ZxSupplyLicense::getCompanyid, supplyid));
            if (flag == 0) {
                factsUtil.setMessage(facts,RuleConstants.RULE_ERROR_MESSAGE_KEY,"该供应商无符合的法人委托书及受托人身份证的证照，不能做进货合同");
                return false;
            } else {
                    //检查是否存在有效期内的法人委托书
                Integer invalidFlag = zxSupplyLicenseMapper.selectCount(Wrappers.<ZxSupplyLicense>lambdaQuery()
                        .eq(ZxSupplyLicense::getLicenseid, 35)
                        .eq(ZxSupplyLicense::getCompanyid, supplyid).ge(ZxSupplyLicense::getLicenseend,new Date().getDate()));
               if (invalidFlag>0){
                   factsUtil.setMessage(facts,RuleConstants.RULE_ERROR_MESSAGE_KEY,"该品种最新的法人委托书及受托人身份证，已过证照有效日期，不能做进货合同");
                   return false;
               }
            }

        }
        return true;
    }

    @Action
    public void doAction(Facts facts) {
        logger.debug("成立");
    }
}
