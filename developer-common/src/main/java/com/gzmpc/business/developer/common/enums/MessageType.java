package com.gzmpc.business.developer.common.enums;

/**
 * 消息类型
 * @author pro
 *
 */
public enum MessageType {
	/**
	 * "短信"
	 */
	SNS("snsSender"),
	/**
	 * "邮件"
	 */
	EMAIL("emailSender"),
	/**
	 * "OTRS工单"
	 */
	OTRS("otrsSender"),
	/**
	 * "企业微信推送"
	 */
	WECHAT_COM("wechatComSender")
	;
	
	private String beanId;
	
	private MessageType(String beanId) {
		this.beanId = beanId;
	}

	public String getBeanId() {
		return beanId;
	}
	
}
