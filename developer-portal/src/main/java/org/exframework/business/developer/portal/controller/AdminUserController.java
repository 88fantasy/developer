package org.exframework.business.developer.portal.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.portal.dto.DeveloperAccountListResponse;
import org.exframework.business.developer.portal.entity.User;
import org.exframework.business.developer.portal.service.AdminUserService;
import org.exframework.support.common.util.BeanUtils;

import io.swagger.annotations.Api;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/admin/user")
@Api(value = "/admin/user", tags = "管理后台用户")
public class AdminUserController extends QueryController<AdminUserService, DeveloperAccountListResponse, User> {

	@Autowired
	AdminUserService accountService;

	@Override
	public Function<User, DeveloperAccountListResponse> getTranslator() {
		return entity -> {
			DeveloperAccountListResponse dto = BeanUtils.copyTo(entity, DeveloperAccountListResponse.class);
			if(entity.getAccountStatus()!= null) {
				dto.setAccountStatus(entity.getAccountStatus());
			}
			if(entity.getDataSource() != null) {
				dto.setSource(entity.getDataSource());
			}
			return dto;
		};
	}
	
	
}