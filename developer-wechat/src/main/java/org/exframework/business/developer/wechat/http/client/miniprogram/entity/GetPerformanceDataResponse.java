package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:27:03
* 类说明
*/

public class GetPerformanceDataResponse extends GlobalResponse {

	private GetPerformanceDataResponseData data;

	public GetPerformanceDataResponseData getData() {
		return data;
	}

	public void setData(GetPerformanceDataResponseData data) {
		this.data = data;
	}
	
	
}
