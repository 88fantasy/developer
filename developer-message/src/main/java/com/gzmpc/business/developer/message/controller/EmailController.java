package com.gzmpc.business.developer.message.controller;

import io.swagger.annotations.*;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.util.Lists;
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
import com.gzmpc.support.rest.entity.ApiResponseData;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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

	@ApiOperation(value = "发送邮件")
	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_SEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<MessageResponse> send(@ApiParam(required = true) @Valid @RequestBody SendEmailRequest request) {
		request.setIp(req.getRemoteHost());
		request.setMessageType(MessageType.EMAIL);
		return emailSender.sendEmail(request);
	}

//	@Autowired
//	IFileService IFileService;
//
//	@ApiOperation(value = MessageApiConstants.MESSAGE_EMAIL_ATTACHMENT, notes = "上传单个附件")
//	@RequestMapping(value = MessageApiConstants.MESSAGE_EMAIL_ATTACHMENT, method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE )
//	public ApiResponseData upload(@ApiParam(value = "上传的文件", required = true) @RequestParam("file") MultipartFile file) {
//
//		ResponseResult result = new ResponseResult();
//		result.setCode(HttpStatus.SC_OK);
//		result.setStatus(true);
//		try {
//			String filename = IFileService.upload(file.getInputStream(), file.getOriginalFilename());
//			result.setData(filename);
//		} catch (PatternSyntaxException e) {
//			result.setStatus(false);
//			result.setMsg("校验上传文件出错:" + e.getMessage());
//		} catch (IOException e) {
//			result.setStatus(false);
//			result.setMsg("上传文件出错:" + e.getMessage());
//		}
//		return result;
//	}
//
//	@ApiOperation(value = "多文件上传附件接口", notes = "上传附件,返回文件在服务器的相对路径")
//	@RequestMapping(value = "uploads", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
//	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
//			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
//	public ApiResponseData uploads(
//			@ApiParam(value = "上传的文件", required = true) @RequestParam("file") MultipartFile[] files) {
//
//		ResponseResult result = new ResponseResult();
//		result.setCode(HttpStatus.SC_OK);
//		result.setStatus(true);
//		try {
//			List<String> filename = Lists.newArrayList();
//			for (MultipartFile file : files) {
//				String name = IFileService.upload(file.getInputStream(), file.getOriginalFilename());
//				filename.add(name);
//			}
//			result.setData(filename);
//		} catch (PatternSyntaxException e) {
//			result.setStatus(false);
//			result.setMsg("校验上传文件出错:" + e.getMessage());
//		} catch (IOException e) {
//			result.setStatus(false);
//			result.setMsg("上传文件出错:" + e.getMessage());
//		}
//		return result;
//	}
}
