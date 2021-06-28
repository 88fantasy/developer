package org.exframework.business.developer.portal.dto;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月21日 下午2:01:42
* 项目列表返回
*/

@ApiModel(value = "项目列表返回")
public class ProjectResponse {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private String id;
	
	/**
	 * 项目名称
	 */
	@ApiModelProperty(value = "项目名称")
	private String title;
	
	/**
	 * 项目图标
	 */
	@ApiModelProperty(value = "项目图标")
	private String logo;
	
	/**
	 * 项目描述
	 */
	@ApiModelProperty(value = "项目描述")
	private String description;
	
	/**
	 * 项目动态更新时间
	 */
	@ApiModelProperty(value = "项目动态更新时间")
	private Date updatedAt;
	
	/**
	 * 项目成员
	 */
	@ApiModelProperty(value = "项目成员")
	private List<String> members;

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

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	
}
