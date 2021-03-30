package com.gzmpc.business.developer.admin.dto;

import javax.validation.constraints.NotNull;


/**
 * @author rwe
 * @version 创建时间：Oct 7, 2020 12:10:00 PM 微信程序实体类
 */

public class WechatAppDTO {

	/**
	 * 应用 Id
	 */
	@NotNull
	private String appId;

	/**
	 * 应用密钥
	 */
	@NotNull
	private String appSecret;

	/**
	 * 商户号
	 */
	private String payId;

	/**
	 * 商户密钥
	 */
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
