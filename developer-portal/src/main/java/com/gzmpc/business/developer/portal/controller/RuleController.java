package com.gzmpc.business.developer.portal.controller;

import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.dto.RuleDTO;
import com.gzmpc.business.developer.portal.dto.RulePackageListResponse;
import com.gzmpc.business.developer.portal.entity.RulePackage;
import com.gzmpc.business.developer.portal.service.DeveloperRuleService;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.rest.entity.ApiResponsePage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午2:53:30
* 类说明
*/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/rule")
@Api(value = "rule", tags = "规则")
public class RuleController extends BaseController<DeveloperRuleService, RulePackageListResponse, RulePackage> {

	@Autowired
	DeveloperRuleService developerRuleService;
	
	@ApiOperation(value = "分页查询规则库")
	@RequestMapping(value = "/queryRules", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<RuleDTO> queryRules(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return developerRuleService.queryRules(request);
	}

	@Override
	public Function<RulePackage, RulePackageListResponse> getTranslator() {
		return developerRuleService.getTranslator();
	}
	
//	@ApiOperation(value = "分页查询规则库")
//	@RequestMapping(value = "saveRule", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponsePage<?> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) Rule request) {
//		return new ApiResponsePage<>(exBaseService.getBaseMapper().query(request.getConditions(), request.getPage(), getTranslator(), entityClass));
//	}
	
}
