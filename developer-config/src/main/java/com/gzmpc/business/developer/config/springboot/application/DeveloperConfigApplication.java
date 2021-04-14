package com.gzmpc.business.developer.config.springboot.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.gzmpc.support.jdbc.annotation.TableEntityScan;
import com.thebeastshop.forest.springboot.annotation.ForestScan;

@SpringBootApplication(
		scanBasePackages = {
	            "com.gzmpc.*"
	    },
		exclude = DruidDataSourceAutoConfigure.class
	)
@MapperScan(basePackages = {"com.gzmpc.business.developer.message.mapper"})
@TableEntityScan({"com.gzmpc.business.developer.message.entity"})
@EnableFeignClients(basePackages = { "com.gzmpc.*" }) // 使用Feign微服务调用时请启用
@EnableTsf
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