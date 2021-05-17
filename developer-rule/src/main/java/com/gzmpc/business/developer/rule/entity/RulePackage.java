package com.gzmpc.business.developer.rule.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午1:37:29
* 规则包
*/

@TableName(value = "rule_package", autoResultMap = true)
public class RulePackage implements Serializable {

	private static final long serialVersionUID = 1043835579030499358L;

	@TableId(type = IdType.ASSIGN_ID)
	private String code;
	
	@TableField
	private String name;
	
	@TableField
	private String description;
	
	@TableField
	private Boolean skipOnFirstAppliedRule;
	
	@TableField
	private Boolean skipOnFirstFailedRule;
	
	@TableField
	private Boolean skipOnFirstNonTriggeredRule;
	
	@TableField
	private Integer rulePriorityThreshold;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	private List<String> tactics;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSkipOnFirstAppliedRule() {
		return skipOnFirstAppliedRule;
	}

	public void setSkipOnFirstAppliedRule(Boolean skipOnFirstAppliedRule) {
		this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
	}

	public Boolean getSkipOnFirstFailedRule() {
		return skipOnFirstFailedRule;
	}

	public void setSkipOnFirstFailedRule(Boolean skipOnFirstFailedRule) {
		this.skipOnFirstFailedRule = skipOnFirstFailedRule;
	}

	public Boolean getSkipOnFirstNonTriggeredRule() {
		return skipOnFirstNonTriggeredRule;
	}

	public void setSkipOnFirstNonTriggeredRule(Boolean skipOnFirstNonTriggeredRule) {
		this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
	}

	public Integer getRulePriorityThreshold() {
		return rulePriorityThreshold;
	}

	public void setRulePriorityThreshold(Integer rulePriorityThreshold) {
		this.rulePriorityThreshold = rulePriorityThreshold;
	}

	public List<String> getTactics() {
		return tactics;
	}

	public void setTactics(List<String> tactics) {
		this.tactics = tactics;
	}
	
	
}
