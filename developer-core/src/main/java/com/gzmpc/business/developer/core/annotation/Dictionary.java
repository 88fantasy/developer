package com.gzmpc.business.developer.core.annotation;

import java.lang.annotation.*;

import com.gzmpc.business.developer.core.enums.DictionaryEnum;


/**
* @author rwe
* @version 创建时间：Oct 15, 2020 11:07:15 AM
* 配置引用
*/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dictionary {

	/**
	 * 配置项key
	 * @return
	 */
	String key() default "";
	
	/**
	 * 关联枚举
	 * @return
	 */
	Class<? extends DictionaryEnum> enums() default DictionaryEnum.class;
	/**
	 * 是否同步 单位/秒
	 * -1 不同步
	 * to-do 0采用推送的方式
	 * @return
	 */
	 long sync() default -1;
}
