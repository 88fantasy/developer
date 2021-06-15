package com.gzmpc.business.developer.portal.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Service;

import com.gzmpc.business.developer.portal.dto.LoginRequest;
import com.gzmpc.business.developer.portal.dto.LoginResponse;
import com.gzmpc.business.developer.portal.entity.DeveloperAccount;
import com.gzmpc.business.developer.portal.entity.Person;
import com.gzmpc.business.developer.portal.entity.DeveloperAccount.AccountDataSource;
import com.gzmpc.business.developer.portal.entity.LoginLog;
import com.gzmpc.business.developer.portal.entity.LoginLog.PlatformType;
import com.gzmpc.business.developer.portal.mapper.DeveloperAccountMapper;
import com.gzmpc.business.developer.portal.mapper.LoginLogMapper;
import com.gzmpc.portal.metadata.sys.Account.AccountStatusTypeEnum;
import com.usthe.sureness.provider.DefaultAccount;
import com.usthe.sureness.provider.SurenessAccount;
import com.usthe.sureness.util.JsonWebTokenUtil;

/**
 * @author rwe
 * @version 创建时间：2021年4月19日 上午11:31:23 帐号业务服务
 */

@Service
public class AccountService {

	@Autowired
	HttpServletRequest request;

	@Autowired
	DeveloperAccountMapper developerAccountMapper;

	@Autowired
	LoginLogMapper loginLogMapper;

	@Autowired
	private LdapTemplate ldapTemplate;

	public SurenessAccount loadSurenessAccount(String account) {
		DeveloperAccount developerAccount = loadAccount(account);
		DefaultAccount defaultAccount = DefaultAccount.builder(developerAccount.getAccount())
				.setOwnRoles(Arrays.asList("admin")).setPassword(developerAccount.getPassword()).build();
		return defaultAccount;
	}

	public LoginResponse login(LoginRequest login) {
		return login(login.getUserName(), login.getPassword());
	}

	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		response.setStatus("error");
		DeveloperAccount account = loadAccount(username);
		// 帐号不存在时读取ldap创建帐号
		if (account == null) {
			Person person = loadPerson(username);
			if (person != null
					&& ldapTemplate.authenticate(person.getId(), new EqualsFilter("cn", username).encode(), password)) {
				account = generateByLdap(person);
			} else {
				return response;
			}
		}

		List<String> ownRole = Arrays.asList("admin");
		String jwt = "Bearer "
				+ JsonWebTokenUtil.issueJwt(UUID.randomUUID().toString(), username, "developer-portal", 3600l, ownRole);
		response.setAuthority(ownRole);
		response.setToken(jwt);
		response.setStatus("ok");
		
		Device device = DeviceUtils.getCurrentDevice(request);
		String userAgent = request.getHeader("User-Agent");

		LoginLog loginLog = new LoginLog();
		loginLog.setAccount(username);
		loginLog.setAccountName(account.getAccountName());
		loginLog.setIpaddress(getIpAddr(request));
		loginLog.setPlatform(device.isMobile()? PlatformType.Mobile : PlatformType.Web);
		loginLog.setDevice(userAgent);
		loginLogMapper.insert(loginLog);

		return response;
	}

	public Person loadPerson(String cn) {
		try {
			return ldapTemplate.findOne(LdapQueryBuilder.query().where("cn").is(cn), Person.class);
		} catch (IncorrectResultSizeDataAccessException e) {
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

	public String getIpAddr(HttpServletRequest request) {
		if (request == null) {
			return "unknown";
		}
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}
}
