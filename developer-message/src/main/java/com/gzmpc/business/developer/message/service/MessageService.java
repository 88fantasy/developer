package com.gzmpc.business.developer.message.service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.dto.Message;
import com.gzmpc.business.developer.message.constant.MessageConstants;
import com.gzmpc.business.developer.message.exception.MessageException;
import com.gzmpc.business.developer.message.mapper.MessageUnionMapper;
import com.gzmpc.spring.boot.autoconfigure.cos.CosClient;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.enums.ResultCode;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.UploadResult;

@Service
public class MessageService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageUnionMapper messageUnionMapper;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Value(value = "${file.upload.pattern}")
	private String defaultPattern;
	
	private String path = "/attachment/";
	
	@Autowired
	CosClient cosClient;
	
	public void send(String json) {
		Message message = JSON.parseObject(json, Message.class);
		Map<String, Sender> senders = applicationContext.getBeansOfType(Sender.class);
		Sender sender = senders.get(message.getMessageType().getBeanId());
		try {
			sender.send(json);
		} catch (MessageException e) {
			logger.error("发送消息出现错误:"+e.getMessage(),e);
		} finally {
			
		}
	}
	
	
	public ApiResponseData<String> upload(MultipartFile file) {
		String filename = file.getOriginalFilename();
		
		Pattern p =  Pattern.compile(defaultPattern);
    // 创建 Matcher 对象
    Matcher m = p.matcher(filename);
    if(!m.matches()) {
    	return new ApiResponseData<>(ResultCode.BAD_REQUEST,"验证文件后缀失败,不允许上传此类文件", null);
    }
    File dest = null;
    try {
    	dest = File.createTempFile(filename, null);
			file.transferTo(dest);
		} catch (IOException e) {
			String message = MessageFormat.format("保存文件[{0}]出现错误: {1}", filename, e.getMessage());
			logger.error(message, e);
			return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, message, null);
		}
    
    try {
    	ObjectMetadata om = new ObjectMetadata();
    	om.addUserMetadata(MessageConstants.ATTACHMENT_FILENAME_KEY, filename);
    	UploadResult result = cosClient.upload(dest, path+dest.getName(), om);
    	return new ApiResponseData<>(result.getKey());
		} catch (CosClientException | InterruptedException e) {
			String message = MessageFormat.format("上传 cos[{0}]出现错误: {1}", filename, e.getMessage());
			logger.error(message, e);
			return new ApiResponseData<>(ResultCode.INTERNAL_SERVER_ERROR, message, null);
		}
    
	}
}
