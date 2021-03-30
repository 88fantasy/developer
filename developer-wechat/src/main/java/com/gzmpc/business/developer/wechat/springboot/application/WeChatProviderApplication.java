package com.gzmpc.business.developer.wechat.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

import com.thebeastshop.forest.springboot.annotation.ForestScan;


@SpringBootApplication(scanBasePackages = { "com.gzmpc.*" })
@EnableFeignClients(basePackages = { "com.gzmpc.*" }) // 使用Feign微服务调用时请启用
@EnableTsf
@ForestScan(basePackages = "com.gzmpc.business.developer.wechat.http.client.*")
/**
 * 微服务 启动类
 * 
 * @author rwe
 * @version 创建时间：May 31, 2020 11:29:07 AM
 * 
 */
public class WeChatProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatProviderApplication.class, args);
	}
}