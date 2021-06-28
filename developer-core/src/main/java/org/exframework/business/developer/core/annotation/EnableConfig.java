package org.exframework.business.developer.core.annotation;

import java.lang.annotation.*;

/**
* @author rwe
* @version 创建时间：Oct 15, 2020 11:07:15 AM
* 开启读取配置中心
*/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableConfig {

}
