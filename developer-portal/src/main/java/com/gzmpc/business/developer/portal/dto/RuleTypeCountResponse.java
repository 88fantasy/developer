package com.gzmpc.business.developer.portal.dto;

import com.gzmpc.business.developer.portal.entity.RuleEntity.RuleType;

/**
* @author rwe
* @version 创建时间：2021年5月1日 下午12:20:47
* 类说明
*/

public class RuleTypeCountResponse {

	private RuleType type;
	
	private Integer count;

	
	public RuleTypeCountResponse() {
		super();
	}

	public RuleTypeCountResponse(RuleType type, Integer count) {
		super();
		this.type = type;
		this.count = count;
	}

	public RuleType getType() {
		return type;
	}

	public void setType(RuleType type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setTypeCount(Integer count) {
		this.count = count;
	}

	
}
