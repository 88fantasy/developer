package org.exframework.business.developer.wechat.dto;

import org.exframework.business.developer.common.dto.WechatAppDTO;
import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:22:59 PM
* 获取app信息返回
*/

@ApiModel(value="获取app信息返回")
public class GetAppInfoResponse extends GlobalResponse {

	@ApiModelProperty(value = "微信小程序")
	private WechatAppDTO appInfo;

	public WechatAppDTO getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(WechatAppDTO appInfo) {
		this.appInfo = appInfo;
	}
	
}
