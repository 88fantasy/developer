package com.gzmpc.business.developer.portal.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.portal.entity.RequestLog;
import com.gzmpc.business.developer.portal.mapper.RequestLogMapper;
import com.gzmpc.support.jdbc.service.ExBaseService;
import com.rabbitmq.client.Channel;

/**
* @author rwe
* @version 创建时间：2021年6月11日 上午10:50:18
* 请求日志业务
*/

@Service
public class RequestLogService extends ExBaseService<RequestLogMapper, RequestLog> {
	
	private final Logger logger = LoggerFactory.getLogger(RequestLogService.class);
	
	@Autowired
	RequestLogMapper requestLogMapper;
	

	@RabbitListener(queues = DeveloperConstants.MQ_QUEUE_REQUEST_LOG, ackMode = "MANUAL")
	public void comsumerRequestLog(String data, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,  Channel channel) throws IOException {
		logger.info("接收到信息: "+data);
		RequestLog entity = JSON.parseObject(data, RequestLog.class);
		int count = requestLogMapper.insert(entity);
		if(count > 0) {
			channel.basicAck(deliveryTag, false);
		}
		else {
			channel.basicNack(deliveryTag, false, true);
		}
	}
}
