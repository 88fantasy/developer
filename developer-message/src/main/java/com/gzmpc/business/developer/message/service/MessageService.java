package com.gzmpc.business.developer.message.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.dto.Message;
import com.gzmpc.business.developer.common.dto.SendEmailRequest;
import com.gzmpc.business.developer.common.dto.SendSnsRequest;
import com.gzmpc.business.developer.message.entity.MessageUnion;
import com.gzmpc.business.developer.message.entity.MessageUnion.MessageType;
import com.gzmpc.business.developer.message.exception.MessageException;
import com.gzmpc.business.developer.message.mapper.MessageUnionMapper;
import com.gzmpc.support.rest.exception.ServerException;

@Service
public class MessageService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageUnionMapper messageUnionMapper;
	
	@Autowired
	ApplicationContext applicationContext;
	
	
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
	
	public void saveEmail(SendEmailRequest request)
			throws ServerException {
		String subject = request.getSubject();
		String target = request.getTarget();
		String content = request.getContent();
		String typeCode = request.getTypeCode();
		String sourceData = request.getSourceData();
		String[] attachments = request.getAttachments();
		MessageUnion message = new MessageUnion(typeCode, sourceData, subject, content, target, MessageType.EMAIL);

		if(attachments != null && attachments.length > 0) {
//			String root = Const.getProjectPath();
//			String[] attach = attachments.split(",");
//			for(String attachment : attach) {
//				File file = new File(root+attachment);
//				if(!file.exists()){
//					throw new ServerException("附件["+attachment+"]不存在");
//				}
//			}
			message.setExt1(String.join(",", attachments));
		}
	
		messageUnionMapper.insert(message);
	}
	
	public void saveMessage(SendSnsRequest request)
			throws ServerException {
		String subject = request.getSubject();
		String target = request.getTarget();
		String content = request.getContent();
		String typeCode = request.getTypeCode();
		String sourceData = request.getSourceData();
		
		MessageUnion message = new MessageUnion(typeCode, sourceData, subject, content, target, MessageType.EMAIL);
	
		messageUnionMapper.insert(message);
	}
	
	public void saveWechatCom(SendSnsRequest request)
			throws ServerException {
		String subject = request.getSubject();
		String target = request.getTarget();
		String content = request.getContent();
		String typeCode = request.getTypeCode();
		String sourceData = request.getSourceData();
		
		MessageUnion message = new MessageUnion(typeCode, sourceData, subject, content, target, MessageType.EMAIL);
	
		messageUnionMapper.insert(message);
	}
}
