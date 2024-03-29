package org.exframework.business.developer.message.springboot.application;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.exframework.support.jdbc.annotation.TableEntityScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "org.exframework.*"
        },
        exclude = DruidDataSourceAutoConfigure.class
)
@MapperScan(basePackages = {"org.exframework.business.developer.message.mapper"})
@TableEntityScan({"org.exframework.business.developer.message.entity"})
@EnableFeignClients(basePackages = {"org.exframework.*"}) // 使用Feign微服务调用时请启用
@ForestScan(basePackages = "org.exframework.business.developer.message.http.client")
/**
 * 微服务 启动类
 *
 * @author rwe
 * @version 创建时间：May 31, 2020 11:29:07 AM
 *
 */
public class DeveloperMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeveloperMessageApplication.class, args);
    }
}