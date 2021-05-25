package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

import com.gzmpc.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:49:45
* 类说明
*/

public class GetVisitPageResponse extends GlobalResponse {

	private String refDate;
	
	private List<GetVisitPage> list;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public List<GetVisitPage> getList() {
		return list;
	}

	public void setList(List<GetVisitPage> list) {
		this.list = list;
	}
	
	
}
