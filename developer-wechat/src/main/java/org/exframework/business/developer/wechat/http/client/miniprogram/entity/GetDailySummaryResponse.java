package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:38:44
* 类说明
*/

public class GetDailySummaryResponse extends GlobalResponse {

	private List<GetDailySummary> list;

	public List<GetDailySummary> getList() {
		return list;
	}

	public void setList(List<GetDailySummary> list) {
		this.list = list;
	}
	
}
