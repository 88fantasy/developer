package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月21日 下午1:33:45
* 项目成员表
*/

@TableName("project_member")
public class ProjectMember implements Serializable {

	private static final long serialVersionUID = 2123328216185191637L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	
	/**
	 * 项目主键
	 */
	@TableField
	@NotNull
	private String projectId;
	
	/**
	 * 帐号
	 */
	@TableField
	@NotNull
	private String account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
