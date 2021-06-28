package org.exframework.business.developer.wechat.dto.miniprogram;

import javax.validation.constraints.NotNull;

import org.exframework.business.developer.wechat.http.client.miniprogram.entity.DateRange;

/**
* @author rwe
* @version 创建时间：2021年5月23日 上午11:57:23
* 类说明
*/

public class GetRetainRequest extends AppDateRangeRequest {

	@NotNull
	private RetainType type;
	
	
	public RetainType getType() {
		return type;
	}

	public void setType(RetainType type) {
		this.type = type;
	}


	public enum RetainType {
		DAILY,
		WEEKLY,
		MONTHLY;
	}
}
