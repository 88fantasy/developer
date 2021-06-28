package org.exframework.business.developer.gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication(scanBasePackages = { "org.exframework.*" }, exclude = {})
@EnableFeignClients(basePackages = { "org.exframework.*" }) // 使用Feign微服务调用时请启用
@org.springframework.boot.autoconfigure.EnableAutoConfiguration
@org.springframework.cloud.client.discovery.EnableDiscoveryClient
@org.springframework.boot.context.properties.EnableConfigurationProperties
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}