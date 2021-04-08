package com.gzmpc.business.developer.message.http.client.entity;

/**
* @author rwe
* @version 创建时间：2021年3月24日 下午11:20:13
* Otrs 发送请求
*/

public class SendOtrsHttpRequest {

	private String UserLogin;
	
	private String Password;
	
	private Ticket Ticket;
	
	private Article Article;
	
	
	public String getUserLogin() {
		return UserLogin;
	}

	public void setUserLogin(String userLogin) {
		UserLogin = userLogin;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Ticket getTicket() {
		return Ticket;
	}

	public void setTicket(Ticket ticket) {
		Ticket = ticket;
	}

	public Article getArticle() {
		return Article;
	}

	public void setArticle(Article article) {
		Article = article;
	}

	public class Ticket {
		
	}
	
	public class Article {
		
	}
}
