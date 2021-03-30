package com.gzmpc.business.developer.wechat.constant;

import com.gzmpc.business.developer.core.constant.WeChatComApiConstants;
import com.gzmpc.business.developer.core.constant.WeChatMiniProgramApiConstants;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatApiConstants extends WeChatComApiConstants, WeChatMiniProgramApiConstants {
	
	public String WECHAT_API_BASE = "v1/wechat";

	public String WECHAT_API_APPINFO = WECHAT_API_BASE+"/appInfo/{appId}";
	
	public String WECHAT_API_BIND_OPENID = WECHAT_API_BASE+"/bindOpenId";
	
	public String WECHAT_API_GET_UACCOUNT_BY_OPENID = WECHAT_API_BASE+"/getUaccountByOpenId/{openid}";
	
	public String WECHAT_API_GET_TOKEN = WECHAT_API_BASE+"/token";
}
