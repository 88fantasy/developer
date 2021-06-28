package org.exframework.business.developer.rule.rules.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.exframework.business.developer.rule.rules.entity.PubCompanyLicense;
import org.exframework.business.developer.rule.rules.entity.PubSupplyer;
import org.exframework.support.jdbc.mapper.ExBaseMapper;

/**
 * @author rwe
 * @version 创建时间：2021年4月24日 下午10:45:26
 * 证照映射类
 */

public interface PubCompanyLicenseMapper extends ExBaseMapper<PubCompanyLicense> {

//	@Select(" select * from pub_company_license o, pub_ddl d  ${ew.customSqlSegment}")
//	List<PubSupplyer> listPubSupplyer(@Param(Constants.WRAPPER) Wrapper<PubSupplyer> wrapper);


    //判断过期的证照中是否有与货品关联的证照
    @Select("SELECT count(*)  FROM zx_company_lose_license a,(SELECT * FROM pub_company_license WHERE companyid = #{companyId}) b" +
            " WHERE a.licenseid = b.licenseid(+) AND a.companyid = #{companyId} AND a.companyflag = #{companyType} " +
            "AND a.licenseid <> 99 AND a.goodsflag = 0 and a.licenseid <> #{noChkLicenseId} " +
            "AND trunc(nvl(b.licenseend,sysdate-1)) < trunc(sysdate)")
    Integer countValidLicenseNum(@Param("companyId") Long companyId, @Param("companyType") Integer companyType, @Param("noChkLicenseId") Integer noChkLicenseId);


    @Select(" SELECT licenseid FROM zx_company_lose_license Where companyid = #{companyId} AND companyflag = #{companyType} and licenseid <> #{noChkLicenseId}\n" +
            "    UNION\n" +
            "    SELECT licenseid FROM pub_company_license WHERE companyid = #{companyId} AND licenseid not in (35,52) AND (trunc(nvl(licenseinvalidate,sysdate-1)) < trunc(sysdate)+30)\n" +
            "    UNION\n" +
            "    SELECT licenseid FROM zx_supply_license WHERE companyid = #{companyId} AND licenseid in (35) AND (trunc(licenseinvalidate) between trunc(sysdate)-180 and trunc(sysdate)+30)\n ")
    List<Long> getCheckLicenseId(@Param("companyId") Long companyId, @Param("companyType") Integer companyType, @Param("noChkLicenseId") Integer noChkLicenseId);


    @Select(
    "<script>" +
            " select b.ddlname licensename,decode(a.licenseid,null,'无证照记录',decode(licenseinvalidate,null,'证照有效期为空','证照过期')) memo,a.licenseend,a.licenseinvalidate "+
            " from (select * from pub_company_license where companyid =  #{companyId} ) a,"+
            " (select * from pub_ddl where keyword = 'ZX_PUB_COMPANY_LICENSE') b"+
            " where b.ddlid = a.licenseid(+)  and b.ddlid in "
            +" <foreach collection='licenseIds' open='(' close=')' separator=',' item='value'>"
            + " ${value} "
            + " </foreach> " +
            " and (trunc(nvl(a.licenseend,sysdate-1)) &lt; trunc(sysdate) or trunc(nvl(a.licenseinvalidate,sysdate-1)) &lt;trunc(sysdate)) " +
            " </script> "
    )
    List<HashMap> getCheckLicenseInfo(@Param("companyId") Long companyId,@Param("licenseIds") List<Long> licenseIds);
}
