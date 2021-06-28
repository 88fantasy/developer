package org.exframework.business.developer.common.dto;


import org.exframework.business.developer.common.enums.MessageFrom;
import org.exframework.business.developer.common.enums.MessageType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 6, 2020 1:45:45 PM
* 发送邮件请求
*/

@ApiModel(value="发送短信请求")
public class SendSnsRequest extends Message {
	
	private static final long serialVersionUID = -3814754646869548929L;
	
	@ApiModelProperty(value = "短信发送者")
	private MessageFrom from;
	
	/**
	 * 业务类型
	 * 最大可支持32个长度的英文字母、数字组合的字符串
	 */
	@ApiModelProperty(value = "业务类型")
	private String svrtype;
	
	/**
	 * 扩展号
	 * 长度不能超过6位，注意通道号+扩展号的总长度不能超过20位，若超出则exno无效，如不需要扩展号则不用提交此字段或填空
	 */
	@ApiModelProperty(value = "扩展号")
	private String exno;

	public MessageFrom getFrom() {
		return from;
	}

	public void setFrom(MessageFrom from) {
		this.from = from;
	}



	@Override
	public MessageType getMessageType() {
		return MessageType.SNS;
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

	
}
