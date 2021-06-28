package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

/**
 * @author rwe
 * @version 创建时间：2021年5月23日 上午10:41:35 获取留存返回
 */

public class GetRetainClientResponse extends GlobalResponse {

	private String refDate;

	private KeyValue[] visitUvNew;

	private KeyValue[] visitUv;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public KeyValue[] getVisitUvNew() {
		return visitUvNew;
	}

	public void setVisitUvNew(KeyValue[] visitUvNew) {
		this.visitUvNew = visitUvNew;
	}

	public KeyValue[] getVisitUv() {
		return visitUv;
	}

	public void setVisitUv(KeyValue[] visitUv) {
		this.visitUv = visitUv;
	}

	
}
