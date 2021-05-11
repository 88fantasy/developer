package com.gzmpc.business.developer.rule.rules;

import java.util.HashMap;
import java.util.Set;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.PubGoods;
import com.gzmpc.business.developer.rule.rules.entity.ZxCutPriceGoodsMsg;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBmsGoodsInfoMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxCheckGoodsMsgMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxChkUseStatusMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxPubGoodsMsgMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月11日 上午10:39:39
* 1 提示是否降价品种 。2提示该品种缺少24号令审批件和受理证明。3检查货品状态临时或作废都不通过。
*/

@RuleProperties(input = "goodsid", output = "cutPriceGoodsFlag", tags = {"降价品种", "审批和受理证明", "货品状态"})
@Rule(name = "检查货品品种", description = "1 提示是否降价品种 。2提示该品种缺少24号令审批件和受理证明。3检查货品状态临时或作废都不通过。")
public class CheckGoodsInfoRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
	ZxCheckGoodsMsgMapper zxCheckGoodsMsgMapper;
	
	@Autowired
	ZxPubGoodsMsgMapper zxPubGoodsMsgMapper;
	
	@Autowired
	ZxBmsGoodsInfoMapper zxBmsGoodsInfoMapper;
	
	@Autowired
	ZxChkUseStatusMapper zxChkUseStatusMapper;

	@Condition
    public boolean isUse(@Fact("goodsid") long goodsid, Facts facts) {
		boolean useStatus = false;
		
		//1 判断降价货品
		Integer count = zxCheckGoodsMsgMapper.selectCount(Wrappers.<ZxCutPriceGoodsMsg>lambdaQuery()
				.eq(ZxCutPriceGoodsMsg::getGoodsid, goodsid));
		if(count>0) {
			factsUtil.setMessage(facts, RuleConstants.RULE_TIPS_MESSAGE_KEY, "该品种是降价品种");
		}
		//2 检查货品状态
		PubGoods pubGoods = zxPubGoodsMsgMapper.selectOne(Wrappers.<PubGoods>lambdaQuery()
				.eq(PubGoods::getGoodsid, goodsid));
		if(pubGoods != null && pubGoods.isUsestatus()) {
			useStatus = true;
		}else {			
			//3 检查24号令审批件和受理证明
			HashMap resultMap = zxBmsGoodsInfoMapper.SelectApprovalDocuments(goodsid);
			Set keys = resultMap.keySet();
			Integer flag = null;String no01 = null;
			for(Object key : keys) {
				if(key.equals("FLAG")) {
					flag = Integer.parseInt(resultMap.get(key).toString());
				}
				if(key.equals("NO01")) {
					no01 = (String) resultMap.get(key);
				}
			}
			if(flag < 1 && no01.equals("01")) {
				factsUtil.setMessage(facts, RuleConstants.RULE_TIPS_MESSAGE_KEY, "该品种缺少24号令审批件和受理证明");
			}
			
			//4 检查货品状态临时或作废都不通过
			HashMap retcodeMap = zxChkUseStatusMapper.SelectRetcode(500050002l, 0);
			if(retcodeMap != null) {
				Set codekeys = retcodeMap.keySet();
				String actmsg = null;Integer retcode = null;
				for(Object key : codekeys) {
					if(key.equals("ACTMSG")) {
						actmsg = (String) retcodeMap.get(key);
					}
					if(key.equals("RETCODE")) {
						retcode = Integer.parseInt(retcodeMap.get(key).toString());
					}
				}
				if(retcode==1) {
					useStatus = true;
				}			
			}
		}
		
		
		return useStatus;
	}
	
	@Action
	public void doAction(Facts facts) {
		
	}
	
}
