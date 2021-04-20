package com.gzmpc.business.developer.portal.dto;


import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.portal.entity.Person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月19日 下午1:35:05
* 类说明
*/

@ApiModel(value = "当前登录返回")
public class CurrentUserResponse {

	@NotNull
	@ApiModelProperty(value = "帐号", required = true)
	private String userid;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "邮箱")
	private String email;
	
	public CurrentUserResponse() {
		
	}

	public CurrentUserResponse(@NotNull String userid, String name, String email) {
		this.userid = userid;
		this.name = name;
		this.email = email;
	}
	
	public CurrentUserResponse(Person person) {
		this.userid = person.getCommonName();
		this.name = person.getDescription();
		this.email = person.getMail();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
