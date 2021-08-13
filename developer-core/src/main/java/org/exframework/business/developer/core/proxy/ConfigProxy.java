package org.exframework.business.developer.core.proxy;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.exframework.business.developer.common.constant.DeveloperAccountParamApiConstants;
import org.exframework.business.developer.common.dto.AccountParamDTO;
import org.exframework.business.developer.common.dto.DictionaryDTO;
import org.exframework.business.developer.common.dto.ParamDTO;
import org.exframework.business.developer.core.config.FeignHeaderConfiguration;
import org.exframework.business.developer.core.constant.ConfigAccountParamApiConstants;
import org.exframework.business.developer.core.constant.ConfigApiConstants;
import org.exframework.business.developer.core.constant.ConfigDictionaryApiConstants;
import org.exframework.business.developer.core.constant.ConfigParamApiConstants;
import org.exframework.business.developer.core.constant.ServiceNameConstants;
import org.exframework.business.developer.core.proxy.fallback.ConfigProxyFallback;
import org.exframework.support.rest.entity.ApiResponseData;

/**
 * 微服务 proxy类
 * 
 * @author pro
 *
 */
@FeignClient(name = ServiceNameConstants.SERVICE_NAME_CONFIG, fallbackFactory = ConfigProxyFallback.class, configuration = {
		FeignHeaderConfiguration.class })
@DubboTransported
public interface ConfigProxy {

	/**
	 * 获取参数配置项
	 * 
	 * @param appCode 应用 code
	 * @param key     键值
	 * @return
	 */
	@RequestMapping(value = ConfigApiConstants.API_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<String> getParamValue(@NotEmpty @PathVariable(value = "appCode") String appCode,
			@PathVariable("key") String key);

	/**
	 * 获取参数配置项
	 * 
	 * @param appCode 应用 code
	 * @param keys    键值数组
	 * @return
	 */
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_FINDKEYS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Map<String, ParamDTO>> findParamByKeys(@PathVariable(value = "appCode") String appCode,
			@RequestBody Collection<String> keys);

	/**
	 * 获取全部参数
	 * 
	 * @param appCode 应用 code
	 * @return
	 */
	@RequestMapping(value = ConfigApiConstants.API_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<List<ParamDTO>> findAllParams(@NotEmpty @PathVariable(value = "appCode") String appCode);

	/**
	 * 获取字典
	 * 
	 * @param appCode 应用 code
	 * @param key     键值
	 * @return
	 */
	@RequestMapping(value = ConfigDictionaryApiConstants.API_DICTIONARY_GET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Map<String, String>> getDictionaryValue(
			@PathVariable(value = "appCode", required = true) String appCode,
			@PathVariable(value = "key", required = true) String key);

	/**
	 * 获取所有字典
	 * 
	 * @param appCode 应用 code
	 * @return
	 */
	@RequestMapping(value = ConfigDictionaryApiConstants.API_DICTIONARY_FINDALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<List<DictionaryDTO>> findDictionaryByKeys(
			@PathVariable(value = "appCode", required = true) String appCode,
			@RequestBody(required = true) Collection<String> keys);

	/**
	 * 获取全部数据项
	 * 
	 * @param appCode 应用 code
	 * @return
	 */
//	@RequestMapping(value = ConfigApiConstants.API_DATAITEM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ApiResponseData<List<DataItem>> findAllDataItems(@NotEmpty @PathVariable("appCode") String appCode);

	/**
	 * 获取用户参数信息
	 * 
	 * @param appCode 应用 code
	 * @param key     键值
	 * @param account 帐号
	 * @return
	 */
	@RequestMapping(value = DeveloperAccountParamApiConstants.API_ACCOUNT_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<String> getAccountParamValue(@PathVariable("appCode") String appCode,
			@PathVariable(value = "key") String key, @PathVariable(value = "account") String account);

	/**
	 * 获取指定帐号参数
	 * 
	 * @param appCode
	 * @param account
	 * @return
	 */
	@RequestMapping(value = ConfigAccountParamApiConstants.API_ACCOUNT_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<List<AccountParamDTO>> findAllAccountParams(
			@PathVariable(value = "appCode", required = true) String appCode,
			@PathVariable(value = "account", required = true) String account);

	/**
	 * 保存用户参数
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = DeveloperAccountParamApiConstants.API_ACCOUNT_PARAM_SAVE_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Boolean> saveAccountParam(@NotNull @RequestBody AccountParamDTO dto);
}
