package org.exframework.business.developer.core.dto.wechat.com.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:23:16 AM 发送消息 请求
 */

@ApiModel(value="文本消息请求")
public class SendTextMessageRequest extends SendMessageGlobalRequest  {

	@ApiModelProperty(value = "文本消息内容", required = true)
	private Text text;
	
	@ApiModelProperty(value = "是否是保密消息")
	private Integer safe;
	

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Integer getSafe() {
		return safe;
	}

	public void setSafe(Integer safe) {
		this.safe = safe;
	}

	@ApiModel(value="文本消息内容")
	public class Text {
		
		@ApiModelProperty(value = "文本消息")
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
		
	}
}
