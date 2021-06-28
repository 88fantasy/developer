package org.exframework.business.developer.portal.dto;

/**
* @author rwe
* @version 创建时间：2021年5月1日 下午4:16:07
* 类说明
*/

public class RuleTagCountResponse {

	private String tag;
	
	private Integer count;

	public RuleTagCountResponse() {
	}

	public RuleTagCountResponse(String tag, Integer count) {
		this.tag = tag;
		this.count = count;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
