package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:38:11
* 类说明
*/

public class GetPerformanceDataResponseBodyTableLineField {

	/**
	 * 日期
	 */
	private String refdate;
	
	/**
	 * 性能数据值
	 */
	private String value;

	public String getRefdate() {
		return refdate;
	}

	public void setRefdate(String refdate) {
		this.refdate = refdate;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
