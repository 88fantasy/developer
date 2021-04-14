package com.gzmpc.business.developer.config.service;

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
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.AccountParamDTO;
import com.gzmpc.business.developer.config.entity.AccountParam;
import com.gzmpc.business.developer.config.entity.Param;
import com.gzmpc.business.developer.config.mapper.AccountParamMapper;

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
	 * 
	 * @param key
	 * @param forceFlush
	 * @return value or null if key not exists
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
		Map<String,String> values = list.stream().collect(Collectors.toMap(AccountParamDTO::getKey, AccountParamDTO::getValue));
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
		globalList.removeIf(entity -> params.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<AccountParamDTO> list = new ArrayList<AccountParamDTO>();
		list.addAll(params.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalList.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}


	public boolean putValue(@Valid AccountParamDTO dto) {
		AccountParam entity = new AccountParam();
		entity.setAppCode(dto.getAppCode());
		entity.setKey(dto.getKey());
		entity.setAccount(dto.getAccount());
		entity.setName(dto.getName());
		entity.setValue(dto.getValue());
		return putParam(entity);
	}

	private boolean putParam(@Valid AccountParam entity) {
		// to-do 权限?
		String appCode = entity.getAppCode();
		String key = entity.getKey();
		String account = entity.getAccount();
		AccountParam old = accountParamMapper.selectOne(Wrappers.<AccountParam>lambdaQuery().eq(AccountParam::getAppCode, appCode).eq(AccountParam::getAccount, account).eq(AccountParam::getKey, key));
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
