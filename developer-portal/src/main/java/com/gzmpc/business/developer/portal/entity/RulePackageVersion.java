package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.business.developer.portal.dependency.RulePackage;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午1:37:29
* 规则集版本
*/

@TableName("rule_package_version")
public class RulePackageVersion implements Serializable, Version {

	private static final long serialVersionUID = 1043835579030499358L;

	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	
	@TableField
	private String code;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	@ColumnType(value = MySqlTypeConstant.JSON)
	private RulePackage entity;
	
	@TableField
	private Integer version;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date versionTime;

	public RulePackageVersion() {
		nextVersion();
	}
			
	public RulePackageVersion(RulePackage entity) {
		this();
		this.code = entity.getCode();
		this.entity = entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public RulePackage getEntity() {
		return entity;
	}

	public void setEntity(RulePackage entity) {
		this.entity = entity;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getVersionTime() {
		return versionTime;
	}

	public void setVersionTime(Date versionTime) {
		this.versionTime = versionTime;
	}
	
	

}
