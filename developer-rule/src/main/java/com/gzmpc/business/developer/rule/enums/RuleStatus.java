package com.gzmpc.business.developer.rule.enums;

/**
 * @author rwe
 * @version 创建时间：2021年4月28日 下午2:21:13 类说明
 */

public enum RuleStatus {

	/**
	 * 初始
	 */
	INIT("初始"),

	/**
	 * 进行中
	 */
	PROCESSING("进行中"),

	/**
	 * 完成
	 */
	FINISHED("完成"),
	
	/**
	 * 失败
	 */
	FAILED("失败"),

	;

	private String label;

	private RuleStatus(String label) {
			this.label = label;
		}

	public String getLabel() {
		return label;
	}

}
