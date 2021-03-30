package com.gzmpc.business.developer.core.dto.wechat.com.message;

/**
* @author rwe
* @version 创建时间：2021年3月25日 下午2:02:01
* 消息内容键值对
*/

public class MiniProgramNoticeContentItem {
	
	private String key;
	
	private String value;

	public MiniProgramNoticeContentItem() {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
