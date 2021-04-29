package com.gzmpc.business.developer.portal.springboot.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.tsf.annotation.EnableTsf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.gzmpc.portal.metadata.entity.EntityScan;
import com.gzmpc.support.jdbc.annotation.TableEntityScan;

@SpringBootApplication(scanBasePackages = { "com.gzmpc.*",
		"com.gitee.sunchenbin.mybatis.actable.manager.*" }, exclude = {DruidDataSourceAutoConfigure.class})
//@EnableFeignClients(basePackages = { "com.gzmpc.*" }) // 使用Feign微服务调用时请启用
@EnableTsf
@MapperScan(basePackages = { "com.gzmpc.business.developer.portal.mapper","com.gzmpc.portal.jdbc.mapper.*", "com.gitee.sunchenbin.mybatis.actable.dao.*" })
@EntityScan({ "com.gzmpc.portal.metadata", "com.gzmpc.portal.web.entity.*", "com.gzmpc.portal.admin.entity.*", "com.gzmpc.business.developer.portal.*", "com.gzmpc.business.developer.rule.entity" })
@TableEntityScan({ "com.gzmpc.portal.jdbc.entity" })
/**
 * 微服务 启动类
 * 
 * @author rwe
 * @version 创建时间：May 31, 2020 11:29:07 AM
 * 
 */
public class DeveloperPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperPortalApplication.class, args);
	}
}