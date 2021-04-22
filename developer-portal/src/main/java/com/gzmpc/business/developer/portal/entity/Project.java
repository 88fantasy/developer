package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月21日 上午11:35:56
* 项目实体类
*/

@TableName("project")
public class Project implements Serializable {

	private static final long serialVersionUID = 8037774467727546254L;

	/**
	 * 项目 Id
	 */
	@TableId
	private String id;
	
	/**
	 * 项目名称
	 */
	@TableField
	@NotNull
	private String title;
	
	/**
	 * 项目 logo
	 */
	@TableField
	private String logo;
	
	/**
	 * 项目描述
	 */
	@TableField
	private String description;
	
	/**
	 * 项目动态更新时间
	 */
	@TableField
	private Date updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
