package org.exframework.business.developer.portal.dto;


import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.exframework.business.developer.portal.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月19日 下午1:35:05
* 当前登录返回
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
	
	@ApiModelProperty(value = "岗位")
	private String title;
	
	@ApiModelProperty(value = "组织架构")
	private String group;
	
	@ApiModelProperty(value = "权限集")
	private List<String> permissions;
	
	
	public CurrentUserResponse() {
		
	}

	public CurrentUserResponse(@NotNull String userid, String name, String email) {
		this(userid, name, email, null, null);
	}
	
	
	
	public CurrentUserResponse(@NotNull String userid, String name, String email, String title, String group) {
		this(userid, name, email, title, group, null);
	}

	public CurrentUserResponse(@NotNull String userid, String name, String email, String title, String group,
			List<String> permissions) {
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.title = title;
		this.group = group;
		this.permissions = permissions;
	}

	public CurrentUserResponse(User account) {
		this.userid = account.getAccount();
		this.name = account.getUserName();
		this.email = account.getEmail();
		this.permissions = Arrays.asList("admin");
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	
	
	
}
