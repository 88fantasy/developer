package org.exframework.business.developer.core.dto.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 6, 2020 3:09:16 PM
* 类说明
*/

@ApiModel(value="获取openid帐号信息返回")
public class GetUaccountByOpenidResponse extends GlobalResponse {

	@ApiModelProperty(value = "统一帐号")
	private String uaccount;

	public String getUaccount() {
		return uaccount;
	}

	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	
	
}
