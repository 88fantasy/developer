package org.exframework.business.developer.portal.controller;

import com.usthe.sureness.provider.annotation.WithoutAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.exframework.business.developer.portal.dto.ActivitiesResponse;
import org.exframework.support.rest.entity.ApiResponseData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年4月22日 上午11:05:05
* 类说明
*/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@Api(value = "dashboard", tags = "工作台")
public class DashboardController {

	
	@WithoutAuth(mapping = "/activities", method = "get")
	@ApiOperation(value = "获取当前登录人动态")
	@RequestMapping(value = "/activities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<List<ActivitiesResponse>> activities() {
			return new ApiResponseData<>(Collections.emptyList());
	}
}
