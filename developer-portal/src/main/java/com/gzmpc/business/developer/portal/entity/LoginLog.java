package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.portal.metadata.dict.Dictionary;
import com.gzmpc.portal.metadata.dict.DictionaryEnum;
import com.gzmpc.portal.metadata.dict.DictionaryEnumClass;
import com.gzmpc.portal.metadata.entity.EntityClass;
import com.gzmpc.support.jdbc.annotation.AutoCreateTime;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:07:22
* 登录日志
*/

@EntityClass
@TableName("login_log")
public class LoginLog implements Serializable, DictionaryEnumClass {

	private static final long serialVersionUID = -3008544253201089066L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long loggerId;
	
	@TableField
	@NotNull
	private String ipaddress;
	
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private PlatformType platform;
	
	@TableField
	private String device;
	
	@TableField
	private String account;
	
	@TableField
	private String accountName;
	
	@AutoCreateTime
	@TableField(fill = FieldFill.INSERT)
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date createTime;

	public Long getLoggerId() {
		return loggerId;
	}

	public void setLoggerId(Long loggerId) {
		this.loggerId = loggerId;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public PlatformType getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformType platform) {
		this.platform = platform;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	@Dictionary( value = "platformType", name = "消息类型")
	public enum PlatformType implements DictionaryEnum {

		Web("网页端"), Mobile("移动端")
		;

		private String label;

		private PlatformType(String label) {
			this.label = label;
		}


		public String getLabel() {
			return label;
		}
	}


	@Override
	public Class<? extends DictionaryEnum>[] enums() {
		return new Class[]{PlatformType.class};
	}
	
}
