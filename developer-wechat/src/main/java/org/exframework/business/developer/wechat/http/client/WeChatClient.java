package org.exframework.business.developer.wechat.http.client;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import org.exframework.business.developer.core.dto.wechat.WechatLoginUserInfo;
import org.exframework.business.developer.wechat.constant.WeChatConstants;
import org.exframework.business.developer.wechat.entity.GetTokenResponse;
import org.exframework.business.developer.wechat.http.client.entity.GetLoginCallBackTokenResponse;

/**
* @author rwe
* @version 创建时间：Sep 21, 2020 10:08:42 AM
* 微信开放平台对接 
*/

public interface WeChatClient {

	@Get(url = WeChatConstants.WECHAT_LOGIN_TOKEN, dataType = "json")
	GetLoginCallBackTokenResponse getLoginToken(@DataVariable("appid") String appid, @DataVariable("secret") String secret, @DataVariable("code") String code);
	
	@Get(url = WeChatConstants.WECHAT_LOGIN_USERINFO, dataType = "json")
	WechatLoginUserInfo getUserInfo(@DataVariable("token") String token, @DataVariable("openid") String openid);

	@Get(url = WeChatConstants.WECHAT_API_TOKEN, dataType = "json")
	GetTokenResponse getAccessToken(@DataVariable("appid") String appid, @DataVariable("secret") String secret);
	
}
