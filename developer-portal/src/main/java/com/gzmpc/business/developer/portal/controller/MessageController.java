package com.gzmpc.business.developer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.portal.dto.MessageDTO;
import com.gzmpc.business.developer.portal.service.MessageService;

import io.swagger.annotations.Api;

/**
 * 控制类
 * @author pro
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.PATCH,
		RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/message")
@Api(value = "message", tags = "消息")
public class MessageController extends BaseController<MessageService, MessageDTO> {

	@Autowired
	MessageService messageService;
	
	
//	@ApiOperation(value = "删除路由信息")
//	@RequestMapping(value = DeveloperWechatAppApiConstants.API_WECHAT_APP_DELETE, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ApiResponseData<Boolean> delete(
//			@ApiParam(required = true) @Valid @RequestBody(required = true) GatewayRouteDeleteDTO dto) {
//		return new ApiResponseData<Boolean>(wechatAppService.delete(dto));
//	}
	
}