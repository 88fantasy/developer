package org.exframework.business.developer.portal.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 原句显示类型枚举
 * 
 * @author pro
 *
 */
public enum DataItemValidTypeEnum implements DictionaryEnum {

	/**
	 *   整数
	 */
	LONG("long","整数"),
	
	/**
	 *   字符串
	 */
	 STRING("string","字符串"),

	/**
	 *  小数
	 */
	BIGDECIMAL("bigdecimal","小数"),
	
	/**
	 * 布尔
	 */
	BOOLEAN("boolean","布尔")
	
	;

	private String key;

  private String value;

	private DataItemValidTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String[] keys() {
		DataItemValidTypeEnum[] values = DataItemValidTypeEnum.values();
		List<String> keys = new ArrayList<String>(values.length);
		for(DataItemValidTypeEnum e : values) {
			keys.add(e.key);
		}
		return keys.toArray(new String[keys.size()]);
	}

	@Override
	public String getValue(String key) {
		for(DataItemValidTypeEnum e : DataItemValidTypeEnum.values()) {
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}
}
