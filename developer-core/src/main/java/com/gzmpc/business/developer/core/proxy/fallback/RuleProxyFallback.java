package com.gzmpc.business.developer.core.proxy.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gzmpc.business.developer.core.dto.rule.RuleSubmitRequest;
import com.gzmpc.business.developer.core.proxy.RuleProxy;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;

import feign.hystrix.FallbackFactory;

/**
* @author rwe
* @version 创建时间：2021年3月25日 上午9:04:37
* 企业微信错误处理
*/

@Component
public class RuleProxyFallback implements FallbackFactory<RuleProxy> {
	
	private static final Logger LOG = LoggerFactory.getLogger(RuleProxyFallback.class);
	

	@Override
	public RuleProxy create(Throwable cause) {
		String msg = "WechatProxy接口不可用,错误处理接管:"+ (cause == null ? "" : cause.getMessage());
    LOG.error(msg, cause);
    final ApiResponseData<String> fallbackResponse = new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, msg, null);
    return new RuleProxy() {

			@Override
			public ApiResponseData<String> submit(RuleSubmitRequest request) {
				return fallbackResponse;
			}
			
    	
    };
	}

}

