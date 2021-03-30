package com.gzmpc.business.developer.wechat.http.client.com.message;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Request;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import com.gzmpc.business.developer.wechat.constant.WeChatComConstants;
import com.gzmpc.business.developer.wechat.http.client.com.ComAccessTokenInterceptor;

/**
* @author rwe
* @version 创建时间：Sep 21, 2020 2:28:01 PM
* 企业微信 消息 api
*/

@BaseRequest(baseURL = WeChatComConstants.WECHAT_COM_API_BASE, interceptor = ComAccessTokenInterceptor.class)
public interface MessageClient {

	@Request(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, type = "post", contentType = "application/json", dataType = "json")
	public SendMessageResponse sendText(@Body SendTextMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Request(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, type = "post", contentType = "application/json", dataType = "json")
	public SendMessageResponse sendImage(@Body SendImageMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);

	@Request(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, type = "post", contentType = "application/json", dataType = "json")
	public SendMessageResponse sendTextcard(@Body SendTextcardMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Request(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, type = "post", contentType = "application/json", dataType = "json")
	public SendMessageResponse sendNews(@Body SendNewsMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
	@Request(url = WeChatComConstants.WECHAT_COM_API_MESSAGE, type = "post", contentType = "application/json", dataType = "json")
	public SendMessageResponse sendMiniProgram(@Body SendMiniProgramMessageRequest request, @Body("msgtype") String weChatSendMessageEnumValue, @Body("enable_id_trans") Integer enableIdTrans, @Body("enable_duplicate_check") Integer enableDuplicateCheck);
	
}
