package org.exframework.business.developer.message.http.client;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Post;
import org.exframework.business.developer.message.constant.MessageConstants;
import org.exframework.business.developer.message.http.client.entity.SendMessageHttpRequest;
import org.exframework.business.developer.message.http.client.entity.SendMessageHttpResponse;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午4:07:13
* 类说明
*/

public interface OtrsClient {

	@Post(url = MessageConstants.OTRS_API_URL, contentType = "application/json", dataType = "json")
	public SendMessageHttpResponse sendMessage(@DataVariable("url") String url, @Body SendMessageHttpRequest request);

	
}
