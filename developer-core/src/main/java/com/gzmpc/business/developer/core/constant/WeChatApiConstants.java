package com.gzmpc.business.developer.core.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatApiConstants {
	
	String WECHAT_API_BASE = "v1/wechat";

	String WECHAT_API_APPINFO = WECHAT_API_BASE+"/appInfo/{appId}";
	
	String WECHAT_API_BIND_OPENID = WECHAT_API_BASE+"/bindOpenId";
	
	String WECHAT_API_GET_UACCOUNT_BY_OPENID = WECHAT_API_BASE+"/getUaccountByOpenId/{openid}";
	
	String WECHAT_API_GET_TOKEN = WECHAT_API_BASE+"/token";
	
	String WECHAT_API_LOGIN_CALLBACK = WECHAT_API_BASE+"/login/callback";

	String WECHAT_API_LOGIN_USERINFO = WECHAT_API_BASE+"/login/userinfo/{appid}/{code}";
}
