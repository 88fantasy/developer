package com.gzmpc.business.developer.admin.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年3月26日 下午5:49:13
* 路由网关
*/

@TableName("gateway_route")
public class GatewayRouteDO extends Editable implements Serializable {

	private static final long serialVersionUID = -2674991425092754350L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	
	@TableField
	@NotNull
  private String serviceId;

	@TableField
	@NotNull
  private String uri;

	@TableField
	@NotNull
  private String predicates;

	@TableField
  private String filters;

//	@TableField("")
//  private String order;

	@TableField
  private String remarks;

	@TableField
  private String delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPredicates() {
		return predicates;
	}

	public void setPredicates(String predicates) {
		this.predicates = predicates;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

//	public String getOrder() {
//		return order;
//	}
//
//	public void setOrder(String order) {
//		this.order = order;
//	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
  
}
