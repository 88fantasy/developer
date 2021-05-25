package com.gzmpc.business.developer.wechat.dto.miniprogram;

import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetRetainClientRequest;

/**
* @author rwe
* @version 创建时间：2021年5月23日 上午11:57:23
* 类说明
*/

public class GetRetainRequest {

	@NotNull
	private String appId;
	
	@NotNull
	private GetRetainClientRequest request;

	@NotNull
	private RetainType type;
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public GetRetainClientRequest getRequest() {
		return request;
	}

	public void setRequest(GetRetainClientRequest request) {
		this.request = request;
	}
	
	public RetainType getType() {
		return type;
	}

	public void setType(RetainType type) {
		this.type = type;
	}


	public enum RetainType {
		DAILY,
		WEEKLY,
		MONTHLY;
	}
}
