package com.gzmpc.business.developer.rule.rules;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyLicenseMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月8日 上午10:39:39
* 检查供应商是否有证照经营期限为空，是则不通过
*/

@RuleProperties(input = "supplyid", output = "licenseTermFlag", tags = {"检查供应商","经营期限"})
@Rule(name = "检查供应商是否有证照经营期限为空，是则不通过", description = "查询(并使用sysdate对比)pubCompanyLicense中的licenseend,限期内使licenseTermFlag = true")
public class CheckSupplyLicenseTermRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
    PubSupplyerMapper pubSupplyerMapper;
	
	@Autowired
	PubCompanyLicenseMapper pubCompanyLicenseMapper;

	@Condition
    public boolean isInvalid(@Fact("supplyid") long supplyid,Facts facts) {
		boolean licenseTermFlag = false;
		//1 校验供应商编码
		Integer supply = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>lambdaQuery().eq(PubCompanyLicense::getCompanyid, supplyid));
		if (supply != null && supply >0) {
			//2 查询经营期限
			Integer count = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>lambdaQuery()
					.eq(PubCompanyLicense::getCompanyid, supplyid)
					.in(PubCompanyLicense::getLicenseid, Arrays.asList(0,1,2,4,36,35,41))
					.isNull(PubCompanyLicense::getLicenseend));
			if(count > 0) {
				factsUtil.setMessage(facts,RuleConstants.RULE_TIPS_MESSAGE_KEY,"该供应商有证照经营期限为空，请检查");
			}else {
				//3 对比经营期限
				Date now = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, 30);
				Date renow = cal.getTime();
				
				Integer sysdateCount = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>lambdaQuery()
						.eq(PubCompanyLicense::getCompanyid, supplyid)
						.in(PubCompanyLicense::getLicenseid, Arrays.asList(0,1,2,4,36,35,41))
						.lt(PubCompanyLicense::getLicenseend, now));
				
				Integer endDateCount = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>lambdaQuery()
						.eq(PubCompanyLicense::getCompanyid, supplyid)
						.in(PubCompanyLicense::getLicenseid, Arrays.asList(0,1,2,4,36,35,41))
						.lt(PubCompanyLicense::getLicenseend, renow));
				if(sysdateCount > 0) {
					//经营期限外
					licenseTermFlag = false;
				}else if(sysdateCount <= 0 && endDateCount > 0) {
					//30天近效期提示
					factsUtil.setMessage(facts,RuleConstants.RULE_TIPS_MESSAGE_KEY,"该供应商的证照的有效期即将到期，请尽快向对方索取新的相关证明!");
					licenseTermFlag = true;
				}else {
					//经营期限内
					licenseTermFlag = true;
				}
			}
        }else {
        	factsUtil.setMessage(facts,RuleConstants.RULE_TIPS_MESSAGE_KEY,"供应商编码无效!");
        }
		return licenseTermFlag;
	}
	
	@Action
	public void doAction(Facts facts) {
		
	}
	
}
