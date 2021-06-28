package org.exframework.business.developer.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.exframework.business.developer.common.constant.DeveloperConstants;

/**
 * @author rwe
 * @version 创建时间：2021年6月11日 上午10:07:41 类说明
 */

@Configuration
public class RabbitConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(DeveloperConstants.MQ_EXCHANGE_REQUEST_LOG);
	}

	@Bean
	public Queue queue() {
		// 创建一个持久化的队列
		return new Queue(DeveloperConstants.MQ_QUEUE_REQUEST_LOG, true);
	}

	@Bean
	public Binding binding(TopicExchange topicExchange, Queue queue) {
		return BindingBuilder.bind(queue).to(topicExchange).with(DeveloperConstants.MQ_ROUTING_REQUEST_LOG);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				logger.info("消息成功发送到Exchange");
			} else {
				logger.info("消息发送到Exchange失败, {}, cause: {}", correlationData, cause);
			}
		});
		rabbitTemplate.setMandatory(true);
//		rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//			logger.info("消息从Exchange路由到Queue失败: exchange: {}, route: {}, replyCode: {}, replyText: {}, message: {}", exchange,
//					routingKey, replyCode, replyText, message);
//		});
		return rabbitTemplate;
	}

}
