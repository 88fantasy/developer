package com.gzmpc.business.developer.rule.rules.entity;

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
public class ZxBmsSuConYearDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("YSUCONID")
    private Long ysuconid;

    @TableField("CREDATE")
    private Date credate;

    @TableField("SUPPLYID")
    private Long supplyid;

    @TableField("BEGINDATE")
    private Date begindate;

    @TableField("ENDDATE")
    private Date enddate;

    @TableField("PAPERNO")
    private String paperno;

    @TableField("CONVERTYPE")
    private Long convertype;

    @TableField("MEMO")
    private String memo;

    @TableField("INPUTMANID")
    private Long inputmanid;

    @TableField("FILEMANID")
    private Long filemanid;

    @TableField("FILEDATE")
    private Date filedate;

    @TableField("FILEFLAG")
    private Integer fileflag;

    @TableField("PRINTNO")
    private String printno;

    @TableField("DOCUSESTATUS")
    private Integer docusestatus;

    @TableField("DOCINVALIDMANID")
    private Long docinvalidmanid;

    @TableField("DOCINVALIDDATE")
    private Date docinvaliddate;

    @TableField("PRINTDATE")
    private Date printdate;

    @TableField("LASTPRTDATE")
    private Date lastprtdate;

    @TableField("SUCONMANNAME")
    private String suconmanname;

    @TableField("SUCONCONTRACTWAY")
    private String suconcontractway;

    @TableField("SUCONMANIDNO")
    private String suconmanidno;

    @TableField("SETTLETYPEID")
    private Integer settletypeid;

    @TableField("TRANMETHOD")
    private Integer tranmethod;

    @TableField("PAYLIMIT")
    private String paylimit;

    @TableField("TOTAL")
    private BigDecimal total;

    @TableField("DTL_LINES")
    private Long dtlLines;

    @TableField("ADRESS1")
    private String adress1;

    @TableField("ADRESS2")
    private String adress2;

    @TableField("POSTNO")
    private String postno;

    @TableField("SIGNDATE")
    private Date signdate;

    /**
     * 取消归档标志人ID
     */
    @TableField("CFILEFLAGMANID")
    private Long cfileflagmanid;

    /**
     * 取消归档标志日期
     */
    @TableField("CFILEFLAGDATE")
    private Date cfileflagdate;

    /**
     * 取消归档标志原因
     */
    @TableField("CFILEFLAGMEMO")
    private String cfileflagmemo;

    /**
     * 医院毛利率
     */
    @TableField("YYGROSSPROFIT")
    private BigDecimal yygrossprofit;

    /**
     * 返利支付期限（1：立即 2：月  3 ：季度 4：半年 5：年度）
     */
    @TableField("ZXCOLUMN1")
    private Integer zxcolumn1;

    /**
     * 返利支付方式（1.票面 2.折让证明（供应商红字发票）3.现金 4.样品）
     */
    @TableField("ZXCOLUMN2")
    private Integer zxcolumn2;

    /**
     * 甲方发票提供方式（1：甲方直接交与乙方采购中心人员 2：甲方邮寄乙方指定地址）
     */
    @TableField("ZXCOLUMN3")
    private Integer zxcolumn3;

    /**
     * 采购清单（1：全品种 2：见附件产品列表及产品作价政策）
     */
    @TableField("ZXCOLUMN4")
    private Integer zxcolumn4;

    /**
     * 付款的到期日期为(1：甲方到帐日期 2：乙方付款日期)
     */
    @TableField("ZXCOLUMN5")
    private Integer zxcolumn5;

    /**
     * 节假日付款顺延(1：是 0：否)
     */
    @TableField("ZXCOLUMN6")
    private Integer zxcolumn6;

    /**
     * 滞销过期产品解决方案（1：乙方可自行退回或销毁    2：乙方需获得甲方同意后方可退回销毁）
     */
    @TableField("ZXCOLUMN7")
    private Integer zxcolumn7;

    /**
     * 付款方式（1：承兑汇票 2：电汇）
     */
    @TableField("ZXCOLUMN8")
    private Integer zxcolumn8;

    /**
     * 付款方式为承兑汇票时的天数
     */
    @TableField("ZXCOLUMN9")
    private Integer zxcolumn9;

    /**
     * 付款条件(1：货到付款 2：售完30%，且到货后超过30天 3：售完1.5倍，且到货大于45天)
     */
    @TableField("ZXCOLUMN10")
    private Integer zxcolumn10;

    /**
     * 付款条件为货到付款时设置的天数
     */
    @TableField("ZXCOLUMN11")
    private Integer zxcolumn11;

    /**
     * 货到多少个月内发现的原箱短少，由（甲方承担、乙方承担、双方商议后共同承担）
     */
    @TableField("ZXCOLUMN12")
    private Integer zxcolumn12;

    /**
     * 1：甲方承担 2：乙方承担 3 ：双方商议后共同承担
     */
    @TableField("ZXCOLUMN13")
    private Integer zxcolumn13;

    /**
     * (来货不合格影响付款的处理方法，甲乙双方同意选择解决方案)2：乙方每次均应将不合格货品退回甲方，在甲方补齐货品后再作付款结算 1：乙方先作入库处理 3;乙方全退当批货品
     */
    @TableField("ZXCOLUMN14")
    private Integer zxcolumn14;

    /**
     * (来货不合格影响付款的处理方法，甲乙双方同意选择解决方案)月数
     */
    @TableField("ZXCOLUMN15")
    private Integer zxcolumn15;

    /**
     * （来货不合格影响付款的处理方法，甲乙双方同意选择解决方案）天数
     */
    @TableField("ZXCOLUMN16")
    private Integer zxcolumn16;

    /**
     * （退货或销毁费用支付方式）1：甲方同意乙方不再支付有关滞销过期货物货款 2：甲方必须在收到乙方的退货或销毁通知后，需1个月内支付退货货款
     */
    @TableField("ZXCOLUMN17")
    private Integer zxcolumn17;

    /**
     * （退货或销毁费用由）1：甲方承担  2：乙方承担 3：双方商议后共同承担
     */
    @TableField("ZXCOLUMN18")
    private Integer zxcolumn18;

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
     * 重复标志
     */
    @TableField("REPEATFLAG")
    private Integer repeatflag;

    @TableField("SUCONSTATUS")
    private Integer suconstatus;

    @TableField("SUCONCFMMANID")
    private Long suconcfmmanid;

    @TableField("SUCONCFMMANNAME")
    private String suconcfmmanname;

    @TableField("SUCONCFMDATE")
    private Date suconcfmdate;

    @TableField("SUCONCFMMEMO")
    private String suconcfmmemo;

    @TableField("RECEIVENO")
    private String receiveno;

    @TableField("RECEIVEMEMO")
    private String receivememo;

    @TableField("TEMPBEGINDATE")
    private Date tempbegindate;

    @TableField("TEMPENDDATE")
    private Date tempenddate;

    @TableField("RECEIVEMANNAME")
    private String receivemanname;

    @TableField("RECEIVEDATE")
    private Date receivedate;

    @TableField("ORGRECEIDATE")
    private Date orgreceidate;

    @TableField("ZXCOLUMN19")
    private String zxcolumn19;

    @TableField("ZXCOLUMN20")
    private Long zxcolumn20;

    @TableField("ZXCOLUMN21")
    private Long zxcolumn21;

    @TableField("ZXCOLUMN22")
    private Long zxcolumn22;

    @TableField("ZXCOLUMN23")
    private Long zxcolumn23;

    @TableField("ZXCOLUMN24")
    private Long zxcolumn24;

    @TableField("ZXCOLUMN25")
    private Long zxcolumn25;

    @TableField("ZXCOLUMN26")
    private Long zxcolumn26;

    @TableField("ZXCOLUMN27")
    private BigDecimal zxcolumn27;

    @TableField("ZXCOLUMN28")
    private BigDecimal zxcolumn28;

    @TableField("ZXCOLUMN29")
    private Long zxcolumn29;

    @TableField("ZXCOLUMN30")
    private Long zxcolumn30;

    @TableField("ZXCOLUMN31")
    private Long zxcolumn31;

    @TableField("ZXCOLUMN32")
    private Long zxcolumn32;

    @TableField("ZXCOLUMN33")
    private String zxcolumn33;

    @TableField("ZXCOLUMN34")
    private BigDecimal zxcolumn34;

    @TableField("ZXCOLUMN35")
    private BigDecimal zxcolumn35;

    @TableField("ZXCOLUMN36")
    private BigDecimal zxcolumn36;

    @TableField("ZXCOLUMN37")
    private BigDecimal zxcolumn37;

    @TableField("ZXCOLUMN38")
    private BigDecimal zxcolumn38;

    @TableField("ZXCOLUMN39")
    private BigDecimal zxcolumn39;

    @TableField("ZXCOLUMN40")
    private BigDecimal zxcolumn40;

    @TableField("ZXCOLUMN41")
    private BigDecimal zxcolumn41;

    @TableField("ZXCOLUMN42")
    private BigDecimal zxcolumn42;

    @TableField("ZXCOLUMN43")
    private BigDecimal zxcolumn43;

    @TableField("ZXCOLUMN44")
    private BigDecimal zxcolumn44;

    @TableField("ZXCOLUMN45")
    private BigDecimal zxcolumn45;

    @TableField("ZXCOLUMN46")
    private BigDecimal zxcolumn46;

    @TableField("ZXCOLUMN47")
    private BigDecimal zxcolumn47;

    @TableField("ZXCOLUMN48")
    private BigDecimal zxcolumn48;

    @TableField("ZXCOLUMN49")
    private BigDecimal zxcolumn49;

    @TableField("ZXCOLUMN50")
    private BigDecimal zxcolumn50;

    @TableField("ZXCOLUMN51")
    private BigDecimal zxcolumn51;

    @TableField("ZXCOLUMN52")
    private BigDecimal zxcolumn52;

    @TableField("ZXCOLUMN53")
    private BigDecimal zxcolumn53;

    @TableField("ZXCOLUMN54")
    private BigDecimal zxcolumn54;

    @TableField("ZXCOLUMN55")
    private BigDecimal zxcolumn55;

    @TableField("ZXCOLUMN56")
    private BigDecimal zxcolumn56;

    @TableField("ZXCOLUMN57")
    private BigDecimal zxcolumn57;

    @TableField("ZXCOLUMN58")
    private BigDecimal zxcolumn58;

    @TableField("ZXCOLUMN59")
    private BigDecimal zxcolumn59;

    @TableField("ZXCOLUMN60")
    private BigDecimal zxcolumn60;

    @TableField("ZXCOLUMN61")
    private BigDecimal zxcolumn61;

    @TableField("ZXCOLUMN62")
    private Integer zxcolumn62;

    @TableField("ZXCOLUMN63")
    private BigDecimal zxcolumn63;

    @TableField("ZXCOLUMN64")
    private String zxcolumn64;

    @TableField("ZXCOLUMN65")
    private BigDecimal zxcolumn65;

    @TableField("ZXCOLUMN66")
    private Integer zxcolumn66;

    @TableField("ZXCOLUMN67")
    private Integer zxcolumn67;

    @TableField("ZXCOLUMN68")
    private Long zxcolumn68;

    @TableField("ZXCOLUMN69")
    private Long zxcolumn69;

    @TableField("CARDNO")
    private String cardno;

    /**
     * 预付款收货期限
     */
    @TableField("RECEIVELIMIT")
    private Integer receivelimit;

    /**
     * 商业分销(全国)，默认4%
     */
    @TableField("ZXCOLUMN70")
    private BigDecimal zxcolumn70;

    /**
     * 商业分销(全广东省内)，默认2%
     */
    @TableField("ZXCOLUMN71")
    private BigDecimal zxcolumn71;

    /**
     * 选择货到日或月
     */
    @TableField("ZXCOLUMN72")
    private Integer zxcolumn72;

    /**
     * 医械：付款条件(1：货到付款 2：售完50%，且到货后超过45天 3：售完，且收货合格后 4：自乙方客户（医院）收取乙方发票之日起一定日期内 5：预付款)
     */
    @TableField("ZXCOLUMN73")
    private Integer zxcolumn73;

    /**
     * 医械：付款条件为：售完，且收货合格后 时设置的天数
     */
    @TableField("ZXCOLUMN74")
    private Long zxcolumn74;

    /**
     * 医械：付款条件为：自乙方客户（医院）收取乙方发票之日起一定日期内 时设置收取乙方发票天数
     */
    @TableField("ZXCOLUMN75")
    private Long zxcolumn75;

    /**
     * 医械：付款条件为：自乙方客户（医院）收取乙方发票之日起一定日期内 时设置且不得短于乙方发票开具天数
     */
    @TableField("ZXCOLUMN76")
    private Long zxcolumn76;

    /**
     * 医械：付款条件为：付款条件为货到付款时设置的天数
     */
    @TableField("ZXCOLUMN77")
    private Long zxcolumn77;

    /**
     * 医械：付款条件为：预付款收货期限
     */
    @TableField("ZXCOLUMN78")
    private Long zxcolumn78;

    /**
     * 医械：付款条件为：预付款超出天数
     */
    @TableField("ZXCOLUMN79")
    private Long zxcolumn79;

    /**
     * 医械：付款条件为：预付款乙方书面通知解除天数
     */
    @TableField("ZXCOLUMN80")
    private Long zxcolumn80;

    public Long getYsuconid() {
        return ysuconid;
    }

    public void setYsuconid(Long ysuconid) {
        this.ysuconid = ysuconid;
    }
    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }
    public Long getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(Long supplyid) {
        this.supplyid = supplyid;
    }
    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }
    public Long getConvertype() {
        return convertype;
    }

    public void setConvertype(Long convertype) {
        this.convertype = convertype;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Long getInputmanid() {
        return inputmanid;
    }

    public void setInputmanid(Long inputmanid) {
        this.inputmanid = inputmanid;
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
    public Integer getFileflag() {
        return fileflag;
    }

    public void setFileflag(Integer fileflag) {
        this.fileflag = fileflag;
    }
    public String getPrintno() {
        return printno;
    }

    public void setPrintno(String printno) {
        this.printno = printno;
    }
    public Integer getDocusestatus() {
        return docusestatus;
    }

    public void setDocusestatus(Integer docusestatus) {
        this.docusestatus = docusestatus;
    }
    public Long getDocinvalidmanid() {
        return docinvalidmanid;
    }

    public void setDocinvalidmanid(Long docinvalidmanid) {
        this.docinvalidmanid = docinvalidmanid;
    }
    public Date getDocinvaliddate() {
        return docinvaliddate;
    }

    public void setDocinvaliddate(Date docinvaliddate) {
        this.docinvaliddate = docinvaliddate;
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
    public String getSuconmanname() {
        return suconmanname;
    }

    public void setSuconmanname(String suconmanname) {
        this.suconmanname = suconmanname;
    }
    public String getSuconcontractway() {
        return suconcontractway;
    }

    public void setSuconcontractway(String suconcontractway) {
        this.suconcontractway = suconcontractway;
    }
    public String getSuconmanidno() {
        return suconmanidno;
    }

    public void setSuconmanidno(String suconmanidno) {
        this.suconmanidno = suconmanidno;
    }
    public Integer getSettletypeid() {
        return settletypeid;
    }

    public void setSettletypeid(Integer settletypeid) {
        this.settletypeid = settletypeid;
    }
    public Integer getTranmethod() {
        return tranmethod;
    }

    public void setTranmethod(Integer tranmethod) {
        this.tranmethod = tranmethod;
    }
    public String getPaylimit() {
        return paylimit;
    }

    public void setPaylimit(String paylimit) {
        this.paylimit = paylimit;
    }
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Long getDtlLines() {
        return dtlLines;
    }

    public void setDtlLines(Long dtlLines) {
        this.dtlLines = dtlLines;
    }
    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }
    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }
    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }
    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }
    public Long getCfileflagmanid() {
        return cfileflagmanid;
    }

    public void setCfileflagmanid(Long cfileflagmanid) {
        this.cfileflagmanid = cfileflagmanid;
    }
    public Date getCfileflagdate() {
        return cfileflagdate;
    }

    public void setCfileflagdate(Date cfileflagdate) {
        this.cfileflagdate = cfileflagdate;
    }
    public String getCfileflagmemo() {
        return cfileflagmemo;
    }

    public void setCfileflagmemo(String cfileflagmemo) {
        this.cfileflagmemo = cfileflagmemo;
    }
    public BigDecimal getYygrossprofit() {
        return yygrossprofit;
    }

    public void setYygrossprofit(BigDecimal yygrossprofit) {
        this.yygrossprofit = yygrossprofit;
    }
    public Integer getZxcolumn1() {
        return zxcolumn1;
    }

    public void setZxcolumn1(Integer zxcolumn1) {
        this.zxcolumn1 = zxcolumn1;
    }
    public Integer getZxcolumn2() {
        return zxcolumn2;
    }

    public void setZxcolumn2(Integer zxcolumn2) {
        this.zxcolumn2 = zxcolumn2;
    }
    public Integer getZxcolumn3() {
        return zxcolumn3;
    }

    public void setZxcolumn3(Integer zxcolumn3) {
        this.zxcolumn3 = zxcolumn3;
    }
    public Integer getZxcolumn4() {
        return zxcolumn4;
    }

    public void setZxcolumn4(Integer zxcolumn4) {
        this.zxcolumn4 = zxcolumn4;
    }
    public Integer getZxcolumn5() {
        return zxcolumn5;
    }

    public void setZxcolumn5(Integer zxcolumn5) {
        this.zxcolumn5 = zxcolumn5;
    }
    public Integer getZxcolumn6() {
        return zxcolumn6;
    }

    public void setZxcolumn6(Integer zxcolumn6) {
        this.zxcolumn6 = zxcolumn6;
    }
    public Integer getZxcolumn7() {
        return zxcolumn7;
    }

    public void setZxcolumn7(Integer zxcolumn7) {
        this.zxcolumn7 = zxcolumn7;
    }
    public Integer getZxcolumn8() {
        return zxcolumn8;
    }

    public void setZxcolumn8(Integer zxcolumn8) {
        this.zxcolumn8 = zxcolumn8;
    }
    public Integer getZxcolumn9() {
        return zxcolumn9;
    }

    public void setZxcolumn9(Integer zxcolumn9) {
        this.zxcolumn9 = zxcolumn9;
    }
    public Integer getZxcolumn10() {
        return zxcolumn10;
    }

    public void setZxcolumn10(Integer zxcolumn10) {
        this.zxcolumn10 = zxcolumn10;
    }
    public Integer getZxcolumn11() {
        return zxcolumn11;
    }

    public void setZxcolumn11(Integer zxcolumn11) {
        this.zxcolumn11 = zxcolumn11;
    }
    public Integer getZxcolumn12() {
        return zxcolumn12;
    }

    public void setZxcolumn12(Integer zxcolumn12) {
        this.zxcolumn12 = zxcolumn12;
    }
    public Integer getZxcolumn13() {
        return zxcolumn13;
    }

    public void setZxcolumn13(Integer zxcolumn13) {
        this.zxcolumn13 = zxcolumn13;
    }
    public Integer getZxcolumn14() {
        return zxcolumn14;
    }

    public void setZxcolumn14(Integer zxcolumn14) {
        this.zxcolumn14 = zxcolumn14;
    }
    public Integer getZxcolumn15() {
        return zxcolumn15;
    }

    public void setZxcolumn15(Integer zxcolumn15) {
        this.zxcolumn15 = zxcolumn15;
    }
    public Integer getZxcolumn16() {
        return zxcolumn16;
    }

    public void setZxcolumn16(Integer zxcolumn16) {
        this.zxcolumn16 = zxcolumn16;
    }
    public Integer getZxcolumn17() {
        return zxcolumn17;
    }

    public void setZxcolumn17(Integer zxcolumn17) {
        this.zxcolumn17 = zxcolumn17;
    }
    public Integer getZxcolumn18() {
        return zxcolumn18;
    }

    public void setZxcolumn18(Integer zxcolumn18) {
        this.zxcolumn18 = zxcolumn18;
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
    public Integer getRepeatflag() {
        return repeatflag;
    }

    public void setRepeatflag(Integer repeatflag) {
        this.repeatflag = repeatflag;
    }
    public Integer getSuconstatus() {
        return suconstatus;
    }

    public void setSuconstatus(Integer suconstatus) {
        this.suconstatus = suconstatus;
    }
    public Long getSuconcfmmanid() {
        return suconcfmmanid;
    }

    public void setSuconcfmmanid(Long suconcfmmanid) {
        this.suconcfmmanid = suconcfmmanid;
    }
    public String getSuconcfmmanname() {
        return suconcfmmanname;
    }

    public void setSuconcfmmanname(String suconcfmmanname) {
        this.suconcfmmanname = suconcfmmanname;
    }
    public Date getSuconcfmdate() {
        return suconcfmdate;
    }

    public void setSuconcfmdate(Date suconcfmdate) {
        this.suconcfmdate = suconcfmdate;
    }
    public String getSuconcfmmemo() {
        return suconcfmmemo;
    }

    public void setSuconcfmmemo(String suconcfmmemo) {
        this.suconcfmmemo = suconcfmmemo;
    }
    public String getReceiveno() {
        return receiveno;
    }

    public void setReceiveno(String receiveno) {
        this.receiveno = receiveno;
    }
    public String getReceivememo() {
        return receivememo;
    }

    public void setReceivememo(String receivememo) {
        this.receivememo = receivememo;
    }
    public Date getTempbegindate() {
        return tempbegindate;
    }

    public void setTempbegindate(Date tempbegindate) {
        this.tempbegindate = tempbegindate;
    }
    public Date getTempenddate() {
        return tempenddate;
    }

    public void setTempenddate(Date tempenddate) {
        this.tempenddate = tempenddate;
    }
    public String getReceivemanname() {
        return receivemanname;
    }

    public void setReceivemanname(String receivemanname) {
        this.receivemanname = receivemanname;
    }
    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }
    public Date getOrgreceidate() {
        return orgreceidate;
    }

    public void setOrgreceidate(Date orgreceidate) {
        this.orgreceidate = orgreceidate;
    }
    public String getZxcolumn19() {
        return zxcolumn19;
    }

    public void setZxcolumn19(String zxcolumn19) {
        this.zxcolumn19 = zxcolumn19;
    }
    public Long getZxcolumn20() {
        return zxcolumn20;
    }

    public void setZxcolumn20(Long zxcolumn20) {
        this.zxcolumn20 = zxcolumn20;
    }
    public Long getZxcolumn21() {
        return zxcolumn21;
    }

    public void setZxcolumn21(Long zxcolumn21) {
        this.zxcolumn21 = zxcolumn21;
    }
    public Long getZxcolumn22() {
        return zxcolumn22;
    }

    public void setZxcolumn22(Long zxcolumn22) {
        this.zxcolumn22 = zxcolumn22;
    }
    public Long getZxcolumn23() {
        return zxcolumn23;
    }

    public void setZxcolumn23(Long zxcolumn23) {
        this.zxcolumn23 = zxcolumn23;
    }
    public Long getZxcolumn24() {
        return zxcolumn24;
    }

    public void setZxcolumn24(Long zxcolumn24) {
        this.zxcolumn24 = zxcolumn24;
    }
    public Long getZxcolumn25() {
        return zxcolumn25;
    }

    public void setZxcolumn25(Long zxcolumn25) {
        this.zxcolumn25 = zxcolumn25;
    }
    public Long getZxcolumn26() {
        return zxcolumn26;
    }

    public void setZxcolumn26(Long zxcolumn26) {
        this.zxcolumn26 = zxcolumn26;
    }
    public BigDecimal getZxcolumn27() {
        return zxcolumn27;
    }

    public void setZxcolumn27(BigDecimal zxcolumn27) {
        this.zxcolumn27 = zxcolumn27;
    }
    public BigDecimal getZxcolumn28() {
        return zxcolumn28;
    }

    public void setZxcolumn28(BigDecimal zxcolumn28) {
        this.zxcolumn28 = zxcolumn28;
    }
    public Long getZxcolumn29() {
        return zxcolumn29;
    }

    public void setZxcolumn29(Long zxcolumn29) {
        this.zxcolumn29 = zxcolumn29;
    }
    public Long getZxcolumn30() {
        return zxcolumn30;
    }

    public void setZxcolumn30(Long zxcolumn30) {
        this.zxcolumn30 = zxcolumn30;
    }
    public Long getZxcolumn31() {
        return zxcolumn31;
    }

    public void setZxcolumn31(Long zxcolumn31) {
        this.zxcolumn31 = zxcolumn31;
    }
    public Long getZxcolumn32() {
        return zxcolumn32;
    }

    public void setZxcolumn32(Long zxcolumn32) {
        this.zxcolumn32 = zxcolumn32;
    }
    public String getZxcolumn33() {
        return zxcolumn33;
    }

    public void setZxcolumn33(String zxcolumn33) {
        this.zxcolumn33 = zxcolumn33;
    }
    public BigDecimal getZxcolumn34() {
        return zxcolumn34;
    }

    public void setZxcolumn34(BigDecimal zxcolumn34) {
        this.zxcolumn34 = zxcolumn34;
    }
    public BigDecimal getZxcolumn35() {
        return zxcolumn35;
    }

    public void setZxcolumn35(BigDecimal zxcolumn35) {
        this.zxcolumn35 = zxcolumn35;
    }
    public BigDecimal getZxcolumn36() {
        return zxcolumn36;
    }

    public void setZxcolumn36(BigDecimal zxcolumn36) {
        this.zxcolumn36 = zxcolumn36;
    }
    public BigDecimal getZxcolumn37() {
        return zxcolumn37;
    }

    public void setZxcolumn37(BigDecimal zxcolumn37) {
        this.zxcolumn37 = zxcolumn37;
    }
    public BigDecimal getZxcolumn38() {
        return zxcolumn38;
    }

    public void setZxcolumn38(BigDecimal zxcolumn38) {
        this.zxcolumn38 = zxcolumn38;
    }
    public BigDecimal getZxcolumn39() {
        return zxcolumn39;
    }

    public void setZxcolumn39(BigDecimal zxcolumn39) {
        this.zxcolumn39 = zxcolumn39;
    }
    public BigDecimal getZxcolumn40() {
        return zxcolumn40;
    }

    public void setZxcolumn40(BigDecimal zxcolumn40) {
        this.zxcolumn40 = zxcolumn40;
    }
    public BigDecimal getZxcolumn41() {
        return zxcolumn41;
    }

    public void setZxcolumn41(BigDecimal zxcolumn41) {
        this.zxcolumn41 = zxcolumn41;
    }
    public BigDecimal getZxcolumn42() {
        return zxcolumn42;
    }

    public void setZxcolumn42(BigDecimal zxcolumn42) {
        this.zxcolumn42 = zxcolumn42;
    }
    public BigDecimal getZxcolumn43() {
        return zxcolumn43;
    }

    public void setZxcolumn43(BigDecimal zxcolumn43) {
        this.zxcolumn43 = zxcolumn43;
    }
    public BigDecimal getZxcolumn44() {
        return zxcolumn44;
    }

    public void setZxcolumn44(BigDecimal zxcolumn44) {
        this.zxcolumn44 = zxcolumn44;
    }
    public BigDecimal getZxcolumn45() {
        return zxcolumn45;
    }

    public void setZxcolumn45(BigDecimal zxcolumn45) {
        this.zxcolumn45 = zxcolumn45;
    }
    public BigDecimal getZxcolumn46() {
        return zxcolumn46;
    }

    public void setZxcolumn46(BigDecimal zxcolumn46) {
        this.zxcolumn46 = zxcolumn46;
    }
    public BigDecimal getZxcolumn47() {
        return zxcolumn47;
    }

    public void setZxcolumn47(BigDecimal zxcolumn47) {
        this.zxcolumn47 = zxcolumn47;
    }
    public BigDecimal getZxcolumn48() {
        return zxcolumn48;
    }

    public void setZxcolumn48(BigDecimal zxcolumn48) {
        this.zxcolumn48 = zxcolumn48;
    }
    public BigDecimal getZxcolumn49() {
        return zxcolumn49;
    }

    public void setZxcolumn49(BigDecimal zxcolumn49) {
        this.zxcolumn49 = zxcolumn49;
    }
    public BigDecimal getZxcolumn50() {
        return zxcolumn50;
    }

    public void setZxcolumn50(BigDecimal zxcolumn50) {
        this.zxcolumn50 = zxcolumn50;
    }
    public BigDecimal getZxcolumn51() {
        return zxcolumn51;
    }

    public void setZxcolumn51(BigDecimal zxcolumn51) {
        this.zxcolumn51 = zxcolumn51;
    }
    public BigDecimal getZxcolumn52() {
        return zxcolumn52;
    }

    public void setZxcolumn52(BigDecimal zxcolumn52) {
        this.zxcolumn52 = zxcolumn52;
    }
    public BigDecimal getZxcolumn53() {
        return zxcolumn53;
    }

    public void setZxcolumn53(BigDecimal zxcolumn53) {
        this.zxcolumn53 = zxcolumn53;
    }
    public BigDecimal getZxcolumn54() {
        return zxcolumn54;
    }

    public void setZxcolumn54(BigDecimal zxcolumn54) {
        this.zxcolumn54 = zxcolumn54;
    }
    public BigDecimal getZxcolumn55() {
        return zxcolumn55;
    }

    public void setZxcolumn55(BigDecimal zxcolumn55) {
        this.zxcolumn55 = zxcolumn55;
    }
    public BigDecimal getZxcolumn56() {
        return zxcolumn56;
    }

    public void setZxcolumn56(BigDecimal zxcolumn56) {
        this.zxcolumn56 = zxcolumn56;
    }
    public BigDecimal getZxcolumn57() {
        return zxcolumn57;
    }

    public void setZxcolumn57(BigDecimal zxcolumn57) {
        this.zxcolumn57 = zxcolumn57;
    }
    public BigDecimal getZxcolumn58() {
        return zxcolumn58;
    }

    public void setZxcolumn58(BigDecimal zxcolumn58) {
        this.zxcolumn58 = zxcolumn58;
    }
    public BigDecimal getZxcolumn59() {
        return zxcolumn59;
    }

    public void setZxcolumn59(BigDecimal zxcolumn59) {
        this.zxcolumn59 = zxcolumn59;
    }
    public BigDecimal getZxcolumn60() {
        return zxcolumn60;
    }

    public void setZxcolumn60(BigDecimal zxcolumn60) {
        this.zxcolumn60 = zxcolumn60;
    }
    public BigDecimal getZxcolumn61() {
        return zxcolumn61;
    }

    public void setZxcolumn61(BigDecimal zxcolumn61) {
        this.zxcolumn61 = zxcolumn61;
    }
    public Integer getZxcolumn62() {
        return zxcolumn62;
    }

    public void setZxcolumn62(Integer zxcolumn62) {
        this.zxcolumn62 = zxcolumn62;
    }
    public BigDecimal getZxcolumn63() {
        return zxcolumn63;
    }

    public void setZxcolumn63(BigDecimal zxcolumn63) {
        this.zxcolumn63 = zxcolumn63;
    }
    public String getZxcolumn64() {
        return zxcolumn64;
    }

    public void setZxcolumn64(String zxcolumn64) {
        this.zxcolumn64 = zxcolumn64;
    }
    public BigDecimal getZxcolumn65() {
        return zxcolumn65;
    }

    public void setZxcolumn65(BigDecimal zxcolumn65) {
        this.zxcolumn65 = zxcolumn65;
    }
    public Integer getZxcolumn66() {
        return zxcolumn66;
    }

    public void setZxcolumn66(Integer zxcolumn66) {
        this.zxcolumn66 = zxcolumn66;
    }
    public Integer getZxcolumn67() {
        return zxcolumn67;
    }

    public void setZxcolumn67(Integer zxcolumn67) {
        this.zxcolumn67 = zxcolumn67;
    }
    public Long getZxcolumn68() {
        return zxcolumn68;
    }

    public void setZxcolumn68(Long zxcolumn68) {
        this.zxcolumn68 = zxcolumn68;
    }
    public Long getZxcolumn69() {
        return zxcolumn69;
    }

    public void setZxcolumn69(Long zxcolumn69) {
        this.zxcolumn69 = zxcolumn69;
    }
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
    public Integer getReceivelimit() {
        return receivelimit;
    }

    public void setReceivelimit(Integer receivelimit) {
        this.receivelimit = receivelimit;
    }
    public BigDecimal getZxcolumn70() {
        return zxcolumn70;
    }

    public void setZxcolumn70(BigDecimal zxcolumn70) {
        this.zxcolumn70 = zxcolumn70;
    }
    public BigDecimal getZxcolumn71() {
        return zxcolumn71;
    }

    public void setZxcolumn71(BigDecimal zxcolumn71) {
        this.zxcolumn71 = zxcolumn71;
    }
    public Integer getZxcolumn72() {
        return zxcolumn72;
    }

    public void setZxcolumn72(Integer zxcolumn72) {
        this.zxcolumn72 = zxcolumn72;
    }
    public Integer getZxcolumn73() {
        return zxcolumn73;
    }

    public void setZxcolumn73(Integer zxcolumn73) {
        this.zxcolumn73 = zxcolumn73;
    }
    public Long getZxcolumn74() {
        return zxcolumn74;
    }

    public void setZxcolumn74(Long zxcolumn74) {
        this.zxcolumn74 = zxcolumn74;
    }
    public Long getZxcolumn75() {
        return zxcolumn75;
    }

    public void setZxcolumn75(Long zxcolumn75) {
        this.zxcolumn75 = zxcolumn75;
    }
    public Long getZxcolumn76() {
        return zxcolumn76;
    }

    public void setZxcolumn76(Long zxcolumn76) {
        this.zxcolumn76 = zxcolumn76;
    }
    public Long getZxcolumn77() {
        return zxcolumn77;
    }

    public void setZxcolumn77(Long zxcolumn77) {
        this.zxcolumn77 = zxcolumn77;
    }
    public Long getZxcolumn78() {
        return zxcolumn78;
    }

    public void setZxcolumn78(Long zxcolumn78) {
        this.zxcolumn78 = zxcolumn78;
    }
    public Long getZxcolumn79() {
        return zxcolumn79;
    }

    public void setZxcolumn79(Long zxcolumn79) {
        this.zxcolumn79 = zxcolumn79;
    }
    public Long getZxcolumn80() {
        return zxcolumn80;
    }

    public void setZxcolumn80(Long zxcolumn80) {
        this.zxcolumn80 = zxcolumn80;
    }

    @Override
    public String toString() {
        return "ZxBmsSuConYearDoc{" +
            "ysuconid=" + ysuconid +
            ", credate=" + credate +
            ", supplyid=" + supplyid +
            ", begindate=" + begindate +
            ", enddate=" + enddate +
            ", paperno=" + paperno +
            ", convertype=" + convertype +
            ", memo=" + memo +
            ", inputmanid=" + inputmanid +
            ", filemanid=" + filemanid +
            ", filedate=" + filedate +
            ", fileflag=" + fileflag +
            ", printno=" + printno +
            ", docusestatus=" + docusestatus +
            ", docinvalidmanid=" + docinvalidmanid +
            ", docinvaliddate=" + docinvaliddate +
            ", printdate=" + printdate +
            ", lastprtdate=" + lastprtdate +
            ", suconmanname=" + suconmanname +
            ", suconcontractway=" + suconcontractway +
            ", suconmanidno=" + suconmanidno +
            ", settletypeid=" + settletypeid +
            ", tranmethod=" + tranmethod +
            ", paylimit=" + paylimit +
            ", total=" + total +
            ", dtlLines=" + dtlLines +
            ", adress1=" + adress1 +
            ", adress2=" + adress2 +
            ", postno=" + postno +
            ", signdate=" + signdate +
            ", cfileflagmanid=" + cfileflagmanid +
            ", cfileflagdate=" + cfileflagdate +
            ", cfileflagmemo=" + cfileflagmemo +
            ", yygrossprofit=" + yygrossprofit +
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
            ", zxcolumn11=" + zxcolumn11 +
            ", zxcolumn12=" + zxcolumn12 +
            ", zxcolumn13=" + zxcolumn13 +
            ", zxcolumn14=" + zxcolumn14 +
            ", zxcolumn15=" + zxcolumn15 +
            ", zxcolumn16=" + zxcolumn16 +
            ", zxcolumn17=" + zxcolumn17 +
            ", zxcolumn18=" + zxcolumn18 +
            ", taxratePoint=" + taxratePoint +
            ", taxratePoint1=" + taxratePoint1 +
            ", invtype=" + invtype +
            ", repeatflag=" + repeatflag +
            ", suconstatus=" + suconstatus +
            ", suconcfmmanid=" + suconcfmmanid +
            ", suconcfmmanname=" + suconcfmmanname +
            ", suconcfmdate=" + suconcfmdate +
            ", suconcfmmemo=" + suconcfmmemo +
            ", receiveno=" + receiveno +
            ", receivememo=" + receivememo +
            ", tempbegindate=" + tempbegindate +
            ", tempenddate=" + tempenddate +
            ", receivemanname=" + receivemanname +
            ", receivedate=" + receivedate +
            ", orgreceidate=" + orgreceidate +
            ", zxcolumn19=" + zxcolumn19 +
            ", zxcolumn20=" + zxcolumn20 +
            ", zxcolumn21=" + zxcolumn21 +
            ", zxcolumn22=" + zxcolumn22 +
            ", zxcolumn23=" + zxcolumn23 +
            ", zxcolumn24=" + zxcolumn24 +
            ", zxcolumn25=" + zxcolumn25 +
            ", zxcolumn26=" + zxcolumn26 +
            ", zxcolumn27=" + zxcolumn27 +
            ", zxcolumn28=" + zxcolumn28 +
            ", zxcolumn29=" + zxcolumn29 +
            ", zxcolumn30=" + zxcolumn30 +
            ", zxcolumn31=" + zxcolumn31 +
            ", zxcolumn32=" + zxcolumn32 +
            ", zxcolumn33=" + zxcolumn33 +
            ", zxcolumn34=" + zxcolumn34 +
            ", zxcolumn35=" + zxcolumn35 +
            ", zxcolumn36=" + zxcolumn36 +
            ", zxcolumn37=" + zxcolumn37 +
            ", zxcolumn38=" + zxcolumn38 +
            ", zxcolumn39=" + zxcolumn39 +
            ", zxcolumn40=" + zxcolumn40 +
            ", zxcolumn41=" + zxcolumn41 +
            ", zxcolumn42=" + zxcolumn42 +
            ", zxcolumn43=" + zxcolumn43 +
            ", zxcolumn44=" + zxcolumn44 +
            ", zxcolumn45=" + zxcolumn45 +
            ", zxcolumn46=" + zxcolumn46 +
            ", zxcolumn47=" + zxcolumn47 +
            ", zxcolumn48=" + zxcolumn48 +
            ", zxcolumn49=" + zxcolumn49 +
            ", zxcolumn50=" + zxcolumn50 +
            ", zxcolumn51=" + zxcolumn51 +
            ", zxcolumn52=" + zxcolumn52 +
            ", zxcolumn53=" + zxcolumn53 +
            ", zxcolumn54=" + zxcolumn54 +
            ", zxcolumn55=" + zxcolumn55 +
            ", zxcolumn56=" + zxcolumn56 +
            ", zxcolumn57=" + zxcolumn57 +
            ", zxcolumn58=" + zxcolumn58 +
            ", zxcolumn59=" + zxcolumn59 +
            ", zxcolumn60=" + zxcolumn60 +
            ", zxcolumn61=" + zxcolumn61 +
            ", zxcolumn62=" + zxcolumn62 +
            ", zxcolumn63=" + zxcolumn63 +
            ", zxcolumn64=" + zxcolumn64 +
            ", zxcolumn65=" + zxcolumn65 +
            ", zxcolumn66=" + zxcolumn66 +
            ", zxcolumn67=" + zxcolumn67 +
            ", zxcolumn68=" + zxcolumn68 +
            ", zxcolumn69=" + zxcolumn69 +
            ", cardno=" + cardno +
            ", receivelimit=" + receivelimit +
            ", zxcolumn70=" + zxcolumn70 +
            ", zxcolumn71=" + zxcolumn71 +
            ", zxcolumn72=" + zxcolumn72 +
            ", zxcolumn73=" + zxcolumn73 +
            ", zxcolumn74=" + zxcolumn74 +
            ", zxcolumn75=" + zxcolumn75 +
            ", zxcolumn76=" + zxcolumn76 +
            ", zxcolumn77=" + zxcolumn77 +
            ", zxcolumn78=" + zxcolumn78 +
            ", zxcolumn79=" + zxcolumn79 +
            ", zxcolumn80=" + zxcolumn80 +
        "}";
    }
}
