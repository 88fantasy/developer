package com.gzmpc.business.developer.core.proxy.fallback;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gzmpc.business.developer.common.dto.ParamDTO;
import com.gzmpc.business.developer.core.entity.AccountParam;
import com.gzmpc.business.developer.core.proxy.DeveloperProxy;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;

import feign.hystrix.FallbackFactory;

/**
* @author rwe
* @version 创建时间：Oct 18, 2020 10:18:35 AM
* ConfigProxy 错误处理
*/

@Component
public class DeveloperProxyFallback implements FallbackFactory<DeveloperProxy> {

	private static final Logger LOG = LoggerFactory.getLogger(DeveloperProxyFallback.class);
	
	@Override
	public DeveloperProxy create(Throwable cause) {
		final String msg = cause == null ? "" : cause.getMessage();
    LOG.error("ConfigProxy接口不可用,错误处理接管:"+msg, cause);
		return new DeveloperProxy() {

			@Override
			public ApiResponseData<String> getParamValue(@NotEmpty String appCode, String key) {
				return new ApiResponseData<String>(ResultCode.SERVICE_UNAVAILABLE, msg, null);
			}

			@Override
			public ApiResponseData<List<ParamDTO>> queryKeys(@NotEmpty String appCode, List<String> keys) {
				return new ApiResponseData<List<ParamDTO>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<ParamDTO>());
			}

			@Override
			public ApiResponseData<List<ParamDTO>> findAllParams(@NotEmpty String appCode) {
				return new ApiResponseData<List<ParamDTO>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<ParamDTO>());
			}

//			@Override
//			public ApiResponseData<Map<String, DictionaryItem>> getDictionaryValue(@NotEmpty String appCode,
//					@NotEmpty String key) {
//				return new ApiResponseData<Map<String, DictionaryItem>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ConcurrentHashMap<String, DictionaryItem>());
//			}
//
//			@Override
//			public ApiResponseData<List<DictionarySaveDTO>> findAllDictionary(@NotEmpty String appCode) {
//				return new ApiResponseData<List<DictionarySaveDTO>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<DictionarySaveDTO>());
//			}
//
//			@Override
//			public ApiResponseData<List<DataItem>> findAllDataItems(@NotEmpty String appCode) {
//				return new ApiResponseData<List<DataItem>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<DataItem>());
//			}

			@Override
			public ApiResponseData<String> getAccountParamValue(@NotEmpty String appCode, @NotEmpty String key,
					@NotEmpty String account) {
				return new ApiResponseData<String>(ResultCode.SERVICE_UNAVAILABLE, msg, null);
			}

			@Override
			public ApiResponseData<List<AccountParam>> findAllAccountParams(@NotEmpty String appCode) {
				return new ApiResponseData<List<AccountParam>>(ResultCode.SERVICE_UNAVAILABLE, msg, new ArrayList<AccountParam>());
			}

			@Override
			public ApiResponseData<Boolean> saveAccountParam(@NotNull AccountParam dto) {
				return new ApiResponseData<Boolean>(ResultCode.SERVICE_UNAVAILABLE, msg, false);
			}

			
		};
	}

}
