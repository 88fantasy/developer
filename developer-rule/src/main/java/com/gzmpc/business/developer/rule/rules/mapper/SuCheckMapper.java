package com.gzmpc.business.developer.rule.rules.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SuCheckMapper {

    //检查是否有预收款
    @Select ("SELECT count(1)  FROM zx_bms_prepay_remain_v  Where supplyid = #{supplyId}")
    Integer countPrePayNumBySupplyId (@Param("supplyId")Long supplyId);



}
