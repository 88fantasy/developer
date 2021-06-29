package org.exframework.business.developer.core.proxy;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.exframework.business.developer.core.config.FeignHeaderConfiguration;
import org.exframework.business.developer.core.constant.ServiceNameConstants;
import org.exframework.business.developer.core.constant.WeChatApiConstants;
import org.exframework.business.developer.core.constant.WeChatComApiConstants;
import org.exframework.business.developer.core.dto.wechat.WechatLoginUserInfo;
import org.exframework.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import org.exframework.business.developer.core.proxy.fallback.WechatProxyFallback;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.exception.ApiException;

/**
 * 微服务 proxy类
 * 
 * @author pro
 *
 */

@FeignClient(name = ServiceNameConstants.SERVICE_NAME_WECHAT, fallbackFactory = WechatProxyFallback.class, configuration = {
		FeignHeaderConfiguration.class })
@DubboTransported
public interface WechatProxy {

	/**
	 * 发送文本信息
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<SendMessageResponse> sendText(SendTextMessageRequest request) throws ApiException;

	/**
	 * 发送文本卡片消息
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_TEXTCARD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<SendMessageResponse> sendTextcard(SendTextcardMessageRequest request) throws ApiException;

	/**
	 * 发送图片消息
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_IMAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<SendMessageResponse> sendImage(SendImageMessageRequest request) throws ApiException;

	/**
	 * 发送图文消息
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_NEWS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<SendMessageResponse> sendNews(SendNewsMessageRequest request) throws ApiException;

	/**
	 * 发送小程序消息
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = WeChatComApiConstants.WECHAT_COM_API_SEND_MINIPROGRAM, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<SendMessageResponse> sendMiniProgram(SendMiniProgramMessageRequest request)
			throws ApiException;

	/**
	 * 获取微信登录用户信息
	 * 
	 * @param appid
	 * @param code
	 * @return
	 */
	@RequestMapping(value = WeChatApiConstants.WECHAT_API_LOGIN_USERINFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<WechatLoginUserInfo> getUserinfo(@PathVariable("appid") String appid,
			@PathVariable("code") String code);

}
