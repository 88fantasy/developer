package com.gzmpc.business.developer.core.constant;

/**
 * 常量类
 * @author pro
 *
 */
public interface WeChatComApiConstants {
	
	public String WECHAT_COM_API_BASE = "v1/com";
	
	public String WECHAT_COM_API_CODE2SESSION = WECHAT_COM_API_BASE+"/code2Session";

	public String WECHAT_COM_API_SEND_TEXT = WECHAT_COM_API_BASE+"/sendText";
	
	public String WECHAT_COM_API_SEND_TEXTCARD = WECHAT_COM_API_BASE+"/sendTextcard";
	
	public String WECHAT_COM_API_SEND_NEWS = WECHAT_COM_API_BASE+"/sendNews";
	
	public String WECHAT_COM_API_SEND_IMAGE = WECHAT_COM_API_BASE+"/sendImage";
	
	public String WECHAT_COM_API_SEND_MINIPROGRAM = WECHAT_COM_API_BASE+"/sendMiniProgram";
}
