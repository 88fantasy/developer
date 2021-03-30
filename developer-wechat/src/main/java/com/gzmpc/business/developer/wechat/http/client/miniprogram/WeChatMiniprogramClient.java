package com.gzmpc.business.developer.wechat.http.client.miniprogram;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:49:38 PM
* 微信小程序 api
*/

public interface WeChatMiniprogramClient {

	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_CODE2SESSION, dataType = "json")
	GetSessionResponse jscode2session(@DataVariable("appid") String corpid, @DataVariable("secret") String secret, @DataVariable("jscode") String jscode);
	
}
