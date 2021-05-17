package com.gzmpc.business.developer.portal.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.portal.entity.RuleEntity.RuleType;


/**
 * @author rwe
 * @version 创建时间：2021年4月27日 下午1:22:59 
 * 规则 dto
 */

public class RuleDTO {

	@NotNull
	private String code;

	@NotNull
	private String name;

	private String description;

	private Integer priority;

	@NotNull
	private RuleType type;
	
	private String input;
	
	private String output;
	
	private String tags;

	private String expression;
	
	private List<String> action;

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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public RuleType getType() {
		return type;
	}

	public void setType(RuleType type) {
		this.type = type;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<String> getAction() {
		return action;
	}

	public void setAction(List<String> action) {
		this.action = action;
	}


}
