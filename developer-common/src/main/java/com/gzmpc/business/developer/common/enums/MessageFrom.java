package com.gzmpc.business.developer.common.enums;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午11:03:13
* 短信发送源
*/

public enum MessageFrom {
	/**
	 * 广州医药
	 */
	GZPC("gzpc"),
	/**
	 * 健之桥
	 */
	JZQYYW("jzqyyw"),
	/**
	 * 采芝林
	 */
	CZL("czl")
	;
	
	private String key;
	
	MessageFrom(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	
}
