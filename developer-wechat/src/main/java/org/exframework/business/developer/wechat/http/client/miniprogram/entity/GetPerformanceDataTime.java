package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:19:55
* 类说明
*/

public class GetPerformanceDataTime {

	/**
	 * 开始日期时间戳
	 */
	private String begin_timestamp;
	
	/**
	 * 结束日期时间戳
	 */
	private String end_timestamp;

	public String getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setBegin_timestamp(String begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public String getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(String end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	
	
}
