package com.gzmpc.business.developer.message.controller;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gzmpc.business.developer.common.dto.SendSnsRequest;
import com.gzmpc.business.developer.common.enums.MessageType;
import com.gzmpc.business.developer.core.constant.MessageApiConstants;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.message.sender.SnsSender;
import com.gzmpc.support.rest.entity.ApiResponseData;

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
	SnsSender messageSender;
	
	@Autowired
  HttpServletRequest req;
	

	@ApiOperation(value = "发送短信接口")
	@RequestMapping(value = MessageApiConstants.MESSAGE_SNS_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<MessageResponse> send (@ApiParam(required = true) @Valid @RequestBody SendSnsRequest request) {
		request.setIp(req.getRemoteHost());
		request.setMessageType(MessageType.SNS);
		return messageSender.sendMessage(request);
	}
	
}
