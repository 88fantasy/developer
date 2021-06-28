package org.exframework.business.developer.core.dto.wechat.com.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:23:16 AM 发送消息 请求
 */

@ApiModel(value = "小程序消息请求")
public class SendMiniProgramMessageRequest extends SendMessageGlobalRequest {

	@ApiModelProperty(value = "小程序消息内容", required = true)
	private MiniProgramNotice miniprogram_notice;

	public SendMiniProgramMessageRequest() {

	}

	public SendMiniProgramMessageRequest(MiniProgramNotice miniprogram_notice) {
		this.miniprogram_notice = miniprogram_notice;
	}

	public MiniProgramNotice getMiniprogram_notice() {
		return miniprogram_notice;
	}

	public void setMiniprogram_notice(MiniProgramNotice miniprogram_notice) {
		this.miniprogram_notice = miniprogram_notice;
	}

}
