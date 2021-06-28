package org.exframework.business.developer.core.proxy.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import org.exframework.business.developer.core.dto.wechat.WechatLoginUserInfo;
import org.exframework.business.developer.core.dto.wechat.com.message.SendImageMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMessageResponse;
import org.exframework.business.developer.core.dto.wechat.com.message.SendMiniProgramMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendNewsMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextMessageRequest;
import org.exframework.business.developer.core.dto.wechat.com.message.SendTextcardMessageRequest;
import org.exframework.business.developer.core.proxy.WechatProxy;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.enums.ResultCode;
import org.exframework.support.rest.exception.ApiException;


/**
* @author rwe
* @version 创建时间：2021年3月25日 上午9:04:37
* 企业微信错误处理
*/

@Component
public class WechatProxyFallback implements FallbackFactory<WechatProxy> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WechatProxyFallback.class);
	

	@Override
	public WechatProxy create(Throwable cause) {
		String msg = "WechatProxy接口不可用,错误处理接管:"+ (cause == null ? "" : cause.getMessage());
    LOG.error(msg, cause);
    final ApiResponseData<SendMessageResponse> fallbackResponse = new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, msg, null);
    return new WechatProxy() {
			@Override
			public ApiResponseData<SendMessageResponse> sendText(SendTextMessageRequest request) throws ApiException {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<SendMessageResponse> sendTextcard(SendTextcardMessageRequest request) throws ApiException {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<SendMessageResponse> sendImage(SendImageMessageRequest request) throws ApiException {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<SendMessageResponse> sendNews(SendNewsMessageRequest request) throws ApiException {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<SendMessageResponse> sendMiniProgram(SendMiniProgramMessageRequest request) throws ApiException {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<WechatLoginUserInfo> getUserinfo(String appid, String code) {
				return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, msg, null);
			}
    	
    };
	}

}

