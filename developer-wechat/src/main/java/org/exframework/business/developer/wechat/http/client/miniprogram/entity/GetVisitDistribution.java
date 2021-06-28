package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:53:46
* 类说明
*/

public class GetVisitDistribution {

	private String index;
	
	private List<GetVisitDistributionItem> itemList;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public List<GetVisitDistributionItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<GetVisitDistributionItem> itemList) {
		this.itemList = itemList;
	}
	
}
