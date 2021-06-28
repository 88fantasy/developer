package org.exframework.business.developer.core.dto.wechat.com.message;

import java.util.List;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:23:16 AM 
 * 发送消息 请求
 */

@ApiModel(value="图文消息请求")
public class SendNewsMessageRequest extends SendMessageGlobalRequest {

	@ApiModelProperty(value = "图文内容", required = true)
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@ApiModel(value="图文内容")
	public class News {
		
		/**
		 * 图文消息，一个图文消息支持1到8条图文
		 */
		@ApiModelProperty(value = "图文内容", required = true)
		private List<Articles> articles;

		public List<Articles> getArticles() {
			return articles;
		}

		public void setArticles(List<Articles> articles) {
			this.articles = articles;
		}
		
	}
	
	@ApiModel(value="文章内容")
	public class Articles {
		
		/**
		 * 标题
		 */
		@ApiModelProperty(value = "标题", required = true)
		private String title;
		
		/**
		 * 描述
		 */
		@ApiModelProperty(value = "描述")
		private String description;
		
		/**
		 * 点击后跳转的链接
		 */
		@ApiModelProperty(value = "点击后跳转的链接", required = true)
		private String url;
		
		/**
		 * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150
		 */
		@ApiModelProperty(value = "图文内容")
		private String picurl;

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

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}
		
	}
}
