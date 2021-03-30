package com.gzmpc.business.developer.wechat.http.client.com.entity;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:58:04 PM
* 类说明
*/

public class GetSessionResponse extends GlobalResponse {

	private String corpid;
	
	private String session_key;
	
	private String userid;


	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
