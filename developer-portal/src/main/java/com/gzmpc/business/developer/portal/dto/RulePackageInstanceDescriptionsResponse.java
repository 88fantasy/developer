package com.gzmpc.business.developer.portal.dto;

import java.util.Date;

import com.gzmpc.business.developer.portal.dependency.RulePackageInstance.RuleStatus;

/**
* @author rwe
* @version 创建时间：2021年5月19日 上午11:40:33
* 类说明
*/

public class RulePackageInstanceDescriptionsResponse {

	private Long id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	private Boolean skipOnFirstAppliedRule;
	
	private Boolean skipOnFirstFailedRule;
	
	private Boolean skipOnFirstNonTriggeredRule;
	
	private Integer rulePriorityThreshold;
	
	private RuleStatus status;
	
	private Date startTime;
	
	private Date endTime;
	
	private String ip;
	
	private String sourceId;
	
	private String input;
	
	private String output;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public RuleStatus getStatus() {
		return status;
	}

	public void setStatus(RuleStatus status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
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
}
