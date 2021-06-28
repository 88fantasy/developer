package org.exframework.business.developer.message.service;

import org.exframework.business.developer.message.exception.MessageException;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午1:15:52
* 发送工厂
*/

public interface Sender {

	
	public void send(String json) throws MessageException;
	
}
