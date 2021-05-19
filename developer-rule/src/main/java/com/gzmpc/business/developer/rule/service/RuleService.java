package com.gzmpc.business.developer.rule.service;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.SpBeanRule;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.spel.SpELRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.rule.entity.RulePackage;
import com.gzmpc.business.developer.rule.listener.RuleExecuteListener;
import com.gzmpc.business.developer.rule.listener.RulePackageListener;
import com.gzmpc.business.developer.rule.PackageWorker;
import com.gzmpc.business.developer.rule.entity.RuleEntity;
import com.gzmpc.business.developer.rule.entity.RuleEntity.RuleType;
import com.gzmpc.business.developer.rule.mapper.RuleMapper;
import com.gzmpc.business.developer.rule.mapper.RulePackageMapper;
import com.gzmpc.support.common.util.SpringContextUtils;
import com.gzmpc.support.rest.exception.ApiException;
import com.gzmpc.support.rest.exception.ServerException;

/**
 * @author rwe
 * @version 创建时间：2021年4月27日 下午1:53:07 类说明
 */

@Service
@DS("developer")
public class RuleService {

	@Autowired
	RuleMapper ruleMapper;

	@Autowired
	RulePackageMapper rulePackageMapper;

	
	@Autowired
	RuleExecutor ruleExcutor;
	
	@Autowired
	RulePackageListener rulePackageListener;
	
	@Autowired
	RuleExecuteListener ruleExecuteListener;

	public String submit(String sourceId, String packageCode, String json) {
		PackageWorker worker = getWorker(sourceId, packageCode, json);
		return ruleExcutor.excute(worker);
	}

	private PackageWorker getWorker(String sourceId, String packageCode, String json) {
		RulePackage pack = rulePackageMapper.selectById(packageCode);
		if (pack == null) {
			throw new ApiException();
		}
		RulesEngineParameters parameters = new RulesEngineParameters().priorityThreshold(pack.getRulePriorityThreshold())
				.skipOnFirstAppliedRule(pack.getSkipOnFirstAppliedRule()).skipOnFirstFailedRule(pack.getSkipOnFirstFailedRule())
				.skipOnFirstNonTriggeredRule(pack.getSkipOnFirstNonTriggeredRule());

		DefaultRulesEngine rulesEngine = new DefaultRulesEngine(parameters);
		rulePackageListener.setPack(pack);
		rulePackageListener.setSourceId(sourceId);
		rulesEngine.registerRulesEngineListener(rulePackageListener);
		rulesEngine.registerRuleListener(ruleExecuteListener);
		
		JSONObject o = JSON.parseObject(json);
		Facts facts = new Facts();
		for (String key : o.keySet()) {
			facts.put(key, o.get(key));
		}

		Rules rules = new Rules();
		List<String> tactics = pack.getTactics();
		if (tactics == null || tactics.size() == 0) {
			throw new ServerException("规则集中没有定义规则");
		}
		List<RuleEntity> ruleEntities = ruleMapper
				.selectList(Wrappers.<RuleEntity>lambdaQuery().in(RuleEntity::getCode, tactics));
		List<OrderedRule> orders = ruleEntities.stream()
				.map(entity -> new OrderedRule(entity, tactics.indexOf(entity.getCode()))).collect(Collectors.toList());
		List<Rule> ruleList = orders.stream().map(order -> {
			RuleEntity entity = order.getEntity();
			int priority = order.getPriority();
//				String code = entity.getCode();
			String name = entity.getName();
			String desc = entity.getDescription();

			String condition = entity.getExpression();
			List<String> actions = entity.getAction();
			if (actions == null || actions.size() == 0) {
				return EMPTY_RULE;
			}
			RuleType type = entity.getType();
			Rule r = EMPTY_RULE;
			switch (type) {
			case CODE:
				Object bean = SpringContextUtils.getBeanById(actions.get(0));
				SpBeanRule beanRule = new SpBeanRule(bean).name(name).description(desc).priority(priority);
				return beanRule;
			case SPEL:
				SpELRule spel = new SpELRule().name(name).description(desc).priority(priority).when(condition);
				for (String action : actions) {
					spel = spel.then(action);
				}
				return spel;
			case MVEL:
				MVELRule mvel = new MVELRule().name(name).description(desc).priority(priority).when(condition);
				for (String action : actions) {
					mvel = mvel.then(action);
				}
				return mvel;
			case GROUP:

			default:

			}
			return r;
		}).collect(Collectors.toList());
		rules.register(ruleList.toArray());
		
		return new PackageWorker(rulesEngine, facts, rules);
	}

	private static final Rule EMPTY_RULE = new Rule() {

		@Override
		public int compareTo(Rule o) {
			return 0;
		}

		@Override
		public boolean evaluate(Facts facts) {
			return true;
		}

		@Override
		public void execute(Facts facts) throws Exception {

		}

	};

	private class OrderedRule {
		private RuleEntity entity;
		private int priority;

		public OrderedRule(RuleEntity entity, int priority) {
			this.entity = entity;
			this.priority = priority;
		}

		public RuleEntity getEntity() {
			return entity;
		}

		public int getPriority() {
			return priority;
		}

	}
}
