package com.gzmpc.business.developer.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gzmpc.support.jdbc.dao.CUTimeMetaObjectHandler;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 文档配置类
 * 
 * @author pro
 *
 */
@Configuration
public class DeveloperConfig {

	@Bean(value = "defaultApi")
	public Docket defaultApi() {
		Docket docket = new Docket(DocumentationType.OAS_30)
				.apiInfo(new ApiInfoBuilder().title("Developer APIs").description("# Developer RESTful APIs")
						.termsOfServiceUrl("http://www.xx.com/").contact(new Contact("阮伟儿", "", "ruanweier@gzmpc.com"))
						.version("1.0").build())
				.groupName("Default API").select()
				// 这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.gzmpc.business.developer.portal.controller")).paths(PathSelectors.any())
				.build();
		return docket;
	}
	
	
}
