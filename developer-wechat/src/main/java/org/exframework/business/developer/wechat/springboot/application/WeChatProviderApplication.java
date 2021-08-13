package org.exframework.business.developer.wechat.springboot.application;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication(scanBasePackages = { "org.exframework.*" })
@EnableFeignClients(basePackages = { "org.exframework.*" }) // 使用Feign微服务调用时请启用
@ForestScan(basePackages = "org.exframework.business.developer.wechat.http.client")
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