package org.exframework.business.developer.portal.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一信息DTO
 * Author: rwe Date: Dec 29, 2020
 *
 * Copyright @ 2020
 * 
 */

@ApiModel(value = "统一信息")
public class MessageDTO  {

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "消息Id", required = true)
	private String id;

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
	 * 标题
	 */
	@NotEmpty
	@ApiModelProperty(value = "标题")
	private String subject;

	/**
	 * 内容
	 */
	@NotEmpty
	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 目标对象
	 */
	@NotEmpty
	@ApiModelProperty(value = "目标对象")
	private String target;

	/**
	 * 信息类型
	 */
	@NotNull
	@ApiModelProperty(value = "信息类型")
	private String messageType;

	/**
	 * 对应途径的序号(如果有)
	 */
	@ApiModelProperty(value = "对应途径的序号(如果有)")
	private String sendTargetId;

	/**
	 * 失败次数
	 */
	@ApiModelProperty(value = "失败次数")
	private Integer failCount;

	/**
	 * 是否发送
	 */
	@ApiModelProperty(value = "发送状态")
	private String sendState;

	/**
	 * 发送时间
	 */
	@ApiModelProperty(value = "发送时间")	
	private Date sendTime;

	/**
	 * 发送反馈
	 */
	@ApiModelProperty(value = "发送反馈")
	
	private String feedback;

	/**
	 * 客户端 IP
	 */
	@ApiModelProperty(value = "客户端 IP")
	
	private String ip;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date credate;

	/**
	 * 优先级
	 */
	@ApiModelProperty(value = "优先级")
	private Integer priority;

	/**
	 * 失效时间
	 */
	@ApiModelProperty(value = "失效时间")
	private Date invalidDate;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSendTargetId() {
		return sendTargetId;
	}

	public void setSendTargetId(String sendTargetId) {
		this.sendTargetId = sendTargetId;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}


	public String getSendState() {
		return sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}


	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	
}
