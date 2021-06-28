package org.exframework.business.developer.core.dto.wechat.com.message;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:23:16 AM 
 * 发送消息 请求
 */

@ApiModel(value="图片消息请求")
public class SendImageMessageRequest extends SendMessageGlobalRequest {

	@ApiModelProperty(value = "图片内容", required = true)
	private Image image;

	@ApiModelProperty(value = "是否是保密消息")
	private Integer safe;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Integer getSafe() {
		return safe;
	}

	public void setSafe(Integer safe) {
		this.safe = safe;
	}

	@ApiModel(value="图片内容")
	public class Image {
		
		@ApiModelProperty(value = "图片媒体文件id", required = true)
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

	}
}
