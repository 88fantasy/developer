package org.exframework.business.developer.core.listener;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import org.exframework.business.developer.common.dto.DictionaryDTO;
import org.exframework.business.developer.core.annotation.Dictionary;
import org.exframework.business.developer.core.annotation.ParamValue;
import org.exframework.business.developer.core.enums.DictionaryEnum;
import org.exframework.business.developer.core.proxy.ConfigProxy;

/**
 * @author rwe
 * @version 创建时间：2021年6月17日 下午1:12:29 
 * 参数配置类 
 * 由于使用 proxy 故不能在InstantiationAwareBeanPostProcessor 时注入
 */

@Repository
public class DictionaryInitListener implements ApplicationListener<ApplicationReadyEvent> {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.application.name}")
	String appCode;

//	/**
//	 * 开启自动配置
//	 */
//	@Value("${exframework.config.enable:true}")
//	boolean enable;

	@Autowired
	ConfigProxy configProxy;

	private ReflectionUtils.FieldFilter paramValueFilter = (Field field) -> field.isAnnotationPresent(Dictionary.class) && field.getType() == Map.class;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		ConcurrentHashMap<String, Map<String,String>> caches = new ConcurrentHashMap<>();
		List<String> keys = new ArrayList<>();
		ConfigurableApplicationContext ac = event.getApplicationContext();
		for (String beanName : ac.getBeanDefinitionNames()) {
			Object bean = ac.getBean(beanName);

			ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
				@Override
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					ParamValue pv = field.getAnnotation(ParamValue.class);
					String key = pv.value();
					if(!keys.contains(key)) {
						keys.add(key);
					}
				}
			}, paramValueFilter);
		}

		if (keys.size() > 0) {
			try {
				List<DictionaryDTO> dictionaries = configProxy.findDictionaryByKeys(appCode, keys)
						.getDataOrElse(new ArrayList<>());
				for (DictionaryDTO dictionary : dictionaries) {
					caches.put(dictionary.getKey(), dictionary.getValue());
				}
			} catch (Exception e) {
				log.warn(MessageFormat.format("加载参数配置失败:{0}", e.getMessage()), e);
			}

			for (String beanName : ac.getBeanDefinitionNames()) {
				Object bean = ac.getBean(beanName);

				ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
					@Override
					public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
						ReflectionUtils.makeAccessible(field);
						Object value = field.get(bean);
						try {
							Dictionary pv = field.getAnnotation(Dictionary.class);
							String key = pv.key();
							Class<? extends DictionaryEnum> c = pv.enums();
							if(StringUtils.hasText(key)) {
								key = c.getName();
							}
//							long sync = pv.sync();
							if(!caches.containsKey(key)) {
								Map<String, String> proxyValue = configProxy.getDictionaryValue(appCode, key).getDataOrElse(null);
								if (proxyValue != null) {
									caches.putIfAbsent(key, proxyValue);
								}
							}
							Map<String, String> proxyValue = caches.getOrDefault(key, null);
							if (proxyValue != null) {
								value = proxyValue;
							} else {
								log.error(field.getName() + "未找到配置项[" + key + "]或服务器失效,请留意");
							}
							log.info(MessageFormat.format("配置项[{0}]配置值{1}设置为{2}", key, proxyValue, value));
							field.set(bean, value);
						} catch (Exception e) {
							log.error(MessageFormat.format("设置配置项[{0}]失败: {1}", field.getName(), e.getMessage()), e);
						}
					}
				}, paramValueFilter);
			}
		}
	}
}
