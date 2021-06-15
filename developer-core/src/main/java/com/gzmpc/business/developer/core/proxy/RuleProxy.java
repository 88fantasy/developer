package com.gzmpc.business.developer.core.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzmpc.business.developer.core.constant.RuleApiConstants;
import com.gzmpc.business.developer.core.constant.ServiceNameConstants;
import com.gzmpc.business.developer.core.dto.rule.RuleSubmitRequest;
import com.gzmpc.business.developer.core.proxy.fallback.RuleProxyFallback;
import com.gzmpc.support.rest.entity.ApiResponseData;

/**
* @author rwe
* @version 创建时间：2021年6月11日 下午4:27:03
* 规则
*/

@FeignClient(name = ServiceNameConstants.SERVICE_NAME_RULE, fallbackFactory = RuleProxyFallback.class, configuration = {})
public interface RuleProxy {

	/**
	 * 执行规则
	 * @param request
	 * @return
	 */
	@RequestMapping(value = RuleApiConstants.RULE_SUBMIT_INSTANCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> submit(RuleSubmitRequest request);

}
