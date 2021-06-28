package org.exframework.business.developer.core.dto.wechat.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 4, 2020 9:43:45 AM
* 登录请求
*/

@ApiModel(value="企业微信登录请求")
public class Code2SessionRequest {

	@ApiModelProperty(value = "应用ID", required = true)
	private Integer agentId;
	
	@ApiModelProperty(value = "登录时获取的code", required = true)
	private String jsCode;

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}

	
}
