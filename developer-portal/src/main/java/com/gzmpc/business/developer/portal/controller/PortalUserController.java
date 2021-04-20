package com.gzmpc.business.developer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.dto.CurrentUserResponse;
import com.gzmpc.business.developer.portal.service.AccountService;
import com.gzmpc.business.developer.portal.service.DeveloperLoginService;
import com.gzmpc.support.rest.entity.ApiResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@Api(value = "user", tags = "帐号")
@RequestMapping(value = "/user")
public class PortalUserController {

	@Autowired
	DeveloperLoginService loginService;
	
	@Autowired
	AccountService accountService;
	
	@ApiOperation(value = "当前登录信息")
	@RequestMapping(value = "/currentUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<CurrentUserResponse> currentUser() {
		return new ApiResponseData<>(new CurrentUserResponse(loginService.currentPerson()));
	}

}