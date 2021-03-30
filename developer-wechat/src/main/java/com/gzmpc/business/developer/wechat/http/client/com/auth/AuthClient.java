package com.gzmpc.business.developer.wechat.http.client.com.auth;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.http.client.com.ComAccessTokenInterceptor;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetSessionResponse;

/**
* @author rwe
* @version 创建时间：Sep 21, 2020 2:28:01 PM
* 企业微信 消息 api
*/

@BaseRequest(baseURL = WeChatComConstants.WECHAT_COM_API_BASE, interceptor = ComAccessTokenInterceptor.class)
public interface AuthClient {

	@Get(url = WeChatComConstants.WECHAT_COM_API_CODE2SESSION, dataType = "json")
	GetSessionResponse jscode2session(@DataVariable("token") String token, @DataVariable("jscode") String jscode);
	
}
