package com.gzmpc.business.developer.rule.rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.rules.entity.SysCp;
import com.gzmpc.business.developer.rule.rules.entity.ZxBusiControlDefDoc;
import com.gzmpc.business.developer.rule.rules.mapper.SysCpMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxBusiControlDefDocMapper;
import com.gzmpc.business.developer.rule.rules.mapper.ZxPubGoodsMsgMapper;
import com.gzmpc.business.developer.rule.util.FactsUtil;

/**
* @author dhx
* @version 创建时间：2021年5月13日 上午10:39:39
* 1检查有无经营范围，无则不通过2 检查对应证照是否过期，过期则不通过
*/

@RuleProperties(input = "cpid", output = "cutPriceGoodsFlag", tags = {"经营范围", "对应证照"})
@Rule(name = "检查经营范围", description = "1检查有无经营范围，无则不通过2 检查对应证照是否过期，过期则不通过")
public class CheckManageRangeRule {
	
	@Autowired
    FactsUtil factsUtil;
	
	@Autowired
	SysCpMapper sysCpMapper;
	
	@Autowired
	ZxPubGoodsMsgMapper zxPubGoodsMsgMapper;
	
	@Autowired
	ZxBusiControlDefDocMapper zxBusiControlDefDocMapper;
	
	@Condition
    public boolean isUse(@Fact("cpid") long cpid, Facts facts) {
		boolean useStatus = false;Long companyType = null;
		Map<String, Object> activeMap = facts.asMap();
		SysCp sysCp = sysCpMapper.selectOne(Wrappers.<SysCp>lambdaQuery()
                .eq(SysCp::getCpid, cpid));
		
		if(sysCp !=null && sysCp.getOpid() != null) {
			List<ZxBusiControlDefDoc> zxs = zxBusiControlDefDocMapper.SelectZxBusiControlDefDocByOpid(sysCp.getOpid());
			if(zxs != null && zxs.size()>0) {				
				for(ZxBusiControlDefDoc zx : zxs) {
					if(zx.getOptype() == 1) {
						if(activeMap.containsKey("usestatus")) {
							boolean usestatus = (boolean) activeMap.get("usestatus");
							if(!usestatus) {
								break;
							}
						}
					}
					if(activeMap.containsKey("goodsid")) {						
						Long goodsid = (Long) activeMap.get("goodsid");
						//检查该品种是否管理经营范围,1 对客户不管，2 对供应商不管，3 对所有单位不管
						HashMap retMap = zxPubGoodsMsgMapper.SelectChkJyfwFlagByGoodsid(goodsid);
						Set keys = retMap.keySet();
						String goodsname = null;String no01 = null;Integer chkjyfwflag = 0;
						for(Object key : keys) {
							if(key.equals("NO01")) {
								no01 = (String) retMap.get(key);
							}
							if(key.equals("GOODSNAME")) {
								goodsname = (String) retMap.get(key);
							}
							if(key.equals("CHKJYFWFLAG")) {
								chkjyfwflag = (Integer) retMap.get(key);
							}
						}
						if(zx.getCompanytype() == 2) {
							if(chkjyfwflag == 1 || chkjyfwflag == 3) {
								continue;
							}
						}else if(zx.getCompanytype() == 1) {
							if(chkjyfwflag == 2 || chkjyfwflag == 3) {
								continue;
							}
						}
						//客户经大众开票时，按大众商场的经营范围检查证照 zfx 2010-1-27
						/*boolean pfChkJyfw = false;
						if(!pfChkJyfw(goodsid,)) {
							useStatus = true;
						}*/
					}
				}
			}
		}
		
		// 以下是检查检验范围，对应证照的函数
		if(activeMap.containsKey("salesdtlid")) {
			Long salesdtlid = (Long) activeMap.get("salesdtlid");
	    }
		
		
		return useStatus;
	}

	@Action
	public void doAction(Facts facts) {
		
	}
	
}
