package org.exframework.business.developer.common.bus;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
* @author rwe
* @version 创建时间：2021年3月28日 下午5:26:50
* 类说明
*/

public class GatewayRouteEvent extends RemoteApplicationEvent {

	private static final long serialVersionUID = -968108352908735527L;

	public GatewayRouteEvent() {
		super();
	}

	public GatewayRouteEvent(String source, String originService, String destinationService) {
		super(source, originService, destinationService);
	}

	public GatewayRouteEvent(String source, String originService) {
		super(source, originService);
	}

	
}
