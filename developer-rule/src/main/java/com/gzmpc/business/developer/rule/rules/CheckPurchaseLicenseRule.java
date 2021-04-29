package com.gzmpc.business.developer.rule.rules;


import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.entity.PubDdl;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyLicenseMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubDdlMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerMapper;

/**
 * @author rwe
 * @version 创建时间：2021年4月24日 下午10:39:39 进货合同，进货退出时检查证照
 */

@Rule(name = "进货合同，进货退出时检查证照", description = "输入supplyid, 供应商性质不是\"非药品生产企业\"或\"非药品经营企业\"的，"
		+ "需同时具备证照类型为《税务登记证》、《相关印章样式》、《随货同行单（票）样式》和《开户信息》才能进行购进业务")
public class CheckPurchaseLicenseRule {

	@Autowired
	PubSupplyerMapper pubSupplyerMapper;
	
	@Autowired
	PubDdlMapper pubDdlMapper;
	
	@Autowired
	PubCompanyLicenseMapper pubCompanyLicenseMapper;

	@Condition
	public boolean isInvalid(Facts facts) {
		if(facts.asMap().containsKey("supplyid")) {
			Long supplyid = facts.get("supplyId");
			PubSupplyer supplyer = pubSupplyerMapper.selectById(supplyid);
			String no05 = supplyer.getNo05();
			if("09".equals(no05) || "10".equals(no05)) {
				return true;
			}
			
			List<Long> licenseIds = Arrays.asList(48l,49l,50l,33l);
	
			
			List<PubCompanyLicense> list = pubCompanyLicenseMapper.selectList(Wrappers.<PubCompanyLicense>lambdaQuery()
					.eq(PubCompanyLicense::getCompanyid, supplyid)
					.in(PubCompanyLicense::getLicenseid, licenseIds));
			
			if(list.size() != licenseIds.size()) {
			
				List<PubDdl> ddls = pubDdlMapper.selectList(Wrappers.<PubDdl>lambdaQuery()
						.select(PubDdl::getDdlname)
						.in(PubDdl::getDdlid, licenseIds)
						.eq(PubDdl::getKeyword, "ZX_PUB_COMPANY_LICENSE")
						.notIn(PubDdl::getDdlid, list.stream().mapToLong(license -> license.getLicenseid()))
						);
				List<String> errors = (List<String>) facts.getFact(RuleConstants.RULE_ERROR_MESSAGE_KEY);
				List<String> ddlNames = ddls.stream().map(ddl -> MessageFormat.format("<{0}>", ddl.getDdlname())).collect(Collectors.toList());
				errors.add("供应商缺少证照："+String.join(",", ddlNames.toArray(new String[ddlNames.size()]))+"。不能进行购进业务，请咨询质量部。");
				facts.put(RuleConstants.RULE_ERROR_MESSAGE_KEY, errors);
				return false;
			}
		}
		
		return true;
	}

	@Action
	public void doAction(Facts facts) {

	}
}
