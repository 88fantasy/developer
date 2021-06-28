package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjf
 * @since 2021-05-13
 */
public class ZxBmsSuConYearDtl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("YSUCONID")
    private Long ysuconid;

    @TableId("YSUCONDTLID")
    private Long ysucondtlid;

    @TableField("USESTATUS")
    private Integer usestatus;

    @TableField("GOODSID")
    private Long goodsid;

    @TableField("GOODSQTY")
    private Long goodsqty;

    @TableField("UNITPRICE")
    private BigDecimal unitprice;

    @TableField("TOTAL_LINE")
    private BigDecimal totalLine;

    @TableField("COSTINGPRICE")
    private BigDecimal costingprice;

    @TableField("MEMO")
    private String memo;

    @TableField("INVALIDMEMO")
    private String invalidmemo;

    @TableField("COSTINGMONEY")
    private BigDecimal costingmoney;

    @TableField("CONQTY")
    private Long conqty;

    @TableField("INVALIDMANID")
    private Long invalidmanid;

    @TableField("INVALIDDATE")
    private Date invaliddate;

    @TableField("TAXRATE")
    private BigDecimal taxrate;

    @TableField("FINDATE")
    private Date findate;

    /**
     * 税率点数
     */
    @TableField("TAXRATE_POINT")
    private String taxratePoint;

    /**
     * 税率点数(其他)
     */
    @TableField("TAXRATE_POINT1")
    private String taxratePoint1;

    /**
     * 发票类型(PUB_INVTYPE)
     */
    @TableField("INVTYPE")
    private Integer invtype;

    /**
     * 简易征收商品
     */
    @TableField("JYZSGOODSFLAG")
    private Integer jyzsgoodsflag;

    /**
     * 复核标志
     */
    @TableField("DTLCFMFLAG")
    private Integer dtlcfmflag;

    /**
     * 检测结果
     */
    @TableField("CHECKRESULT")
    private String checkresult;

    public Long getYsuconid() {
        return ysuconid;
    }

    public void setYsuconid(Long ysuconid) {
        this.ysuconid = ysuconid;
    }
    public Long getYsucondtlid() {
        return ysucondtlid;
    }

    public void setYsucondtlid(Long ysucondtlid) {
        this.ysucondtlid = ysucondtlid;
    }
    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }
    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
    public Long getGoodsqty() {
        return goodsqty;
    }

    public void setGoodsqty(Long goodsqty) {
        this.goodsqty = goodsqty;
    }
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }
    public BigDecimal getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(BigDecimal totalLine) {
        this.totalLine = totalLine;
    }
    public BigDecimal getCostingprice() {
        return costingprice;
    }

    public void setCostingprice(BigDecimal costingprice) {
        this.costingprice = costingprice;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getInvalidmemo() {
        return invalidmemo;
    }

    public void setInvalidmemo(String invalidmemo) {
        this.invalidmemo = invalidmemo;
    }
    public BigDecimal getCostingmoney() {
        return costingmoney;
    }

    public void setCostingmoney(BigDecimal costingmoney) {
        this.costingmoney = costingmoney;
    }
    public Long getConqty() {
        return conqty;
    }

    public void setConqty(Long conqty) {
        this.conqty = conqty;
    }
    public Long getInvalidmanid() {
        return invalidmanid;
    }

    public void setInvalidmanid(Long invalidmanid) {
        this.invalidmanid = invalidmanid;
    }
    public Date getInvaliddate() {
        return invaliddate;
    }

    public void setInvaliddate(Date invaliddate) {
        this.invaliddate = invaliddate;
    }
    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }
    public Date getFindate() {
        return findate;
    }

    public void setFindate(Date findate) {
        this.findate = findate;
    }
    public String getTaxratePoint() {
        return taxratePoint;
    }

    public void setTaxratePoint(String taxratePoint) {
        this.taxratePoint = taxratePoint;
    }
    public String getTaxratePoint1() {
        return taxratePoint1;
    }

    public void setTaxratePoint1(String taxratePoint1) {
        this.taxratePoint1 = taxratePoint1;
    }
    public Integer getInvtype() {
        return invtype;
    }

    public void setInvtype(Integer invtype) {
        this.invtype = invtype;
    }
    public Integer getJyzsgoodsflag() {
        return jyzsgoodsflag;
    }

    public void setJyzsgoodsflag(Integer jyzsgoodsflag) {
        this.jyzsgoodsflag = jyzsgoodsflag;
    }
    public Integer getDtlcfmflag() {
        return dtlcfmflag;
    }

    public void setDtlcfmflag(Integer dtlcfmflag) {
        this.dtlcfmflag = dtlcfmflag;
    }
    public String getCheckresult() {
        return checkresult;
    }

    public void setCheckresult(String checkresult) {
        this.checkresult = checkresult;
    }

    @Override
    public String toString() {
        return "ZxBmsSuConYearDtl{" +
            "ysuconid=" + ysuconid +
            ", ysucondtlid=" + ysucondtlid +
            ", usestatus=" + usestatus +
            ", goodsid=" + goodsid +
            ", goodsqty=" + goodsqty +
            ", unitprice=" + unitprice +
            ", totalLine=" + totalLine +
            ", costingprice=" + costingprice +
            ", memo=" + memo +
            ", invalidmemo=" + invalidmemo +
            ", costingmoney=" + costingmoney +
            ", conqty=" + conqty +
            ", invalidmanid=" + invalidmanid +
            ", invaliddate=" + invaliddate +
            ", taxrate=" + taxrate +
            ", findate=" + findate +
            ", taxratePoint=" + taxratePoint +
            ", taxratePoint1=" + taxratePoint1 +
            ", invtype=" + invtype +
            ", jyzsgoodsflag=" + jyzsgoodsflag +
            ", dtlcfmflag=" + dtlcfmflag +
            ", checkresult=" + checkresult +
        "}";
    }
}
