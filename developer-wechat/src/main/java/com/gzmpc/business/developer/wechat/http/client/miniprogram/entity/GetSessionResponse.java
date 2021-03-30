package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:58:04 PM
* 类说明
*/

public class GetSessionResponse extends GlobalResponse {

	private String openid;
	
	private String session_key;
	
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}
