package com.gzmpc.business.developer.common.dto;

import java.util.Map;

import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 16, 2020 10:46:37 AM
* 字典DTO
*/

@ApiModel(value = "字典DTO")
public class DictionaryDTO extends GlobalDTO {

	@ApiModelProperty(value = "键", required = true)
	@NotNull
	private String key;

	@ApiModelProperty(value = "名称", required = true)
	@NotNull
	private String name;
	
	@ApiModelProperty(value = "值", required = true)
	@NotNull
	private Map<String,String> value;

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

	public Map<String, String> getValue() {
		return value;
	}

	public void setValue(Map<String, String> value) {
		this.value = value;
	}

	
	
}
