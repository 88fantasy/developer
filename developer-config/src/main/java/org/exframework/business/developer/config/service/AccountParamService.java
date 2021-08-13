package org.exframework.business.developer.config.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.exframework.business.developer.common.constant.DeveloperConstants;
import org.exframework.business.developer.common.dto.AccountParamDTO;
import org.exframework.business.developer.config.entity.AccountParam;
import org.exframework.business.developer.config.entity.Param;
import org.exframework.business.developer.config.mapper.AccountParamMapper;

/**
 * 配置处理类
 * 
 * @author pro
 *
 */
@Service
public class AccountParamService extends ConfigBaseService<AccountParamMapper, AccountParam> {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
	AccountParamMapper accountParamMapper;

	/**
	 * 获取配置项
	 * @param appCode 应用码
	 * @param key 参数 key
	 * @param account 关联帐号
	 * @return value or null if not exists
	 */
	@Nullable
	public String getValue(String appCode, String key, String account) {
		return getValue(appCode, key, account, false);
	}
	
	@Nullable
	public String getValue(String appCode, String key, String account, boolean forceFlush) {
		String redisKey = MessageFormat.format(DeveloperConstants.CONFIG_ACCOUNTPARAM_KEY, appCode, account);
		if (redisTemplate.hasKey(redisKey) && !forceFlush) {
			String value = (String) redisTemplate.opsForHash().get(redisKey, key);
			if (value != null) {
				return value;
			}
		}
		
		List<AccountParamDTO> list = findByAppCodeAndAccount(appCode, account);
		Map<String,String> values = list.stream().collect(Collectors.toMap(AccountParamDTO::getParamKey, AccountParamDTO::getValue));
		redisTemplate.opsForHash().putAll(redisKey, values);
		return values.get(key);
	}

	public List<AccountParamDTO> findByAppCodeAndAccount(String appCode, String account) {
		List<AccountParam> params = accountParamMapper.selectList(Wrappers.<AccountParam>lambdaQuery().eq(AccountParam::getAppCode, appCode).eq(AccountParam::getAccount, account));
		List<AccountParam> globalList = accountParamMapper.selectList(Wrappers.<AccountParam>lambdaQuery()
				.eq(AccountParam::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE)
				.eq(Param::getInherited, true)
				.eq(AccountParam::getAccount, account));
		//去重,优先app配置
		globalList.removeIf(entity -> params.stream().anyMatch(p -> p.getParamKey().equals(entity.getParamKey())));
		List<AccountParamDTO> list = new ArrayList<>();
		list.addAll(params.stream().map(this::toDTO).collect(Collectors.toList()));
		list.addAll(globalList.stream().map(this::toDTO).collect(Collectors.toList()));
		return list;
	}


	public boolean putValue(@Valid AccountParamDTO dto) {
		AccountParam entity = new AccountParam();
		entity.setAppCode(dto.getAppCode());
		entity.setParamKey(dto.getParamKey());
		entity.setAccount(dto.getAccount());
		entity.setParamName(dto.getParamName());
		entity.setValue(dto.getValue());
		return putParam(entity);
	}

	private boolean putParam(@Valid AccountParam entity) {
		// to-do 权限?
		String appCode = entity.getAppCode();
		String key = entity.getParamKey();
		String account = entity.getAccount();
		AccountParam old = accountParamMapper.selectOne(Wrappers.<AccountParam>lambdaQuery().eq(AccountParam::getAppCode, appCode).eq(AccountParam::getAccount, account).eq(AccountParam::getParamKey, key));
		if(old != null) {
			entity.setId(old.getId());
			accountParamMapper.updateById(entity);
		}
		else {
			accountParamMapper.insert(entity);
		}
		getValue(appCode, key, account, true);
		return true;
	}
	
	private AccountParamDTO toDTO(AccountParam entity) {
		AccountParamDTO vo = new AccountParamDTO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
}
