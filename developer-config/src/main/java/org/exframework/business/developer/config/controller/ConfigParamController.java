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

import org.exframework.business.developer.common.dto.ParamDTO;
import org.exframework.business.developer.config.service.ParamService;
import org.exframework.business.developer.core.constant.ConfigParamApiConstants;
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
@Api(value = "param", tags = "参数")
public class ConfigParamController {

	@Autowired
	ParamService paramService;

	@ApiOperation(value = "获取参数配置")
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> getParamValue(
			@ApiParam(value = "系统编号", required = true) @PathVariable(required = true) String appCode,
			@ApiParam(value = "参数键值", required = true) @PathVariable(required = true) String key) {
		return new ApiResponseData<String>(paramService.getValue(appCode, key));
	}

	@ApiOperation(value = "保存参数配置")
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_SAVE_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> putValue(
			@ApiParam(value = "保存dto", required = true) @Valid @RequestBody(required = true) ParamDTO dto) {
		return new ApiResponseData<Boolean>(
				paramService.putValue(dto));
	}

	@ApiOperation(value = "获取app参数")
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<ParamDTO>> findAll(
			@ApiParam(value = "系统编号", required = true) @PathVariable("appCode") String appCode) {
		return new ApiResponseData<List<ParamDTO>>(paramService.findByAppCode(appCode));
	}

	@ApiOperation(value = "获取app指定参数")
	@RequestMapping(value = ConfigParamApiConstants.API_PARAM_FINDKEYS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Map<String,ParamDTO>> findKeys(
			@ApiParam(value = "系统编号", required = true) @PathVariable(required = true) String appCode,
			@RequestBody(required = true) List<String> keys) {
		return new ApiResponseData<>(paramService.findByKeys(appCode, keys.toArray(new String[keys.size()])));
	}
}