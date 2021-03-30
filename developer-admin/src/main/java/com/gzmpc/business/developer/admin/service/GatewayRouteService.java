package com.gzmpc.business.developer.admin.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.admin.dto.GatewayRouteDTO;
import com.gzmpc.business.developer.admin.dto.GatewayRouteDeleteDTO;
import com.gzmpc.business.developer.admin.entity.GatewayRouteDO;
import com.gzmpc.business.developer.admin.mapper.GatewayRouteMapper;
import com.gzmpc.business.developer.common.bus.GatewayRouteEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;

/**
 * 网关路由处理类
 * 
 * @author pro
 *
 */
@Service
public class GatewayRouteService extends DeveloperBaseService<GatewayRouteMapper, GatewayRouteDO> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
  private BusProperties busProperties;
	
	@Autowired
  private ApplicationEventPublisher eventPublisher;

	Consumer<GatewayRouteDO> after = entity -> saveToRedis(entity);

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
		List<GatewayRouteDO> entities = list();
		for (GatewayRouteDO entity : entities) {
			logger.info("更新路由 ->{}", JSON.toJSONString(entity));
			saveToRedis(entity);
		}
		
		//广播所有网关实例进行刷新
		String instanceId = busProperties.getId();
		GatewayRouteEvent event = new GatewayRouteEvent(UUID.randomUUID().toString(), instanceId, DeveloperConstants.SERVICE_NAME_GATEWAY);
    eventPublisher.publishEvent(event);
    
		logger.info("更新网关路由结束");
	}

	private void saveToRedis(GatewayRouteDO entity) {
		redisTemplate.opsForHash().put(DeveloperConstants.GATEWAY_ROUTES_KEY, entity.getServiceId(),
				JSON.toJSONString(entity));
	}
}
