package com.gzmpc.business.developer.core.dto.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 6, 2020 1:45:45 PM
* 类说明
*/

@ApiModel(value="绑定 openid 请求")
public class BindOpenIdRequest {

	@ApiModelProperty(value = "统一帐号")
	private String uaccount;
	
	@ApiModelProperty(value = "微信openid")
	private String openid;

	public String getUaccount() {
		return uaccount;
	}

	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
