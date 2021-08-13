package org.exframework.business.developer.core.proxy;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.exframework.business.developer.common.dto.SendEmailRequest;
import org.exframework.business.developer.common.dto.SendSnsRequest;
import org.exframework.business.developer.core.config.FeignHeaderConfiguration;
import org.exframework.business.developer.core.constant.MessageApiConstants;
import org.exframework.business.developer.core.constant.ServiceNameConstants;
import org.exframework.business.developer.core.dto.message.MessageResponse;
import org.exframework.business.developer.core.proxy.fallback.MessageProxyFallback;
import org.exframework.support.rest.entity.ApiResponseData;


/**
 * 微服务 proxy类
 * @author pro
 *
 */


@FeignClient(name = ServiceNameConstants.SERVICE_NAME_MESSAGE, fallbackFactory = MessageProxyFallback.class, configuration = {
		FeignHeaderConfiguration.class })
@DubboTransported
public interface MessageProxy {

	/**
	 * 发送邮件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<MessageResponse> sendEmail(SendEmailRequest request);
	
	/**
	 * 发送短信
	 * @param request
	 * @return
	 */
	@RequestMapping(value = MessageApiConstants.MESSAGE_SNS_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<MessageResponse> sendSns(SendSnsRequest request);
}


