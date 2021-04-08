package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.time.DateUtils;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.portal.metadata.dict.Dictionary;
import com.gzmpc.portal.metadata.dict.DictionaryEnum;
import com.gzmpc.portal.metadata.dict.DictionaryEnumClass;
import com.gzmpc.portal.metadata.entity.EntityClass;
import com.gzmpc.support.doc.annotation.TableDoc;
import com.gzmpc.support.doc.annotation.TableFieldDoc;

/**
 * 统一信息实体类 Author: rwe Date: Dec 29, 2020
 *
 * Copyright @ 2020
 * 
 */
@EntityClass
@TableDoc("统一信息")
@TableName(value = "message_union", excludeProperty = {})
public class MessageUnion implements Serializable, DictionaryEnumClass {

	private static final long serialVersionUID = 3758720093132638087L;

	/**
	 * 主键
	 */
	@TableFieldDoc("主键")
	@TableId
	private String id;

	/**
	 * 类型码
	 */
	@TableFieldDoc("类型码")
	@TableField
	private String typeCode;

	/**
	 * 开发者参数
	 */
	@TableFieldDoc("开发者参数")
	@TableField
	private String sourceData;

	/**
	 * 标题
	 */
	@NotEmpty
	@TableFieldDoc("标题")
	@TableField
	private String subject;

	/**
	 * 内容
	 */
	@NotEmpty
	@TableFieldDoc("内容")
	@TableField
	private String content;

	/**
	 * 目标对象
	 */
	@NotEmpty
	@TableFieldDoc("目标对象")
	@TableField
	private String target;

	/**
	 * 信息类型
	 */
	@NotNull
	@TableFieldDoc("信息类型")
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private MessageType messageType;

	/**
	 * 对应途径的序号(如果有)
	 */
	@TableFieldDoc("对应途径的序号(如果有)")
	@TableField
	private String sendTargetId;

	/**
	 * 失败次数
	 */
	@TableFieldDoc("失败次数")
	@TableField
	private Integer failCount;

	/**
	 * 是否发送
	 */
	@TableFieldDoc("是否发送")
	@TableField
	private Boolean sended;

	/**
	 * 发送时间
	 */
	@TableFieldDoc("发送时间")
	@TableField
	private Date sendTime;

	/**
	 * 发送反馈
	 */
	@TableFieldDoc("发送反馈")
	@TableField
	private String feedback;

	/**
	 * 客户端 IP
	 */
	@TableFieldDoc("客户端 IP")
	@TableField
	private String ip;

	/**
	 * 创建时间
	 */
	@TableFieldDoc("创建时间")
	@TableField
	private Date credate;

	/**
	 * 扩展参数1
	 */
	@TableFieldDoc("扩展参数1")
	@TableField
	private String ext1;

	/**
	 * 扩展参数2
	 */
	@TableFieldDoc("扩展参数2")
	@TableField
	private String ext2;

	/**
	 * 扩展参数3
	 */
	@TableFieldDoc("扩展参数3")
	@TableField
	private String ext3;

	/**
	 * 扩展参数4
	 */
	@TableFieldDoc("扩展参数4")
	@TableField
	private String ext4;

	/**
	 * 扩展参数5
	 */
	@TableFieldDoc("扩展参数5")
	@TableField
	private String ext5;

	/**
	 * 优先级
	 */
	@TableFieldDoc("优先级")
	@TableField
	private Integer priority;

	/**
	 * 失效时间
	 */
	@TableFieldDoc("失效时间")
	@TableField
	private Date invalidDate;

	public MessageUnion() {

	}

	public MessageUnion(String typeCode, String sourceData, @NotEmpty String subject, @NotEmpty String content,
			@NotEmpty String target, @NotNull MessageType messageType) {
		this(typeCode, sourceData, subject, content, target, messageType, null, null, null, null, null, null);
	}

	public MessageUnion(String typeCode, String sourceData, @NotEmpty String subject, @NotEmpty String content,
			@NotEmpty String target, @NotNull MessageType messageType, String ip, String ext1, String ext2, String ext3,
			String ext4, String ext5) {
		this(typeCode, sourceData, subject, content, target, messageType, null, 0, false, null, null, ip, ext1, ext2, ext3,
				ext4, ext5, 0, DateUtils.addDays(new Date(), 1));
	}

	public MessageUnion(String typeCode, String sourceData, @NotEmpty String subject, @NotEmpty String content,
			@NotEmpty String target, @NotNull MessageType messageType, String sendTargetId, Integer failCount, Boolean sended,
			Date sendTime, String feedback, String ip, String ext1, String ext2, String ext3, String ext4, String ext5,
			Integer priority, Date invalidDate) {
		this.typeCode = typeCode;
		this.sourceData = sourceData;
		this.subject = subject;
		this.content = content;
		this.target = target;
		this.messageType = messageType;
		this.sendTargetId = sendTargetId;
		this.failCount = failCount;
		this.sended = sended;
		this.sendTime = sendTime;
		this.feedback = feedback;
		this.ip = ip;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
		this.priority = priority;
		this.invalidDate = invalidDate;
		this.credate = new Date();
	}

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

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
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

	public Boolean getSended() {
		return sended;
	}

	public void setSended(Boolean sended) {
		this.sended = sended;
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

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
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

	@Dictionary( value = "messageType", name = "消息类型")
	public enum MessageType implements DictionaryEnum<String> {

		MESSAGE("message", "短信"), EMAIL("email", "邮件"), OTRS("otrs", "OTRS工单"), WECHAT_COM("wechat_com", "企业微信推送"),

		;

		private String key;

		private String name;

		private MessageType(String key, String name) {
			this.key = key;
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

		@Override
		public String getValue() {
			return this.key;
		}
	}
	
	@Dictionary( value = "sendedEnum", name = "发送状态")
	public enum SendedEnum implements DictionaryEnum<String> {

		WAITING("waiting", "等待中"), SUCCESS("success", "已发送"), FAIL("fail", "发送失败")
		;

		private String key;

		private String name;

		private SendedEnum(String key, String name) {
			this.key = key;
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

		@Override
		public String getValue() {
			return this.key;
		}
	}

	@Override
	public Class<? extends DictionaryEnum<?>>[] enums() {
		return new Class[]{SendedEnum.class, MessageType.class};
	}
}
