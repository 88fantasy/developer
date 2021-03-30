package com.gzmpc.business.developer.admin.controller;


import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.admin.constant.DeveloperGatewayApiConstants;
import com.gzmpc.business.developer.admin.constant.DeveloperWechatAppApiConstants;
import com.gzmpc.business.developer.admin.dto.WechatAppDTO;
import com.gzmpc.business.developer.admin.service.WechatAppService;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.util.BeanUtils;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.entity.ApiResponsePage;

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
@Api(value = "wechat-app", tags = "微信应用")
public class WechatAppController {

	@Autowired
	WechatAppService wechatAppService;
	
	@ApiOperation(value = "获取微信应用")
	@RequestMapping(value = DeveloperWechatAppApiConstants.API_WECHAT_APP_GET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<WechatAppDTO> getById(
			@ApiParam(value = "路由Id", required = true)  @PathVariable( value = "id", required = true) String id) {
			return new ApiResponseData<>(BeanUtils.copyTo(wechatAppService.getById(id), WechatAppDTO.class));
	}
	
	@ApiOperation(value = "保存微信应用")
	@RequestMapping(value = DeveloperWechatAppApiConstants.API_WECHAT_APP_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<Boolean> update(
			@ApiParam(required = true) @Valid @RequestBody(required = true) WechatAppDTO dto) {
		return new ApiResponseData<Boolean>(wechatAppService.saveOrUpdateDTO(dto));
	}
	
//	@ApiOperation(value = "删除路由信息")
//	@RequestMapping(value = DeveloperWechatAppApiConstants.API_WECHAT_APP_DELETE, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<Boolean> delete(
//			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDeleteDTO dto) {
//		return new ApiResponseData<Boolean>(wechatAppService.delete(dto));
//	}
	
	@ApiOperation(value = "分页查询微信应用")
	@RequestMapping(value = DeveloperWechatAppApiConstants.API_WECHAT_APP_QUERYLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<WechatAppDTO> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return new ApiResponsePage<WechatAppDTO>(wechatAppService.getBaseMapper().query(request.getConditions(), request.getPage(), WechatAppDTO.class));
	}
	
}