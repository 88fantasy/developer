package com.gzmpc.business.developer.core.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzmpc.business.developer.core.constant.ServiceNameConstants;
import com.gzmpc.business.developer.core.constant.WeChatComApiConstants;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import com.gzmpc.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import com.gzmpc.business.developer.core.proxy.fallback.WechatProxyFallback;
import com.gzmpc.support.rest.exception.ApiException;


/**
 * 微服务 proxy类
 * @author pro
 *
 */


@FeignClient(name = ServiceNameConstants.SERVICE_NAME_WECHAT, fallbackFactory = WechatProxyFallback.class, configuration = {})
public interface WechatProxy {

	/**
	 * 发送文本信息
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SendMessageResponse sendText(SendTextMessageRequest request) throws ApiException;
	
	/**
	 * 发送文本卡片消息
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXTCARD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SendMessageResponse sendTextcard(SendTextcardMessageRequest request) throws ApiException;
	
	/**
	 * 发送图片消息
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_IMAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SendMessageResponse sendImage(SendImageMessageRequest request) throws ApiException;
	
	/**
	 * 发送图文消息
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_NEWS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SendMessageResponse sendNews(SendNewsMessageRequest request) throws ApiException;
	
	/**
	 * 发送小程序消息
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_MINIPROGRAM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SendMessageResponse sendMiniProgram(SendMiniProgramMessageRequest request) throws ApiException;
}


