package org.exframework.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccount;

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
	
	@AutoCurrentAccount
	@TableField(fill = FieldFill.INSERT)
	private String creator;
	
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public Date getVersionTime() {
		return versionTime;
	}

	@Override
	public void setVersionTime(Date versionTime) {
		this.versionTime = versionTime;
	}
	
	

}
