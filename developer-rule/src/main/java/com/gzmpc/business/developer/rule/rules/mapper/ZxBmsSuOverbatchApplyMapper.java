package com.gzmpc.business.developer.rule.rules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzmpc.business.developer.rule.rules.entity.ZxBmsSuOverbatchApply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.Map;

public interface ZxBmsSuOverbatchApplyMapper  extends BaseMapper<ZxBmsSuOverbatchApply> {


   @Select(" SELECT nvl(Min(applyid), 0)  FROM zx_bms_su_overbatch_apply Where goodsid = #{goodsId} AND nvl(batchqty, 0) - nvl(finishqty, 0) > 0 AND usestatus In (3)")
   Long getApplyIdByGoodsId(@Param("goodsId") Long goodsId);


    /**
     * 查货品分类数量、上限数量
     */
    @Select("SELECT nvl(max(a.busidtlqty),0) busidtlqty, nvl(max(round(decode(a.usestatus,1,a.upqty,0))),0) upqty FROM bms_busi_dtl a, bms_busiclass_def b, pub_goods c, bms_busi_def d WHERE a.busiclassid = b.busiclassid AND a.busiaccid = d.busiaccid  AND b.busiclassno = c.opcode AND c.goodsid = #{goodsId} AND d.busitype = 1")
    Map getBusiDtlQtyAndUpQty(@Param("goodsId") Long goodsId);

    /**
     * 查未执行合同数
     */
    @Select("SELECT nvl(sum(goodsqty - nvl(accqty,0)),0) FROM bms_su_con_dtl_v WHERE usestatus IN (2,3) AND goodsid = #{goodsId} AND sucondtlid <> #{suConDtlId}")
    Long  getUnAccQty(@Param("goodsId") Long goodsId,@Param("suConDtlId") Long suConDtlId);

    /**
     * 查未完成的超量数量
     */
    @Select("  SELECT nvl(batchqty, 0) - nvl(finishqty, 0)  FROM zx_bms_su_overbatch_apply Where applyid  =#{applyId}")
    Long  getNotFinishQtyByApplyId(@Param("applyId") Long applyId);

    /**
     *    获取新增的合同数量
     */
    @Select("  SELECT nvl(#{currGoodsQty}, 0) - nvl(Max(goodsqty), 0) FROM bms_su_con_dtl Where sucondtlid = #{suConDtlId}")
    BigDecimal  getNewAddGoodsQty(@Param("currGoodsQty") BigDecimal currGoodsQty,@Param("suConDtlId") Long suConDtlId);



}
