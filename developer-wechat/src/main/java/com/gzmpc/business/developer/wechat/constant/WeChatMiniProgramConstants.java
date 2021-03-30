package com.gzmpc.business.developer.wechat.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatMiniProgramConstants {
	
	public String WECHAT_MP_SESSION_BASE = "/wechat-auth/mp/session/{0}/{1}/{2}";
	
	public String WECHAT_MP_API_TOKEN = WeChatConstants.WECHAT_API_TOKEN;

	public String WECHAT_MP_API_CODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=${appid}&secret=${secret}&js_code=${jscode}&grant_type=authorization_code";
	
}
