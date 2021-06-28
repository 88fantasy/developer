package org.exframework.business.developer.portal.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.portal.dto.LoginRequest;
import org.exframework.business.developer.portal.dto.LoginResponse;
import org.exframework.business.developer.portal.service.AdminAccountService;
import org.exframework.support.rest.entity.ApiResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@Api(value = "login", tags = "登录")
@RequestMapping(value = "/login")
public class PortalLoginController {

	@Autowired
	AdminAccountService accountService;
	
	@ApiOperation(value = "登录接口")
	@RequestMapping(value = "/account", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<LoginResponse> login(@Valid
			@ApiParam(required = true)  @RequestBody(required = true) LoginRequest request) {
			return new ApiResponseData<>(accountService.login(request));
	}

}