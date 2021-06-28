package org.exframework.business.developer.portal.dto;

/**
* @author rwe
* @version 创建时间：2021年4月28日 下午6:40:57
* 规则包列表查询返回
*/

public class RulePackageListResponse {

	private String code;
	
	private String name;
	
	private String description;
	
	private Integer ruleCount;
	
	private Integer history;
	
	private Integer today;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRuleCount() {
		return ruleCount;
	}

	public void setRuleCount(Integer ruleCount) {
		this.ruleCount = ruleCount;
	}

	public Integer getHistory() {
		return history;
	}

	public void setHistory(Integer history) {
		this.history = history;
	}

	public Integer getToday() {
		return today;
	}

	public void setToday(Integer today) {
		this.today = today;
	}
	
	
}
