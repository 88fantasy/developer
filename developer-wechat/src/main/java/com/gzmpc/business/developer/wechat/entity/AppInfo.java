package com.gzmpc.business.developer.wechat.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:10:00 PM
* 微信程序实体类
*/

//@Document(collection = "appinfo")
public class AppInfo {
	
	/**
	 * 应用 Id
	 */
	@Id
	@NotNull
	private String appId;
	
	/**
	 * 应用密钥
	 */
//	@Field
	@NotNull
	private String appSecret;
	
	/**
	 * 商户号
	 */
//	@Field
	private String payId;
	
	/**
	 * 商户密钥
	 */
//	@Field
	private String paySecret;
	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPaySecret() {
		return paySecret;
	}

	public void setPaySecret(String paySecret) {
		this.paySecret = paySecret;
	}
	
}
