package com.gzmpc.business.developer.portal.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月19日 下午1:35:05
* 类说明
*/

@ApiModel(value = "登录请求")
public class LoginResponse {

	@NotNull
	@ApiModelProperty(value = "登录结果", required = true)
	private String status;
	
	@ApiModelProperty(value = "token")
	private String token;
	
	@ApiModelProperty(value = "角色")
	private List<String> authority;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getAuthority() {
		return authority;
	}

	public void setAuthority(List<String> authority) {
		this.authority = authority;
	}
	
	
}
