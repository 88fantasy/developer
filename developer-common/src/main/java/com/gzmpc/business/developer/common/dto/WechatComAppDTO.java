package com.gzmpc.business.developer.common.dto;

import javax.validation.constraints.NotNull;

/**
 * @author rwe
 * @version 创建时间：Oct 7, 2020 12:10:00 PM 微信程序实体类
 */

public class WechatComAppDTO {

	/**
	 * 应用Id
	 */
	@NotNull
	private String agentId;

	/**
	 * 应用密钥
	 */
	@NotNull
	private String name;
	
	/**
	 * 应用密钥
	 */
	@NotNull
	private String secret;

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	

}
