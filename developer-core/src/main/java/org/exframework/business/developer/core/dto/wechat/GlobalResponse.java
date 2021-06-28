package org.exframework.business.developer.core.dto.wechat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 10:54:21 AM 全局参数
 */

@ApiModel(value = "登录请求")
public class GlobalResponse {

	/**
	 * 出错返回码，为0表示成功，非0表示调用失败
	 */
	@ApiModelProperty(value = "出错返回码")
	private Integer errcode;

	/**
	 * 返回码提示语
	 */
	@ApiModelProperty(value = "返回码提示语")
	private String errmsg;

	public GlobalResponse() {
		super();
	}
	
	public GlobalResponse(Integer errcode, String errmsg) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		if (errcode == null) {
			this.errcode = 0;
		} else {
			this.errcode = errcode;
		}
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Boolean checkSuccess() {
		return errcode == null || errcode == 0;
	}
}
