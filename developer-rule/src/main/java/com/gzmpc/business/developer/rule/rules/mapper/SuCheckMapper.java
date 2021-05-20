package com.gzmpc.business.developer.rule.rules.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SuCheckMapper {

    //检查是否有预收款
    @Select ("SELECT count(1)  FROM zx_bms_prepay_remain_v  Where supplyid = #{supplyId}")
    Integer countPrePayNumBySupplyId (@Param("supplyId")Long supplyId);

    @Select ("select pf_chk_legal(#{supplyId}, #{goodsId}) from dual")
    Integer checkLegal(@Param("supplyId")Long supplyId, @Param("goodsId")Long goodsId);


    //检查特殊药品
    @Select ("SELECT count(1)  FROM ZX_SUCON_GOODS_CHK_V  Where goodsid = #{goodsId}")
    Integer countSpecialGoodsById (@Param("goodsId")Long goodsId);

}
