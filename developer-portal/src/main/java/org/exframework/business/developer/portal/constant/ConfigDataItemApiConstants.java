package org.exframework.business.developer.portal.constant;

/**
 * 参数配置常量类
 * @author pro
 *
 */
public interface ConfigDataItemApiConstants {

	public String API_DATAITEM = "v1/dataitem";
	
	public String API_DATAITEM_GET_VALUE = API_DATAITEM+"/get/{appCode}/{withGlobal}";
	
	public String API_DATAITEM_POST_VALUE = API_DATAITEM+"/post";
	
	public String API_DATAITEM_DELETE_VALUE = API_DATAITEM+"/delete";
	
	public String API_DATAITEM_QUERYLIST = API_DATAITEM+"/queryList";
	
	public String API_DATAITEM_FINDALL = API_DATAITEM+"/findAll/{appCode}";
	
}
