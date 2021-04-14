package com.gzmpc.business.developer.message.controller;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gzmpc.business.developer.common.dto.SendEmailRequest;
import com.gzmpc.business.developer.common.enums.MessageType;
import com.gzmpc.business.developer.core.constant.MessageApiConstants;
import com.gzmpc.business.developer.core.dto.message.MessageResponse;
import com.gzmpc.business.developer.message.sender.EmailSender;
import com.gzmpc.business.developer.message.service.MessageService;
import com.gzmpc.support.rest.entity.ApiResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author rwe
 * @desc
 * @Date 2021-04-08 11:41
 */

@Api(tags = "邮件Api")
@RestController
public class EmailController {
	
	@Autowired
	EmailSender emailSender;
	
	@Autowired
  HttpServletRequest req;
	
	@Autowired
	MessageService messageService;

	@ApiOperation(value = "发送邮件")
	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<MessageResponse> send(@ApiParam(required = true) @Valid @RequestBody SendEmailRequest request) {
		request.setIp(req.getRemoteHost());
		request.setMessageType(MessageType.EMAIL);
		return emailSender.sendEmail(request);
	}

	@ApiOperation(value = "上传单个附件")
	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_ATTACHMENT, method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE )
	public ApiResponseData<String> upload(@ApiParam(value = "上传的文件", required = true) @Valid @RequestParam(required = true) MultipartFile file) {
		return messageService.upload(file);
	}

}
