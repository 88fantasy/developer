package org.exframework.business.developer.core.annotation;

import java.lang.annotation.*;
import java.util.concurrent.ConcurrentHashMap;

import org.exframework.business.developer.core.enums.ConfigParamValueTypeEnum;


/**
* @author rwe
* @version 创建时间：Oct 15, 2020 11:07:15 AM
* 配置引用
*/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamValue {

	/**
	 * 配置项key
	 * @return
	 */
	String value();
	
	/**
	 * 当获取配置项失败时的默认返回值
	 * @return
	 */
	String defaultValue() default "";
	
	/**
	 * 值类型
	 * @return
	 */
	ConfigParamValueTypeEnum type() default ConfigParamValueTypeEnum.STRING;
	/**
	 * 类名
	 * @return
	 */
	Class<?> cls() default ConcurrentHashMap.class;
	
}
