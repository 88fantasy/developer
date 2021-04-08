package com.gzmpc.business.developer.portal.entity;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author rwe
 * @version 创建时间：Oct 7, 2020 12:10:00 PM 微信程序实体类
 */

@TableName("wechat_com_app")
public class WechatComApp extends Editable {

	private static final long serialVersionUID = 3401115089003184599L;

	/**
	 * 应用Id
	 */
	@TableId(type = IdType.INPUT)
	@NotNull
	private String agentId;

	/**
	 * 应用密钥
	 */
	@TableField
	@NotNull
	private String name;
	
	/**
	 * 应用密钥
	 */
	@TableField
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
