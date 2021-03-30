package com.gzmpc.business.developer.wechat.http.client.com;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetTokenResponse;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 10:07:56 AM 
 * 企业微信 api
 */

public interface WeChatComClient {

	@Get(url = WeChatComConstants.WECHAT_COM_API_TOKEN, dataType = "json")
	GetTokenResponse getToken(@DataVariable("id") String corpid, @DataVariable("secret") String secret);

}
