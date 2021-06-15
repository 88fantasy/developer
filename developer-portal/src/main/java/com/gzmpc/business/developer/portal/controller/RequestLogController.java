package com.gzmpc.business.developer.portal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.common.dto.RequestLogger;
import com.gzmpc.business.developer.portal.entity.RequestLog;
import com.gzmpc.business.developer.portal.service.RequestLogService;

import io.swagger.annotations.Api;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:50:33
* 登录日志 controller
*/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@RequestMapping("/log/request")
@Api(value = "request-log", tags = "请求日志")
public class RequestLogController extends QueryController<RequestLogService, RequestLogger, RequestLog> {

}
