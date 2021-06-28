package org.exframework.business.developer.config.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.exframework.business.developer.common.constant.DeveloperConstants;
import org.exframework.business.developer.common.dto.DictionaryDTO;
import org.exframework.business.developer.config.constant.ConfigConstants;
import org.exframework.business.developer.config.entity.Dictionary;
import org.exframework.business.developer.config.mapper.DictionaryMapper;

/**
 * 字典处理类
 * 
 * @author pro
 *
 */
@Service
public class DictionaryService {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Autowired
	DictionaryMapper dictionaryMapper;

	/**
	 * 获取配置项
	 * 
	 * @param key
	 * @param forceFlush
	 * @return value or null if key not exists
	 */
	@Nullable
	public Map<String, String> getValue(String appCode, String key) {
		return getValue(appCode, key, false);
	}

	@Nullable
	public Map<String, String> getValue(String appCode, String key, boolean forceFlush) {
		String redisKey = MessageFormat.format(DeveloperConstants.CONFIG_DICTIONARY_KEY, appCode, key);
		if (redisTemplate.hasKey(redisKey) && !forceFlush) {
			String value = redisTemplate.opsForValue().get(redisKey);
			if (value != null) {
				return toMap(value);
			}
		}

		Dictionary entity = dictionaryMapper
				.selectOne(Wrappers.<Dictionary>lambdaQuery().eq(Dictionary::getAppCode, appCode).eq(Dictionary::getKey, key));
		if (entity != null) {
			String value = entity.getValue();
			redisTemplate.opsForValue().set(redisKey, value, ConfigConstants.oneMinuteDuration);
			return toMap(value);
		} else {
			Dictionary globalEntity = dictionaryMapper.selectOne(Wrappers.<Dictionary>lambdaQuery()
					.eq(Dictionary::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE).eq(Dictionary::getKey, key));
			if (globalEntity != null) {
				String value = globalEntity.getValue();
				redisTemplate.opsForValue().set(redisKey, value, ConfigConstants.oneMinuteDuration);
				return toMap(value);
			} else {
				return null;
			}
		}
	}
	
	public List<DictionaryDTO> findByKeys(String appCode, String... keys) {
		List<Dictionary> dicts = dictionaryMapper.selectList(
				Wrappers.<Dictionary>lambdaQuery().eq(Dictionary::getAppCode, appCode).in(Dictionary::getKey, Arrays.asList(keys)));
		List<Dictionary> globalDicts = dictionaryMapper.selectList(Wrappers.<Dictionary>lambdaQuery()
				.eq(Dictionary::getAppCode, DeveloperConstants.GLOBAL_APPLICATION_CODE).in(Dictionary::getKey, Arrays.asList(keys)));
		// 去重,优先app配置
		globalDicts.removeIf(entity -> dicts.stream().anyMatch(p -> p.getKey().equals(entity.getKey())));
		List<DictionaryDTO> list = new ArrayList<DictionaryDTO>();
		list.addAll(dicts.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		list.addAll(globalDicts.stream().map(row -> toDTO(row)).collect(Collectors.toList()));
		return list;
	}

	public boolean putValue(@Valid DictionaryDTO dto) {
		Dictionary entity = new Dictionary();
		entity.setAppCode(dto.getAppCode());
		entity.setKey(dto.getKey());
		entity.setName(dto.getName());
		Map<String, String> value = dto.getValue();
		if (value != null && value.size() > 0) {
			String dict = JSON.toJSONString(value);
			entity.setValue(dict);
			return putValue(entity);
		} else {
			return false;
		}
	}

	private boolean putValue(@Valid Dictionary entity) {
		// to-do 权限?
		String appCode = entity.getAppCode();
		String key = entity.getKey();
		Dictionary old = dictionaryMapper
				.selectOne(Wrappers.<Dictionary>lambdaQuery().eq(Dictionary::getAppCode, appCode).eq(Dictionary::getKey, key));
		if (old != null) {
			entity.setId(old.getId());
			dictionaryMapper.updateById(entity);
		} else {
			dictionaryMapper.insert(entity);
		}
		getValue(appCode, key, true);
		return true;
	}
	
	private DictionaryDTO toDTO(Dictionary entity) {
		DictionaryDTO vo = new DictionaryDTO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}

	private Map<String, String> toMap(String value) {
		Map<String, String> map = new ConcurrentHashMap<>();
		JSONObject json = JSON.parseObject(value);
		for (Entry<String, Object> entry : json.entrySet()) {
			map.put(entry.getKey(), (String) entry.getValue());
		}
		return map;
	}
}
