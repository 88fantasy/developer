package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 进货合同明细
 * </p>
 *
 * @author yjf
 * @since 2021-05-11
 */
@TableName("BMS_SU_CON_DTL")
public class BmsSuConDtl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 进货明细标识号
     */
    @TableId("SUCONDTLID")
    private Long sucondtlid;

    /**
     * 合同总单标识号
     */
    @TableField("SUCONID")
    private Long suconid;

    /**
     * 业务员标识号
     */
    @TableField("SUPPLYERID")
    private Long supplyerid;

    /**
     * 业务员部门标识号
     */
    @TableField("DEPTID")
    private Long deptid;

    /**
     * 细目外部编号
     */
    @TableField("SUCONDTLNO")
    private String sucondtlno;

    /**
     * 货品标识号
     */
    @TableField("GOODSID")
    private Long goodsid;

    /**
     * 数量
     */
    @TableField("GOODSQTY")
    private BigDecimal goodsqty;

    /**
     * 税率
     */
    @TableField("TAXRATE")
    private BigDecimal taxrate;

    /**
     * 合同货价（针对进口合同）
     */
    @TableField("FOREIGNPRICE")
    private BigDecimal foreignprice;

    /**
     * 合同金额（针对进口合同）
     */
    @TableField("FOREIGNMONEY")
    private BigDecimal foreignmoney;

    /**
     * 货币名称(RMB、USD，HKD等)
     */
    @TableField("CURRENCY")
    private String currency;

    /**
     * 成本金额
     */
    @TableField("COSTINGMONEY")
    private BigDecimal costingmoney;

    /**
     * 进货价
     */
    @TableField("UNITPRICE")
    private BigDecimal unitprice;

    /**
     * 金额
     */
    @TableField("TOTAL_LINE")
    private BigDecimal totalLine;

    /**
     * 合同状态0:作废;1:未签;2:已签;3:执行;4:中止；5:完成;系统字典SYS_DDL(SUCON_USESTATUS)
     */
    @TableField("USESTATUS")
    private Integer usestatus;

    /**
     * 完成日期
     */
    @TableField("FINDATE")
    private Date findate;

    /**
     * 累计入库数
     */
    @TableField("ACCQTY")
    private BigDecimal accqty;

    /**
     * 备注
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 作废人标识号
     */
    @TableField("INVALIDMANID")
    private Long invalidmanid;

    /**
     * 作废时间
     */
    @TableField("INVALIDDATE")
    private Date invaliddate;

    /**
     * 到货批数
     */
    @TableField("BATCHNUM")
    private Long batchnum;

    /**
     * 是否有进货协议
     */
    @TableField("AGREEDOCFLAG")
    private Integer agreedocflag;

    /**
     * 成本价
     */
    @TableField("COSTINGPRICE")
    private BigDecimal costingprice;

    /**
     * 累计退货数量
     */
    @TableField("ACCBACKQTY")
    private BigDecimal accbackqty;

    /**
     * 累计交货差异（实际—计划）
     */
    @TableField("REALEXECDIFF")
    private BigDecimal realexecdiff;

    /**
     * 完成时累计执行数量
     */
    @TableField("FINEXECQTY")
    private BigDecimal finexecqty;

    /**
     * 实际价
     */
    @TableField("REALPRICE")
    private BigDecimal realprice;

    /**
     * "存厂直拨ID"
     */
    @TableField("ZXCOLUMN1")
    private String zxcolumn1;

    /**
     * "请购单明细ID"
     */
    @TableField("ZXCOLUMN2")
    private String zxcolumn2;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN3")
    private String zxcolumn3;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN4")
    private String zxcolumn4;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN5")
    private String zxcolumn5;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN6")
    private String zxcolumn6;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN7")
    private String zxcolumn7;

    /**
     * 共享库存销售细单ID
     */
    @TableField("ZXCOLUMN8")
    private String zxcolumn8;

    /**
     * "中止原因"
     */
    @TableField("ZXCOLUMN9")
    private String zxcolumn9;

    /**
     * 零售价 
     */
    @TableField("ZXCOLUMN10")
    private String zxcolumn10;

    /**
     * 采购计划ID
     */
    @TableField("WRKPLNID")
    private Long wrkplnid;

    /**
     * 采购计划细单ID
     */
    @TableField("WRKPLNEXEID")
    private Long wrkplnexeid;

    /**
     * 协议分销号
     */
    @TableField("DITCHNO")
    private String ditchno;

    /**
     * 预计到货日期
     */
    @TableField("DTLEXPECTDATE")
    private Date dtlexpectdate;

    /**
     * 默认收货仓库ID
     */
    @TableField("LSTID")
    private Long lstid;

    /**
     * 实际收货仓库编码
     */
    @TableField("LSTOPCODE")
    private String lstopcode;

    /**
     * 实际收货仓库
     */
    @TableField("LSTNAME")
    private String lstname;

    /**
     * 预付付款单ID
     */
    @TableField("PREPAYID")
    private Long prepayid;

    /**
     * 年度合同细单ID
     */
    @TableField("YSUCONDTLID")
    private Long ysucondtlid;

    /**
     * 超批量申请单ID
     */
    @TableField("OBAPPLYID")
    private Long obapplyid;

    /**
     * 超批量采购数量
     */
    @TableField("OBQTY")
    private Long obqty;

    /**
     * 修改日期
     */
    @TableField("MODIFYDATE")
    private Date modifydate;

    /**
     * 修改人标识号
     */
    @TableField("MODIFYMAN")
    private BigDecimal modifyman;

    /**
     * 默认收货仓库ID默认值
     */
    @TableField("LSTID0")
    private Long lstid0;

    /**
     * 预约时间段
     */
    @TableField("DTLEXPECTDATEPERIOD")
    private Integer dtlexpectdateperiod;

    /**
     * 实际来货单位
     */
    @TableField("REALRGCOMPANY")
    private String realrgcompany;

    /**
     * 委托配送协议细单ID
     */
    @TableField("WTPS_DTLID")
    private Long wtpsDtlid;

    /**
     * 释放时间
     */
    @TableField("RELEASETIME")
    private Date releasetime;

    /**
     * 预收货单生成时间
     */
    @TableField("PRERGTIME")
    private Date prergtime;

    /**
     * 运单号
     */
    @TableField("DTLTRANSNO")
    private String dtltransno;

    /**
     * 运单号修改时间
     */
    @TableField("DTLTRANSNOMODIFYDATE")
    private Date dtltransnomodifydate;

    /**
     * 运单号修改人
     */
    @TableField("DTLTRANSNOMODIFYMAN")
    private BigDecimal dtltransnomodifyman;

    /**
     * 实际来货数量
     */
    @TableField("ACTUALCOMQTY")
    private BigDecimal actualcomqty;

    /**
     * 二次预计到货日期
     */
    @TableField("DTLSECEXPECTDATE")
    private Date dtlsecexpectdate;

    /**
     * 二次预约时间段
     */
    @TableField("DTLSECEXPECTDATEPERIOD")
    private Integer dtlsecexpectdateperiod;

    /**
     * 到货限制天数
     */
    @TableField("DHTS")
    private Integer dhts;

    /**
     * 货品明细ID
     */
    @TableField("GOODSDTLID")
    private Long goodsdtlid;

    /**
     * 收货提示
     */
    @TableField("SOLUTION")
    private String solution;

    /**
     * 套装名称
     */
    @TableField("BOMNAME")
    private String bomname;

    @TableField("IMPORTFLAG")
    private Integer importflag;

    @TableField("CHECKFLAG")
    private Integer checkflag;

    public Long getSucondtlid() {
        return sucondtlid;
    }

    public void setSucondtlid(Long sucondtlid) {
        this.sucondtlid = sucondtlid;
    }
    public Long getSuconid() {
        return suconid;
    }

    public void setSuconid(Long suconid) {
        this.suconid = suconid;
    }
    public Long getSupplyerid() {
        return supplyerid;
    }

    public void setSupplyerid(Long supplyerid) {
        this.supplyerid = supplyerid;
    }
    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }
    public String getSucondtlno() {
        return sucondtlno;
    }

    public void setSucondtlno(String sucondtlno) {
        this.sucondtlno = sucondtlno;
    }
    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
    public BigDecimal getGoodsqty() {
        return goodsqty;
    }

    public void setGoodsqty(BigDecimal goodsqty) {
        this.goodsqty = goodsqty;
    }
    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }
    public BigDecimal getForeignprice() {
        return foreignprice;
    }

    public void setForeignprice(BigDecimal foreignprice) {
        this.foreignprice = foreignprice;
    }
    public BigDecimal getForeignmoney() {
        return foreignmoney;
    }

    public void setForeignmoney(BigDecimal foreignmoney) {
        this.foreignmoney = foreignmoney;
    }
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public BigDecimal getCostingmoney() {
        return costingmoney;
    }

    public void setCostingmoney(BigDecimal costingmoney) {
        this.costingmoney = costingmoney;
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
    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }
    public Date getFindate() {
        return findate;
    }

    public void setFindate(Date findate) {
        this.findate = findate;
    }
    public BigDecimal getAccqty() {
        return accqty;
    }

    public void setAccqty(BigDecimal accqty) {
        this.accqty = accqty;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
    public Long getBatchnum() {
        return batchnum;
    }

    public void setBatchnum(Long batchnum) {
        this.batchnum = batchnum;
    }
    public Integer getAgreedocflag() {
        return agreedocflag;
    }

    public void setAgreedocflag(Integer agreedocflag) {
        this.agreedocflag = agreedocflag;
    }
    public BigDecimal getCostingprice() {
        return costingprice;
    }

    public void setCostingprice(BigDecimal costingprice) {
        this.costingprice = costingprice;
    }
    public BigDecimal getAccbackqty() {
        return accbackqty;
    }

    public void setAccbackqty(BigDecimal accbackqty) {
        this.accbackqty = accbackqty;
    }
    public BigDecimal getRealexecdiff() {
        return realexecdiff;
    }

    public void setRealexecdiff(BigDecimal realexecdiff) {
        this.realexecdiff = realexecdiff;
    }
    public BigDecimal getFinexecqty() {
        return finexecqty;
    }

    public void setFinexecqty(BigDecimal finexecqty) {
        this.finexecqty = finexecqty;
    }
    public BigDecimal getRealprice() {
        return realprice;
    }

    public void setRealprice(BigDecimal realprice) {
        this.realprice = realprice;
    }
    public String getZxcolumn1() {
        return zxcolumn1;
    }

    public void setZxcolumn1(String zxcolumn1) {
        this.zxcolumn1 = zxcolumn1;
    }
    public String getZxcolumn2() {
        return zxcolumn2;
    }

    public void setZxcolumn2(String zxcolumn2) {
        this.zxcolumn2 = zxcolumn2;
    }
    public String getZxcolumn3() {
        return zxcolumn3;
    }

    public void setZxcolumn3(String zxcolumn3) {
        this.zxcolumn3 = zxcolumn3;
    }
    public String getZxcolumn4() {
        return zxcolumn4;
    }

    public void setZxcolumn4(String zxcolumn4) {
        this.zxcolumn4 = zxcolumn4;
    }
    public String getZxcolumn5() {
        return zxcolumn5;
    }

    public void setZxcolumn5(String zxcolumn5) {
        this.zxcolumn5 = zxcolumn5;
    }
    public String getZxcolumn6() {
        return zxcolumn6;
    }

    public void setZxcolumn6(String zxcolumn6) {
        this.zxcolumn6 = zxcolumn6;
    }
    public String getZxcolumn7() {
        return zxcolumn7;
    }

    public void setZxcolumn7(String zxcolumn7) {
        this.zxcolumn7 = zxcolumn7;
    }
    public String getZxcolumn8() {
        return zxcolumn8;
    }

    public void setZxcolumn8(String zxcolumn8) {
        this.zxcolumn8 = zxcolumn8;
    }
    public String getZxcolumn9() {
        return zxcolumn9;
    }

    public void setZxcolumn9(String zxcolumn9) {
        this.zxcolumn9 = zxcolumn9;
    }
    public String getZxcolumn10() {
        return zxcolumn10;
    }

    public void setZxcolumn10(String zxcolumn10) {
        this.zxcolumn10 = zxcolumn10;
    }
    public Long getWrkplnid() {
        return wrkplnid;
    }

    public void setWrkplnid(Long wrkplnid) {
        this.wrkplnid = wrkplnid;
    }
    public Long getWrkplnexeid() {
        return wrkplnexeid;
    }

    public void setWrkplnexeid(Long wrkplnexeid) {
        this.wrkplnexeid = wrkplnexeid;
    }
    public String getDitchno() {
        return ditchno;
    }

    public void setDitchno(String ditchno) {
        this.ditchno = ditchno;
    }
    public Date getDtlexpectdate() {
        return dtlexpectdate;
    }

    public void setDtlexpectdate(Date dtlexpectdate) {
        this.dtlexpectdate = dtlexpectdate;
    }
    public Long getLstid() {
        return lstid;
    }

    public void setLstid(Long lstid) {
        this.lstid = lstid;
    }
    public String getLstopcode() {
        return lstopcode;
    }

    public void setLstopcode(String lstopcode) {
        this.lstopcode = lstopcode;
    }
    public String getLstname() {
        return lstname;
    }

    public void setLstname(String lstname) {
        this.lstname = lstname;
    }
    public Long getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(Long prepayid) {
        this.prepayid = prepayid;
    }
    public Long getYsucondtlid() {
        return ysucondtlid;
    }

    public void setYsucondtlid(Long ysucondtlid) {
        this.ysucondtlid = ysucondtlid;
    }
    public Long getObapplyid() {
        return obapplyid;
    }

    public void setObapplyid(Long obapplyid) {
        this.obapplyid = obapplyid;
    }
    public Long getObqty() {
        return obqty;
    }

    public void setObqty(Long obqty) {
        this.obqty = obqty;
    }
    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
    public BigDecimal getModifyman() {
        return modifyman;
    }

    public void setModifyman(BigDecimal modifyman) {
        this.modifyman = modifyman;
    }
    public Long getLstid0() {
        return lstid0;
    }

    public void setLstid0(Long lstid0) {
        this.lstid0 = lstid0;
    }
    public Integer getDtlexpectdateperiod() {
        return dtlexpectdateperiod;
    }

    public void setDtlexpectdateperiod(Integer dtlexpectdateperiod) {
        this.dtlexpectdateperiod = dtlexpectdateperiod;
    }
    public String getRealrgcompany() {
        return realrgcompany;
    }

    public void setRealrgcompany(String realrgcompany) {
        this.realrgcompany = realrgcompany;
    }
    public Long getWtpsDtlid() {
        return wtpsDtlid;
    }

    public void setWtpsDtlid(Long wtpsDtlid) {
        this.wtpsDtlid = wtpsDtlid;
    }
    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }
    public Date getPrergtime() {
        return prergtime;
    }

    public void setPrergtime(Date prergtime) {
        this.prergtime = prergtime;
    }
    public String getDtltransno() {
        return dtltransno;
    }

    public void setDtltransno(String dtltransno) {
        this.dtltransno = dtltransno;
    }
    public Date getDtltransnomodifydate() {
        return dtltransnomodifydate;
    }

    public void setDtltransnomodifydate(Date dtltransnomodifydate) {
        this.dtltransnomodifydate = dtltransnomodifydate;
    }
    public BigDecimal getDtltransnomodifyman() {
        return dtltransnomodifyman;
    }

    public void setDtltransnomodifyman(BigDecimal dtltransnomodifyman) {
        this.dtltransnomodifyman = dtltransnomodifyman;
    }
    public BigDecimal getActualcomqty() {
        return actualcomqty;
    }

    public void setActualcomqty(BigDecimal actualcomqty) {
        this.actualcomqty = actualcomqty;
    }
    public Date getDtlsecexpectdate() {
        return dtlsecexpectdate;
    }

    public void setDtlsecexpectdate(Date dtlsecexpectdate) {
        this.dtlsecexpectdate = dtlsecexpectdate;
    }
    public Integer getDtlsecexpectdateperiod() {
        return dtlsecexpectdateperiod;
    }

    public void setDtlsecexpectdateperiod(Integer dtlsecexpectdateperiod) {
        this.dtlsecexpectdateperiod = dtlsecexpectdateperiod;
    }
    public Integer getDhts() {
        return dhts;
    }

    public void setDhts(Integer dhts) {
        this.dhts = dhts;
    }
    public Long getGoodsdtlid() {
        return goodsdtlid;
    }

    public void setGoodsdtlid(Long goodsdtlid) {
        this.goodsdtlid = goodsdtlid;
    }
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getBomname() {
        return bomname;
    }

    public void setBomname(String bomname) {
        this.bomname = bomname;
    }
    public Integer getImportflag() {
        return importflag;
    }

    public void setImportflag(Integer importflag) {
        this.importflag = importflag;
    }
    public Integer getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(Integer checkflag) {
        this.checkflag = checkflag;
    }

    @Override
    public String toString() {
        return "BmsSuConDtl{" +
            "sucondtlid=" + sucondtlid +
            ", suconid=" + suconid +
            ", supplyerid=" + supplyerid +
            ", deptid=" + deptid +
            ", sucondtlno=" + sucondtlno +
            ", goodsid=" + goodsid +
            ", goodsqty=" + goodsqty +
            ", taxrate=" + taxrate +
            ", foreignprice=" + foreignprice +
            ", foreignmoney=" + foreignmoney +
            ", currency=" + currency +
            ", costingmoney=" + costingmoney +
            ", unitprice=" + unitprice +
            ", totalLine=" + totalLine +
            ", usestatus=" + usestatus +
            ", findate=" + findate +
            ", accqty=" + accqty +
            ", memo=" + memo +
            ", invalidmanid=" + invalidmanid +
            ", invaliddate=" + invaliddate +
            ", batchnum=" + batchnum +
            ", agreedocflag=" + agreedocflag +
            ", costingprice=" + costingprice +
            ", accbackqty=" + accbackqty +
            ", realexecdiff=" + realexecdiff +
            ", finexecqty=" + finexecqty +
            ", realprice=" + realprice +
            ", zxcolumn1=" + zxcolumn1 +
            ", zxcolumn2=" + zxcolumn2 +
            ", zxcolumn3=" + zxcolumn3 +
            ", zxcolumn4=" + zxcolumn4 +
            ", zxcolumn5=" + zxcolumn5 +
            ", zxcolumn6=" + zxcolumn6 +
            ", zxcolumn7=" + zxcolumn7 +
            ", zxcolumn8=" + zxcolumn8 +
            ", zxcolumn9=" + zxcolumn9 +
            ", zxcolumn10=" + zxcolumn10 +
            ", wrkplnid=" + wrkplnid +
            ", wrkplnexeid=" + wrkplnexeid +
            ", ditchno=" + ditchno +
            ", dtlexpectdate=" + dtlexpectdate +
            ", lstid=" + lstid +
            ", lstopcode=" + lstopcode +
            ", lstname=" + lstname +
            ", prepayid=" + prepayid +
            ", ysucondtlid=" + ysucondtlid +
            ", obapplyid=" + obapplyid +
            ", obqty=" + obqty +
            ", modifydate=" + modifydate +
            ", modifyman=" + modifyman +
            ", lstid0=" + lstid0 +
            ", dtlexpectdateperiod=" + dtlexpectdateperiod +
            ", realrgcompany=" + realrgcompany +
            ", wtpsDtlid=" + wtpsDtlid +
            ", releasetime=" + releasetime +
            ", prergtime=" + prergtime +
            ", dtltransno=" + dtltransno +
            ", dtltransnomodifydate=" + dtltransnomodifydate +
            ", dtltransnomodifyman=" + dtltransnomodifyman +
            ", actualcomqty=" + actualcomqty +
            ", dtlsecexpectdate=" + dtlsecexpectdate +
            ", dtlsecexpectdateperiod=" + dtlsecexpectdateperiod +
            ", dhts=" + dhts +
            ", goodsdtlid=" + goodsdtlid +
            ", solution=" + solution +
            ", bomname=" + bomname +
            ", importflag=" + importflag +
            ", checkflag=" + checkflag +
        "}";
    }
}
