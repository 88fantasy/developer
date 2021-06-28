package org.exframework.business.developer.portal.dto;

/**
* @author rwe
* @version 创建时间：2021年5月1日 下午4:14:50
* 规则定义统计项
*/

public class RuleStatisticResponse {

	private RuleTypeCountResponse[] typeCount;
	
	private RuleTagCountResponse[] tagCount;

	public RuleTypeCountResponse[] getTypeCount() {
		return typeCount;
	}

	public void setTypeCount(RuleTypeCountResponse[] typeCount) {
		this.typeCount = typeCount;
	}

	public RuleTagCountResponse[] getTagCount() {
		return tagCount;
	}

	public void setTagCount(RuleTagCountResponse[] tagCount) {
		this.tagCount = tagCount;
	}
	
	
}
