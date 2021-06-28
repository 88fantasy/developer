package org.exframework.business.developer.gateway.filter;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import org.exframework.business.developer.common.constant.DeveloperConstants;
import org.exframework.business.developer.common.dto.RequestLogger;

import reactor.core.publisher.Mono;

/**
 * @author rwe
 * @version 创建时间：2021年6月11日 上午9:17:13 记录访问日志
 */

@Component
public class LoggingFilter implements GlobalFilter, Ordered {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	private final String START_TIME = "startTime";

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Value("${loggingfilter.excludedSuffix}")
	String exclude;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String method = exchange.getRequest().getMethod().name();
		String path = exchange.getRequest().getURI().getPath();
		String params = JSON.toJSONString(exchange.getRequest().getQueryParams());
		int index = path.lastIndexOf(".");
		if(index > -1) {
			String suffix = path.substring(index+1);
			if(Arrays.asList(exclude.split("\\|")).stream().anyMatch(ex -> ex.equals(suffix))) {
				return chain.filter(exchange);
			}
		}

		String info = String.format("Method:{%s} Host:{%s} Path:{%s} Query:{%s}", method,
				exchange.getRequest().getURI().getHost(), path, params);
		logger.info(info);
		exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			Long startTime = exchange.getAttribute(START_TIME);
			if (startTime != null) {
				Long executeTime = (System.currentTimeMillis() - startTime);

				logger.info(exchange.getRequest().getURI().getRawPath() + " : " + executeTime + "ms");

				RequestLogger requestLog = new RequestLogger(method, path, params,
						exchange.getResponse().getStatusCode().value(), executeTime);

				String json = JSON.toJSONString(requestLog);

				rabbitTemplate.convertAndSend(DeveloperConstants.MQ_EXCHANGE_REQUEST_LOG,
						DeveloperConstants.MQ_ROUTING_REQUEST_LOG, json);
			}
		}));
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

}
