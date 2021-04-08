package com.gzmpc.business.developer.core.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzmpc.business.developer.common.dto.SendEmailRequest;
import com.gzmpc.business.developer.common.dto.SendMessageRequest;
import com.gzmpc.business.developer.core.constant.MessageApiConstants;
import com.gzmpc.business.developer.core.constant.ServiceNameConstants;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.core.proxy.fallback.MessageProxyFallback;
import com.gzmpc.support.rest.entity.ApiResponseData;


/**
 * 微服务 proxy类
 * @author pro
 *
 */


@FeignClient(name = ServiceNameConstants.SERVICE_NAME_MESSAGE, fallbackFactory = MessageProxyFallback.class, configuration = {})
public interface MessageProxy {

	/**
	 * 发送邮件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<MessageResponse> send(SendEmailRequest request);
	
	/**
	 * 发送短信
	 * @param request
	 * @return
	 */
	@RequestMapping(value = MessageApiConstants.MESSAGE_SNS_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<MessageResponse> send (SendMessageRequest request);
}


