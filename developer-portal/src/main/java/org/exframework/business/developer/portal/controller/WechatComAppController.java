package org.exframework.business.developer.portal.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.common.dto.WechatComAppDTO;
import org.exframework.business.developer.portal.entity.WechatComApp;
import org.exframework.business.developer.portal.service.WechatComAppService;
import org.exframework.support.rest.entity.ApiResponseData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/wechat-com-app")
@Api(value = "wechat-com-app", tags = "企业微信应用")
public class WechatComAppController extends QueryAndGetController<WechatComAppService, WechatComAppDTO, WechatComApp> {

	@Autowired
	WechatComAppService wechatComAppService;
	
	@ApiOperation(value = "保存企业微信应用")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Boolean> update(
			@ApiParam(required = true) @Valid @RequestBody(required = true) WechatComAppDTO dto) {
		return new ApiResponseData<>(wechatComAppService.saveOrUpdateDTO(dto,null, wechatComAppService.getConsumer()));
	}
	
	@ApiOperation(value = "刷新配置")
	@RequestMapping(value = "/refresh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String refresh() {
		wechatComAppService.reload();
		return "success";
	}
}