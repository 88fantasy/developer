package com.gzmpc.business.developer.admin.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.admin.constant.DeveloperRedisKeys;
import com.gzmpc.business.developer.admin.entity.ParamDO;
import com.gzmpc.business.developer.admin.mapper.ParamMapper;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.ParamDTO;
import com.gzmpc.support.redis.util.RedisUtil;

/**
 * 配置处理类
 * 
 * @author pro
 *
 */
@Service
public class ParamService extends DeveloperBaseService<ParamMapper, ParamDO> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RedisUtil redisUtil;

	/**
	 * 获取配置项
	 * 
	 * @param key
	 * @param forceFlush
	 * @return value or null if key not exists
	 */
	@Nullable
	public String getValue(String appCode, String key) {
		return getValue(appCode, key, false);
	}
	
	@Nullable
	public String getValue(String appCode, String key, boolean forceFlush) {
		String redisKey = MessageFormat.format(DeveloperRedisKeys.PARAM_KEY, appCode, key);
		if (redisUtil.hasKey(redisKey) && !forceFlush) {
			ParamDO entity = (ParamDO) redisUtil.get(redisKey);
			if (entity != null) {
				return entity.getValue();
			}
		}

		ParamDO entity = findByKey(appCode, key);
		if (entity != null) {
			String value = entity.getValue();
			redisUtil.set(redisKey, entity);
			return value;
		} else {
			ParamDO globalEntity = findByKey(DeveloperConstants.GLOBAL_APPLICATION_CODE, key);
			if( globalEntity != null) {
				String value = globalEntity.getValue();
				redisUtil.set(redisKey, globalEntity);
				return value;
			}
			else {
				return null;
			}
		}
	}
	
	public List<ParamDTO> findByAppCode(String appCode) {
		List<ParamDO> params = findByAppCodeOri(appCode);
		List<ParamDO> globalParams = findByAppCodeOri(DeveloperConstants.GLOBAL_APPLICATION_CODE);
		//去重,优先app配置
		globalParams.removeIf(entity -> params.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<ParamDTO> list = new ArrayList<ParamDTO>();
		list.addAll(params.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalParams.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}
	
	public List<ParamDTO> findByKeys(String appCode, String... keys) {
		List<ParamDO> params = findByKeysOri(appCode, keys);
		List<ParamDO> globalParams = findByKeysOri(DeveloperConstants.GLOBAL_APPLICATION_CODE, keys);
		//去重,优先app配置
		globalParams.removeIf(entity -> params.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<ParamDTO> list = new ArrayList<ParamDTO>();
		list.addAll(params.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalParams.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}
	
	public boolean putValue(String key, String name, String value) {
		return putValue(DeveloperConstants.GLOBAL_APPLICATION_CODE, key, name, value, false);
	}

	public boolean putValue(String appCode, String name, String key, String value) {
		return putValue(appCode, key, name, value, false);
	}

	public boolean putValue(String appCode, String key, String name, String value, boolean inherited) {
		ParamDO entity = new ParamDO();
		entity.setAppCode(appCode);
		entity.setKey(key);
		entity.setName(name);
		entity.setValue(value);
		entity.setInherited(inherited);
		return putParam(entity);
	}

	private boolean putParam(ParamDO entity) {
		// to-do 权限?
		if (entity != null && !StringUtils.isEmpty(entity.getAppCode()) && !StringUtils.isEmpty(entity.getKey())
				&& entity.getValue() != null) {
			String appCode = entity.getAppCode();
			String key = entity.getKey();
			ParamDO old = findByKey(appCode, key);
			if(old != null) {
				entity.setId(old.getId());
				getBaseMapper().updateById(entity);
			}
			else {
				getBaseMapper().insert(entity);
			}
			String redisKey = MessageFormat.format(DeveloperRedisKeys.PARAM_KEY, appCode, key);
			return redisUtil.set(redisKey, entity);
		} else {
			throw new NullPointerException("entity为空或缺少必要字段");
		}
	}
	
	private ParamDTO toDTO(ParamDO entity) {
		ParamDTO vo = new ParamDTO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	private ParamDO findByKey(String appCode, String key) {
		ParamDO entity = getOne(Wrappers.<ParamDO>lambdaQuery().eq(ParamDO::getKey, key).eq(ParamDO::getAppCode, appCode));
		if(entity != null) {
			return entity;
		}
		else {
			return null;
		}
	}
	
	private List<ParamDO> findByKeysOri(String appCode, String... keys) {
		return list(Wrappers.<ParamDO>lambdaQuery().in(ParamDO::getKey, Arrays.asList(keys)).eq(ParamDO::getAppCode, appCode));
	}
	
	public List<ParamDO> findByAppCodeOri(String appCode) {
		return list(Wrappers.<ParamDO>lambdaQuery().eq(ParamDO::getAppCode, appCode));
	}
}
