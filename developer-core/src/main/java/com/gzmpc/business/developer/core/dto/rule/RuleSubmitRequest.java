package com.gzmpc.business.developer.core.dto.rule;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年4月30日 下午5:25:00
* 提交规则运算请求
*/

@ApiModel(value="提交规则运算请求")
public class RuleSubmitRequest {

	@NotEmpty
	@ApiModelProperty(value = "规则集代码", required = true)
	private String  packageCode;
	
	@NotEmpty
	@ApiModelProperty(value = "业务单据内容", required = true)
	private String  json;
	
	@ApiModelProperty(value = "ip", hidden = true)
	private String  ip;

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
