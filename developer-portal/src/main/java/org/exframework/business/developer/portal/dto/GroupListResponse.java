package org.exframework.business.developer.portal.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年6月18日 上午10:41:10
* 用户组列表请求
*/

@ApiModel(value = "用户组列表请求")
public class GroupListResponse {

	@ApiModelProperty(value = "用户组Id")
	private Long id;
	
	@ApiModelProperty(value = "用户组名称")
	private String name;
	
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
