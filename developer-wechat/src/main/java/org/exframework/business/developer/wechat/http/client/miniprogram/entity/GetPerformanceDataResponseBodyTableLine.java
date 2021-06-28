package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:37:43
* 类说明
*/

public class GetPerformanceDataResponseBodyTableLine {

	private List<GetPerformanceDataResponseBodyTableLineField> fields;

	public List<GetPerformanceDataResponseBodyTableLineField> getFields() {
		return fields;
	}

	public void setFields(List<GetPerformanceDataResponseBodyTableLineField> fields) {
		this.fields = fields;
	}
	
	
}
