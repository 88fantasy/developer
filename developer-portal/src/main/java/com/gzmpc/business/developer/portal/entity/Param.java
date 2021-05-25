package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author rwe
 * @version 创建时间：Oct 15, 2020 11:48:39 AM 
 * 参数数据实体
 */

@TableName("param")
public class Param extends Global implements Serializable {

	private static final long serialVersionUID = 7083780975464797162L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	
	@TableField
	@NotNull
	private String paramKey;
	
	@TableField
	private String paramName;

	@TableField
	@NotNull
	private String value;

	@TableField
	private Boolean inherited;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getInherited() {
		return inherited;
	}

	public void setInherited(Boolean inherited) {
		this.inherited = inherited;
	}


}
