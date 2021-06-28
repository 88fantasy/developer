package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:32:31
* 类说明
*/

public class GetPerformanceDataResponseBodyTable {

	private String id;
	
	private List<GetPerformanceDataResponseBodyTableLine> lines;
	
	private String zh;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<GetPerformanceDataResponseBodyTableLine> getLines() {
		return lines;
	}

	public void setLines(List<GetPerformanceDataResponseBodyTableLine> lines) {
		this.lines = lines;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}
	
	
}
