package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：Oct 15, 2020 4:02:02 PM
* 类说明
*/

@TableName("application")
public class Application extends Global implements Serializable {
	
	private static final long serialVersionUID = -6205818368992076415L;
	
	@TableField
	private String appName;


	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
}
