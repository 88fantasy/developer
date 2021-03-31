package com.gzmpc.business.developer.gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication(scanBasePackages = { "com.gzmpc.*" }, exclude = {})
@EnableFeignClients(basePackages = { "com.gzmpc.*" }) // 使用Feign微服务调用时请启用
@org.springframework.boot.autoconfigure.EnableAutoConfiguration
@org.springframework.cloud.client.discovery.EnableDiscoveryClient
@org.springframework.boot.context.properties.EnableConfigurationProperties
@org.springframework.tsf.auth.annotation.EnableTsfAuth
@org.springframework.cloud.tsf.route.annotation.EnableTsfRoute
@org.springframework.tsf.ratelimit.annotation.EnableTsfRateLimit
@com.tencent.tsf.sleuth.annotation.EnableTsfSleuth
@com.tencent.tsf.monitor.annotation.EnableTsfMonitor
@org.springframework.cloud.tsf.faulttolerance.annotation.EnableTsfFaultTolerance
@com.tencent.cloud.tsf.lane.annotation.EnableTsfLane
//@EnableTsf
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}