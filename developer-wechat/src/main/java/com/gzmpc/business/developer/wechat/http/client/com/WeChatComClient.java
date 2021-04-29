package com.gzmpc.business.developer.wechat.http.client.com;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.entity.GetTokenResponse;
import com.gzmpc.business.developer.wechat.http.client.com.entity.GetSessionResponse;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 10:07:56 AM 
 * 企业微信 api
 */

public interface WeChatComClient {

	@Get(url = WeChatComConstants.WECHAT_COM_API_TOKEN, dataType = "json")
	GetTokenResponse getToken(@DataVariable("id") String corpid, @DataVariable("secret") String secret);

	@Get(url = WeChatComConstants.WECHAT_COM_API_CODE2SESSION, dataType = "json")
	GetSessionResponse jscode2session(@DataVariable("token") String token, @DataVariable("jscode") String jscode);

	@Post(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, contentType = "application/json", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	public SendMessageResponse sendText(@Body SendTextMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Post(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, contentType = "application/json", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	public SendMessageResponse sendImage(@Body SendImageMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);

	@Post(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, contentType = "application/json", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	public SendMessageResponse sendTextcard(@Body SendTextcardMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Post(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, contentType = "application/json", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	public SendMessageResponse sendNews(@Body SendNewsMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Post(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, contentType = "application/json", dataType = "json", interceptor = ComAccessTokenInterceptor.class)
	public SendMessageResponse sendMiniProgram(@Body SendMiniProgramMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
}
