package com.gzmpc.business.developer.wechat.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.wechat.entity.AppInfo;

/**
* @author rwe
* @version 创建时间：Oct 7, 2020 12:12:06 PM
* 类说明
*/

@Service
public class WeChatService {
	
	private ConcurrentHashMap<String,AppInfo> apps;

	WeChatService() {
		apps = new ConcurrentHashMap<String,AppInfo>();
		AppInfo bpmMp = new AppInfo();
		bpmMp.setAppId("wxc3c33c1a8ecb5bd2");
		bpmMp.setAppSecret("8c3eb38df31282625a4b94412c03d989");
		AppInfo healthMp = new AppInfo();
		healthMp.setAppId("wx931f605511d9a870");
		healthMp.setAppSecret("fe77e213db06fa00e9676e0f2af7f3ad");
		healthMp.setPayId("1603692645");
		healthMp.setPaySecret("Kjgs20201029Kjgs20201029lsdsfwb0");
		apps.put("wxc3c33c1a8ecb5bd2", bpmMp);
		apps.put("wx931f605511d9a870", healthMp);
	}
	
	public AppInfo getAppInfo(String appId) {
		return apps.get(appId);
	}
}
