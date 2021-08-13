package org.exframework.business.developer.portal.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.portal.constant.DeveloperGatewayApiConstants;
import org.exframework.business.developer.portal.dto.GatewayRouteDTO;
import org.exframework.business.developer.portal.dto.GatewayRouteDeleteDTO;
import org.exframework.business.developer.portal.service.GatewayRouteService;
import org.exframework.portal.web.dto.PostConditionQueryRequest;
import org.exframework.support.common.util.BeanUtils;
import org.exframework.support.rest.entity.ApiResponseData;
import org.exframework.support.rest.entity.ApiResponsePage;

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
@Api(value = "gateway", tags = "网关")
public class AdminGatewayController {

	@Autowired
	GatewayRouteService gatewayRouteService;
	
	@ApiOperation(value = "获取路由信息")
	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_GET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<GatewayRouteDTO> getById(
			@ApiParam(value = "路由Id", required = true)  @PathVariable( value = "id", required = true) String id) {
			return new ApiResponseData<>(BeanUtils.copyTo(gatewayRouteService.getById(id), GatewayRouteDTO.class));
	}
	
	@ApiOperation(value = "保存路由信息")
	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Boolean> update(
			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDTO dto) {
		return new ApiResponseData<Boolean>(gatewayRouteService.saveOrUpdate(dto));
	}
	
	@ApiOperation(value = "删除路由信息")
	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_DELETE, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<Boolean> delete(
			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDeleteDTO dto) {
		return new ApiResponseData<Boolean>(gatewayRouteService.delete(dto));
	}
	
	@ApiOperation(value = "分页查询路由信息")
	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_QUERYLIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponsePage<GatewayRouteDTO> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return new ApiResponsePage<GatewayRouteDTO>(gatewayRouteService.getBaseMapper().query(request.getConditions(), request.getPage(), GatewayRouteDTO.class));
	}
	
	@ApiOperation(value = "刷新路由")
	@RequestMapping(value = DeveloperGatewayApiConstants.API_GATEWAY_REFRESH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String refresh() {
		gatewayRouteService.reload();
		return "success";
	}
}