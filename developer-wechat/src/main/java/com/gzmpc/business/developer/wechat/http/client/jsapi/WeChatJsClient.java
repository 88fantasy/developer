package com.gzmpc.business.developer.wechat.http.client.jsapi;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.gzmpc.business.developer.wechat.constant.WeChatJsConstants;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetTokenResponse;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 10:07:56 AM 
 * 企业微信 api
 */

public interface WeChatJsClient {

	@Get(url = WeChatJsConstants.WECHAT_JS_API_TOKEN, dataType = "json")
	GetTokenResponse getToken(@DataVariable("appid") String appid, @DataVariable("secret") String secret);

	
}
