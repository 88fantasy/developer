package com.gzmpc.business.developer.wechat.dto.miniprogram;

import javax.validation.constraints.NotNull;

/**
 * @author rwe
 * @version 创建时间：2021年5月27日 上午11:11:19 类说明
 */

public class GetUserPortraitRequest extends AppDateRequest {
	
	@NotNull
	private Integer range;

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

}
