package com.gzmpc.business.developer.core.dto.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 10:54:21 AM 
 * 发送消息返回
 */

@ApiModel(value = "发送消息返回")
public class MessageResponse {

	/**
	 * 消息平台唯一流水号
	 */
	@ApiModelProperty(value = "消息平台唯一流水号")
	private String msgId;

	public MessageResponse() {

	}
	
	public MessageResponse(String msgId) {
		this.msgId = msgId;
	}

}
