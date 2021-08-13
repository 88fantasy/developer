package org.exframework.business.developer.message.controller;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.exframework.business.developer.common.dto.SendSnsRequest;
import org.exframework.business.developer.common.enums.MessageType;
import org.exframework.business.developer.core.constant.MessageApiConstants;
import org.exframework.business.developer.core.dto.message.MessageResponse;
import org.exframework.business.developer.message.sender.SnsSender;
import org.exframework.support.rest.entity.ApiResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @author rwe
 * @desc
 * @Date 2021-04-08 11:41
 */

@Api(tags = "短信Api")
@RestController
public class SnsController {
	
	@Autowired
	SnsSender snsSender;
	
	@Autowired
  HttpServletRequest req;
	

	@ApiOperation(value = "发送短信接口")
	@RequestMapping(value = MessageApiConstants.MESSAGE_SNS_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseData<MessageResponse> send (@ApiParam(required = true) @Valid @RequestBody SendSnsRequest request) {
		request.setIp(req.getRemoteHost());
		request.setMessageType(MessageType.SNS);
		return snsSender.sendMessage(request);
	}
	
}
