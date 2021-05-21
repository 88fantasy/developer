package com.gzmpc.business.developer.rule.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.BmsSuConDtl;
import com.gzmpc.business.developer.rule.rules.mapper.BmsSuConDtlMapper;
import com.gzmpc.business.developer.rule.rules.mapper.PubCompanyLicenseMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月10日 上午10:39:39
* 检查当前品种和供应商的历史进货合同，实际来货单位是否为空，
* 非空则回填委托配送协议细单ID和来货单位
*/

@RuleProperties(input = "supplyid,goodsid", output = "inItemUnitFlag", tags = {"品种, 供应商", "实际来货单位"})
@Rule(name = "检查当前品种和供应商的历史进货合同", description = "检查当前品种和供应商的历史进货合同，实际来货单位是否为空，非空则回填委托配送协议细单ID和来货单位")
public class CheckSupplyHistoryDocuRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
	BmsSuConDtlMapper bmsSuConDtlMapper;
	
	@Autowired
	PubCompanyLicenseMapper pubCompanyLicenseMapper;

	@Condition
    public boolean isInvalid(@Fact("supplyid") long supplyId, @Fact("goodsid") long goodsId ,Facts facts) {
		boolean inItemUnitFlag = false;
		
		BmsSuConDtl dtl = bmsSuConDtlMapper.CheckSupplyHistoryDocu(supplyId, goodsId);
		if(dtl != null) {
			if(dtl.getWtpsDtlid() == 0) {
				inItemUnitFlag = true;
			}else {
				if(dtl.getWtpsDtlid() != null) {
					facts.put("wtps_dtlid", dtl.getWtpsDtlid());
				}
				if(dtl.getRealrgcompany() != null) {
					facts.put("realrgcompany", dtl.getRealrgcompany());	
				}
				inItemUnitFlag = true;
			}
		}else {
			factsUtil.setMessage(facts,RuleConstants.RULE_ERROR_MESSAGE_KEY,"历史进货合同的数据为空!");
		}
		
		return inItemUnitFlag;
	}
	
	@Action
	public void doAction(Facts facts) {
		
	}
	
}
