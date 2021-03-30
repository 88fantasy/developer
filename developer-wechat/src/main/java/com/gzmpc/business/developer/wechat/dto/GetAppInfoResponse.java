package com.gzmpc.business.developer.wechat.dto;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;
import com.gzmpc.business.developer.wechat.entity.AppInfo;

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
	private AppInfo appInfo;

	public AppInfo getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(AppInfo appInfo) {
		this.appInfo = appInfo;
	}
	
}
