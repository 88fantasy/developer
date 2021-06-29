package org.exframework.business.developer.core.proxy;


import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.exframework.business.developer.core.config.FeignHeaderConfiguration;
import org.exframework.business.developer.core.constant.RuleApiConstants;
import org.exframework.business.developer.core.constant.ServiceNameConstants;
import org.exframework.business.developer.core.dto.rule.RuleSubmitRequest;
import org.exframework.business.developer.core.proxy.fallback.RuleProxyFallback;
import org.exframework.support.rest.entity.ApiResponseData;

/**
* @author rwe
* @version 创建时间：2021年6月11日 下午4:27:03
* 规则
*/

@FeignClient(name = ServiceNameConstants.SERVICE_NAME_RULE, fallbackFactory = RuleProxyFallback.class, configuration = {
		FeignHeaderConfiguration.class })
@DubboTransported
public interface RuleProxy {

	/**
	 * 执行规则
	 * @param request
	 * @return
	 */
	@RequestMapping(value = RuleApiConstants.RULE_SUBMIT_INSTANCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> submit(RuleSubmitRequest request);

}
