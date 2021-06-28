package org.exframework.business.developer.wechat.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatComConstants {
	
	public String WECHAT_COM_TOKEN_BASE = "/wechat-sign/com/token/{0}/{1}";

	public String WECHAT_COM_SESSION_BASE = "/wechat-auth/com/session/{0}/{1}/{2}";

	public String WECHAT_COM_API_BASE = "https://qyapi.weixin.qq.com/cgi-bin";
	
	public String WECHAT_COM_API_TOKEN = WECHAT_COM_API_BASE+"/gettoken?corpid=${id}&corpsecret=${secret}";
	
	public String WECHAT_COM_API_MESSAGE = WECHAT_COM_API_BASE+"/message/send";
	
	public String WECHAT_COM_API_CODE2SESSION = WECHAT_COM_API_BASE+"/miniprogram/jscode2session?access_token=${token}&js_code=${jscode}&grant_type=authorization_code";
}
