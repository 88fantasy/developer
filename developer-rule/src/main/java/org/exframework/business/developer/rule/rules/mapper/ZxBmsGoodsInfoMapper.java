package org.exframework.business.developer.rule.rules.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.exframework.business.developer.rule.rules.entity.ZxBmsGoodsInfo;
import org.exframework.support.jdbc.mapper.ExBaseMapper;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午6:20:10
* PubSupplyer
*/

public interface ZxBmsGoodsInfoMapper extends ExBaseMapper<ZxBmsGoodsInfo> {
	
	@Select("select nvl(a.spj24,0)+nvl(a.slzm24,0) as flag,b.no01 from zx_bms_goods_info a,pub_goods b where a.goodsid = #{goodsId} and a.goodsid = b.goodsid")
	HashMap SelectApprovalDocuments(@Param("goodsId")Long goodsId);

}
