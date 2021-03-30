package com.gzmpc.business.developer.core.dto.wechat.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Sep 23, 2020 9:17:24 AM
* 鉴权类
*/

@ApiModel(value="调用接口凭证")
public class AccessTokenRequest {

	@ApiModelProperty(value = "企业ID")
	private String corpid;
	
	@ApiModelProperty(value = "应用的凭证密钥")
	private String screct;

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getScrect() {
		return screct;
	}

	public void setScrect(String screct) {
		this.screct = screct;
	}
	
	
}
