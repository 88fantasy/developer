package com.gzmpc.business.developer.portal.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.common.bus.WechatAppUpdateEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.portal.entity.WechatApp;
import com.gzmpc.business.developer.portal.mapper.WechatAppMapper;

/**
* @author rwe
* @version 创建时间：2021年3月29日 下午11:01:28
* 微信应用业务处理
*/

@Service
public class WechatAppService extends DeveloperBaseService<WechatAppMapper, WechatApp> implements IRedisConfig<WechatAppUpdateEvent,WechatApp> {

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
		return DeveloperConstants.WECHAT_APP_KEY;
	}

	@Override
	public ApplicationEventPublisher getApplicationEventPublisher() {
		return publisher;
	}

	@Override
	public WechatAppUpdateEvent getRemoteApplicationEvent(String instanceId) {
		return new WechatAppUpdateEvent(UUID.randomUUID().toString(), instanceId, DeveloperConstants.SERVICE_NAME_WECHAT);
	}

}
