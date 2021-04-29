package com.gzmpc.business.developer.rule.config;

import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import com.gzmpc.support.common.annotation.AnnotationClassPathBeanDefinitionScanner;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午10:24:47
* 加载 Rule 注解
*/

@Configuration
public class RuleScannerConfigurer implements  BeanFactoryPostProcessor, ApplicationContextAware {
	
	private static Logger log = LoggerFactory.getLogger(RuleScannerConfigurer.class.getName());

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AnnotationClassPathBeanDefinitionScanner scanner = new AnnotationClassPathBeanDefinitionScanner((BeanDefinitionRegistry)beanFactory, Rule.class);
		scanner.setResourceLoader(this.applicationContext);
		int count = scanner.scan("com.gzmpc.*");
  	log.info("扫描静态规则数量"+count);
	}

}
