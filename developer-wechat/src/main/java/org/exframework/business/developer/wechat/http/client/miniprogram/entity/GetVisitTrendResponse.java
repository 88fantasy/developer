package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午8:46:10
* 访问趋势返回
*/

public class GetVisitTrendResponse extends GlobalResponse  {

	private List<GetVisitTrend> list;

	public List<GetVisitTrend> getList() {
		return list;
	}

	public void setList(List<GetVisitTrend> list) {
		this.list = list;
	}
	
}
