package com.gzmpc.business.developer.config.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.common.constant.DeveloperConstants;
import com.gzmpc.business.developer.common.dto.ParamDTO;
import com.gzmpc.business.developer.config.constant.ConfigConstants;
import com.gzmpc.business.developer.config.entity.Param;
import com.gzmpc.business.developer.config.mapper.AccountParamMapper;
import com.gzmpc.business.developer.config.mapper.ParamMapper;

/**
 * 配置处理类
 * 
 * @author pro
 *
 */
@Service
public class ParamService {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Autowired
	ParamMapper paramMapper;

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
	public String getValue(String appCode, String key) {
		return getValue(appCode, key, false);
	}

	@Nullable
	public String getValue(String appCode, String key, boolean forceFlush) {
		String redisKey = MessageFormat.format(DeveloperConstants.CONFIG_PARAM_KEY, appCode, key);
		if (redisTemplate.hasKey(redisKey) && !forceFlush) {
			Param entity = (Param) redisTemplate.opsForValue().get(redisKey);
			if (entity != null) {
				return entity.getValue();
			}
		}
		;
		Param entity = paramMapper.selectOne(Wrappers.<Param>lambdaQuery().eq(Param::getAppCode, appCode).eq(Param::getKey, key));
		if (entity != null) {
			String value = entity.getValue();
			redisTemplate.opsForValue().set(redisKey, entity, ConfigConstants.oneMinuteDuration);
			return value;
		} else {
			Param globalEntity = paramMapper.selectOne(Wrappers.<Param>lambdaQuery()
					.eq(Param::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE).eq(Param::getInherited, true).eq(Param::getKey, key));
			if (globalEntity != null) {
				String value = globalEntity.getValue();
				redisTemplate.opsForValue().set(redisKey, globalEntity);
				return value;
			} else {
				return null;
			}
		}
	}

	public List<ParamDTO> findByAppCode(String appCode) {
		List<Param> params = paramMapper.selectList(Wrappers.<Param>lambdaQuery().eq(Param::getAppCode, appCode));
		List<Param> globalParams = paramMapper.selectList(Wrappers.<Param>lambdaQuery().eq(Param::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE).eq(Param::getInherited, true));
		// 去重,优先app配置
		globalParams.removeIf(entity -> params.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<ParamDTO> list = new ArrayList<ParamDTO>();
		list.addAll(params.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalParams.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}

	public List<ParamDTO> findByKeys(String appCode, String... keys) {
		List<Param> params = paramMapper.selectList(
				Wrappers.<Param>lambdaQuery().eq(Param::getAppCode, appCode).in(Param::getKey, Arrays.asList(keys)));
		List<Param> globalParams = paramMapper.selectList(Wrappers.<Param>lambdaQuery()
				.eq(Param::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE).eq(Param::getInherited, true).in(Param::getKey, Arrays.asList(keys)));
		// 去重,优先app配置
		globalParams.removeIf(entity -> params.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<ParamDTO> list = new ArrayList<ParamDTO>();
		list.addAll(params.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalParams.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}

//	public boolean putValue(String key, String name, String value) {
//		return putValue(DeveloperConstants.GLOBAL_APPLICATION_CODE, key, name, value);
//	}

	public boolean putValue(ParamDTO param) {
		Param entity = new Param();
		entity.setAppCode(param.getAppCode());
		entity.setKey(param.getKey());
		entity.setName(param.getName());
		entity.setValue(param.getValue());
		entity.setInherited(param.getInherited());
		return putParam(entity);
	}

	private boolean putParam(@Valid Param entity) {
		// to-do 权限?
		String appCode = entity.getAppCode();
		String key = entity.getKey();
		Param old = paramMapper.selectOne(Wrappers.<Param>lambdaQuery().eq(Param::getAppCode, appCode).eq(Param::getKey, key));
		if (old != null) {
			entity.setId(old.getId());
			paramMapper.updateById(entity);
		}
		else {
			paramMapper.insert(entity);
		}
		getValue(appCode, key, true);
		return true;
	}

	private ParamDTO toDTO(Param entity) {
		ParamDTO vo = new ParamDTO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
}
