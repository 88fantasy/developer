package com.gzmpc.business.developer.message.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.gzmpc.business.developer.message.entity.MontnetsAccount;

/**
* @author rwe
* @version 创建时间：2021年4月8日 上午8:52:15
* 类说明
*/

@Component
@ConfigurationProperties(prefix = "montnets")
public class MontnetsBean {

	private List<MontnetsAccount> accounts;

	public void setAccounts(List<MontnetsAccount> accounts) {
		this.accounts = accounts;
	}

	public List<MontnetsAccount> getAccounts() {
		return accounts;
	}
	
}
