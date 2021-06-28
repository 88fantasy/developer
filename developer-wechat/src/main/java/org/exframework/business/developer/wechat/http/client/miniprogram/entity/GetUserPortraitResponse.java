package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午12:06:53
* 类说明
*/

public class GetUserPortraitResponse extends GlobalResponse  {

	private String refDate;
	
  private GetUserPortrait visitUvNew;
  
  private  GetUserPortrait visitUv;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public GetUserPortrait getVisitUvNew() {
		return visitUvNew;
	}

	public void setVisitUvNew(GetUserPortrait visitUvNew) {
		this.visitUvNew = visitUvNew;
	}

	public GetUserPortrait getVisitUv() {
		return visitUv;
	}

	public void setVisitUv(GetUserPortrait visitUv) {
		this.visitUv = visitUv;
	}
  
  
}
