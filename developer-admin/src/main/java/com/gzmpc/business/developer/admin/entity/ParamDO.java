package com.gzmpc.business.developer.admin.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author rwe
 * @version 创建时间：Oct 15, 2020 11:48:39 AM 
 * 参数数据实体
 */

@TableName("param")
public class ParamDO extends GlobalDO implements Serializable {

	private static final long serialVersionUID = 7083780975464797162L;

	@TableId
	private String id;
	
	@TableField
	@NotNull
	private String key;
	
	@TableField
	private String name;

	@TableField
	@NotNull
	private String value;

	@TableField
	private boolean inherited;
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isInherited() {
		return inherited;
	}

	public void setInherited(boolean inherited) {
		this.inherited = inherited;
	}


}
