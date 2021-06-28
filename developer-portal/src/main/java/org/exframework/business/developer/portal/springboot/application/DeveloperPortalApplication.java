package org.exframework.business.developer.portal.springboot.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.exframework.portal.metadata.entity.EntityScan;
import org.exframework.support.jdbc.annotation.TableEntityScan;

@SpringBootApplication(scanBasePackages = { "org.exframework.*",
		"com.gitee.sunchenbin.mybatis.actable.manager.*" }, exclude = { DruidDataSourceAutoConfigure.class })
@EnableFeignClients(basePackages = { "org.exframework.*" }) // 使用Feign微服务调用时请启用
@MapperScan(basePackages = { "org.exframework.business.developer.portal.mapper", "org.exframework.portal.jdbc.mapper.*",
		"com.gitee.sunchenbin.mybatis.actable.dao.*" })
@EntityScan({ "org.exframework.portal.metadata", "org.exframework.portal.web.entity.*", "org.exframework.portal.admin.entity.*",
		"org.exframework.business.developer.portal.*" })
@TableEntityScan({ "org.exframework.portal.jdbc.entity" })
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