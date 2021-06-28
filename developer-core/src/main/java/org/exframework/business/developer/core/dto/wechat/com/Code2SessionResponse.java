package org.exframework.business.developer.core.dto.wechat.com;


import org.exframework.business.developer.core.dto.wechat.GlobalResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 4, 2020 9:43:45 AM
* 登录返回
*/

@ApiModel(value="登录返回")
public class Code2SessionResponse extends GlobalResponse {

	@ApiModelProperty(value = "用户所属企业的corpid")
	private String corpid;
	
	@ApiModelProperty(value = "用户在企业内的UserID，对应管理端的帐号，企业内唯一")
	private String userid;


	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
}
