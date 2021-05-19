package com.gzmpc.business.developer.rule.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyerControlMsg;
import com.gzmpc.business.developer.rule.rules.mapper.PubSupplyerControlMsgMapper;

/**
* @author dhx
* @version 创建时间：2021年5月7日 上午10:39:39
* 检查是否控制供应商，是则不通过zx_supplyer_controlmsg 仅有三个
*/

@RuleProperties(input = "supplyid", output = "controlMsgFlag", tags = {"控制供应商"})
@Rule(name = "检查是否控制供应商，是则不通过zx_supplyer_controlmsg 仅有三个", description = "查询supplyerControlMsg返回不为空时controlMsgFlag = true")
public class CheckSupplyMsgRule {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PubSupplyerControlMsgMapper pubSupplyerControlMsgMapper;

	@Condition
    public boolean isControl(@Fact("supplyid") long supplyid) {
		boolean controlStatus = false;
		PubSupplyerControlMsg control = pubSupplyerControlMsgMapper.selectOne(Wrappers.<PubSupplyerControlMsg>lambdaQuery()
				.eq(PubSupplyerControlMsg::getSupplyid, supplyid)
		);
		
		if(control != null) {
			controlStatus = control.isControlflag();
		}else {
			return false;
		}
		
		return controlStatus;
	}
	
	@Action
	public void doAction(Facts facts) {
		
	}
	
}
