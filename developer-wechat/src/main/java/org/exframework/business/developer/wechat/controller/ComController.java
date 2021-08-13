package org.exframework.business.developer.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.core.constant.WeChatComApiConstants;
import org.exframework.business.developer.core.dto.wechat.com.Code2SessionRequest;
import org.exframework.business.developer.core.dto.wechat.com.Code2SessionResponse;
import org.exframework.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import org.exframework.business.developer.wechat.service.com.ComService;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.exception.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author rwe
 * @version 创建时间：Sep 23, 2020 10:52:32 AM 预售活动 
 * 企业微信接口类
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@Api(tags = "企业微信 API")
public class ComController {

	@Autowired
	ComService comService;
	
	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_CODE2SESSION, notes = "登录")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_CODE2SESSION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Code2SessionResponse> code2Session(@ApiParam(value = "登录", required = true) @RequestBody Code2SessionRequest request) throws ApiException {
		return comService.code2Session(request);
	}

	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXT, notes = "发送文本信息")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<SendMessageResponse> sendText(@ApiParam(value = "消息", required = true) @RequestBody SendTextMessageRequest request) throws ApiException {
		return comService.sendText(request);
	}
	
	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXTCARD, notes = "发送文本卡片消息")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXTCARD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<SendMessageResponse> sendTextcard(@ApiParam(value = "消息", required = true) @RequestBody SendTextcardMessageRequest request) throws ApiException {
		return comService.sendTextcard(request);
	}
	
	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_SEND_IMAGE, notes = "发送图片消息")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_IMAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<SendMessageResponse> sendImage(@ApiParam(value = "消息", required = true) @RequestBody SendImageMessageRequest request) throws ApiException {
		return comService.sendImage(request);
	}
	
	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_SEND_NEWS, notes = "发送图文消息")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_NEWS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<SendMessageResponse> sendNews(@ApiParam(value = "消息", required = true) @RequestBody SendNewsMessageRequest request) throws ApiException {
		return comService.sendNews(request);
	}
	
	@ApiOperation(value = WeChatComApiConstants.WECHAT_COM_API_SEND_MINIPROGRAM, notes = "发送小程序消息")
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_MINIPROGRAM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<SendMessageResponse> sendMiniProgram(@ApiParam(value = "消息", required = true) @RequestBody SendMiniProgramMessageRequest request) throws ApiException {
		return comService.sendMiniProgram(request);
	}
}
