package com.gzmpc.business.developer.portal.dto;

import java.util.Date;
import com.gzmpc.business.developer.portal.dependency.RulePackageInstance.RuleStatus;

/**
* @author rwe
* @version 创建时间：2021年5月19日 上午10:33:36
* 规则执行记录列表返回
*/

public class RulePackageInstanceListResponse {

	private Long id;
	
	private String code;
	
	private String name;
	
	private RuleStatus status;
	
	private Date startTime;
	
	private Date endTime;
	
	private String ip;
	
	private String sourceId;

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
	
	
}
