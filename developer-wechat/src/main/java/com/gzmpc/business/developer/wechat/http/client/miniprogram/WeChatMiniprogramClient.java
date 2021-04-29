package com.gzmpc.business.developer.wechat.http.client.miniprogram;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.gzmpc.business.developer.wechat.constant.WeChatMiniProgramConstants;
import com.gzmpc.business.developer.wechat.http.client.com.ComAccessTokenInterceptor;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetOcrBankCardResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetPaidUnionResponse;
import com.gzmpc.business.developer.wechat.http.client.miniprogram.entity.GetSessionResponse;

/**
* @author rwe
* @version 创建时间：Oct 3, 2020 9:49:38 PM
* 微信小程序 api
*/

public interface WeChatMiniprogramClient {

	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_CODE2SESSION, dataType = "json")
	GetSessionResponse jscode2session(@DataVariable("appid") String corpid, @DataVariable("secret") String secret, @DataVariable("jscode") String jscode);
	
	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_GETPAIDUNIONID + "&transaction_id=${transaction_id}", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	GetPaidUnionResponse getPaidUnionId(@DataVariable("appid") String appid, @DataVariable("openid") String openid, @DataVariable("transaction_id") String transactionId);
	
	@Get(url = WeChatMiniProgramConstants.WECHAT_MP_API_GETPAIDUNIONID + "&mch_id=${mch_id}&out_trade_no=${out_trade_no}", dataType = "json", interceptor = ComAccessTokenInterceptor.class )
	GetPaidUnionResponse getPaidUnionId(@DataVariable("appid") String appid, @DataVariable("openid") String openid, @DataVariable("mch_id") String mchId, @DataVariable("mch_id") String outTradeNo);
	
	@Post(url = WeChatMiniProgramConstants.WECHAT_MP_API_OCR_BANKCARD, dataType = "json", interceptor = ComAccessTokenInterceptor.class )
	GetOcrBankCardResponse ocrBankCard(@DataVariable("appid") String appid, @DataVariable("url") String imgUrl);
	
}
