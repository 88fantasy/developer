package com.gzmpc.business.developer.portal.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 原句显示类型枚举
 * 
 * @author pro
 *
 */
public enum DataItemDisplayTypeEnum implements DictionaryEnum {

	/**
	 *  普通
	 */
	EDIT("edit", "普通"),
	
	/**
	 *  只读
	 */
	READONLY("readonly", "只读"),

	/**
	 * 字典
	 */
	DICTIONARY("dictionary", "字典"),
	
	/**
	 * 复选
	 */
	CHECKBOX("checkbox", "复选");
	
	private String key;

  private String value;

	private DataItemDisplayTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String[] keys() {
		DataItemDisplayTypeEnum[] values = DataItemDisplayTypeEnum.values();
		List<String> keys = new ArrayList<String>(values.length);
		for(DataItemDisplayTypeEnum e : values) {
			keys.add(e.key);
		}
		return keys.toArray(new String[keys.size()]);
	}

	@Override
	public String getValue(String key) {
		for(DataItemDisplayTypeEnum e : DataItemDisplayTypeEnum.values()) {
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}

}
