package org.exframework.business.developer.message.http.client;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Post;
import org.exframework.business.developer.message.http.client.entity.SendMessageHttpRequest;
import org.exframework.business.developer.message.http.client.entity.SendMessageHttpResponse;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午4:07:13
* 梦网短信接口
*/

public interface MessageClient {

	@Post(url = "http://${url}/sms/v2/std/send_single", contentType = "application/json", dataType = "json")
	public SendMessageHttpResponse sendSingle(@DataVariable("url") String url, @Body SendMessageHttpRequest request);

	@Post(url = "http://${url}/sms/v2/std/send_batch", contentType = "application/json", dataType = "json")
	public SendMessageHttpResponse sendBatch(@DataVariable("url") String url, @Body SendMessageHttpRequest request);

}
