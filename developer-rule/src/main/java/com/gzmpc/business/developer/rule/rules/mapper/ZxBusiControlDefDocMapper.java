package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.ZxBusiControlDefDoc;
import com.gzmpc.business.developer.rule.rules.entity.ZxLicenseToGoods;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年4月24日 下午10:45:26
* 映射类
*/

public interface ZxBusiControlDefDocMapper extends ExBaseMapper<ZxBusiControlDefDoc>{
	
	@Select("select t.docid,t.columnname,t.controlflag,t.jyfwmsg,c.compsubtype as optype,t.companytype,t.approvemanid "
			+ "FROM SYS_OP o, ZX_BUSICONTROL_DEF_DOC t, SYS_COMP c WHERE o.opid = t.opid AND o.COMPID = c.COMPID "
			+ "and t.opid =  #{opid} AND t.flag = 0 order by t.companytype")
	List<ZxBusiControlDefDoc> SelectZxBusiControlDefDocByOpid(@Param("opid")Long opid);
	
	@Select("select t.docid,t.columnname,t.controlflag,t.msg,c.compsubtype as optype "
			+ "FROM SYS_OP o, ZX_BUSICONTROL_DEF_DOC t, SYS_COMP c WHERE o.opid = t.opid AND o.COMPID = c.COMPID "
			+ "and t.opid =  #{opid} AND t.flag = 1")
	ZxBusiControlDefDoc SelectGzmpcZxBusiControlDefDocByOpid(@Param("opid")Long opid);
	
	@Select("select t.docid,t.columnname,t.controlflag,t.msg,c.compsubtype as optype,t.companytype,nvl(t.msgdetailflag,0) as msgdetailflag,t.approvemanid "
			+ "FROM SYS_OP o, ZX_BUSICONTROL_DEF_DOC t, SYS_COMP c WHERE o.opid = t.opid AND o.COMPID = c.COMPID "
			+ "and t.opid =  #{opid} AND t.flag = 0 order by t.companytype")
	List<ZxBusiControlDefDoc> SelectCustomerListZxBusiControlDefDocByOpid(@Param("opid")Long opid);
	
	@Select("select count(1) from pub_customer_set_dtl a,pub_customer b where a.setid in (10284, 10283, 10282) "
			+ "and a.customid=b.customid and b.no01='06' and a.customid = #{customId}")
	Integer SelectCountFromPubCustomerSetDtlByCustomId(@Param("customId")Long customId);
	
	@Select("select count(1) from pub_customer_set_dtl a where a.setid in (10284, 10283, 10282) and a.customid = #{customId}")
	Integer SelectCbflagFromPubCustomerSetDtl(@Param("customId")Long customId);
	
	@Select("select a.rowsid,a.goodsno,a.licenseid,b.ddlname from zx_license_to_goods a,pub_ddl b where a.licenseid = b.ddlid and  "
			+ "b.keyword = 'ZX_PUB_COMPANY_LICENSE' and (a.companyno01 is null or a.companyno01 = #{companyno01} and a.no01 = #{goodsno01} and #{flag} = 1")
	List<ZxLicenseToGoods> SelectZxLicenseToGoodsByNo01(@Param("companyno01")String companyno01, @Param("goodsno01")String goodsno01, @Param("flag")String flag);

	
	@Select("select pf_license_need_chk(#{companyid}, #{licenseid}, #{rowsid}, #{companytype}) from dual")
	Integer SelectChkFlagFromDual(@Param("companyid")Long companyid, @Param("licenseid")Long licenseid, @Param("rowsid")Long rowsid, @Param("companytype")Long companytype);

	@Select("select count(*) from pub_goods where #{goodsno} = (select #{goodsno} from zx_license_to_goods where rowsid = #{rowsid}) and goodsid = #{goodsid}")
	Integer SelectCountFromPubGoodsById(@Param("goodsno")String goodsno, @Param("rowsid")Long rowsid, @Param("goodsid")Long goodsid);

	@Select("select count(*) from (select * from pub_ddl where keyword = 'ZX_PUB_COMPANY_LICENSE') a,(select * from pub_company_license where companyid = #{companyid}) b where a.ddlid = b.licenseid"
			+ " and a.ddlid in (#{slicenseid}) and (trunc(nvl(b.licenseinvalidate,sysdate-1)) < trunc(sysdate)")
	Integer selectpubDdlByCompanyId(long companyid, String slicenseid);	

}
