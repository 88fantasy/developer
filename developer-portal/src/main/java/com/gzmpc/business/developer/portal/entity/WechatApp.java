package com.gzmpc.business.developer.portal.entity;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author rwe
 * @version 创建时间：Oct 7, 2020 12:10:00 PM 
 * 微信程序实体类
 */

@TableName("wechat_app")
public class WechatApp extends Editable {

	private static final long serialVersionUID = -1376312363555952381L;

	/**
	 * 应用 Id
	 */
	@TableId(type = IdType.INPUT)
	@NotNull
	private String appId;
	
	/**
	 * 应用 名称
	 */
	@TableField
	@NotNull
	private String name;

	/**
	 * 应用密钥
	 */
	@TableField
	@NotNull
	private String appSecret;

	/**
	 * 商户号
	 */
	@TableField
	private String payId;

	/**
	 * 商户密钥
	 */
	@TableField
	private String paySecret;
	
	/**
	 * 小程序
	 */
	@TableField
	private Boolean miniprogram;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(Boolean miniprogram) {
		this.miniprogram = miniprogram;
	}

}
