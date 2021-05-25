package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:36:09
* 类说明
*/

public class GetDailySummary {

	private String refDate;
	
	/**
	 * 累计用户数
	 */
	private Integer visitTotal;
	
	/**
	 * 转发次数
	 */
	private Integer sharePv;
	
	/**
	 * 转发人数
	 */
	private Integer shareUv;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public Integer getVisitTotal() {
		return visitTotal;
	}

	public void setVisitTotal(Integer visitTotal) {
		this.visitTotal = visitTotal;
	}

	public Integer getSharePv() {
		return sharePv;
	}

	public void setSharePv(Integer sharePv) {
		this.sharePv = sharePv;
	}

	public Integer getShareUv() {
		return shareUv;
	}

	public void setShareUv(Integer shareUv) {
		this.shareUv = shareUv;
	}
	
	
}
