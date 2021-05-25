package com.gzmpc.business.developer.wechat.http.client.miniprogram.entity;

import java.util.List;

/**
* @author rwe
* @version 创建时间：2021年5月24日 上午10:19:36
* 类说明
*/

public class GetPerformanceDataRequest {

	/**
	 * 时间跨度不能超过30天
	 */
	private GetPerformanceDataTime time;
	
	/**
	 * 查询数据的类型
	 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/data-analysis/analysis.getPerformanceData.html
	 */
	private String module;
	
	/**
	 * 查询条件
	 */
	private List<GetPerformanceDataParam> params;

	public GetPerformanceDataTime getTime() {
		return time;
	}

	public void setTime(GetPerformanceDataTime time) {
		this.time = time;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public List<GetPerformanceDataParam> getParams() {
		return params;
	}

	public void setParams(List<GetPerformanceDataParam> params) {
		this.params = params;
	}
	
	
}
