package com.gzmpc.business.developer.portal.service;

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
import com.gzmpc.business.developer.common.bus.GatewayRouteEvent;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.portal.dto.GatewayRouteDTO;
import com.gzmpc.business.developer.portal.dto.GatewayRouteDeleteDTO;
import com.gzmpc.business.developer.portal.entity.GatewayRoute;
import com.gzmpc.business.developer.portal.entity.MessageUnion;
import com.gzmpc.business.developer.portal.mapper.GatewayRouteMapper;
import com.gzmpc.business.developer.portal.mapper.MessageUnionMapper;
import com.gzmpc.support.jdbc.service.ExBaseService;

/**
 * 网关路由处理类
 * 
 * @author pro
 *
 */
@Service
public class MessageService extends ExBaseService<MessageUnionMapper, MessageUnion> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	public boolean saveOrUpdate(GatewayRouteDTO gatewayRouteDto) {
//		return saveOrUpdateDTO(gatewayRouteDto, null, after);
//	}

	
}
