package com.gzmpc.business.developer.common.dto;

import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 16, 2020 10:46:37 AM
* 参数DTO
*/

@ApiModel(value = "参数DTO")
public class ParamDTO extends GlobalDTO {

	@ApiModelProperty(value = "键", required = true)
	@NotNull
	private String key;

	@ApiModelProperty(value = "名称", required = true)
	@NotNull
	private String name;
	
	@ApiModelProperty(value = "值", required = true)
	@NotNull
	private String value;

	@ApiModelProperty(value = "继承")
	private boolean inherited;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public boolean getInherited() {
		return inherited;
	}

	public void setInherited(boolean inherited) {
		this.inherited = inherited;
	}

	
}
