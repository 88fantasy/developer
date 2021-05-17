package com.gzmpc.business.developer.rule;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

/**
 * @author rwe
 * @version 创建时间：2021年5月17日 上午10:12:40 
 * Spring Bean Rule
 */

public class SpBeanRule extends BasicRule {

	private Condition condition = Condition.FALSE;
	private final List<Action> actions = new ArrayList<>();

	public SpBeanRule(Object rule) {

	}

	public SpBeanRule name(String name) {
		this.name = name;
		return this;
	}

	public SpBeanRule description(String description) {
		this.description = description;
		return this;
	}

	public SpBeanRule priority(int priority) {
		this.priority = priority;
		return this;
	}

	@Override
	public boolean evaluate(Facts facts) {
		return condition.evaluate(facts);
	}

	@Override
	public void execute(Facts facts) throws Exception {
		for (Action action : actions) {
			action.execute(facts);
		}
	}
}
