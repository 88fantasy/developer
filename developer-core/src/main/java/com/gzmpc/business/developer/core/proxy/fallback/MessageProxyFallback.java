package com.gzmpc.business.developer.core.proxy.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gzmpc.business.developer.common.dto.SendEmailRequest;
import com.gzmpc.business.developer.common.dto.SendSnsRequest;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.core.proxy.MessageProxy;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;

import feign.hystrix.FallbackFactory;

/**
* @author rwe
* @version 创建时间：2021年3月25日 上午9:04:37
* 消息服务错误处理
*/

@Component
public class MessageProxyFallback implements FallbackFactory<MessageProxy> {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageProxyFallback.class);
	

	@Override
	public MessageProxy create(Throwable cause) {
		String msg = "MessageProxy接口不可用,错误处理接管:"+ (cause == null ? "" : cause.getMessage());
    LOG.error(msg, cause);
    final ApiResponseData<MessageResponse> fallbackResponse = new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, msg, null);
    return new MessageProxy() {

			@Override
			public ApiResponseData<MessageResponse> sendEmail(SendEmailRequest request) {
				return fallbackResponse;
			}

			@Override
			public ApiResponseData<MessageResponse> sendSns(SendSnsRequest request) {
				return fallbackResponse;
			}
			
    	
    };
	}

}

