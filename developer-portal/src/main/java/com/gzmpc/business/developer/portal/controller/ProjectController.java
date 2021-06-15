package com.gzmpc.business.developer.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.dto.ProjectResponse;
import com.gzmpc.business.developer.portal.entity.Project;
import com.gzmpc.business.developer.portal.service.ProjectService;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.usthe.sureness.provider.annotation.RequiresRoles;

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
@RequestMapping("/project")
@Api(value = "project", tags = "项目")
public class ProjectController extends QueryAndGetController<ProjectService, ProjectResponse, Project> {

	@Autowired
	ProjectService projectService;

	@RequiresRoles(roles = {"admin"}, mapping = "/project/notice", method = "get") 
	@ApiOperation(value = "获取当前帐号项目列表")
	@RequestMapping(value = "/notice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<List<ProjectResponse>> notice() {
			return projectService.getProjectsByCurrent();
	}
	
//	@Override
//	public Function<Project, ProjectResponse> getTranslator() {
//		return entity -> {
//			ProjectResponse dto = BeanUtils.copyTo(entity, ProjectResponse.class);
//			
//			return dto;
//		};
//	}
		
}