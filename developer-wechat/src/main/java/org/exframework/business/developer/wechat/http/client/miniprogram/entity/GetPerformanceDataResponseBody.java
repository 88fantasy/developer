package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:26:43
* 类说明
*/

public class GetPerformanceDataResponseBody {

	private List<GetPerformanceDataResponseBodyTable> tables;
	
	private Integer count;

	public List<GetPerformanceDataResponseBodyTable> getTables() {
		return tables;
	}

	public void setTables(List<GetPerformanceDataResponseBodyTable> tables) {
		this.tables = tables;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
