package com.gzmpc.business.developer.admin.entity;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 业务参数 DO
 * @author pro
 *
 */
@TableName("account-param")
public class AccountParamDO extends ParamDO {

	private static final long serialVersionUID = -471441775045046642L;
	
	@TableField
	@NotNull
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
