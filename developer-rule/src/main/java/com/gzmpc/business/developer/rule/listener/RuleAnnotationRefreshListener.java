package com.gzmpc.business.developer.rule.listener;

import java.util.Map;

import org.jeasy.rules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.gzmpc.business.developer.rule.entity.RuleEntity;
import com.gzmpc.business.developer.rule.mapper.RuleMapper;

/**
* @author rwe
* @version 创建时间：2021年4月28日 下午4:04:10
* 读取注解到数据库
*/

@Repository
public class RuleAnnotationRefreshListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	RuleMapper ruleMapper;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(Rule.class);
		for(Map.Entry<String,Object> entry : beans.entrySet()) {
			String key = entry.getKey();
			Object o = entry.getValue();
			Rule rule = o.getClass().getAnnotation(Rule.class);
			String ruleName = rule.name();
			String ruleDesc = rule.description();
			int rulePriority = rule.priority();
			
			RuleEntity entity = ruleMapper.selectById(key);
			if(entity != null) {
				entity.setName(ruleName);
				entity.setDescription(ruleDesc);
				entity.setPriority(rulePriority);
				ruleMapper.updateById(entity);
			}
			else {
				entity = new RuleEntity(key, ruleName, ruleDesc, rulePriority, RuleEntity.RuleType.CODE);
				ruleMapper.insert(entity);
			}
			
		}
		
	}

}
