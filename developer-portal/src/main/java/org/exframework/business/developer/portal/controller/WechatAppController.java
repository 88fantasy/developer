package org.exframework.business.developer.portal.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.common.dto.WechatAppDTO;
import org.exframework.business.developer.portal.entity.WechatApp;
import org.exframework.business.developer.portal.service.WechatAppService;
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
@RequestMapping("/wechat-app")
@Api(value = "wechat-app", tags = "微信小程序")
public class WechatAppController extends QueryAndGetController<WechatAppService, WechatAppDTO, WechatApp> {

	@Autowired
	WechatAppService wechatAppService;
	
	@ApiOperation(value = "保存微信小程序")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> update(
			@ApiParam(required = true) @Valid @RequestBody(required = true) WechatAppDTO dto) {
		return new ApiResponseData<Boolean>(wechatAppService.saveOrUpdateDTO(dto,null, wechatAppService.getConsumer()));
	}
	
	@ApiOperation(value = "刷新配置")
	@RequestMapping(value = "/refresh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String refresh() {
		wechatAppService.reload();
		return "success";
	}
}