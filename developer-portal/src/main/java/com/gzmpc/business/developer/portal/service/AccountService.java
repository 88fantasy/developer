package com.gzmpc.business.developer.portal.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.portal.dto.CurrentUserResponse;
import com.gzmpc.business.developer.portal.dto.LoginRequest;
import com.gzmpc.business.developer.portal.dto.LoginResponse;
import com.gzmpc.business.developer.portal.entity.Person;
import com.usthe.sureness.provider.DefaultAccount;
import com.usthe.sureness.provider.SurenessAccount;
import com.usthe.sureness.util.JsonWebTokenUtil;

/**
* @author rwe
* @version 创建时间：2021年4月19日 上午11:31:23
* 类说明
*/

@Service
public class AccountService {

	@Autowired
  private LdapTemplate ldapTemplate;
	
	public SurenessAccount loadAccount(String account) {
		Person person = loadPerson(account);
		return toSureness(person);
	}
	
	public CurrentUserResponse currentUser(String account) {
		Person person = loadPerson(account);
		return new CurrentUserResponse(person);
	}
	
	public LoginResponse login(LoginRequest login) {
		return login(login.getUserName(),login.getPassword());
	}
	
	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		Person person = loadPerson(username);
		if(person != null && ldapTemplate.authenticate(person.getId(), new EqualsFilter("cn",username).encode(), password)) {
			List<String> ownRole = Arrays.asList("admin");
			String jwt = "Bearer "+JsonWebTokenUtil.issueJwt(UUID.randomUUID().toString(), username,
          "developer-portal", 3600l, ownRole);
			response.setAuthority(ownRole);
			response.setToken(jwt);
			response.setStatus("ok");
		}
		else {
			response.setStatus("error");
		}
		return response;
	}
	
	public Person loadPerson(String cn) {
		try {
			return ldapTemplate.findOne(LdapQueryBuilder.query().where("cn").is(cn), Person.class);
		} catch ( IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	private SurenessAccount toSureness(Person person) {
		return DefaultAccount.builder(person.getUid())
				.setOwnRoles(Arrays.asList("admin"))
				.setPassword(person.getUserPassword())
				.build();
	}
}
