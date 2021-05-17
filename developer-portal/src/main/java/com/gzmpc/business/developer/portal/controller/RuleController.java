package com.gzmpc.business.developer.portal.controller;

import java.util.List;
import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.dto.RuleDTO;
import com.gzmpc.business.developer.portal.dto.RulePackageListResponse;
import com.gzmpc.business.developer.portal.dto.RulePackageSaveDTO;
import com.gzmpc.business.developer.portal.dto.RuleStatisticResponse;
import com.gzmpc.business.developer.portal.entity.RulePackage;
import com.gzmpc.business.developer.portal.entity.RulePackageInstance;
import com.gzmpc.business.developer.portal.service.DeveloperRuleService;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.entity.FilterCondition;
import com.gzmpc.support.rest.entity.ApiResponseData;
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
	
	@ApiOperation(value = "获取")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<RulePackageSaveDTO> getById(
			@ApiParam(value = "Id", required = true)  @PathVariable( value = "id", required = true) String id) {
			return new ApiResponseData<>(developerRuleService.get(id));
	}
	
	@ApiOperation(value = "分页查询规则库")
	@RequestMapping(value = "/queryRules", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<RuleDTO> queryRules(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return developerRuleService.queryRules(request);
	}
	
	@ApiOperation(value = "分页查询规则实例")
	@RequestMapping(value = "/queryPackageInstances", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<RulePackageInstance> queryPackageInstances(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return developerRuleService.queryPackageInstances(request);
	}
	
	@ApiOperation(value = "按规则分类统计规则")
	@RequestMapping(value = "/postRuleStatistic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<RuleStatisticResponse> postRuleStatistic(@ApiParam(value = "查询条件")  @RequestBody List<FilterCondition> conditions) {
		return developerRuleService.postRuleStatistic(conditions);
	}
	
	@ApiOperation(value = "保存规则集")
	@RequestMapping(value = "saveRulePackage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) RulePackageSaveDTO request) {
		developerRuleService.saveRulePackage(request);
		return new ApiResponseData<>(true);
	}
	

	@Override
	public Function<RulePackage, RulePackageListResponse> getTranslator() {
		return developerRuleService.getTranslator();
	}
	
	
}
