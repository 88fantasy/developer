package com.gzmpc.business.developer.portal.service;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gzmpc.business.developer.portal.dto.RuleDTO;
import com.gzmpc.business.developer.portal.dto.RulePackageListResponse;
import com.gzmpc.business.developer.portal.entity.RuleEntity;
import com.gzmpc.business.developer.portal.entity.RulePackage;
import com.gzmpc.business.developer.portal.entity.RulePackageInstance;
import com.gzmpc.business.developer.portal.entity.RulePackageTactics;
import com.gzmpc.business.developer.portal.mapper.RuleMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageInstanceMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageMapper;
import com.gzmpc.business.developer.portal.mapper.RulePackageTacticsMapper;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.util.BeanUtils;
import com.gzmpc.support.jdbc.service.ExBaseService;
import com.gzmpc.support.rest.entity.ApiResponsePage;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午2:26:16
* 规则业务处理
*/

@Service
public class DeveloperRuleService extends ExBaseService<RulePackageMapper, RulePackage> {

	@Autowired
	RuleMapper ruleMapper;
	
	@Autowired
	RulePackageTacticsMapper rulePackageTacticsMapper;
	
	@Autowired
	RulePackageInstanceMapper rulePackageInstanceMapper;
	
	public void saveRule(RuleDTO rule, boolean replace) {
		RuleEntity entity = ruleMapper.selectById(rule.getCode());
		boolean exists = entity != null;
		if(exists && !replace ) {
			return;
		}
		entity = BeanUtils.copyTo(rule, RuleEntity.class);
		entity.setType(rule.getType());
		if(exists) {
			ruleMapper.updateById(entity);
		}
		else {
			ruleMapper.insert(entity);
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
		return new ApiResponsePage<>(rulePackageInstanceMapper.query(request.getConditions(), request.getPage(), rule -> rule, RulePackageInstance.class));
	}

	public Function<RulePackage, RulePackageListResponse> getTranslator() {
		return entity -> {
			RulePackageListResponse res = BeanUtils.copyTo(entity, RulePackageListResponse.class);;
			String code = entity.getCode();
			Date now = new Date();
			res.setRuleCount(rulePackageTacticsMapper.selectCount(Wrappers.<RulePackageTactics>lambdaQuery().eq(RulePackageTactics::getPackageCode, code)));
			res.setHistory(rulePackageInstanceMapper.selectCount(Wrappers.<RulePackageInstance>lambdaQuery().eq(RulePackageInstance::getCode, code)));
			res.setToday(rulePackageInstanceMapper.selectCount(Wrappers.<RulePackageInstance>lambdaQuery().eq(RulePackageInstance::getCode, code).between(RulePackageInstance::getStartTime, DateUtils.truncate(now, Calendar.DATE) , now)));
			return res;
		};
	}
	
	
	
}
