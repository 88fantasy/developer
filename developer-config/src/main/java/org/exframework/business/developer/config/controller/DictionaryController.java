package org.exframework.business.developer.config.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.common.dto.DictionaryDTO;
import org.exframework.business.developer.config.service.DictionaryService;
import org.exframework.business.developer.core.constant.ConfigDictionaryApiConstants;
import org.exframework.support.rest.entity.ApiResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 控制类
 * 
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@Api(tags = "字典配置")
public class DictionaryController {

	@Autowired
	DictionaryService dictionaryService;

	@ApiOperation(value = "获取字典配置")
	@RequestMapping(value = ConfigDictionaryApiConstants.API_DICTIONARY_GET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Map<String, String>> getDictionaryValue(
			@ApiParam(value = "系统编号", required = true) @PathVariable(value = "appCode", required = true) String appCode,
			@ApiParam(value = "参数键值", required = true) @PathVariable(value = "key", required = true) String key) {
			return new ApiResponseData<>(dictionaryService.getValue(appCode, key));
	}

	@ApiOperation(value = "保存字典配置")
	@RequestMapping(value = ConfigDictionaryApiConstants.API_DICTIONARY_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> postValue(@ApiParam(value = "保存dto", required = true) @Valid @RequestBody(required = true) DictionaryDTO dto) {
		return new ApiResponseData<>(dictionaryService.putValue(dto));
	}

	@ApiOperation(value = "获取指定字典")
	@RequestMapping(value = ConfigDictionaryApiConstants.API_DICTIONARY_FINDALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<DictionaryDTO>> findKeys(
			@ApiParam(value = "系统编号", required = true) @PathVariable(required = true) String appCode,
			@RequestBody(required = true) List<String> keys) {
		return new ApiResponseData<List<DictionaryDTO>>(dictionaryService.findByKeys(appCode, keys.toArray(new String[keys.size()])));
	}
}