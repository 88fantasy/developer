package com.gzmpc.business.developer.message.http.client.entity;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午10:34:19
* 梦网短信发送返回
*/

public class SendMessageHttpResponse {

	private Long result;
	
	private Long msgid;
	
	private String custid;

	public Long getResult() {
		return result;
	}

	public void setResult(Long result) {
		this.result = result;
	}

	public Long getMsgid() {
		return msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	
}
