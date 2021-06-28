package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:56:07
* 类说明
*/

public class GetVisitDistributionResponse extends GlobalResponse  {

	private String refDate;
	
	private List<GetVisitDistribution> list;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public List<GetVisitDistribution> getList() {
		return list;
	}

	public void setList(List<GetVisitDistribution> list) {
		this.list = list;
	}
	
	
}
