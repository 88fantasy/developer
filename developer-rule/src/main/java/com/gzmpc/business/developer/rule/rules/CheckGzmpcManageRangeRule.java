package com.gzmpc.business.developer.rule.rules;

import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.constant.RuleConstants;
import com.gzmpc.business.developer.rule.rules.entity.ZxBusiControlDefDoc;
import com.gzmpc.business.developer.rule.rules.entity.ZxManageRange;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBusiControlDefDocMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxManageRangeMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxPubGoodsMsgMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月13日 上午10:39:39
* 检查我司经营范围，有则通过
*/

@RuleProperties(input = "companyid", output = "manageRangeFlag", tags = {"经营范围", "gzmpc"})
@Rule(name = "检查经营范围", description = "检查我司经营范围，有则通过")
public class CheckGzmpcManageRangeRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
	ZxManageRangeMapper zxManageRangeMapper;
	
	@Autowired
	ZxPubGoodsMsgMapper zxPubGoodsMsgMapper;
	
	@Autowired
	ZxBusiControlDefDocMapper zxBusiControlDefDocMapper;
	
	@Condition
    public boolean isUse(@Fact("companyid") long companyid, @Fact("goodsid") long goodsid, @Fact("no01") String no01, Facts facts) {
		boolean status = false;
		Integer flag = null;Integer controlFlag = null;
		//环节控制
		ZxBusiControlDefDoc zxBusiControlDefDoc = zxBusiControlDefDocMapper.SelectGzmpcZxBusiControlDefDocByOpid(1623l);
		if(zxBusiControlDefDoc != null) {
			controlFlag = zxBusiControlDefDoc.getControlflag();
		}
		
		//检查经营范围
		List<ZxManageRange> results = zxManageRangeMapper.SelectZxManageRange(companyid, no01);
		if(results !=null && results.size() > 0) {
			for(ZxManageRange result : results) {
				String jyfw = result.getJyfw(); 
				Long jyfwId = result.getJyfwid();
				flag = zxPubGoodsMsgMapper.SelectPubGoodsByGoodsid(jyfw, jyfwId, goodsid);
			}
			if(flag > 0) {
				status = true;
			}else {
				factsUtil.setMessage(facts, RuleConstants.RULE_ERROR_MESSAGE_KEY, "该品种不在我司的经营范围内!");
				if(controlFlag == 1) {
					status = false;
				}else {
					status = true;
				}
			}
		}
		
		return status;
	}

	@Action
	public void doAction(Facts facts) {
		
	}
	
}
