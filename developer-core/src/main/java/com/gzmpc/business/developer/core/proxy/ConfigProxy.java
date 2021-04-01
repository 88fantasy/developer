package com.gzmpc.business.developer.core.proxy;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzmpc.business.developer.common.constant.DeveloperAccountParamApiConstants;
import com.gzmpc.business.developer.common.dto.ParamDTO;
import com.gzmpc.business.developer.core.constant.ConfigApiConstants;
import com.gzmpc.business.developer.core.constant.ConfigParamApiConstants;
import com.gzmpc.business.developer.core.constant.ServiceNameConstants;
import com.gzmpc.business.developer.core.entity.AccountParam;
import com.gzmpc.business.developer.core.proxy.fallback.DeveloperProxyFallback;
import com.gzmpc.support.rest.entity.ApiResponseData;

/**
 * 微服务 proxy类
 * @author pro
 *
 */
@FeignClient(name = ServiceNameConstants.SERVICE_NAME_CONFIG, fallbackFactory = DeveloperProxyFallback.class)
public interface ConfigProxy {

	/**
	 * 获取参数配置项
	 * @param appCode 应用 code
	 * @param key 键值
	 * @return
	 */
	@RequestMapping(value = ConfigApiConstants.API_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> getParamValue(@NotEmpty @PathVariable("appCode") String appCode,@PathVariable("key") String key);
	
	/**
	 * 获取参数配置项
	 * @param appCode 应用 code
	 * @param keys 键值数组
	 * @return
	 */
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_QUERY_KEYS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<ParamDTO>> queryKeys(@NotEmpty @PathVariable("appCode") String appCode,
			@RequestBody List<String> keys);
	
	/**
	 * 获取全部参数
	 * @param appCode 应用 code
	 * @return
	 */
	@RequestMapping(value = ConfigApiConstants.API_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<ParamDTO>> findAllParams(@NotEmpty @PathVariable("appCode") String appCode);
	
	/**
	 * 获取字典
	 * @param appCode 应用 code
	 * @param key 键值
	 * @return
	 */
//	@RequestMapping(value = ConfigApiConstants.API_DICTIONARY_GET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<Map<String,DictionaryItem>> getDictionaryValue(@NotEmpty @PathVariable("appCode") String appCode, @NotEmpty @PathVariable("key") String key);
	
	/**
	 * 获取所有字典
	 * @param appCode 应用 code
	 * @return
	 */
//	@RequestMapping(value = ConfigApiConstants.API_DICTIONARY_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<List<DictionarySaveDTO>> findAllDictionary(@NotEmpty @PathVariable("appCode") String appCode);
	
	/**
	 * 获取全部数据项
	 * @param appCode 应用 code
	 * @return
	 */
//	@RequestMapping(value = ConfigApiConstants.API_DATAITEM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<List<DataItem>> findAllDataItems(@NotEmpty @PathVariable("appCode") String appCode);
	
	
	/**
	 * 获取用户参数信息
	 * @param appCode 应用 code
	 * @param key 键值
	 * @param account 帐号
	 * @return
	 */
	@RequestMapping(value = DeveloperAccountParamApiConstants.API_ACCOUNT_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> getAccountParamValue(@NotEmpty @PathVariable("appCode") String appCode, @NotEmpty @PathVariable("key") String key, @NotEmpty @PathVariable("account") String account);
	
	/**
	 * 获取全部帐号参数
	 * @param appCode
	 * @return
	 */
	@RequestMapping(value = DeveloperAccountParamApiConstants.API_ACCOUNT_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<AccountParam>> findAllAccountParams(@NotEmpty @PathVariable("appCode") String appCode);
	
	/**
	 * 保存用户参数
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = DeveloperAccountParamApiConstants.API_ACCOUNT_PARAM_SAVE_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> saveAccountParam(@NotNull @RequestBody AccountParam dto) ;
}
