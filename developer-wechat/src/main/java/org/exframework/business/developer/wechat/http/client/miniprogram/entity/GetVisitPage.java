package org.exframework.business.developer.wechat.http.client.miniprogram.entity;

/**
* @author rwe
* @version 创建时间：2021年5月23日 下午11:46:32
* 类说明
*/

public class GetVisitPage {

	/**
	 * 页面路径
	 */
	private String pagePath;
	
	/**
	 * 访问次数
	 */
	private Integer pageVisitPv;
	
	/**
	 * 访问人数
	 */
	private Integer pageVisitUv;
	
	/**
	 * 次均停留时长
	 */
	private Integer pageStaytimePv;
	
	/**
	 * 进入页次数
	 */
	private Integer entrypagePv;
	
	/**
	 * 退出页次数
	 */
	private Integer exitpagePv;
	
	/**
	 * 转发次数
	 */
	private Integer pageSharePv;
	
	/**
	 * 转发人数
	 */
	private Integer pageShareUv;

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public Integer getPageVisitPv() {
		return pageVisitPv;
	}

	public void setPageVisitPv(Integer pageVisitPv) {
		this.pageVisitPv = pageVisitPv;
	}

	public Integer getPageVisitUv() {
		return pageVisitUv;
	}

	public void setPageVisitUv(Integer pageVisitUv) {
		this.pageVisitUv = pageVisitUv;
	}

	public Integer getPageStaytimePv() {
		return pageStaytimePv;
	}

	public void setPageStaytimePv(Integer pageStaytimePv) {
		this.pageStaytimePv = pageStaytimePv;
	}

	public Integer getEntrypagePv() {
		return entrypagePv;
	}

	public void setEntrypagePv(Integer entrypagePv) {
		this.entrypagePv = entrypagePv;
	}

	public Integer getExitpagePv() {
		return exitpagePv;
	}

	public void setExitpagePv(Integer exitpagePv) {
		this.exitpagePv = exitpagePv;
	}

	public Integer getPageSharePv() {
		return pageSharePv;
	}

	public void setPageSharePv(Integer pageSharePv) {
		this.pageSharePv = pageSharePv;
	}

	public Integer getPageShareUv() {
		return pageShareUv;
	}

	public void setPageShareUv(Integer pageShareUv) {
		this.pageShareUv = pageShareUv;
	}
	
	
}
