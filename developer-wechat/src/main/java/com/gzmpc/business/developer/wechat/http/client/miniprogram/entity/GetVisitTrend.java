package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import java.math.BigDecimal;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午8:41:22
* 访问趋势
*/

public class GetVisitTrend {

	private String refDate;
	
	/**
	 * 打开次数
	 */
	private Integer sessionCnt;
	
	/**
	 * 访问次数
	 */
	private Integer visitPv;
	
	/**
	 * 访问人数
	 */
	private Integer visitUv;
	
	/**
	 * 新用户数
	 */
	private Integer visitUvNew;
	
	/**
	 * 人均停留时长 (秒)
	 */
	private Integer stayTimeUv;
	
	/**
	 * 次均停留时长 (秒)
	 */
	private Integer stayTimeSession;
	
	/**
	 * 平均访问深度
	 */
	private BigDecimal visitDepth;

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public Integer getSessionCnt() {
		return sessionCnt;
	}

	public void setSessionCnt(Integer sessionCnt) {
		this.sessionCnt = sessionCnt;
	}

	public Integer getVisitPv() {
		return visitPv;
	}

	public void setVisitPv(Integer visitPv) {
		this.visitPv = visitPv;
	}

	public Integer getVisitUv() {
		return visitUv;
	}

	public void setVisitUv(Integer visitUv) {
		this.visitUv = visitUv;
	}

	public Integer getVisitUvNew() {
		return visitUvNew;
	}

	public void setVisitUvNew(Integer visitUvNew) {
		this.visitUvNew = visitUvNew;
	}

	public Integer getStayTimeUv() {
		return stayTimeUv;
	}

	public void setStayTimeUv(Integer stayTimeUv) {
		this.stayTimeUv = stayTimeUv;
	}

	public Integer getStayTimeSession() {
		return stayTimeSession;
	}

	public void setStayTimeSession(Integer stayTimeSession) {
		this.stayTimeSession = stayTimeSession;
	}

	public BigDecimal getVisitDepth() {
		return visitDepth;
	}

	public void setVisitDepth(BigDecimal visitDepth) {
		this.visitDepth = visitDepth;
	}

	
	
}
