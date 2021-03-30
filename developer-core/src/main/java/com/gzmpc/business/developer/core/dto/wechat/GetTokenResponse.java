package com.gzmpc.business.developer.core.dto.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:22:59 PM
* 类说明
*/

@ApiModel(value="获取app信息返回")
public class GetTokenResponse extends GlobalResponse {

	@ApiModelProperty(value = "掩码")
	private String token;
	
	private long expires;

	public GetTokenResponse() {
		super(0, "");
	}

	public GetTokenResponse(String token, long expires) {
		this();
		this.token = token;
		this.expires = expires;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}
	
	
}
