package com.gzmpc.business.developer.gateway.entity;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSON;

/**
 *
 * Author: rwe Date: 2021年3月25日
 *
 * Copyright @ 2021
 * 
 */
public class GatewayRoute {

	private Long id;

	private String serviceId;

	private String uri;

	private String predicates;

	private String filters;

	private Integer order;

	private String creatorId;

	private Date createDate;

	private String updateId;

	private Date updateDate;

	private String remarks;

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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

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

	public RouteDefinition toDefinition() {
		RouteDefinition definition = new RouteDefinition();
		Map<String, String> predicateParams = new HashMap<>(8);
		PredicateDefinition predicate = new PredicateDefinition();
		FilterDefinition filterDefinition = new FilterDefinition();
		Map<String, String> filterParams = new HashMap<>(8);

		URI uri = null;
		if (getUri().startsWith("http")) {
			// http地址
			uri = UriComponentsBuilder.fromHttpUrl(getUri()).build().toUri();
		} else {
			// 注册中心
			uri = UriComponentsBuilder.fromUriString("lb://" + getUri()).build().toUri();
		}

		definition.setId(getServiceId());
		// 名称是固定的，spring gateway会根据名称找对应的PredicateFactory
		predicate.setName("Path");
		predicateParams.put("pattern", getPredicates());
		predicate.setArgs(predicateParams);

		// 名称是固定的, 路径去前缀
		filterDefinition.setName("StripPrefix");
		filterParams.put("_genkey_0", "2");
		filterDefinition.setArgs(filterParams);

		definition.setPredicates(Arrays.asList(predicate));
		definition.setFilters(Arrays.asList(filterDefinition));
		definition.setUri(uri);
//		definition.setOrder(getOrder());

		return definition;
	}
	
	public static GatewayRoute fromDefinition(RouteDefinition definition) {
		GatewayRoute route = new GatewayRoute();
		route.setServiceId(definition.getId());
		route.setFilters(JSON.toJSONString(definition.getFilters()));
		route.setPredicates(JSON.toJSONString(definition.getPredicates()));
		route.setUri(definition.getUri().toString());
		route.setOrder(definition.getOrder());
		return route;
	}
}
