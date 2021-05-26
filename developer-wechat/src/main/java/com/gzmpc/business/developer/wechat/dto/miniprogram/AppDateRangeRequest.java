package com.gzmpc.business.developer.wechat.dto.miniprogram;

import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.DateRange;

/**
* @author rwe
* @version 创建时间：2021年5月26日 上午11:34:33
* 小程序日期范围请求
*/

public class AppDateRangeRequest {

	@NotNull
	private String appId;
	
	@NotNull
	private DateRange request;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public DateRange getRequest() {
		return request;
	}

	public void setRequest(DateRange request) {
		this.request = request;
	}
	
	
}
