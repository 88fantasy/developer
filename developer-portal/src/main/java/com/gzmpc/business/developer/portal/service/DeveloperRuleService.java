package com.gzmpc.business.developer.portal.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.portal.dto.RuleDTO;
import com.gzmpc.business.developer.portal.dto.RulePackageListResponse;
import com.gzmpc.business.developer.portal.dto.RulePackageSaveDTO;
import com.gzmpc.business.developer.portal.dto.RuleStatisticResponse;
import com.gzmpc.business.developer.portal.dto.RuleTagCountResponse;
import com.gzmpc.business.developer.portal.dto.RuleTypeCountResponse;
import com.gzmpc.business.developer.portal.entity.RuleEntity;
import com.gzmpc.business.developer.portal.entity.RuleEntity.RuleType;
import com.gzmpc.business.developer.portal.entity.RulePackage;
import com.gzmpc.business.developer.portal.entity.RulePackageInstance;
import com.gzmpc.business.developer.portal.entity.RulePackageVersion;
import com.gzmpc.business.developer.portal.mapper.RuleMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageInstanceMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageVersionMapper;
import com.gzmpc.portal.exception.NotFoundException;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.entity.FilterCondition;
import com.gzmpc.support.common.util.BeanUtils;
import com.gzmpc.support.jdbc.service.ExBaseService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.entity.ApiResponsePage;

/**
 * @author rwe
 * @version 创建时间：2021年4月25日 下午2:26:16 规则业务处理
 */

@Service
public class DeveloperRuleService extends ExBaseService<RulePackageMapper, RulePackage> {

	@Autowired
	RulePackageMapper rulePackageMapper;
	
	@Autowired
	RuleMapper ruleMapper;

	@Autowired
	RulePackageInstanceMapper rulePackageInstanceMapper;
	
	@Autowired
	RulePackageVersionMapper rulePackageVersionMapper;

	public RulePackageSaveDTO get(String code) {
		RulePackage entity = rulePackageMapper.selectById(code);
		if(entity == null) {
			throw new NotFoundException("找不到此规则集");
		}
		RulePackageSaveDTO result = BeanUtils.copyTo(entity, RulePackageSaveDTO.class);
		List<String> tactics = entity.getTactics();
		if (tactics != null && tactics.size() > 0) {
			List<RuleDTO> rules = ruleMapper.list(Wrappers.<RuleEntity>lambdaQuery().in(RuleEntity::getCode, tactics), e -> {
				RuleDTO rule = BeanUtils.copyTo(entity, RuleDTO.class);
				rule.setType(e.getType());
				return rule;
			}, RuleDTO.class);
			rules.sort((rule1, rule2) -> {
				Integer priority1 = tactics.indexOf(rule1.getCode()), priority2 = tactics.indexOf(rule2.getCode());
				return priority1.compareTo(priority2);
			});
			result.setRules(rules);
		}
		return result;
	}

	public Integer getLatestPackage(String code) {
		List<Object> query = rulePackageMapper
				.selectObjs(Wrappers.<RulePackage>query().select("max(version) as latest").eq("code", code));
		Object latest = query.get(0);
		if (latest == null) {
			return null;
		}
		return (Integer) latest;
	}

	public RulePackageVersion getVersion(String code, Integer version) {
		RulePackageVersion entity = rulePackageVersionMapper.selectOne(Wrappers.<RulePackageVersion>lambdaQuery().eq(RulePackageVersion::getCode, code).eq(RulePackageVersion::getVersion, version));
		if (entity == null) {
			throw new NotFoundException("找不到此规则集[version:" + version + "]");
		}
		return entity;
	}

	public void saveRule(RuleDTO rule, boolean replace) {
		RuleEntity entity = ruleMapper.selectById(rule.getCode());
		boolean exists = entity != null;
		if (exists && !replace) {
			return;
		}
		entity = BeanUtils.copyTo(rule, RuleEntity.class);
		entity.setType(rule.getType());
		if (exists) {
			ruleMapper.updateById(entity);
		} else {
			ruleMapper.insert(entity);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveRulePackage(RulePackageSaveDTO pack) {
		boolean newVersion = false;
		String code = pack.getCode();
		List<String> tactics = pack.getRules().stream().map(RuleDTO::getCode).collect(Collectors.toList());
		RulePackage entity = rulePackageMapper.selectById(code);
		if (entity == null) {
			entity = BeanUtils.copyTo(pack, RulePackage.class);
			entity.setTactics(tactics);
			rulePackageMapper.insert(entity);
			newVersion = true;
		}
		else if (!same(entity.getName(), pack.getName()) || !same(entity.getDescription(), pack.getDescription())
				|| !same(entity.getRulePriorityThreshold(), pack.getRulePriorityThreshold())
				|| !same(entity.getSkipOnFirstAppliedRule(), pack.getSkipOnFirstAppliedRule())
				|| !same(entity.getSkipOnFirstFailedRule(),
						pack.getSkipOnFirstFailedRule()
								|| !same(entity.getSkipOnFirstNonTriggeredRule(), pack.getSkipOnFirstNonTriggeredRule()))
				|| new Predicate<List<String>>() {
					@Override
					public boolean test(List<String> t) {
						if (tactics.size() != t.size()) {
							return true;
						}
						for (int i = 0, j = tactics.size(); i < j; i++) {
							if (!tactics.get(i).equals(t.get(i))) {
								return false;
							}
						}
						return true;
					}
				}.test(entity.getTactics())) {
			BeanUtils.copyProperties(pack, entity);
			entity.setTactics(tactics);
			rulePackageMapper.updateById(entity);
			newVersion = true;
		}

		if(newVersion) {
			RulePackageVersion version = new RulePackageVersion(entity);
			rulePackageVersionMapper.insert(version);
		}
	}

	public ApiResponsePage<RuleDTO> queryRules(PostConditionQueryRequest request) {
		return new ApiResponsePage<>(ruleMapper.query(request.getConditions(), request.getPage(), rule -> {
			RuleDTO dto = BeanUtils.copyTo(rule, RuleDTO.class);
			dto.setType(rule.getType());
			return dto;
		}, RuleDTO.class));
	}

	public ApiResponsePage<RulePackageInstance> queryPackageInstances(PostConditionQueryRequest request) {
		return new ApiResponsePage<>(rulePackageInstanceMapper.query(request.getConditions(), request.getPage(),
				rule -> rule, RulePackageInstance.class));
	}

	public ApiResponseData<RuleStatisticResponse> postRuleStatistic(List<FilterCondition> conditions) {
		RuleStatisticResponse response = new RuleStatisticResponse();
		List<RuleEntity> rules = ruleMapper.selectList(ruleMapper.wrapperFromCondition(conditions));
		ConcurrentMap<RuleType, List<RuleEntity>> ruleTypeGroup = rules.parallelStream()
				.collect(Collectors.groupingByConcurrent(RuleEntity::getType));
		List<RuleTypeCountResponse> typeCount = new ArrayList<RuleTypeCountResponse>();
		for (RuleType type : ruleTypeGroup.keySet()) {
			typeCount.add(new RuleTypeCountResponse(type, ruleTypeGroup.get(type).size()));
		}
		response.setTypeCount(typeCount.toArray(new RuleTypeCountResponse[typeCount.size()]));
		Map<String, Integer> tagGroup = new ConcurrentHashMap<>();
		for (RuleEntity rule : rules) {
			String tags = rule.getTags();
			if (StringUtils.hasText(tags)) {
				String[] tag = tags.split(" ");
				for (String t : tag) {
					if (StringUtils.hasText(t)) {
						tagGroup.put(t, tagGroup.getOrDefault(t, 0) + 1);
					}
				}
			}
		}
		List<RuleTagCountResponse> tagCount = new ArrayList<>();
		for (String tag : tagGroup.keySet()) {
			tagCount.add(new RuleTagCountResponse(tag, tagGroup.get(tag)));
		}
		response.setTagCount(tagCount.toArray(new RuleTagCountResponse[tagCount.size()]));
		return new ApiResponseData<>(response);
	}

	public Function<RulePackage, RulePackageListResponse> getTranslator() {
		return entity -> {
			RulePackageListResponse res = BeanUtils.copyTo(entity, RulePackageListResponse.class);
			String code = entity.getCode();
			Date now = new Date();
			res.setRuleCount(entity.getTactics() == null? 0 : entity.getTactics().size());
			res.setHistory(rulePackageInstanceMapper
					.selectCount(Wrappers.<RulePackageInstance>lambdaQuery().eq(RulePackageInstance::getCode, code)));
			res.setToday(rulePackageInstanceMapper
					.selectCount(Wrappers.<RulePackageInstance>lambdaQuery().eq(RulePackageInstance::getCode, code)
							.between(RulePackageInstance::getStartTime, DateUtils.truncate(now, Calendar.DATE), now)));
			return res;
		};
	}

	private boolean same(Object o1, Object o2) {
		return ( o1 == null ? o2 == null : o1 == o2 || o1.equals(o2));
	}

}
