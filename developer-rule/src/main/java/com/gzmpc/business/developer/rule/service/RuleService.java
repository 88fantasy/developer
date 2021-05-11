package com.gzmpc.business.developer.rule.service;

import java.util.Date;
import java.util.List;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.spel.SpELRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.entity.RulePackage;
import com.gzmpc.business.developer.rule.entity.RulePackageInstance;
import com.gzmpc.business.developer.rule.entity.RulePackageInstance.RuleStatus;
import com.gzmpc.business.developer.rule.entity.RulePackageTactics;
import com.gzmpc.business.developer.rule.entity.RuleEntity;
import com.gzmpc.business.developer.rule.entity.RuleEntity.RuleType;
import com.gzmpc.business.developer.rule.mapper.RuleMapper;
import com.gzmpc.business.developer.rule.mapper.RulePackageInstanceMapper;
import com.gzmpc.business.developer.rule.mapper.RulePackageMapper;
import com.gzmpc.business.developer.rule.mapper.RulePackageTacticsMapper;
import com.gzmpc.support.common.util.SpringContextUtils;
import com.gzmpc.support.rest.exception.ApiException;

/**
* @author rwe
* @version 创建时间：2021年4月27日 下午1:53:07
* 类说明
*/

@Service
@DS("developer")
public class RuleService  {
	
	@Autowired
	RuleMapper ruleMapper;
	
	@Autowired
	RulePackageTacticsMapper rulePackageTacticsMapper;
	
	@Autowired
	RulePackageMapper rulePackageMapper;
	
	@Autowired
	RulePackageInstanceMapper rulePackageInstanceMapper;
	
	public String submit(String packageCode, String json) {
		RulePackage pack = rulePackageMapper.selectById(packageCode);
		if(pack != null ) {
			JSONObject o = JSON.parseObject(json);
			Facts facts = new Facts();
			for(String key : o.keySet()) {
				facts.put(key, o.get(key));
			}
			RulesEngineParameters parameters = new RulesEngineParameters()
			    .priorityThreshold(pack.getRulePriorityThreshold())
			    .skipOnFirstAppliedRule(pack.getSkipOnFirstAppliedRule())
			    .skipOnFirstFailedRule(pack.getSkipOnFirstFailedRule())
			    .skipOnFirstNonTriggeredRule(pack.getSkipOnFirstNonTriggeredRule());
			    
			DefaultRulesEngine rulesEngine = new DefaultRulesEngine(parameters);
			rulesEngine.registerRulesEngineListener(new RulesEngineListener() {
				
				private RulePackageInstance ins = null;
				
				@Override
				public void beforeEvaluate(Rules rules, Facts facts) {
					RulePackageInstance instance = new RulePackageInstance();
					instance.setCode(packageCode);
					instance.setName(pack.getName());
					instance.setDescription(pack.getDescription());
					instance.setRulePriorityThreshold(pack.getRulePriorityThreshold());
					instance.setSkipOnFirstAppliedRule(pack.getSkipOnFirstAppliedRule());
					instance.setSkipOnFirstFailedRule(pack.getSkipOnFirstFailedRule());
					instance.setSkipOnFirstNonTriggeredRule(pack.getSkipOnFirstNonTriggeredRule());
					instance.setStatus(RuleStatus.PROCESSING);
					instance.setStartTime(new Date());
					rulePackageInstanceMapper.insert(instance);
					ins = instance;
				}

				@Override
				public void afterExecute(Rules rules, Facts facts) {
					if(ins != null) {
						ins.setStatus(RuleStatus.FINISHED);
						ins.setEndTime(new Date());
						rulePackageInstanceMapper.updateById(ins);
					}
				}
				
			});
			
			Rules rules = new Rules();
			
			List<RulePackageTactics> tactics = rulePackageTacticsMapper.selectList(Wrappers.<RulePackageTactics>lambdaQuery().eq(RulePackageTactics::getRuleCode, packageCode));
			List<RuleEntity> ruleEntities = ruleMapper.selectList(Wrappers.<RuleEntity>lambdaQuery().in(RuleEntity::getCode, tactics.stream().map(RulePackageTactics::getRuleCode)));
			ruleEntities.forEach(entity -> {
				String code = entity.getCode();
				String name = entity.getName();
				String desc = entity.getDescription();
				
				RulePackageTactics tmp = new RulePackageTactics();
				tmp.setPriority(entity.getPriority());
				Integer priority = tactics.stream().filter(tactic -> tactic.getRuleCode().equals(code)).findFirst().orElse(tmp).getPriority();
				String condition = entity.getExpression();
				String action = entity.getAction();
				RuleType type = entity.getType();
				Object r = null;
				switch(type) {
					case CODE:
						r = SpringContextUtils.getBeanById(action);
						break;
					case SPEL:
						r = new SpELRule()
								.name(name)
								.description(desc)
								.priority(priority)
								.when(condition)
								.then(action);
						break;
					case MVEL:
						r = new MVELRule()
							.name(name)
							.description(desc)
							.priority(priority)
							.when(condition)
							.then(action);
					case GROUP:
						
					default:
						
				}
				if(r != null) {
					rules.register(r);
				}
			});
			rulesEngine.fire(rules, facts);
			
			return JSON.toJSONString(facts);
		}
		throw new ApiException("找不到规则包");
	}

}
