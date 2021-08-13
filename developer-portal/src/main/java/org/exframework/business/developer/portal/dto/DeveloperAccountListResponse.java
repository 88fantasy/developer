package org.exframework.business.developer.portal.dto;

import java.util.Date;

import org.exframework.business.developer.portal.entity.User;
import org.exframework.business.developer.portal.entity.User.AccountDataSource;
import org.exframework.portal.metadata.sys.Account.AccountStatusTypeEnum;

/**
* @author rwe
* @version 创建时间：2021年6月17日 下午4:24:07
* 类说明
*/

public class DeveloperAccountListResponse {

	private String account;
	
	private String accountName;
	
	private Date lastLoginDate;
	
	private AccountDataSource source;
	
	private AccountStatusTypeEnum accountStatus;
	
	public DeveloperAccountListResponse() {
	
	}
	
	public DeveloperAccountListResponse(User account) {
		this.account = account.getAccount();
		this.accountName = account.getUserName();
		this.lastLoginDate = account.getLastLoginDate();
		this.source = account.getDataSource();
		this.accountStatus = account.getAccountStatus();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public AccountDataSource getSource() {
		return source;
	}

	public void setSource(AccountDataSource source) {
		this.source = source;
	}

	public AccountStatusTypeEnum getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatusTypeEnum accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
