package com.gzmpc.business.developer.config.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
* @author rwe
* @version 创建时间：Oct 15, 2020 4:00:05 PM
*  全局变量 DO
*/

public class Global {

	@TableField
	private String appCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	
}
