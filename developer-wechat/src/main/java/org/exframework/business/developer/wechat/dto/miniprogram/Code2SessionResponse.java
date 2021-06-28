package org.exframework.business.developer.wechat.dto.miniprogram;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 4, 2020 9:43:45 AM
* 登录返回
*/

@ApiModel(value="登录返回")
public class Code2SessionResponse extends GlobalResponse {

	@ApiModelProperty(value = "用户唯一标识")
	private String openid;
	
	@ApiModelProperty(value = "会话密钥")
	private String sessionKey;
	
	@ApiModelProperty(value = "用户在开放平台的唯一标识符")
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}
