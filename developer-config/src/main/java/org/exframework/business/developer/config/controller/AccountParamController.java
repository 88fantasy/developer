package org.exframework.business.developer.config.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.common.dto.AccountParamDTO;
import org.exframework.business.developer.config.service.AccountParamService;
import org.exframework.business.developer.core.constant.ConfigAccountParamApiConstants;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.enums.ResultCode;
import org.exframework.support.rest.exception.GlobalControllerExceptionControllerAdvice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@Api(tags = "用户参数配置")
public class AccountParamController {

	@Autowired
	AccountParamService accountParamService;
	
	@ApiOperation(value = "获取用户参数配置")
	@RequestMapping(value = ConfigAccountParamApiConstants.API_ACCOUNT_PARAM_GET_VALUE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> getParamValue(
			@ApiParam(value = "系统编号", required = true) @PathVariable("appCode") String appCode,
			@ApiParam(value = "参数键值", required = true) @PathVariable("key") String key,
			@ApiParam(value = "帐号", required = true) @PathVariable("account") String account) {
		if (!StringUtils.isEmpty(appCode) && !StringUtils.isEmpty(key) && !StringUtils.isEmpty(account)) {
			return new ApiResponseData<String>(accountParamService.getValue(appCode, key, account));
		} else {
			return new ApiResponseData<String>(ResultCode.BAD_REQUEST, GlobalControllerExceptionControllerAdvice.PARAMS_ERROR, null);
		}
	}
	
	@ApiOperation(value = "保存用户参数配置")
	@RequestMapping(value = ConfigAccountParamApiConstants.API_ACCOUNT_PARAM_SAVE_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> putValue(
			@ApiParam(value = "保存dto", required = true) @Valid @RequestBody AccountParamDTO dto) {
		return new ApiResponseData<Boolean>(accountParamService.putValue(dto));
	}
	
	@ApiOperation(value = "获取app参数")
	@RequestMapping(value = ConfigAccountParamApiConstants.API_ACCOUNT_PARAM_FINDALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<AccountParamDTO>> findAll(@ApiParam(value = "系统编号", required = true) @PathVariable(value = "appCode", required = true) String appCode,
			@ApiParam(value = "帐号", required = true) @PathVariable(value = "account", required = true) String account) {
		return new ApiResponseData<List<AccountParamDTO>>(accountParamService.findByAppCodeAndAccount(appCode, account));
	}
}