package com.gzmpc.business.developer.message.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author rwe
 * @version 创建时间：2021年4月8日 上午8:50:51 类说明
 */

public class MontnetsAccount implements Serializable {

	private static final long serialVersionUID = -2924426924426308067L;

	/**
	 * 发送者
	 */
	@NotNull
	private String from;

	/**
	 * 发送地址
	 */
	@NotNull
	private String url;

	/**
	 * 帐号
	 */
	@NotNull
	private String userid;

	/**
	 * 密码
	 */
	@NotNull
	private String pwd;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
