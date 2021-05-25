package com.gzmpc.business.developer.portal.dto;

import java.util.Date;

import com.gzmpc.business.developer.portal.entity.RuleInstance.RuleStatus;


/**
* @author rwe
* @version 创建时间：2021年5月19日 下午5:23:22
* 类说明
*/

public class RuleInstanceListResponse {
	
	private String id;

	private String name;
	
	private String description;
	
	private Integer priority;
	
	private RuleStatus status;
	
	private Date startTime;
	
	private Date endTime;
	
	private String input;
	
	private String output;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
