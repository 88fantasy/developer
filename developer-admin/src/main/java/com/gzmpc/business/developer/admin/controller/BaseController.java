package com.gzmpc.business.developer.admin.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzmpc.business.developer.admin.constant.DeveloperGatewayApiConstants;
import com.gzmpc.business.developer.admin.dto.GatewayRouteDTO;
import com.gzmpc.business.developer.admin.dto.GatewayRouteDeleteDTO;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.util.BeanUtils;
import com.gzmpc.support.jdbc.service.ExBaseService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.entity.ApiResponsePage;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年3月30日 上午12:17:11
* 类说明
*/

public class BaseController<T extends ExBaseService> {

//	@ApiOperation(value = "获取")
//	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<GatewayRouteDTO> getById(
//			@ApiParam(value = "Id", required = true)  @PathVariable( value = "id", required = true) String id) {
//			return new ApiResponseData<>(BeanUtils.copyTo(gatewayRouteService.getById(id), GatewayRouteDTO.class));
//	}
//	
//	@ApiOperation(value = "保存")
//	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<Boolean> update(
//			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDTO dto) {
//		return new ApiResponseData<Boolean>(gatewayRouteService.saveOrUpdate(dto));
//	}
//	
//	@ApiOperation(value = "删除")
//	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<Boolean> delete(
//			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDeleteDTO dto) {
//		return new ApiResponseData<Boolean>(gatewayRouteService.delete(dto));
//	}
//	
//	@ApiOperation(value = "分页查询")
//	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_QUERYLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponsePage<GatewayRouteDTO> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
//		return new ApiResponsePage<GatewayRouteDTO>(gatewayRouteService.getBaseMapper().query(request.getConditions(), request.getPage(), GatewayRouteDTO.class));
//	}
}
