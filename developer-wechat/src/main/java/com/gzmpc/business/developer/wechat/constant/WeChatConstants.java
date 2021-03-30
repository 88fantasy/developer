package com.gzmpc.business.developer.wechat.constant;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 12:31:28 PM 
 * 通用常量
 */

public interface WeChatConstants extends WeChatComConstants, WeChatJsConstants, WeChatMiniProgramConstants {

	public String WECHAT_OPENID_BASE = "/wechat-sign/openid/{0}";
	
	public String API_OPERTE_NORMAL = "正常返回";

	public String API_OPERATE_ERROR = "操作[{0}]失败:{1} , 参数:{2}";

	public String API_OPERATE_SUCCESS = "操作[{0}]成功";
	
	public String TOKEN_SECRET = "GZMPCTOKENSECRET";
	
	public long EXPIRE_DATE = 2*60*60;
	
	public String WECHAT_TENANT_TOKEN_BASE = "/wechat/tenant/{0}";
	
	public String WECHAT_API_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${appid}&secret=${secret}";
}
