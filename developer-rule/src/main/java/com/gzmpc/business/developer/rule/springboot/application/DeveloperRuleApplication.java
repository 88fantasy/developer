package com.gzmpc.business.developer.rule.springboot.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.gzmpc.support.jdbc.annotation.TableEntityScan;

@SpringBootApplication(
		scanBasePackages = {
	            "com.gzmpc.*", 
	    },
		exclude = DruidDataSourceAutoConfigure.class
	)
@MapperScan(basePackages = {"com.gzmpc.business.developer.rule.mapper", "com.gzmpc.business.developer.rule.rules.mapper", })
@TableEntityScan({"com.gzmpc.business.developer.rule.entity", "com.gzmpc.business.developer.rule.rules.entity"})
@EnableFeignClients(basePackages = { "com.gzmpc.*" }) 
@EnableTsf
/**
 * 微服务 启动类
 * 
 * @author rwe
 * @version 创建时间：May 31, 2020 11:29:07 AM
 * 
 */
public class DeveloperRuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperRuleApplication.class, args);
	}
}