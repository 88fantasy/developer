package com.gzmpc.business.developer.portal.service;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.bus.GatewayRouteEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.portal.dto.GatewayRouteDTO;
import com.gzmpc.business.developer.portal.dto.GatewayRouteDeleteDTO;
import com.gzmpc.business.developer.portal.entity.GatewayRoute;
import com.gzmpc.business.developer.portal.mapper.GatewayRouteMapper;

/**
 * 网关路由处理类
 * 
 * @author pro
 *
 */
@Service
public class GatewayRouteService extends DeveloperBaseService<GatewayRouteMapper, GatewayRoute> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
  private BusProperties busProperties;
	
	@Autowired
  private ApplicationEventPublisher eventPublisher;

	Consumer<GatewayRoute> after = entity -> saveToRedis(entity);

	public boolean saveOrUpdate(GatewayRouteDTO gatewayRouteDto) {
		return saveOrUpdateDTO(gatewayRouteDto, null, after);
	}

	public Boolean delete(GatewayRouteDeleteDTO gatewayRouteDeleteDTO) {
		List<String> ids = gatewayRouteDeleteDTO.getIds();
		List<String> services = listByIds(ids).stream().map(entity -> entity.getServiceId()).collect(Collectors.toList());
		if(services.size() > 0) {
			boolean success = removeByIds(ids);
			for(String serviceId : services) {
				redisTemplate.opsForHash().delete(DeveloperConstants.GATEWAY_ROUTES_KEY, serviceId);
			}
			return success;
		}
		else {
			return false;
		}
	}

	public void reload() {
		Boolean result = redisTemplate.delete(DeveloperConstants.GATEWAY_ROUTES_KEY);
		logger.info("清空网关路由 {} ", result);
		List<GatewayRoute> entities = list();
		for (GatewayRoute entity : entities) {
			logger.info("更新路由 ->{}", JSON.toJSONString(entity));
			saveToRedis(entity);
		}
		
		//广播所有网关实例进行刷新
		String instanceId = busProperties.getId();
		GatewayRouteEvent event = new GatewayRouteEvent(UUID.randomUUID().toString(), instanceId, DeveloperConstants.SERVICE_NAME_GATEWAY);
    eventPublisher.publishEvent(event);
    
		logger.info("更新网关路由结束");
	}

	private void saveToRedis(GatewayRoute entity) {
		redisTemplate.opsForHash().put(DeveloperConstants.GATEWAY_ROUTES_KEY, entity.getServiceId(),
				JSON.toJSONString(entity));
	}
}
