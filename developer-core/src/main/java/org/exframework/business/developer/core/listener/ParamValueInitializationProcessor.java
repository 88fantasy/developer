package org.exframework.business.developer.core.listener;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.exframework.business.developer.core.annotation.ParamValue;
import org.exframework.business.developer.core.enums.ConfigParamValueTypeEnum;
import org.exframework.business.developer.core.proxy.ConfigProxy;

/**
 * @author rwe
 * @version 创建时间：2021年6月17日 上午9:46:35 类初始化后设置值
 */

//@Component
public class ParamValueInitializationProcessor implements InstantiationAwareBeanPostProcessor, PriorityOrdered {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Value("${spring.application.name}")
	String appCode;

	/**
	 * 开启自动配置
	 */
	@Value("${exframework.config.enable:true}")
	boolean enable;

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ConfigProxy configProxy;

	private final ConcurrentHashMap<String, String> caches = new ConcurrentHashMap<>();

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				Object value = field.get(bean);
				try {
					ParamValue pv = field.getAnnotation(ParamValue.class);
					String key = pv.value();
					ConfigParamValueTypeEnum type = pv.type();
					Class<?> cls = pv.cls();
					String defaultValue = pv.defaultValue();

					
					if (!caches.containsKey(key)) {
						String proxyValue = configProxy.getParamValue(appCode, key).getDataOrElse(defaultValue);
						if(StringUtils.hasText(proxyValue)) {
							caches.putIfAbsent(key, proxyValue);
						}
					}
					String valueString = caches.get(key);
					if(StringUtils.hasText(valueString)) {
						value = getParamObject(valueString, type, cls);
					}
					else {
						log.error(field.getName() + "未找到配置项[" + key + "]或服务器失效,并没有指定默认值,不进行配置");
					}
					field.set(bean, value);
				} catch (Exception e) {
					log.error(MessageFormat.format("设置配置项[{0}]失败: {1}", field.getName(), e.getMessage()), e);
				}
			}
		}, new ReflectionUtils.FieldFilter() {
			@Override
			public boolean matches(Field field) {
				return field.isAnnotationPresent(ParamValue.class);
			}
		});

		return bean;
	}

	private Object getParamObject(String value, ConfigParamValueTypeEnum type, Class<?> cls)
			throws JsonParseException, JsonMappingException, IOException {
		switch (type) {
		case STRING:
			return value;
		case LONG:
			return new Long(value);
		case BIGDECIMAL:
			return new BigDecimal(value);
		case MAP:
			return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true).readValue(value,
					new TypeReference<ConcurrentHashMap<String, Object>>() {
					});
		case BEAN:
			return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true).readValue(value,
					cls);
		default:
			return value;
		}
	}

	@Override
	public int getOrder() {
		return PriorityOrdered.HIGHEST_PRECEDENCE;
	}

//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		List<String> keys = new ArrayList<>();
//		for( String beanName : beanFactory.getBeanDefinitionNames()) {
//			Object bean = beanFactory.getBean(beanName);
//			ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
//				@Override
//				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
//					ParamValue pv = field.getAnnotation(ParamValue.class);
//					String key = pv.value();
//					keys.add(key);
//				}
//			}, new ReflectionUtils.FieldFilter() {
//				@Override
//				public boolean matches(Field field) {
//					return field.isAnnotationPresent(ParamValue.class);
//				}
//			});
//		}
//		
//		if (keys.size() > 0) {
//			try {
//				Map<String, ParamDTO> paramList = configProxy.findParamByKeys(appCode, keys)
//						.getDataOrElse(new ConcurrentHashMap<>());
//				for (ParamDTO param : paramList.values()) {
//					caches.put(param.getParamKey(), param);
//				}
//			} catch (Exception e) {
//				log.warn(MessageFormat.format("加载参数配置失败:{0}", e.getMessage()), e);
//			}
//		}
//	}

}
