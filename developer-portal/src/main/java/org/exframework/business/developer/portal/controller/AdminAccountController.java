package org.exframework.business.developer.portal.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.portal.dto.DeveloperAccountListResponse;
import org.exframework.business.developer.portal.dto.MessageDTO;
import org.exframework.business.developer.portal.entity.DeveloperAccount;
import org.exframework.business.developer.portal.entity.MessageUnion;
import org.exframework.business.developer.portal.service.AdminAccountService;
import org.exframework.business.developer.portal.service.MessageService;
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
@RequestMapping("/account")
@Api(value = "account", tags = "帐号")
public class AdminAccountController extends QueryController<AdminAccountService, DeveloperAccountListResponse, DeveloperAccount> {

	@Autowired
	AdminAccountService accountService;

	@Override
	public Function<DeveloperAccount, DeveloperAccountListResponse> getTranslator() {
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