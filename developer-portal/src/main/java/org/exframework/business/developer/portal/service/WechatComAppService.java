package org.exframework.business.developer.portal.service;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import org.exframework.business.developer.common.bus.WechatComAppUpdateEvent;
import org.exframework.business.developer.common.constant.DeveloperConstants;
import org.exframework.business.developer.portal.entity.WechatComApp;
import org.exframework.business.developer.portal.mapper.WechatComAppMapper;

/**
* @author rwe
* @version 创建时间：2021年3月29日 下午11:01:28
* 微信应用业务处理
*/

@Service
public class WechatComAppService extends DeveloperBaseService<WechatComAppMapper, WechatComApp> implements IRedisConfig<WechatComAppUpdateEvent,WechatComApp> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	ApplicationEventPublisher publisher;
	

	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@Override
	public String getRedisKey() {
		return DeveloperConstants.WECHAT_COM_APP_KEY;
	}

	@Override
	public ApplicationEventPublisher getApplicationEventPublisher() {
		return publisher;
	}

	@Override
	public WechatComAppUpdateEvent getRemoteApplicationEvent(String instanceId) {
		return new WechatComAppUpdateEvent(UUID.randomUUID().toString(), instanceId, DeveloperConstants.SERVICE_NAME_WECHAT);
	}

	
	

//	public Boolean delete(GatewayRouteDeleteDTO gatewayRouteDeleteDTO) {
//		List<String> ids = gatewayRouteDeleteDTO.getIds();
//		List<String> services = listByIds(ids).stream().map(entity -> entity.getServiceId()).collect(Collectors.toList());
//		if(services.size() > 0) {
//			boolean success = removeByIds(ids);
//			for(String serviceId : services) {
//				redisTemplate.opsForHash().delete(DeveloperConstants.GATEWAY_ROUTES_KEY, serviceId);
//			}
//			return success;
//		}
//		else {
//			return false;
//		}
//	}

}
