package com.gzmpc.business.developer.rule.listener;

import java.util.Map;

import org.jeasy.rules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.gzmpc.business.developer.rule.annotation.RuleProperties;
import com.gzmpc.business.developer.rule.entity.RuleEntity;
import com.gzmpc.business.developer.rule.mapper.RuleMapper;

/**
* @author rwe
* @version 创建时间：2021年4月28日 下午4:04:10
* 读取注解到数据库
*/

@Repository
@DS("developer")
public class RuleAnnotationRefreshListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	RuleMapper ruleMapper;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(Rule.class);
		for(Map.Entry<String,Object> entry : beans.entrySet()) {
			String key = entry.getKey();
			Object o = entry.getValue();
			Class<?> clazz = o.getClass();
			Rule rule = clazz.getAnnotation(Rule.class);
			String ruleName = rule.name();
			String ruleDesc = rule.description();
			int rulePriority = rule.priority();
			
			
			RuleEntity entity = ruleMapper.selectById(key);
			if(entity != null) {
				entity.setName(ruleName);
				entity.setDescription(ruleDesc);
				entity.setPriority(rulePriority);
				setProperties(entity, clazz);
				ruleMapper.updateById(entity);
			}
			else {
				entity = new RuleEntity(key, ruleName, ruleDesc, rulePriority, RuleEntity.RuleType.CODE);
				entity.setAction(key);
				setProperties(entity, clazz);
				ruleMapper.insert(entity);
			}
			
		}
		
	}

	private void setProperties(RuleEntity entity, Class<?> clazz) {
		if(clazz.isAnnotationPresent(RuleProperties.class)) {
			RuleProperties properties = clazz.getAnnotation(RuleProperties.class);
			entity.setInput(properties.input());
			entity.setOutput(properties.output());
			entity.setTags(String.join(" ", properties.tags()));
		}
	}
}
