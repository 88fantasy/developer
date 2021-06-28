package org.exframework.business.developer.portal.constant;

/**
 * 参数配置常量类
 * @author pro
 *
 */
public interface DeveloperParamApiConstants {

	public String API_PARAM = "v1/param";
	
	public String API_PARAM_GET_VALUE = API_PARAM+"/getValue/{appCode}/{key}";
	
	public String API_PARAM_QUERY_KEYS = API_PARAM+"/queryKeys/{appCode}";
	
	public String API_PARAM_SAVE_VALUE = API_PARAM+"/saveValue";
	
	public String API_PARAM_FINDALL = API_PARAM+"/findAll/{appCode}";
	
	public String API_PARAM_QUERYLIST = API_PARAM+"/queryList";
}
