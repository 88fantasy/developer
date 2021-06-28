package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 商品货源信息表
 * </p>
 *
 * @author yjf
 * @since 2021-05-12
 */
public class BmsSuGdsresLst implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 	货品标识号
     */
    @TableId("GOODSID")
    private Long goodsid;

    /**
     * 	供应商标识号
     */
    @TableField("SUPPLYID")
    private Long supplyid;

    /**
     * 	进货提前期  单位：天
     */
    @TableField("ORDERPERIOD")
    private Integer orderperiod;

    /**
     * 	优先级1,2 …正常，99：停止,100 ：黑名单
     */
    @TableField("PRIORITY")
    private Integer priority;

    /**
     * 	1：正常  0：停用  
     */
    @TableField("USESTATUS")
    private Integer usestatus;

    /**
     * 	1:有协议，0:无协议
     */
    @TableField("AGREEDOCFLAG")
    private Integer agreedocflag;

    /**
     * 	估计进货折让率
     */
    @TableField("DISCOUNTRATE")
    private BigDecimal discountrate;

    /**
     * 	代销标志1:代销0:经销
     */
    @TableField("AGTFLAG")
    private Integer agtflag;

    /**
     * 备注
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 录入人ID
     */
    @TableField("IMPUTMANID")
    private Long imputmanid;

    /**
     * 录入日期
     */
    @TableField("MODIDATE")
    private Date modidate;

    /**
     * 信息ID
     */
    @TableField("INFOID")
    private Long infoid;

    /**
     * 购进属性 用户字典表PUB_DDL(JHHY_SUPTYPE)
     */
    @TableField("SUPTYPE")
    private Integer suptype;

    /**
     * 默认收货仓库
     */
    @TableField("DEFAULTSTORERID")
    private Long defaultstorerid;

    /**
     * 修改人ID(计划员)
     */
    @TableField("JHMODIMANID")
    private Long jhmodimanid;

    /**
     * 计划员修改日期
     */
    @TableField("JHMODIDATE")
    private Date jhmodidate;

    /**
     * 修改人ID(采购员)
     */
    @TableField("CGMODIMANID")
    private Long cgmodimanid;

    /**
     * 采购员修改日期
     */
    @TableField("CGMODIDATE")
    private Date cgmodidate;

    /**
     * 特药审批人
     */
    @TableField("SPECIALDRUGASSMAN")
    private String specialdrugassman;

    /**
     * 特药审批时间
     */
    @TableField("SPECIALDRUGASSDATE")
    private Date specialdrugassdate;

    /**
     * 质量部审批标志
     */
    @TableField("ZLBCONFIRM")
    private Integer zlbconfirm;

    /**
     * 质量部审批人ID
     */
    @TableField("ZLBID")
    private Long zlbid;

    /**
     * 质量部审批时间
     */
    @TableField("ZLBCONFIRMDATE")
    private Date zlbconfirmdate;

    /**
     * 委托人检查结果
     */
    @TableField("WTCHECKFLAG")
    private Integer wtcheckflag;

    /**
     * 固定电话
     */
    @TableField("TELEPHONE")
    private String telephone;

    /**
     * 温度偏差处理方式
     */
    @TableField("TEMPBIASPROCESSMODE")
    private Integer tempbiasprocessmode;

    /**
     * 偏差联系方式
     */
    @TableField("BIASCONTACTMODE")
    private String biascontactmode;

    /**
     * 温度数据提供方式
     */
    @TableField("TEMPDATASUPPORT")
    private Integer tempdatasupport;

    /**
     * 温度数据读取要求
     */
    @TableField("TEMPDATAREADREQUEST")
    private Integer tempdatareadrequest;

    /**
     * 温度数据是否需返还
     */
    @TableField("TEMPDATANEEDRETURN")
    private Integer tempdataneedreturn;

    /**
     * 数据返还电子邮箱
     */
    @TableField("DATARETURNEMAIL")
    private String datareturnemail;

    /**
     * 联系人
     */
    @TableField("DATACONTACTMAN")
    private String datacontactman;

    /**
     * 联系电话
     */
    @TableField("DATACONTACTTEL")
    private String datacontacttel;

    /**
     * 温度记录仪返回方式
     */
    @TableField("TEMPRECORDERBACKMODE")
    private Integer temprecorderbackmode;

    /**
     * 温度记录仪邮寄地址
     */
    @TableField("TEMPRECORDERMAILADDRESS")
    private String temprecordermailaddress;

    /**
     * 邮寄联系人
     */
    @TableField("MAILCONTACTMAN")
    private String mailcontactman;

    /**
     * 邮寄联系电话
     */
    @TableField("MAILTELEPHONE")
    private String mailtelephone;

    /**
     * 前一状态
     */
    @TableField("PRE_USESTATUS")
    private Integer preUsestatus;

    /**
     * 录入人ID
     */
    @TableField("CREMANID")
    private Long cremanid;

    /**
     * 录入日期
     */
    @TableField("CREDATE")
    private Date credate;

    /**
     * 收货提示
     */
    @TableField("SOLUTION")
    private String solution;

    /**
     * 临时收货提示
     */
    @TableField("TEMPSOLUTION")
    private String tempsolution;

    /**
     * 采购经理审批人ID
     */
    @TableField("CGMANAGERID")
    private Long cgmanagerid;

    /**
     * 采购经理审批人时间
     */
    @TableField("CGMANAGERDATE")
    private Date cgmanagerdate;

    /**
     * 采购总监审批人ID
     */
    @TableField("CGDIRECTORID")
    private Long cgdirectorid;

    /**
     * 采购总监审批人时间
     */
    @TableField("CGDIRECTORDATE")
    private Date cgdirectordate;

    /**
     * 收货提示审批进度
     */
    @TableField("SOLUTIONSTATUS")
    private Long solutionstatus;

    /**
     * 采购经理审批结果
     */
    @TableField("CGMANAGERAPPROVE")
    private Integer cgmanagerapprove;

    /**
     * 采购总监审批结果
     */
    @TableField("CGDIRECTORAPPROVE")
    private Integer cgdirectorapprove;

    /**
     * 修改标志--物流升级项目
     */
    @TableField("MODIFYFLAG")
    private Integer modifyflag;

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
    public Long getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(Long supplyid) {
        this.supplyid = supplyid;
    }
    public Integer getOrderperiod() {
        return orderperiod;
    }

    public void setOrderperiod(Integer orderperiod) {
        this.orderperiod = orderperiod;
    }
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }
    public Integer getAgreedocflag() {
        return agreedocflag;
    }

    public void setAgreedocflag(Integer agreedocflag) {
        this.agreedocflag = agreedocflag;
    }
    public BigDecimal getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(BigDecimal discountrate) {
        this.discountrate = discountrate;
    }
    public Integer getAgtflag() {
        return agtflag;
    }

    public void setAgtflag(Integer agtflag) {
        this.agtflag = agtflag;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Long getImputmanid() {
        return imputmanid;
    }

    public void setImputmanid(Long imputmanid) {
        this.imputmanid = imputmanid;
    }
    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }
    public Long getInfoid() {
        return infoid;
    }

    public void setInfoid(Long infoid) {
        this.infoid = infoid;
    }
    public Integer getSuptype() {
        return suptype;
    }

    public void setSuptype(Integer suptype) {
        this.suptype = suptype;
    }
    public Long getDefaultstorerid() {
        return defaultstorerid;
    }

    public void setDefaultstorerid(Long defaultstorerid) {
        this.defaultstorerid = defaultstorerid;
    }
    public Long getJhmodimanid() {
        return jhmodimanid;
    }

    public void setJhmodimanid(Long jhmodimanid) {
        this.jhmodimanid = jhmodimanid;
    }
    public Date getJhmodidate() {
        return jhmodidate;
    }

    public void setJhmodidate(Date jhmodidate) {
        this.jhmodidate = jhmodidate;
    }
    public Long getCgmodimanid() {
        return cgmodimanid;
    }

    public void setCgmodimanid(Long cgmodimanid) {
        this.cgmodimanid = cgmodimanid;
    }
    public Date getCgmodidate() {
        return cgmodidate;
    }

    public void setCgmodidate(Date cgmodidate) {
        this.cgmodidate = cgmodidate;
    }
    public String getSpecialdrugassman() {
        return specialdrugassman;
    }

    public void setSpecialdrugassman(String specialdrugassman) {
        this.specialdrugassman = specialdrugassman;
    }
    public Date getSpecialdrugassdate() {
        return specialdrugassdate;
    }

    public void setSpecialdrugassdate(Date specialdrugassdate) {
        this.specialdrugassdate = specialdrugassdate;
    }
    public Integer getZlbconfirm() {
        return zlbconfirm;
    }

    public void setZlbconfirm(Integer zlbconfirm) {
        this.zlbconfirm = zlbconfirm;
    }
    public Long getZlbid() {
        return zlbid;
    }

    public void setZlbid(Long zlbid) {
        this.zlbid = zlbid;
    }
    public Date getZlbconfirmdate() {
        return zlbconfirmdate;
    }

    public void setZlbconfirmdate(Date zlbconfirmdate) {
        this.zlbconfirmdate = zlbconfirmdate;
    }
    public Integer getWtcheckflag() {
        return wtcheckflag;
    }

    public void setWtcheckflag(Integer wtcheckflag) {
        this.wtcheckflag = wtcheckflag;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Integer getTempbiasprocessmode() {
        return tempbiasprocessmode;
    }

    public void setTempbiasprocessmode(Integer tempbiasprocessmode) {
        this.tempbiasprocessmode = tempbiasprocessmode;
    }
    public String getBiascontactmode() {
        return biascontactmode;
    }

    public void setBiascontactmode(String biascontactmode) {
        this.biascontactmode = biascontactmode;
    }
    public Integer getTempdatasupport() {
        return tempdatasupport;
    }

    public void setTempdatasupport(Integer tempdatasupport) {
        this.tempdatasupport = tempdatasupport;
    }
    public Integer getTempdatareadrequest() {
        return tempdatareadrequest;
    }

    public void setTempdatareadrequest(Integer tempdatareadrequest) {
        this.tempdatareadrequest = tempdatareadrequest;
    }
    public Integer getTempdataneedreturn() {
        return tempdataneedreturn;
    }

    public void setTempdataneedreturn(Integer tempdataneedreturn) {
        this.tempdataneedreturn = tempdataneedreturn;
    }
    public String getDatareturnemail() {
        return datareturnemail;
    }

    public void setDatareturnemail(String datareturnemail) {
        this.datareturnemail = datareturnemail;
    }
    public String getDatacontactman() {
        return datacontactman;
    }

    public void setDatacontactman(String datacontactman) {
        this.datacontactman = datacontactman;
    }
    public String getDatacontacttel() {
        return datacontacttel;
    }

    public void setDatacontacttel(String datacontacttel) {
        this.datacontacttel = datacontacttel;
    }
    public Integer getTemprecorderbackmode() {
        return temprecorderbackmode;
    }

    public void setTemprecorderbackmode(Integer temprecorderbackmode) {
        this.temprecorderbackmode = temprecorderbackmode;
    }
    public String getTemprecordermailaddress() {
        return temprecordermailaddress;
    }

    public void setTemprecordermailaddress(String temprecordermailaddress) {
        this.temprecordermailaddress = temprecordermailaddress;
    }
    public String getMailcontactman() {
        return mailcontactman;
    }

    public void setMailcontactman(String mailcontactman) {
        this.mailcontactman = mailcontactman;
    }
    public String getMailtelephone() {
        return mailtelephone;
    }

    public void setMailtelephone(String mailtelephone) {
        this.mailtelephone = mailtelephone;
    }
    public Integer getPreUsestatus() {
        return preUsestatus;
    }

    public void setPreUsestatus(Integer preUsestatus) {
        this.preUsestatus = preUsestatus;
    }
    public Long getCremanid() {
        return cremanid;
    }

    public void setCremanid(Long cremanid) {
        this.cremanid = cremanid;
    }
    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getTempsolution() {
        return tempsolution;
    }

    public void setTempsolution(String tempsolution) {
        this.tempsolution = tempsolution;
    }
    public Long getCgmanagerid() {
        return cgmanagerid;
    }

    public void setCgmanagerid(Long cgmanagerid) {
        this.cgmanagerid = cgmanagerid;
    }
    public Date getCgmanagerdate() {
        return cgmanagerdate;
    }

    public void setCgmanagerdate(Date cgmanagerdate) {
        this.cgmanagerdate = cgmanagerdate;
    }
    public Long getCgdirectorid() {
        return cgdirectorid;
    }

    public void setCgdirectorid(Long cgdirectorid) {
        this.cgdirectorid = cgdirectorid;
    }
    public Date getCgdirectordate() {
        return cgdirectordate;
    }

    public void setCgdirectordate(Date cgdirectordate) {
        this.cgdirectordate = cgdirectordate;
    }
    public Long getSolutionstatus() {
        return solutionstatus;
    }

    public void setSolutionstatus(Long solutionstatus) {
        this.solutionstatus = solutionstatus;
    }
    public Integer getCgmanagerapprove() {
        return cgmanagerapprove;
    }

    public void setCgmanagerapprove(Integer cgmanagerapprove) {
        this.cgmanagerapprove = cgmanagerapprove;
    }
    public Integer getCgdirectorapprove() {
        return cgdirectorapprove;
    }

    public void setCgdirectorapprove(Integer cgdirectorapprove) {
        this.cgdirectorapprove = cgdirectorapprove;
    }
    public Integer getModifyflag() {
        return modifyflag;
    }

    public void setModifyflag(Integer modifyflag) {
        this.modifyflag = modifyflag;
    }

    @Override
    public String toString() {
        return "BmsSuGdsresLst{" +
            "goodsid=" + goodsid +
            ", supplyid=" + supplyid +
            ", orderperiod=" + orderperiod +
            ", priority=" + priority +
            ", usestatus=" + usestatus +
            ", agreedocflag=" + agreedocflag +
            ", discountrate=" + discountrate +
            ", agtflag=" + agtflag +
            ", memo=" + memo +
            ", imputmanid=" + imputmanid +
            ", modidate=" + modidate +
            ", infoid=" + infoid +
            ", suptype=" + suptype +
            ", defaultstorerid=" + defaultstorerid +
            ", jhmodimanid=" + jhmodimanid +
            ", jhmodidate=" + jhmodidate +
            ", cgmodimanid=" + cgmodimanid +
            ", cgmodidate=" + cgmodidate +
            ", specialdrugassman=" + specialdrugassman +
            ", specialdrugassdate=" + specialdrugassdate +
            ", zlbconfirm=" + zlbconfirm +
            ", zlbid=" + zlbid +
            ", zlbconfirmdate=" + zlbconfirmdate +
            ", wtcheckflag=" + wtcheckflag +
            ", telephone=" + telephone +
            ", tempbiasprocessmode=" + tempbiasprocessmode +
            ", biascontactmode=" + biascontactmode +
            ", tempdatasupport=" + tempdatasupport +
            ", tempdatareadrequest=" + tempdatareadrequest +
            ", tempdataneedreturn=" + tempdataneedreturn +
            ", datareturnemail=" + datareturnemail +
            ", datacontactman=" + datacontactman +
            ", datacontacttel=" + datacontacttel +
            ", temprecorderbackmode=" + temprecorderbackmode +
            ", temprecordermailaddress=" + temprecordermailaddress +
            ", mailcontactman=" + mailcontactman +
            ", mailtelephone=" + mailtelephone +
            ", preUsestatus=" + preUsestatus +
            ", cremanid=" + cremanid +
            ", credate=" + credate +
            ", solution=" + solution +
            ", tempsolution=" + tempsolution +
            ", cgmanagerid=" + cgmanagerid +
            ", cgmanagerdate=" + cgmanagerdate +
            ", cgdirectorid=" + cgdirectorid +
            ", cgdirectordate=" + cgdirectordate +
            ", solutionstatus=" + solutionstatus +
            ", cgmanagerapprove=" + cgmanagerapprove +
            ", cgdirectorapprove=" + cgdirectorapprove +
            ", modifyflag=" + modifyflag +
        "}";
    }
}
