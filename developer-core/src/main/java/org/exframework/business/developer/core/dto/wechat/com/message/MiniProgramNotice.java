package org.exframework.business.developer.core.dto.wechat.com.message;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：2021年3月25日 下午2:00:52
* 小程序消息内容
*/

@ApiModel(value="小程序消息内容")
public class MiniProgramNotice {
	
	@ApiModelProperty(value = "小程序ID")
	private String appid;
	
	@ApiModelProperty(value = "点击消息卡片后的小程序页面")
	private String page;
	
	@ApiModelProperty(value = "消息标题")
	private String title;
	
	@ApiModelProperty(value = "消息描述")
	private String description;
	
	@ApiModelProperty(value = "是否放大第一个Item")
	private boolean emphasis_first_item;
	
	@ApiModelProperty(value = "消息内容键值对，最多允许10个item")
	private List<MiniProgramNoticeContentItem> content_item;

	public MiniProgramNotice() {
		this(null, null, null, null, false, null);
	}

	public MiniProgramNotice(String appid, String page, String title, String description) {
		this(appid, page, title, description, false, null);
	}
	
	public MiniProgramNotice(String appid, String page, String title, String description, boolean emphasis_first_item,
			List<MiniProgramNoticeContentItem> content_item) {
		this.appid = appid;
		this.page = page;
		this.title = title;
		this.description = description;
		this.emphasis_first_item = emphasis_first_item;
		this.content_item = content_item;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

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


	public boolean getEmphasis_first_item() {
		return emphasis_first_item;
	}

	public void setEmphasis_first_item(boolean emphasis_first_item) {
		this.emphasis_first_item = emphasis_first_item;
	}

	public List<MiniProgramNoticeContentItem> getContent_item() {
		return content_item;
	}

	public void setContent_item(List<MiniProgramNoticeContentItem> content_item) {
		this.content_item = content_item;
	}

}