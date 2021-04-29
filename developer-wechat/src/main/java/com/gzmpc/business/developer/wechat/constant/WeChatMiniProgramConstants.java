package com.gzmpc.business.developer.wechat.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatMiniProgramConstants {
	
	String WECHAT_MP_SESSION_BASE = "/wechat-auth/mp/session/{0}/{1}/{2}";
	
	String WECHAT_MP_TOKEN_BASE = "/wechat-auth/mp/token/{0}/{1}";
	
	String WECHAT_MP_API_TOKEN = WeChatConstants.WECHAT_API_TOKEN;

	String WECHAT_MP_API_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=${appid}&secret=${secret}&js_code=${jscode}&grant_type=authorization_code";
	
	String WECHAT_MP_API_GETPAIDUNIONID = "https://api.weixin.qq.com/wxa/getpaidunionid?openid=${openid}";
	
	String WECHAT_MP_API_OCR_BANKCARD = "https://api.weixin.qq.com/cv/ocr/bankcard?img_url=${url}";
	
}
