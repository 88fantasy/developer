package com.gzmpc.business.developer.gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.tsf.circuitbreaker.config.TsfCircuitBreakerFilterAutoConfiguration;
import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication(scanBasePackages = { "com.gzmpc.*" }, exclude = {})
@EnableFeignClients(basePackages = { "com.gzmpc.*" }) // 使用Feign微服务调用时请启用
@EnableTsf
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}