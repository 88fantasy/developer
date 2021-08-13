package org.exframework.business.developer.portal.controller;

import io.swagger.annotations.Api;
import org.exframework.business.developer.portal.entity.LoginLog;
import org.exframework.business.developer.portal.entity.OperateLog;
import org.exframework.business.developer.portal.service.LoginLogService;
import org.exframework.business.developer.portal.service.OperateLogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:50:33
* 登录日志 controller
*/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.POST })
@RequestMapping("/log/operate")
@Api(value = "operate-log", tags = "操作日志")
public class AdminOperateLogController extends QueryController<OperateLogService, OperateLog, OperateLog> {

}
