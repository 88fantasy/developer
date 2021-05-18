package com.gzmpc.business.developer.rule.rules;

import java.util.Map;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.rules.entity.PubCompany;
import com.gzmpc.business.developer.rule.rules.entity.PubCustomer;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubCustomerMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerMapper;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午5:27:37
* 检查主数据使用状态
*/

@RuleProperties(input = "customid 或 supplyid 或 conpanyid", tags = {"主数据"})
@Rule(name = "检查主数据使用状态", description = "检查 usestatus")
public class CheckUseStatusRule {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PubCustomerMapper pubCustomerMapper;
	
	@Autowired
	PubCompanyMapper pubCompanyMapper;
	
	@Autowired
	PubSupplyerMapper pubSupplyerMapper;

	@Condition
  public boolean containsKey(Facts facts) {
		Map<String, Object> map = facts.asMap();
		int useStatus = -1;
		if(map.containsKey("customid")) {
			String customid = map.get("customid").toString();
			PubCustomer customer = pubCustomerMapper.selectOne(Wrappers.<PubCustomer>lambdaQuery().eq(PubCustomer::getCustomid, customid));
			if(customer != null) {
				useStatus = customer.getUsestatus();
			}
			else {
				return false;
			}
		}
		if(map.containsKey("supplyid")) {
			String supplyid = map.get("supplyid").toString();
			PubSupplyer supply = pubSupplyerMapper.selectOne(Wrappers.<PubSupplyer>lambdaQuery().eq(PubSupplyer::getSupplyid, supplyid));
			if(supply != null) {
				useStatus = supply.getUsestatus();
			}
			else {
				return false;
			}
		}
		if(map.containsKey("companyid")) {
			String companyid = map.get("companyid").toString();
			PubCompany company = pubCompanyMapper.selectOne(Wrappers.<PubCompany>lambdaQuery().eq(PubCompany::getCompanyid, companyid));
			if(company != null) {
				useStatus = company.getUsestatus();
			}
			else {
				return false;
			}
		}
		if(useStatus == 1) {
			return true;
		}
		else {
			return false;
		}
  }
	
  @Action
  public void doAction(Facts facts) {
  	logger.debug("成立");
  }
}
