package com.gzmpc.business.developer.admin.service;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.common.bus.WechatComAppUpdateEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.support.common.util.SpringContextUtils;

/**
* @author rwe
* @version 创建时间：2021年3月31日 下午11:45:54
* 通过 Redis 配置
*/

public interface IRedisConfig<E extends RemoteApplicationEvent, T> {
	
	ApplicationEventPublisher getApplicationEventPublisher();
	
	
	BaseMapper<T> getBaseMapper();
	
	RedisTemplate<String, Object> getRedisTemplate();
	
	String getRedisKey();

	default void reload() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		ApplicationContext ac = SpringContextUtils.getApplicationContext();
		ApplicationEventPublisher publisher = getApplicationEventPublisher();
		BusProperties busProperties = ac.getBean(BusProperties.class);
		RedisTemplate<String, Object> redisTemplate = getRedisTemplate();
		Boolean result = redisTemplate.delete(getRedisKey());
		logger.info("清空{}配置 {} ", this.getClass(), result);
		List<T> entities = getBaseMapper().selectList(Wrappers.emptyWrapper());
		for (T entity : entities) {
			logger.info("更新{}配置 ->{}", this.getClass(),JSON.toJSONString(entity));
			saveToRedis(entity);
		}
		
		//广播所有网关实例进行刷新
		String instanceId = busProperties.getId();
		WechatComAppUpdateEvent event = new WechatComAppUpdateEvent(UUID.randomUUID().toString(), instanceId, DeveloperConstants.SERVICE_NAME_WECHAT);
		publisher.publishEvent(event);
    
		logger.info("更新{}配置结束", this.getClass());
	}
	
	default void saveToRedis(T entity) {
		Object key = getKey(entity);
		getRedisTemplate().opsForHash().put(getRedisKey(), key,
				JSON.toJSONString(entity));
	}
	
	default Object getKey(T entity) {
		TableInfo tableInfo = TableInfoHelper.getTableInfo(entity.getClass());
    Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!");
    String keyProperty = tableInfo.getKeyProperty();
    Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!");
    return ReflectionKit.getFieldValue(entity, tableInfo.getKeyProperty());
	}
	
	default Consumer<T> getConsumer() {
		return entity -> saveToRedis(entity);
	}
}
