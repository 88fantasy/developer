package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.gzmpc.business.developer.rule.rules.entity.PubCompanyLicense;
import com.gzmpc.business.developer.rule.rules.entity.PubSupplyer;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午10:45:26
* 证照映射类
*/

public interface PubCompanyLicenseMapper extends ExBaseMapper<PubCompanyLicense>{
	
//	@Select(" select * from pub_company_license o, pub_ddl d  ${ew.customSqlSegment}")
//	List<PubSupplyer> listPubSupplyer(@Param(Constants.WRAPPER) Wrapper<PubSupplyer> wrapper);

//    //检查是否有法人委托书
//    @Select("SELECT count(1) FROM zx_supply_license t1 WHERE t1.companyid = #{companyId}  and t1.licenseid = 35")
//    Integer countLicenseNumByCompanyId (@Param("companyId")Long companyId);
//
//    //检查法人委托书是否效期内
//    @Select("SELECT count(1) FROM zx_supply_license WHERE t1.companyid = #{companyId} AND t1.licenseend >= trunc(sysdate, 'dd')and t1.licenseid = 35")
//    Integer countLicenseNumInvalidByCompanyId(@Param("companyId")Long companyId);


}
