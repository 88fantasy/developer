package org.exframework.business.developer.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.portal.dto.DeveloperAccountListResponse;
import org.exframework.business.developer.portal.dto.DeveloperPermissionListResponse;
import org.exframework.business.developer.portal.dto.GroupListResponse;
import org.exframework.business.developer.portal.service.AdminPermissionService;
import org.exframework.portal.web.dto.PostConditionQueryRequest;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.entity.ApiResponsePage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:50:33
* 登录日志 controller
*/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST,  })
@RequestMapping("/permission")
@Api(value = "permission", tags = "权限")
public class AdminPermissionController {

	@Autowired
	AdminPermissionService adminPermissionService;
	
	@ApiOperation(value = "用户组列表")
	@RequestMapping(value = "/group/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<GroupListResponse>> listGroup() {
		return adminPermissionService.listGroup();
	}
	
	@ApiOperation(value = "用户组关联帐号分页查询")
	@RequestMapping(value = "/group/queryAccount/{code}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<DeveloperAccountListResponse> queryAccount(
			@ApiParam(value = "code", required = true)  @PathVariable( value = "code", required = true) String code,
			@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return adminPermissionService.queryAccount(code, request);
	}
	
//	@ApiOperation(value = "权限集合列表")
//	@RequestMapping(value = "/permission/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<List<DeveloperPermissionListResponse>> listPermissions() {
//		return adminPermissionService.listPermissions();
//	}
}
