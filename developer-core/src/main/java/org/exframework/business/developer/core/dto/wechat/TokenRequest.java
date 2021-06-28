package org.exframework.business.developer.core.dto.wechat;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 6, 2020 1:45:45 PM
* 类说明
*/

@ApiModel(value="获取租户 token 请求")
public class TokenRequest {

	@ApiModelProperty(value = "租户id")
	@NotNull( message = "租户id不能为空" )
	private String tenantId;
	
	@ApiModelProperty(value = "密钥")
	@NotNull( message = "密钥不能为空" )
	private String secret;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
}
