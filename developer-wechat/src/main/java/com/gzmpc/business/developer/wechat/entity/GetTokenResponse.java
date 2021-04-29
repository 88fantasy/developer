package com.gzmpc.business.developer.wechat.entity;

import java.io.Serializable;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;


/**
* @author rwe
* @version 创建时间：Sep 21, 2020 10:47:15 AM
* 获取 token 返回信息
*/

public class GetTokenResponse extends GlobalResponse implements Serializable {

	private static final long serialVersionUID = -5771815579141745744L;
	
	private String accessToken;
	
	private Long expiresIn;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
