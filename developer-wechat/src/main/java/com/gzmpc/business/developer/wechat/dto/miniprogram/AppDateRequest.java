package com.gzmpc.business.developer.wechat.dto.miniprogram;

import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.DateRange;

/**
* @author rwe
* @version 创建时间：2021年5月26日 上午11:34:33
* 小程序日期范围请求
*/

public class AppDateRequest {

	@NotNull
	private String appId;
	
	@NotNull
	private String date;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
