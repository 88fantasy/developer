package com.gzmpc.business.developer.gateway.route;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.gateway.entity.GatewayRoute;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 从 redis 同步路由表 
 * Author: rwe 
 * Date: 2021年3月25日
 *
 * Copyright @ 2021
 * 
 */
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

	private static final Logger logger = LoggerFactory.getLogger(RedisRouteDefinitionRepository.class);
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		List<RouteDefinition> routeDefinitions = new ArrayList<>();
		redisTemplate.opsForHash().values(DeveloperConstants.GATEWAY_ROUTES_KEY).stream().forEach(routeDefinition -> {
			GatewayRoute route = JSON.parseObject(routeDefinition.toString(),GatewayRoute.class);
			logger.info(MessageFormat.format("加载路由{0}", JSON.toJSONString(route)));
			routeDefinitions.add(route.toDefinition());
		});
		return Flux.fromIterable(routeDefinitions);
	}

	@Override
	public Mono<Void> save(Mono<RouteDefinition> route) {
		return route.flatMap(routeDefinition -> {
			redisTemplate.opsForHash().put(DeveloperConstants.GATEWAY_ROUTES_KEY, routeDefinition.getId(), JSON.toJSONString(routeDefinition));
			return Mono.empty();
		});
	}

	@Override
	public Mono<Void> delete(Mono<String> routeId) {
		return routeId.flatMap(id -> {
			if (redisTemplate.opsForHash().hasKey(DeveloperConstants.GATEWAY_ROUTES_KEY, id)) {
				redisTemplate.opsForHash().delete(DeveloperConstants.GATEWAY_ROUTES_KEY, id);
			} else {
				logger.error("路由文件没有找到: " + routeId);
			}
			return Mono.empty();
		});
	}
}
