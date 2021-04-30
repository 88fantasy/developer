package com.gzmpc.business.developer.rule.rules;

import java.util.Arrays;
import java.util.Date;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyLicenseMapper;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午10:39:39
* 进货合同，进货退出时检查证照
*/

@RuleProperties(input = "supplyid", output = "licenseInvalidFlag", tags = {"进货合同", "采购", "证照"})
@Rule(name = "进货合同，进货退出时检查证照", description = "超过有效期置licenseInvalidFlag = true")
public class CheckSupplyLicenseRule {
	
	@Autowired
	PubCompanyLicenseMapper pubCompanyLicenseMapper;

	@Condition
  public boolean isInvalid(@Fact("supplyid") long supplyid) {
		Integer count = pubCompanyLicenseMapper.selectCount(Wrappers.<PubCompanyLicense>lambdaQuery()
				.eq(PubCompanyLicense::getCompanyid, supplyid)
				.in(PubCompanyLicense::getLicenseid, Arrays.asList(0,1,2,4,6,7,30,35,41))
				.lt(PubCompanyLicense::getLicenseinvalidate, new Date()));
		return count > 0;
	}
	
	@Action
	public void doAction(Facts facts) {
		facts.put("licenseInvalidFlag", true);
	}
}
