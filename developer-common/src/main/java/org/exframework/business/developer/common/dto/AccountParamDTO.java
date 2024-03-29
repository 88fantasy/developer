package org.exframework.business.developer.common.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 16, 2020 10:46:37 AM
* 保存参数DTO
*/

@ApiModel(value = "帐号参数DTO")
public class AccountParamDTO extends ParamDTO {

	@ApiModelProperty(value = "帐号", required = true)
	@NotNull
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	
}
