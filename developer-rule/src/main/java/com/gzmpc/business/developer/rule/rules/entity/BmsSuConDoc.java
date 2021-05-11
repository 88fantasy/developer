package com.gzmpc.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 进货合同总单表
 * </p>
 *
 * @author yjf
 * @since 2021-05-11
 */
public class BmsSuConDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 进货合同总单标识号
     */
    @TableId("SUCONID")
    private Long suconid;

    /**
     * 合同号
     */
    @TableField("SUCONNO")
    private String suconno;

    /**
     * 签约日
     */
    @TableField("SIGNDATE")
    private Date signdate;

    /**
     * 签约地
     */
    @TableField("SIGNADDRESS")
    private String signaddress;

    /**
     * 有效期开始日期
     */
    @TableField("VALIDBEGDATE")
    private Date validbegdate;

    /**
     * 有效期结束日期
     */
    @TableField("VALIDENDDATE")
    private Date validenddate;

    /**
     * 供应商标识号
     */
    @TableField("SUPPLYID")
    private Long supplyid;

    /**
     * 供应商名称
     */
    @TableField("SUPPLYNAME")
    private String supplyname;

    /**
     * 合计金额(含税不含其他费用)
     */
    @TableField("TOTAL")
    private BigDecimal total;

    /**
     * 录入员标识号
     */
    @TableField("INPUTMANID")
    private Long inputmanid;

    /**
     * 其他费用
     */
    @TableField("OTHERMONEY")
    private BigDecimal othermoney;

    /**
     * 合同类型，公共字典表PUB_DDL(SUCON_TYPE_NEW)
     */
    @TableField("CONTRACTTYPE")
    private Integer contracttype;

    /**
     * 备注
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 运输方式，公共字典表PUB_DDL(BMS_TRANSPORT_METHOD)
     */
    @TableField("TRANMETHOD")
    private Integer tranmethod;

    /**
     * 代理方式 0:经销1:代销，系统字典表SYS_DDL(SYS_AGTFLAG)
     */
    @TableField("AGENTFLAG")
    private Integer agentflag;

    /**
     * 承付模式由Bms_su_paymode_def定义表确定。
     */
    @TableField("PAYMODE")
    private Integer paymode;

    /**
     * 完成日期
     */
    @TableField("FINDATE")
    private Date findate;

    /**
     * 结算方式 详见PUB_SETTLETYPE_DDL字典表
     */
    @TableField("SETTLETYPEID")
    private Integer settletypeid;

    /**
     * 预付款
     */
    @TableField("PREPAY")
    private BigDecimal prepay;

    /**
     * 交接方式，系统字典表SYS_DDL(BMS_SWITHMODE)
     */
    @TableField("SWITCHMODE")
    private Integer switchmode;

    /**
     * 提货地点
     */
    @TableField("PICKADDRESS")
    private String pickaddress;

    /**
     * 运费自负担比例
     */
    @TableField("TRANCOSTRATE")
    private BigDecimal trancostrate;

    /**
     * 细目笔数
     */
    @TableField("DTL_LINES")
    private Integer dtlLines;

    /**
     * 书面合同号
     */
    @TableField("PAPERNO")
    private String paperno;

    /**
     * 签约人姓名
     */
    @TableField("SIGNMAN")
    private String signman;

    /**
     * 运送地点标识号（可为空）
     */
    @TableField("DESTPOSID")
    private Long destposid;

    /**
     * 付款期天数
     */
    @TableField("PAYLIMIT")
    private Integer paylimit;

    /**
     * 累计预付款
     */
    @TableField("PREPAYACC")
    private BigDecimal prepayacc;

    /**
     * 进口合同标志：1-是，0-否
     */
    @TableField("IMPORTFLAG")
    private Integer importflag;

    /**
     * 核算单元ID
     */
    @TableField("ENTRYID")
    private Long entryid;

    /**
     * 外币ID
     */
    @TableField("FMID")
    private Long fmid;

    /**
     * 记录原合同类型
     */
    @TableField("ZXCOLUMN1")
    private String zxcolumn1;

    /**
     * 记录文件生成进货合同的文件名
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
     * 专项字段
     */
    @TableField("ZXCOLUMN8")
    private String zxcolumn8;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN9")
    private String zxcolumn9;

    /**
     * 专项字段
     */
    @TableField("ZXCOLUMN10")
    private String zxcolumn10;

    /**
     * 来源类型
     */
    @TableField("SOURCETYPE")
    private Integer sourcetype;

    /**
     * 目标单位ID
     */
    @TableField("TOCOMPANYID")
    private Long tocompanyid;

    /**
     * 汇率
     */
    @TableField("EXCHANGE")
    private BigDecimal exchange;

    /**
     * 发货方式：0-
     */
    @TableField("DELIVERMETHOD")
    private Integer delivermethod;

    /**
     * 目的地
     */
    @TableField("TARGETPOSNAME")
    private String targetposname;

    /**
     * 目的地标识号
     */
    @TableField("TARGETPOSID")
    private Long targetposid;

    /**
     * SCM订单要求送达日期
     */
    @TableField("SCM_TARGETDATE")
    private Date scmTargetdate;

    /**
     * 统一供应商ID
     */
    @TableField("UVENDERID")
    private Long uvenderid;

    /**
     * 1-增值税发票 2-普通发票
     */
    @TableField("INVTYPE")
    private Integer invtype;

    /**
     * 单据确定标志
     */
    @TableField("CONFIRMFLAG")
    private Integer confirmflag;

    /**
     * SCM订单释放标志
     */
    @TableField("SCMRELEASEFLAG")
    private Integer scmreleaseflag;

    /**
     * SCM订单标志
     */
    @TableField("SCMFLAG")
    private Integer scmflag;

    /**
     * 专项字段
     */
    @TableField("IFROCANCEL")
    private Integer ifrocancel;

    /**
     * 站点ID
     */
    @TableField("STAGEID")
    private Long stageid;

    /**
     * 统一客户ID
     */
    @TableField("UCUSTOMERID")
    private Long ucustomerid;

    /**
     * 取货地点ID
     */
    @TableField("GETGOODSPOSID")
    private Long getgoodsposid;

    /**
     * 取货地点日期
     */
    @TableField("GETGOODSDATE")
    private Date getgoodsdate;

    /**
     * 纸面合同
     */
    @TableField("PAPERCON")
    private Integer papercon;

    /**
     * 结算提示
     */
    @TableField("SETTLEMSG")
    private String settlemsg;

    /**
     * 仓房ID
     */
    @TableField("WAREHOUSEID")
    private Long warehouseid;

    /**
     * 证照超效期标志
     */
    @TableField("LICENSEINVALIDFLAG")
    private Integer licenseinvalidflag;

    /**
     * 报告书附送方式
     */
    @TableField("REPORT_TRANSTYPE")
    private Integer reportTranstype;

    /**
     * 无报告书是否拒收
     */
    @TableField("REFUSERGFLAG")
    private Integer refusergflag;

    /**
     * 预计到货日期
     */
    @TableField("EXPECTDATE")
    private Date expectdate;

    /**
     * 有来货明细信息标志
     */
    @TableField("LOTMSGFLAG")
    private Integer lotmsgflag;

    /**
     * 预付付款单ID
     */
    @TableField("PREPAYID")
    private Long prepayid;

    /**
     * 归档标志
     */
    @TableField("FILEFLAG")
    private Integer fileflag;

    /**
     * 归档人ID
     */
    @TableField("FILEMANID")
    private Long filemanid;

    /**
     * 归档日期
     */
    @TableField("FILEDATE")
    private Date filedate;

    /**
     * 打印号
     */
    @TableField("PRINTNO")
    private String printno;

    /**
     * 打印日期
     */
    @TableField("PRINTDATE")
    private Date printdate;

    /**
     * 最近打印日期
     */
    @TableField("LASTPRTDATE")
    private Date lastprtdate;

    /**
     * 修改时间
     */
    @TableField("MODIFYDATE")
    private Date modifydate;

    /**
     * 修改人
     */
    @TableField("MODIFYMAN")
    private BigDecimal modifyman;

    /**
     * 进货合同总单预约时间段
     */
    @TableField("EXPECTDATEPERIOD")
    private Integer expectdateperiod;

    /**
     * 运单号
     */
    @TableField("TRANSNO")
    private String transno;

    /**
     * 运单号修改时间
     */
    @TableField("TRANSNOMODIFYDATE")
    private Date transnomodifydate;

    /**
     * 运单号修改人
     */
    @TableField("TRANSNOMODIFYMAN")
    private BigDecimal transnomodifyman;

    /**
     * 预付申请单ID
     */
    @TableField("REPAYAPPLYID")
    private Long repayapplyid;

    /**
     * 机会销售字段
     */
    @TableField("OPPORTUNITY")
    private Integer opportunity;

    /**
     * 样品合同类型
     */
    @TableField("TEXTCONTYPE")
    private Integer textcontype;

    /**
     * 通关单号
     */
    @TableField("CLEARANCENO")
    private String clearanceno;

    /**
     * 运输容器号
     */
    @TableField("CONTAINERNO")
    private String containerno;

    /**
     * 订单类型
     */
    @TableField("ORDER_TYPE")
    private Integer orderType;

    /**
     * 两票制标识
     */
    @TableField("TWOTICKFLAG")
    private Integer twotickflag;

    /**
     * 预售活动ID
     */
    @TableField("PRESALESID")
    private String presalesid;

    /**
     * 套装ID
     */
    @TableField("BOMID")
    private Long bomid;

    /**
     * 套装含收货通知单条数
     */
    @TableField("BOMDTLCNT")
    private Integer bomdtlcnt;

    public Long getSuconid() {
        return suconid;
    }

    public void setSuconid(Long suconid) {
        this.suconid = suconid;
    }
    public String getSuconno() {
        return suconno;
    }

    public void setSuconno(String suconno) {
        this.suconno = suconno;
    }
    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }
    public String getSignaddress() {
        return signaddress;
    }

    public void setSignaddress(String signaddress) {
        this.signaddress = signaddress;
    }
    public Date getValidbegdate() {
        return validbegdate;
    }

    public void setValidbegdate(Date validbegdate) {
        this.validbegdate = validbegdate;
    }
    public Date getValidenddate() {
        return validenddate;
    }

    public void setValidenddate(Date validenddate) {
        this.validenddate = validenddate;
    }
    public Long getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(Long supplyid) {
        this.supplyid = supplyid;
    }
    public String getSupplyname() {
        return supplyname;
    }

    public void setSupplyname(String supplyname) {
        this.supplyname = supplyname;
    }
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Long getInputmanid() {
        return inputmanid;
    }

    public void setInputmanid(Long inputmanid) {
        this.inputmanid = inputmanid;
    }
    public BigDecimal getOthermoney() {
        return othermoney;
    }

    public void setOthermoney(BigDecimal othermoney) {
        this.othermoney = othermoney;
    }
    public Integer getContracttype() {
        return contracttype;
    }

    public void setContracttype(Integer contracttype) {
        this.contracttype = contracttype;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Integer getTranmethod() {
        return tranmethod;
    }

    public void setTranmethod(Integer tranmethod) {
        this.tranmethod = tranmethod;
    }
    public Integer getAgentflag() {
        return agentflag;
    }

    public void setAgentflag(Integer agentflag) {
        this.agentflag = agentflag;
    }
    public Integer getPaymode() {
        return paymode;
    }

    public void setPaymode(Integer paymode) {
        this.paymode = paymode;
    }
    public Date getFindate() {
        return findate;
    }

    public void setFindate(Date findate) {
        this.findate = findate;
    }
    public Integer getSettletypeid() {
        return settletypeid;
    }

    public void setSettletypeid(Integer settletypeid) {
        this.settletypeid = settletypeid;
    }
    public BigDecimal getPrepay() {
        return prepay;
    }

    public void setPrepay(BigDecimal prepay) {
        this.prepay = prepay;
    }
    public Integer getSwitchmode() {
        return switchmode;
    }

    public void setSwitchmode(Integer switchmode) {
        this.switchmode = switchmode;
    }
    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress;
    }
    public BigDecimal getTrancostrate() {
        return trancostrate;
    }

    public void setTrancostrate(BigDecimal trancostrate) {
        this.trancostrate = trancostrate;
    }
    public Integer getDtlLines() {
        return dtlLines;
    }

    public void setDtlLines(Integer dtlLines) {
        this.dtlLines = dtlLines;
    }
    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }
    public String getSignman() {
        return signman;
    }

    public void setSignman(String signman) {
        this.signman = signman;
    }
    public Long getDestposid() {
        return destposid;
    }

    public void setDestposid(Long destposid) {
        this.destposid = destposid;
    }
    public Integer getPaylimit() {
        return paylimit;
    }

    public void setPaylimit(Integer paylimit) {
        this.paylimit = paylimit;
    }
    public BigDecimal getPrepayacc() {
        return prepayacc;
    }

    public void setPrepayacc(BigDecimal prepayacc) {
        this.prepayacc = prepayacc;
    }
    public Integer getImportflag() {
        return importflag;
    }

    public void setImportflag(Integer importflag) {
        this.importflag = importflag;
    }
    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }
    public Long getFmid() {
        return fmid;
    }

    public void setFmid(Long fmid) {
        this.fmid = fmid;
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
    public Integer getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
    }
    public Long getTocompanyid() {
        return tocompanyid;
    }

    public void setTocompanyid(Long tocompanyid) {
        this.tocompanyid = tocompanyid;
    }
    public BigDecimal getExchange() {
        return exchange;
    }

    public void setExchange(BigDecimal exchange) {
        this.exchange = exchange;
    }
    public Integer getDelivermethod() {
        return delivermethod;
    }

    public void setDelivermethod(Integer delivermethod) {
        this.delivermethod = delivermethod;
    }
    public String getTargetposname() {
        return targetposname;
    }

    public void setTargetposname(String targetposname) {
        this.targetposname = targetposname;
    }
    public Long getTargetposid() {
        return targetposid;
    }

    public void setTargetposid(Long targetposid) {
        this.targetposid = targetposid;
    }
    public Date getScmTargetdate() {
        return scmTargetdate;
    }

    public void setScmTargetdate(Date scmTargetdate) {
        this.scmTargetdate = scmTargetdate;
    }
    public Long getUvenderid() {
        return uvenderid;
    }

    public void setUvenderid(Long uvenderid) {
        this.uvenderid = uvenderid;
    }
    public Integer getInvtype() {
        return invtype;
    }

    public void setInvtype(Integer invtype) {
        this.invtype = invtype;
    }
    public Integer getConfirmflag() {
        return confirmflag;
    }

    public void setConfirmflag(Integer confirmflag) {
        this.confirmflag = confirmflag;
    }
    public Integer getScmreleaseflag() {
        return scmreleaseflag;
    }

    public void setScmreleaseflag(Integer scmreleaseflag) {
        this.scmreleaseflag = scmreleaseflag;
    }
    public Integer getScmflag() {
        return scmflag;
    }

    public void setScmflag(Integer scmflag) {
        this.scmflag = scmflag;
    }
    public Integer getIfrocancel() {
        return ifrocancel;
    }

    public void setIfrocancel(Integer ifrocancel) {
        this.ifrocancel = ifrocancel;
    }
    public Long getStageid() {
        return stageid;
    }

    public void setStageid(Long stageid) {
        this.stageid = stageid;
    }
    public Long getUcustomerid() {
        return ucustomerid;
    }

    public void setUcustomerid(Long ucustomerid) {
        this.ucustomerid = ucustomerid;
    }
    public Long getGetgoodsposid() {
        return getgoodsposid;
    }

    public void setGetgoodsposid(Long getgoodsposid) {
        this.getgoodsposid = getgoodsposid;
    }
    public Date getGetgoodsdate() {
        return getgoodsdate;
    }

    public void setGetgoodsdate(Date getgoodsdate) {
        this.getgoodsdate = getgoodsdate;
    }
    public Integer getPapercon() {
        return papercon;
    }

    public void setPapercon(Integer papercon) {
        this.papercon = papercon;
    }
    public String getSettlemsg() {
        return settlemsg;
    }

    public void setSettlemsg(String settlemsg) {
        this.settlemsg = settlemsg;
    }
    public Long getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Long warehouseid) {
        this.warehouseid = warehouseid;
    }
    public Integer getLicenseinvalidflag() {
        return licenseinvalidflag;
    }

    public void setLicenseinvalidflag(Integer licenseinvalidflag) {
        this.licenseinvalidflag = licenseinvalidflag;
    }
    public Integer getReportTranstype() {
        return reportTranstype;
    }

    public void setReportTranstype(Integer reportTranstype) {
        this.reportTranstype = reportTranstype;
    }
    public Integer getRefusergflag() {
        return refusergflag;
    }

    public void setRefusergflag(Integer refusergflag) {
        this.refusergflag = refusergflag;
    }
    public Date getExpectdate() {
        return expectdate;
    }

    public void setExpectdate(Date expectdate) {
        this.expectdate = expectdate;
    }
    public Integer getLotmsgflag() {
        return lotmsgflag;
    }

    public void setLotmsgflag(Integer lotmsgflag) {
        this.lotmsgflag = lotmsgflag;
    }
    public Long getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(Long prepayid) {
        this.prepayid = prepayid;
    }
    public Integer getFileflag() {
        return fileflag;
    }

    public void setFileflag(Integer fileflag) {
        this.fileflag = fileflag;
    }
    public Long getFilemanid() {
        return filemanid;
    }

    public void setFilemanid(Long filemanid) {
        this.filemanid = filemanid;
    }
    public Date getFiledate() {
        return filedate;
    }

    public void setFiledate(Date filedate) {
        this.filedate = filedate;
    }
    public String getPrintno() {
        return printno;
    }

    public void setPrintno(String printno) {
        this.printno = printno;
    }
    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }
    public Date getLastprtdate() {
        return lastprtdate;
    }

    public void setLastprtdate(Date lastprtdate) {
        this.lastprtdate = lastprtdate;
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
    public Integer getExpectdateperiod() {
        return expectdateperiod;
    }

    public void setExpectdateperiod(Integer expectdateperiod) {
        this.expectdateperiod = expectdateperiod;
    }
    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno;
    }
    public Date getTransnomodifydate() {
        return transnomodifydate;
    }

    public void setTransnomodifydate(Date transnomodifydate) {
        this.transnomodifydate = transnomodifydate;
    }
    public BigDecimal getTransnomodifyman() {
        return transnomodifyman;
    }

    public void setTransnomodifyman(BigDecimal transnomodifyman) {
        this.transnomodifyman = transnomodifyman;
    }
    public Long getRepayapplyid() {
        return repayapplyid;
    }

    public void setRepayapplyid(Long repayapplyid) {
        this.repayapplyid = repayapplyid;
    }
    public Integer getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Integer opportunity) {
        this.opportunity = opportunity;
    }
    public Integer getTextcontype() {
        return textcontype;
    }

    public void setTextcontype(Integer textcontype) {
        this.textcontype = textcontype;
    }
    public String getClearanceno() {
        return clearanceno;
    }

    public void setClearanceno(String clearanceno) {
        this.clearanceno = clearanceno;
    }
    public String getContainerno() {
        return containerno;
    }

    public void setContainerno(String containerno) {
        this.containerno = containerno;
    }
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    public Integer getTwotickflag() {
        return twotickflag;
    }

    public void setTwotickflag(Integer twotickflag) {
        this.twotickflag = twotickflag;
    }
    public String getPresalesid() {
        return presalesid;
    }

    public void setPresalesid(String presalesid) {
        this.presalesid = presalesid;
    }
    public Long getBomid() {
        return bomid;
    }

    public void setBomid(Long bomid) {
        this.bomid = bomid;
    }
    public Integer getBomdtlcnt() {
        return bomdtlcnt;
    }

    public void setBomdtlcnt(Integer bomdtlcnt) {
        this.bomdtlcnt = bomdtlcnt;
    }

    @Override
    public String toString() {
        return "BmsSuConDoc{" +
            "suconid=" + suconid +
            ", suconno=" + suconno +
            ", signdate=" + signdate +
            ", signaddress=" + signaddress +
            ", validbegdate=" + validbegdate +
            ", validenddate=" + validenddate +
            ", supplyid=" + supplyid +
            ", supplyname=" + supplyname +
            ", total=" + total +
            ", inputmanid=" + inputmanid +
            ", othermoney=" + othermoney +
            ", contracttype=" + contracttype +
            ", memo=" + memo +
            ", tranmethod=" + tranmethod +
            ", agentflag=" + agentflag +
            ", paymode=" + paymode +
            ", findate=" + findate +
            ", settletypeid=" + settletypeid +
            ", prepay=" + prepay +
            ", switchmode=" + switchmode +
            ", pickaddress=" + pickaddress +
            ", trancostrate=" + trancostrate +
            ", dtlLines=" + dtlLines +
            ", paperno=" + paperno +
            ", signman=" + signman +
            ", destposid=" + destposid +
            ", paylimit=" + paylimit +
            ", prepayacc=" + prepayacc +
            ", importflag=" + importflag +
            ", entryid=" + entryid +
            ", fmid=" + fmid +
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
            ", sourcetype=" + sourcetype +
            ", tocompanyid=" + tocompanyid +
            ", exchange=" + exchange +
            ", delivermethod=" + delivermethod +
            ", targetposname=" + targetposname +
            ", targetposid=" + targetposid +
            ", scmTargetdate=" + scmTargetdate +
            ", uvenderid=" + uvenderid +
            ", invtype=" + invtype +
            ", confirmflag=" + confirmflag +
            ", scmreleaseflag=" + scmreleaseflag +
            ", scmflag=" + scmflag +
            ", ifrocancel=" + ifrocancel +
            ", stageid=" + stageid +
            ", ucustomerid=" + ucustomerid +
            ", getgoodsposid=" + getgoodsposid +
            ", getgoodsdate=" + getgoodsdate +
            ", papercon=" + papercon +
            ", settlemsg=" + settlemsg +
            ", warehouseid=" + warehouseid +
            ", licenseinvalidflag=" + licenseinvalidflag +
            ", reportTranstype=" + reportTranstype +
            ", refusergflag=" + refusergflag +
            ", expectdate=" + expectdate +
            ", lotmsgflag=" + lotmsgflag +
            ", prepayid=" + prepayid +
            ", fileflag=" + fileflag +
            ", filemanid=" + filemanid +
            ", filedate=" + filedate +
            ", printno=" + printno +
            ", printdate=" + printdate +
            ", lastprtdate=" + lastprtdate +
            ", modifydate=" + modifydate +
            ", modifyman=" + modifyman +
            ", expectdateperiod=" + expectdateperiod +
            ", transno=" + transno +
            ", transnomodifydate=" + transnomodifydate +
            ", transnomodifyman=" + transnomodifyman +
            ", repayapplyid=" + repayapplyid +
            ", opportunity=" + opportunity +
            ", textcontype=" + textcontype +
            ", clearanceno=" + clearanceno +
            ", containerno=" + containerno +
            ", orderType=" + orderType +
            ", twotickflag=" + twotickflag +
            ", presalesid=" + presalesid +
            ", bomid=" + bomid +
            ", bomdtlcnt=" + bomdtlcnt +
        "}";
    }
}
