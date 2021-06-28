package org.exframework.business.developer.rule.rules.mapper;

import org.exframework.business.developer.rule.rules.entity.BmsSuConDoc;
import org.exframework.support.jdbc.mapper.ExBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ZxBmsSuConYearMapper  {

    @Select(" SELECT nvl(max(ysuconid), 0)  FROM zx_bms_su_con_year_doc a " +
            " WHERE a.supplyid = #{supplyId} AND A.ZXCOLUMN4 = 1 and a.convertype = 1 " +
            " AND #{signDate} BETWEEN begindate AND enddate AND a.docusestatus In (2, 3)")
    Long getYearSuConId(@Param("supplyId") Long supplyId,@Param("signDate") Date signDate);


    @Select(" <script> SELECT nvl(max(ysucondtlid), 0) FROM zx_bms_su_con_year_doc a, zx_bms_su_con_year_dtl b " +
            "WHERE a.ysuconid = b.ysuconid AND a.supplyid = #{supplyId} AND b.goodsid = #{goodsId}" +
            " AND #{signDate} BETWEEN begindate AND enddate AND usestatus In  " +
            " <foreach collection='useStatus' open='(' close=')' separator=',' item='value'>" +
            " ${valu" +
            "" +
            "e} "+
            " </foreach>  </script>")
    Long getYearSuConDtlId(@Param("supplyId") Long supplyId,@Param("goodsId") Long goodsId,@Param("signDate") Date signDate, @Param("useStatus") List<Integer> useStatus);



    @Select("SELECT nvl(goodsqty, 0) - nvl(conqty, 0) remqty, Round(unitprice, 3) yunitprice ,ysuconid " +
            "FROM zx_bms_su_con_year_dtl Where ysucondtlid = #{ySuConDtlId}")
    Map getRemqtyAndPriceByDtlId(@Param("ySuConDtlId") Long ySuConDtlId);

}