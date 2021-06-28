package org.exframework.business.developer.wechat.dto.miniprogram;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 4, 2020 9:43:45 AM
* 登录请求
*/

@ApiModel(value="登录请求")
public class Code2SessionRequest {

	@ApiModelProperty(value = "小程序appId", required = true)
	private String appid;
	
	@ApiModelProperty(value = "登录时获取的code", required = true)
	private String jsCode;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}

	
}
