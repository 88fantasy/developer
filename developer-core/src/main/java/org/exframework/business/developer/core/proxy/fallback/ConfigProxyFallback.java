package org.exframework.business.developer.core.proxy.fallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import org.exframework.business.developer.common.dto.AccountParamDTO;
import org.exframework.business.developer.common.dto.DictionaryDTO;
import org.exframework.business.developer.common.dto.ParamDTO;
import org.exframework.business.developer.core.proxy.ConfigProxy;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.enums.ResultCode;

/**
* @author rwe
* @version 创建时间：Oct 18, 2020 10:18:35 AM
* ConfigProxy 错误处理
*/

@Component
public class ConfigProxyFallback implements FallbackFactory<ConfigProxy> {

	private static final Logger LOG = LoggerFactory.getLogger(ConfigProxyFallback.class);
	
	@Override
	public ConfigProxy create(Throwable cause) {
		final String msg = cause == null ? "" : cause.getMessage();
    LOG.error("ConfigProxy接口不可用,错误处理接管:"+msg, cause);
		return new ConfigProxy() {

			@Override
			public ApiResponseData<String> getParamValue(@NotEmpty String appCode, String key) {
				return new ApiResponseData<String>(ResultCode.SERVICE_UNAVAILABLE, msg, null);
			}

			@Override
			public ApiResponseData<List<ParamDTO>> findAllParams(@NotEmpty String appCode) {
				return new ApiResponseData<List<ParamDTO>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<ParamDTO>());
			}

			@Override
			public ApiResponseData<String> getAccountParamValue(@NotEmpty String appCode, @NotEmpty String key,
					@NotEmpty String account) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, null);
			}

			@Override
			public ApiResponseData<List<AccountParamDTO>> findAllAccountParams(@NotEmpty String appCode, String account) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<AccountParamDTO>());
			}

			@Override
			public ApiResponseData<Boolean> saveAccountParam(@NotNull AccountParamDTO dto) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, false);
			}

			@Override
			public ApiResponseData<Map<String, String>> getDictionaryValue(String appCode, String key) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, new ConcurrentHashMap<String,String>());
			}

			@Override
			public ApiResponseData<List<DictionaryDTO>> findDictionaryByKeys(String appCode, Collection<String> keys) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<>());
			}

			@Override
			public ApiResponseData<Map<String, ParamDTO>> findParamByKeys(String appCode, Collection<String> keys) {
				return new ApiResponseData<>(ResultCode.SERVICE_UNAVAILABLE, msg, new ConcurrentHashMap<>());
			}
			
		};
	}

}
