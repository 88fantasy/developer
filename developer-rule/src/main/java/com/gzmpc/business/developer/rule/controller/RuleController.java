package com.gzmpc.business.developer.rule.controller;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.core.constant.RuleApiConstants;
import com.gzmpc.business.developer.core.dto.rule.RuleSubmitRequest;
import com.gzmpc.business.developer.rule.service.RuleService;
import com.gzmpc.support.rest.entity.ApiResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @author rwe
 * @desc
 * @Date 2021-04-08 11:41
 */

@Api(tags = "规则")
@RestController
public class RuleController {
	
	@Autowired
	RuleService ruleService;
	
	@Autowired
  HttpServletRequest req;
	

	@ApiOperation(value = "执行规则")
	@RequestMapping(value = RuleApiConstants.RULE_SUBMIT_INSTANCE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<String> submit(@ApiParam(required = true) @Valid @RequestBody RuleSubmitRequest request) {
		request.setIp(req.getRemoteHost());
		return new ApiResponseData<>(ruleService.submit(request.getSourceId(), request.getPackageCode(),	request.getJson()));
	}
	
}
