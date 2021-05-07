package com.gzmpc.business.developer.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gzmpc.business.developer.portal.dto.RuleTypeCountResponse;
import com.gzmpc.business.developer.portal.entity.RuleEntity;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午2:01:50
* 规则映射
*/

public interface RuleMapper extends ExBaseMapper<RuleEntity> {

	
	@Select("select type, count(1) type_count from rule o ${ew.customSqlSegment}")
	List<RuleTypeCountResponse> getRuleTypeCount(@Param(Constants.WRAPPER) Wrapper<?> wrapper);
}
