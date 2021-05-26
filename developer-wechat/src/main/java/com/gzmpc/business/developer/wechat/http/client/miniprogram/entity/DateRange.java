package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import javax.validation.constraints.NotNull;

/**
* @author rwe
* @version 创建时间：2021年5月23日 上午10:41:35
* 日期范围
*/

public class DateRange {
	
	@NotNull
	private String begin_date;
	
	@NotNull
	private String end_date;

	public String getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
}
