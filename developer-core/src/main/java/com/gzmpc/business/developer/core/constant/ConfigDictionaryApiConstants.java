package com.gzmpc.business.developer.core.constant;

/**
 * 字典配置常量类
 * @author pro
 *
 */
public interface ConfigDictionaryApiConstants {

	public String API_DICTIONARY = "v1/dictionary";
	
	public String API_DICTIONARY_GET = API_DICTIONARY+"/get/{appCode}/{key}";
	
	public String API_DICTIONARY_SAVE = API_DICTIONARY+"/save";
	
	public String API_DICTIONARY_DETELE = API_DICTIONARY+"/delete";
	
	public String API_DICTIONARY_QUERYLIST = API_DICTIONARY+"/queryList";
	
	public String API_DICTIONARY_FINDALL = API_DICTIONARY+"/findAll/{appCode}";
}
