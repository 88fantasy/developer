package org.exframework.business.developer.rule.rules.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.exframework.business.developer.rule.rules.entity.BmsSuConDtl;
import org.exframework.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年4月24日 下午10:45:26
* 映射类
*/

public interface BmsSuConDtlMapper extends ExBaseMapper<BmsSuConDtl>{
	
	@Select("select * from (select d.realrgcompany, d.wtps_dtlid from bms_su_con_doc t , bms_su_con_dtl d "
			+ "where t.supplyid = #{supplyId} and d.goodsid = #{goodsId} and t.suconid = d.suconid "
			+ "and d.realrgcompany is not null order by t.signdate desc) where rownum < 2")
	BmsSuConDtl CheckSupplyHistoryDocu(@Param("supplyId")Long supplyId, @Param("goodsId")Long goodsId);

}
