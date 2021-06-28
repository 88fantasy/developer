package org.exframework.business.developer.common.bus;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import org.exframework.business.developer.common.constant.DeveloperConstants;

/**
* @author rwe
* @version 创建时间：2021年3月28日 下午5:26:50
* 类说明
*/

public class WechatAppUpdateEvent extends RemoteApplicationEvent {

	private static final long serialVersionUID = -968292605391739532L;

	public WechatAppUpdateEvent() {
		super();
	}

	public WechatAppUpdateEvent(String source, String originService, String destinationService) {
		super(source, originService, destinationService);
	}

	public WechatAppUpdateEvent(String source, String originService) {
		super(source, originService, DeveloperConstants.SERVICE_NAME_WECHAT);
	}

	
}
