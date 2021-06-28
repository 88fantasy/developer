package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:58:04 PM
* 类说明
*/

public class GetPaidUnionResponse extends GlobalResponse {
	
	private String unionid;

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
