package com.gzmpc.business.developer.portal.dto;

import javax.validation.constraints.NotNull;

/**
 * @author rwe
 * @version 创建时间：2021年3月27日 上午10:28:51 
 * 路由 DTO
 */

public class GatewayRouteDTO {

	private String id;

	@NotNull
	private String serviceId;

	@NotNull
	private String uri;

	@NotNull
	private String predicates;

	private String filters;

	private String order;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
