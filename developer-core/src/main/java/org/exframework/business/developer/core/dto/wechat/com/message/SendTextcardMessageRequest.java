package org.exframework.business.developer.core.dto.wechat.com.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:23:16 AM 
 * 发送消息 请求
 */

@ApiModel(value="文本卡片消息请求")
public class SendTextcardMessageRequest extends SendMessageGlobalRequest  {

	@ApiModelProperty(value = "文本卡片内容", required = true)
	private Textcard textcard;

	public Textcard getTextcard() {
		return textcard;
	}

	public void setTextcard(Textcard textcard) {
		this.textcard = textcard;
	}

	@ApiModel(value="文本卡片内容")
	public class Textcard {
		
		@ApiModelProperty(value = "标题", required = true)
		private String title;

		@ApiModelProperty(value = "描述", required = true)
		private String description;
		
		@ApiModelProperty(value = "点击后跳转的链接", required = true)
		private String url;
		
		@ApiModelProperty(value = "按钮文字")
		private String btntxt;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getBtntxt() {
			return btntxt;
		}

		public void setBtntxt(String btntxt) {
			this.btntxt = btntxt;
		}
		

	}
}
