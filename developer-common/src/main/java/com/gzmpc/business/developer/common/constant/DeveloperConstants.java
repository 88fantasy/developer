package com.gzmpc.business.developer.common.constant;

/**
 * @author rwe
 * @version 创建时间：2021年3月27日 上午10:05:31 常量
 */

public interface DeveloperConstants {

	String GATEWAY_ROUTES_KEY = "/developer/gateway/routes";
	String WECHAT_COM_APP_KEY = "/developer/wechat/com/app";
	String WECHAT_APP_KEY = "/developer/wechat/app";

	String CONFIG_KEY = "/developer/config";
	String CONFIG_PARAM_KEY = CONFIG_KEY+"/param/{0}/{1}";
	String CONFIG_ACCOUNTPARAM_KEY = CONFIG_KEY+"/accountparam/{0}/{1}";
	String CONFIG_DICTIONARY_KEY = CONFIG_KEY+"/dictionary/{0}/{1}";
//	String CONFIG_DATAITEM_KEY = "/developer/config/dataitem/{0}";

	String GLOBAL_APPLICATION_CODE = "global";

	String SERVICE_NAME_GATEWAY = "developer-gateway";

	String SERVICE_NAME_CONFIG = "developer-config";

	String SERVICE_NAME_WECHAT = "developer-wechat";

	String SERVICE_NAME_MESSAGE = "developer-message";
	
	String SERVICE_NAME_RULE = "developer-rule";
}
