package org.exframework.business.developer.config.springboot.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.exframework.support.jdbc.annotation.TableEntityScan;

@SpringBootApplication(
		scanBasePackages = {
	            "org.exframework.*"
	    },
		exclude = DruidDataSourceAutoConfigure.class
	)
@MapperScan(basePackages = {"org.exframework.business.developer.config.mapper"})
@TableEntityScan({"org.exframework.business.developer.config.entity"})
@EnableFeignClients(basePackages = { "org.exframework.*" }) // 使用Feign微服务调用时请启用
/**
 * 微服务 启动类
 * 
 * @author rwe
 * @version 创建时间：May 31, 2020 11:29:07 AM
 * 
 */
public class DeveloperConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperConfigApplication.class, args);
	}
}