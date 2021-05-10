package com.gzmpc.business.developer.rule.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzmpc.business.developer.rule.rules.entity.BmsSuConDtl;
import com.gzmpc.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年4月24日 下午10:45:26
* 映射类
*/

public interface BmsSuConDtlMapper extends ExBaseMapper<BmsSuConDtl>{
	
	//@Select(" select *from bms_su_con_doc t , bms_su_con_dtl d ${ew.customSqlSegment}")
	@Select(" select *from bms_su_con_doc t , bms_su_con_dtl d "
			+ "where t.supplyid = #{supplyId} and d.goodsid = #{goodsId} and t.suconid = d.suconid "
			+ "and d.realrgcompany is not null order by t.signdate desc")
	List<BmsSuConDtl> CheckSupplyHistoryDocu(@Param("supplyId")Long supplyId, @Param("goodsId")Long goodsId);

}
