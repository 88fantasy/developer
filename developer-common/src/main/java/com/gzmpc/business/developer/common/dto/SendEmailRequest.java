package com.gzmpc.business.developer.common.dto;


import com.gzmpc.business.developer.common.enums.MessageType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 6, 2020 1:45:45 PM
* 发送邮件请求
*/

@ApiModel(value="发送邮件请求")
public class SendEmailRequest extends Message {
	
	private static final long serialVersionUID = 8040205609129515621L;
	
	@ApiModelProperty(value = "附件列表")
	private String[] attachments;


	public String[] getAttachments() {
		return attachments;
	}

	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

	@Override
	public MessageType getMessageType() {
		return MessageType.EMAIL;
	}

	
}
