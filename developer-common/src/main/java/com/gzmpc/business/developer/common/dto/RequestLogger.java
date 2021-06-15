package com.gzmpc.business.developer.common.dto;

import java.util.Date;

/**
* @author rwe
* @version 创建时间：2021年6月11日 上午10:29:08
* 请求日志
*/

public class RequestLogger {

	private String method;
	
	private String uri;
	
	private String params;
	
	private Integer statusCode;
	
	private Long executeTime;
	
	private Date createTime;

	
	
	public RequestLogger() {
		
	}

	public RequestLogger(String method, String uri, String params, Integer statusCode, Long executeTime) {
		this.method = method;
		this.uri = uri;
		this.params = params;
		this.statusCode = statusCode;
		this.executeTime = executeTime;
		this.createTime = new Date();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Long getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Long executeTime) {
		this.executeTime = executeTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
