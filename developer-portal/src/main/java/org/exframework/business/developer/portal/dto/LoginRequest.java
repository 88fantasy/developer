package org.exframework.business.developer.portal.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月19日 下午1:22:38
* 登录请求
*/

@ApiModel(value = "登录请求")
public class LoginRequest {

	@NotNull
	@ApiModelProperty(value = "帐号", required = true)
	private String userName;
	
	@NotNull
	@ApiModelProperty(value = "密码", required = true)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
