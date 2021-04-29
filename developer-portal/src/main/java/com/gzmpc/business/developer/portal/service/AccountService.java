package com.gzmpc.business.developer.portal.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.portal.dto.CurrentUserResponse;
import com.gzmpc.business.developer.portal.dto.LoginRequest;
import com.gzmpc.business.developer.portal.dto.LoginResponse;
import com.gzmpc.business.developer.portal.entity.DeveloperAccount;
import com.gzmpc.business.developer.portal.entity.Person;
import com.gzmpc.business.developer.portal.entity.DeveloperAccount.AccountDataSource;
import com.gzmpc.business.developer.portal.mapper.DeveloperAccountMapper;
import com.gzmpc.portal.metadata.sys.Account.AccountStatusTypeEnum;
import com.usthe.sureness.provider.DefaultAccount;
import com.usthe.sureness.provider.SurenessAccount;
import com.usthe.sureness.util.JsonWebTokenUtil;

/**
* @author rwe
* @version 创建时间：2021年4月19日 上午11:31:23
* 帐号业务服务
*/

@Service
public class AccountService {

	@Autowired
	DeveloperAccountMapper developerAccountMapper;
	
	@Autowired
  private LdapTemplate ldapTemplate;
	
	public SurenessAccount loadSurenessAccount(String account) {
		DeveloperAccount developerAccount = loadAccount(account);
		DefaultAccount defaultAccount = DefaultAccount.builder(developerAccount.getAccount())
			.setOwnRoles(Arrays.asList("admin"))
			.setPassword(developerAccount.getPassword())
			.build();
		return defaultAccount;
	}
	
	
	public LoginResponse login(LoginRequest login) {
		return login(login.getUserName(),login.getPassword());
	}
	
	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		response.setStatus("error");
		DeveloperAccount account = loadAccount(username);
		//帐号不存在时读取ldap创建帐号
		if(account == null) {
			Person person = loadPerson(username);
			if(person != null && ldapTemplate.authenticate(person.getId(), new EqualsFilter("cn",username).encode(), password)) {
				account = generateByLdap(person);
			}
			else {
				return response;
			}
		}
		
		List<String> ownRole = Arrays.asList("admin");
		String jwt = "Bearer "+JsonWebTokenUtil.issueJwt(UUID.randomUUID().toString(), username,
        "developer-portal", 3600l, ownRole);
		response.setAuthority(ownRole);
		response.setToken(jwt);
		response.setStatus("ok");
		return response;
	}
	
	public Person loadPerson(String cn) {
		try {
			return ldapTemplate.findOne(LdapQueryBuilder.query().where("cn").is(cn), Person.class);
		} catch ( IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	public DeveloperAccount loadAccount(String account) {
		return developerAccountMapper.selectById(account);
	}
	
	public DeveloperAccount generateByLdap(Person person) {
		DeveloperAccount entity = new DeveloperAccount();
		entity.setAccount(person.getCommonName());
		entity.setAccountName(person.getDescription());
		entity.setDataSource(AccountDataSource.LDAP);
		entity.setEmail(person.getMail());
		entity.setAccountStatus(AccountStatusTypeEnum.VALID);
		developerAccountMapper.insert(entity);
		return entity;
	}
	
	public boolean authenticateByLdap(Person person, String pwd) {
		return ldapTemplate.authenticate(person.getId(), new EqualsFilter("cn", person.getCommonName()).encode(), pwd);
	}
	
	public void test() {
		
	}
}
