package com.gzmpc.business.developer.message.service;

import com.gzmpc.business.developer.message.exception.MessageException;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午1:15:52
* 发送工厂
*/

public interface Sender {

	
	public void send(String json) throws MessageException;
	
}
