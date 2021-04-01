package com.gzmpc.business.developer.wechat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.gzmpc.business.developer.common.bus.GatewayRouteEvent;
import com.gzmpc.business.developer.common.bus.WechatAppUpdateEvent;
import com.gzmpc.business.developer.common.bus.WechatComAppUpdateEvent;
import com.gzmpc.business.developer.wechat.service.WeChatService;
import com.gzmpc.business.developer.wechat.service.com.ComService;

/**
* @author rwe
* @version 创建时间：2021年3月28日 下午5:33:01
* 类说明
*/

@Configuration
@RemoteApplicationEventScan(basePackageClasses = {WechatAppUpdateEvent.class, WechatComAppUpdateEvent.class})
public class BusConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(BusConfiguration.class);
	
	@Autowired
	WeChatService weChatService;
	
	@Autowired
	ComService comService;

	@EventListener
  public void onGatewayRemoteApplicationEvent(WechatAppUpdateEvent event) {
			logger.info("刷新微信小程序 originService: {}, destinationService: {} ", event.getOriginService(), event.getDestinationService());
			weChatService.refresh();
  }
	
	@EventListener
  public void onGatewayRemoteApplicationEvent(WechatComAppUpdateEvent event) {
			logger.info("刷新微信应用 originService: {}, destinationService: {} ", event.getOriginService(), event.getDestinationService());
			comService.refresh();
  }
}
