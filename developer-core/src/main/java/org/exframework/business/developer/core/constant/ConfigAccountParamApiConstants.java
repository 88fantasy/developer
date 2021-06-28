package org.exframework.business.developer.core.constant;

/**
 * 参数配置常量类
 * @author pro
 *
 */
public interface ConfigAccountParamApiConstants {

	public String API_ACCOUNT_PARAM = "v1/accountParam";
	
	public String API_ACCOUNT_PARAM_GET_VALUE = API_ACCOUNT_PARAM+"/getValue/{appCode}/{account}/{key}";
	
	public String API_ACCOUNT_PARAM_SAVE_VALUE = API_ACCOUNT_PARAM+"/saveValue";
	
	public String API_ACCOUNT_PARAM_FINDALL = API_ACCOUNT_PARAM+"/findAll/{appCode}/{account}";
}
