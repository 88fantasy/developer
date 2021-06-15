package com.gzmpc.business.developer.portal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.entity.LoginLog;
import com.gzmpc.business.developer.portal.service.LoginLogService;

import io.swagger.annotations.Api;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:50:33
* 登录日志 controller
*/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@RequestMapping("/log/login")
@Api(value = "login-log", tags = "登录日志")
public class LoginLogController extends QueryController<LoginLogService, LoginLog, LoginLog> {

}
