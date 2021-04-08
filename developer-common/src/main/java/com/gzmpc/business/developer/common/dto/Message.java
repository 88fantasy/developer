package com.gzmpc.business.developer.common.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gzmpc.business.developer.common.enums.MessageType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午1:32:06
* 类说明
*/

@ApiModel(value="消息")
public class Message implements Serializable {

	private static final long serialVersionUID = -9200156002635902216L;

	/**
	 * 标题
	 */
	@NotEmpty( message = "缺少必要参数 - 标题[subject]")
	@ApiModelProperty(value = "标题", required = true)
	private String subject;
	
	/**
	 * 内容
	 */
	@NotEmpty( message = "缺少必要参数 - 内容[content]")
	@ApiModelProperty(value = "内容", required = true)
	private String content;
	
	/**
	 * 目标对象
	 * 多个用逗号(,)分隔
	 */
	@NotEmpty( message = "缺少必要参数 - 目标对象[target]")
	@ApiModelProperty(value = "目标对象,多个用逗号(,)分隔", required = true)
	private String target;

	/**
	 * 类型码
	 */
	@ApiModelProperty(value = "类型码")
	private String typeCode;
	
	/**
	 * 开发者参数
	 */
	@ApiModelProperty(value = "开发者参数")
	private String sourceData;
	
	/**
	 * 消息类型
	 */
	@ApiModelProperty(hidden = true)
	private MessageType messageType;

	/**
	 * 来源 IP
	 */
	@ApiModelProperty(hidden = true)
	private String ip;
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getSourceData() {
		return sourceData;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}
	

	
}
