package com.gzmpc.business.developer.wechat.constant;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 12:31:28 PM 
 * 通用常量
 */

public interface WeChatConstants extends WeChatComConstants, WeChatJsConstants, WeChatMiniProgramConstants {

	String WECHAT_OPENID_BASE = "/wechat-sign/openid/{0}";
	
	String API_OPERTE_NORMAL = "正常返回";

	String API_OPERATE_ERROR = "操作[{0}]失败:{1} , 参数:{2}";

	String API_OPERATE_SUCCESS = "操作[{0}]成功";
	
	String TOKEN_SECRET = "GZMPCTOKENSECRET";
	
	long EXPIRE_DATE = 2*60*60;
	
	String WECHAT_TENANT_TOKEN_BASE = "/wechat/tenant/{0}";
	
	String WECHAT_API_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${appid}&secret=${secret}";

	String WECHAT_LOGIN_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=${appid}&secret=${secret}&code=${code}&grant_type=authorization_code";

	String WECHAT_LOGIN_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=${token}&openid=${openid}";

	String WECHAT_LOGIN_CODE_KEY = "/wechat/login/code/{0}";
}
