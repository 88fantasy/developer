package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:58:04 PM
* 类说明
*/

public class GetOcrBankCardResponse extends GlobalResponse {
	
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
