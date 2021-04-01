package com.gzmpc.business.developer.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.admin.entity.WechatApp;
import com.gzmpc.business.developer.admin.mapper.WechatAppMapper;
import com.gzmpc.business.developer.common.bus.WechatAppUpdateEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;

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

}
