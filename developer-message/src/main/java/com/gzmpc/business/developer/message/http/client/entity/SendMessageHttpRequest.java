package com.gzmpc.business.developer.message.http.client.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午10:28:48
* 梦网短信发送请求
*/

public class SendMessageHttpRequest {

	private String userid;
	
	private String pwd;
	
	private String mobile;
	
	private String content;
	
	private String timestamp;
	
	private String svrtype;
	
	private String exno;
	
	private String custid;

	public SendMessageHttpRequest(String userid, String pwd, String mobile, String content, String svrtype,
			String exno, String custid) {
		String time = new SimpleDateFormat("MMddHHmmss").format(new Date());
		String md5 = DigestUtils.md5Hex(userid+"00000000"+pwd+time);
		this.userid = userid;
		this.pwd = md5;
		this.mobile = mobile;
		this.content = content;
		this.timestamp = time;
		this.svrtype = svrtype;
		this.exno = exno;
		this.custid = custid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSvrtype() {
		return svrtype;
	}

	public void setSvrtype(String svrtype) {
		this.svrtype = svrtype;
	}

	public String getExno() {
		return exno;
	}

	public void setExno(String exno) {
		this.exno = exno;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
	
}
