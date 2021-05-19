package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.ZxManageRange;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午6:20:10
* PubSupplyer
*/

public interface ZxManageRangeMapper extends ExBaseMapper<ZxManageRange> {
	
	@Select("select jyfw,jyfwid from zx_company_jyfw where companyid = #{companyid} and no01 = #{no01}")
	List<ZxManageRange> SelectZxManageRange(@Param("companyid")Long companyid, @Param("no01")String no01);
}
