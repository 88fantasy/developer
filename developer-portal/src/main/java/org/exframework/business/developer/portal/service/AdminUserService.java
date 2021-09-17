package org.exframework.business.developer.portal.service;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.usthe.sureness.util.SurenessConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.exframework.business.developer.portal.dto.LoginRequest;
import org.exframework.business.developer.portal.dto.LoginResponse;
import org.exframework.business.developer.portal.entity.User;
import org.exframework.business.developer.portal.entity.Person;
import org.exframework.business.developer.portal.entity.User.AccountDataSource;
import org.exframework.business.developer.portal.entity.LoginLog;
import org.exframework.business.developer.portal.entity.LoginLog.PlatformType;
import org.exframework.business.developer.portal.mapper.UserMapper;
import org.exframework.business.developer.portal.mapper.LoginLogMapper;
import org.exframework.portal.metadata.sys.Account.AccountStatusTypeEnum;
import org.exframework.support.jdbc.service.ExBaseService;
import com.usthe.sureness.provider.DefaultAccount;
import com.usthe.sureness.provider.SurenessAccount;
import com.usthe.sureness.util.JsonWebTokenUtil;

/**
 * @author rwe
 * @version 创建时间：2021年4月19日 上午11:31:23
 * 帐号业务服务
 */

@Service
public class AdminUserService extends ExBaseService<UserMapper, User> {

	public static final long TOKEN_EXPIRED_SECONDS = 3600;

	@Autowired
	HttpServletRequest request;

	@Autowired
	UserMapper userMapper;

	@Autowired
	LoginLogMapper loginLogMapper;

	@Autowired
    LdapTemplate ldapTemplate;

	public SurenessAccount loadSurenessAccount(String account) {
		User user = loadAccount(account);
		DefaultAccount defaultAccount = DefaultAccount.builder(user.getAccount())
				.setOwnRoles(permissions(user.getAccount())).setPassword(user.getPassword()).build();
		return defaultAccount;
	}

	public LoginResponse login(LoginRequest login) {
		return login(login.getUserName(), login.getPassword());
	}

	@Transactional(rollbackFor = Exception.class)
	public LoginResponse login(String username, String password) {
		LoginResponse response = new LoginResponse();
		response.setStatus("error");
		User account = loadAccount(username);
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

		SurenessAccount surenessAccount = loadSurenessAccount(username);
		response.setPermissions(surenessAccount.getOwnRoles());
		response.setToken(token(username, surenessAccount.getOwnRoles(), TOKEN_EXPIRED_SECONDS));
		response.setStatus("ok");

		Device device = DeviceUtils.getCurrentDevice(request);
		String userAgent = request.getHeader("User-Agent");

		String ip = getIpAddr(request);
		LoginLog loginLog = new LoginLog();
		loginLog.setAccount(username);
		loginLog.setAccountName(account.getUserName());
		loginLog.setIpaddress(ip);
		loginLog.setPlatform(device.isMobile()? PlatformType.Mobile : PlatformType.Web);
		loginLog.setDevice(userAgent);
		loginLogMapper.insert(loginLog);

		account.setLastLoginIp(ip);
		account.setLastLoginDate(new Date());
		userMapper.updateById(account);

		return response;
	}

	public Person loadPerson(String cn) {
		try {
			return ldapTemplate.findOne(LdapQueryBuilder.query().where("cn").is(cn), Person.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	public User loadAccount(String account) {
		return userMapper.selectById(account);
	}

	public List<String> permissions(String account) {
		return Arrays.asList("admin");
	}

	public String token(String user, Long period) {
		return token(user, loadSurenessAccount(user).getOwnRoles(), period);
	}

	public String token(String user, List<String> permissions, Long period) {
		return MessageFormat.format("{0}{1}", SurenessConstant.BEARER, JsonWebTokenUtil.issueJwt(UUID.randomUUID().toString(), user, "app-store", period, permissions));
	}

	public User generateByLdap(Person person) {
		User entity = new User();
		entity.setAccount(person.getCommonName());
		entity.setUserName(person.getDescription());
		entity.setDataSource(AccountDataSource.LDAP);
		entity.setEmail(person.getMail());
		entity.setAccountStatus(AccountStatusTypeEnum.VALID);
		userMapper.insert(entity);
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
