package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjf
 * @since 2021-05-11
 */
@TableName("ZX_BMS_SU_OVERBATCH_APPLY")

public class ZxBmsSuOverbatchApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 申请单ID
     */
    @TableId("APPLYID")
    private Long applyid;

    /**
     * 货品ID
     */
    @TableField("GOODSID")
    private Long goodsid;

    /**
     * 申请批量
     */
    @TableField("BATCHQTY")
    private Long batchqty;

    /**
     * 已勾对数量
     */
    @TableField("FINISHQTY")
    private Long finishqty;

    /**
     * 计划原因
     */
    @TableField("JHREASONID")
    private Integer jhreasonid;

    /**
     * 采购原因
     */
    @TableField("CGREASONID")
    private Integer cgreasonid;

    /**
     * 指定审批总监
     */
    @TableField("DEFAULTAPPROVEMANID")
    private Long defaultapprovemanid;

    /**
     * 备注
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 预计到货日期
     */
    @TableField("TARGETRGDATE")
    private Date targetrgdate;

    /**
     * 预计售完日期
     */
    @TableField("TARGETSADATE")
    private Date targetsadate;

    /**
     * 使用状态
     */
    @TableField("USESTATUS")
    private Integer usestatus;

    /**
     * 录入人ID
     */
    @TableField("INPUTMANID")
    private Long inputmanid;

    /**
     * 录入日期
     */
    @TableField("INPUTDATE")
    private Date inputdate;

    /**
     * 申请人ID
     */
    @TableField("APPLYMANID")
    private Long applymanid;

    /**
     * 申请日期
     */
    @TableField("APPLYDATE")
    private Date applydate;

    /**
     * 确认意见
     */
    @TableField("CFMFLAG")
    private Integer cfmflag;

    /**
     * 确认人ID
     */
    @TableField("CFMMANID")
    private Long cfmmanid;

    /**
     * 确认日期
     */
    @TableField("CFMDATE")
    private Date cfmdate;

    /**
     * 组长审批意见
     */
    @TableField("APPROVEOPN1")
    private Integer approveopn1;

    /**
     * 审批组长ID
     */
    @TableField("APPROVEMANID1")
    private Long approvemanid1;

    /**
     * 组长审批日期
     */
    @TableField("APPROVEDATE1")
    private Date approvedate1;

    /**
     * 审批总监ID
     */
    @TableField("APPROVEMANID2")
    private Long approvemanid2;

    /**
     * 总监审批日期
     */
    @TableField("APPROVEDATE2")
    private Date approvedate2;

    /**
     * 审批主管经理ID
     */
    @TableField("APPROVEMANID3")
    private Long approvemanid3;

    /**
     * 主管经理审批日期
     */
    @TableField("APPROVEDATE3")
    private Date approvedate3;

    /**
     * 中止/作废人ID
     */
    @TableField("INVALIDMANID")
    private Long invalidmanid;

    /**
     * 中止/作废日期
     */
    @TableField("INVALIDDATE")
    private Date invaliddate;

    /**
     * 品种分类 /审批时(usestatus更新为3, 下同)记录
     */
    @TableField("TYPENAME")
    private String typename;

    /**
     * 当前库存数量 /审批时记录
     */
    @TableField("BUSIDTLQTY")
    private Long busidtlqty;

    /**
     * 未执行合同数量 /审批时记录
     */
    @TableField("CNOTACCQTY")
    private Long cnotaccqty;

    /**
     * 已执行合同数量 /审批时记录
     */
    @TableField("CACCQTY")
    private Long caccqty;

    /**
     * 库存上限 /审批时记录
     */
    @TableField("UPQTY")
    private Long upqty;

    /**
     * 平均月销量 /审批时记录
     */
    @TableField("SALESQTYPERM")
    private Long salesqtyperm;

    /**
     * 总监审批意见
     */
    @TableField("APPROVEOPN2")
    private Long approveopn2;

    /**
     * 主管经理审批意见
     */
    @TableField("APPROVEOPN3")
    private Long approveopn3;

    /**
     * 默认完成审批层级 /审批时记录
     */
    @TableField("NEEDLV")
    private Long needlv;

    /**
     * 自动审批标志
     */
    @TableField("AUTOCONFIRM")
    private Integer autoconfirm;

    /**
     * 自动审批备注
     */
    @TableField("AUTOCONFIRMMEMO")
    private String autoconfirmmemo;

    /**
     * 手机审批ID
     */
    @TableField("PINSTANCEID")
    private Long pinstanceid;

    public Long getApplyid() {
        return applyid;
    }

    public void setApplyid(Long applyid) {
        this.applyid = applyid;
    }
    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }
    public Long getBatchqty() {
        return batchqty;
    }

    public void setBatchqty(Long batchqty) {
        this.batchqty = batchqty;
    }
    public Long getFinishqty() {
        return finishqty;
    }

    public void setFinishqty(Long finishqty) {
        this.finishqty = finishqty;
    }
    public Integer getJhreasonid() {
        return jhreasonid;
    }

    public void setJhreasonid(Integer jhreasonid) {
        this.jhreasonid = jhreasonid;
    }
    public Integer getCgreasonid() {
        return cgreasonid;
    }

    public void setCgreasonid(Integer cgreasonid) {
        this.cgreasonid = cgreasonid;
    }
    public Long getDefaultapprovemanid() {
        return defaultapprovemanid;
    }

    public void setDefaultapprovemanid(Long defaultapprovemanid) {
        this.defaultapprovemanid = defaultapprovemanid;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Date getTargetrgdate() {
        return targetrgdate;
    }

    public void setTargetrgdate(Date targetrgdate) {
        this.targetrgdate = targetrgdate;
    }
    public Date getTargetsadate() {
        return targetsadate;
    }

    public void setTargetsadate(Date targetsadate) {
        this.targetsadate = targetsadate;
    }
    public Integer getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Integer usestatus) {
        this.usestatus = usestatus;
    }
    public Long getInputmanid() {
        return inputmanid;
    }

    public void setInputmanid(Long inputmanid) {
        this.inputmanid = inputmanid;
    }
    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }
    public Long getApplymanid() {
        return applymanid;
    }

    public void setApplymanid(Long applymanid) {
        this.applymanid = applymanid;
    }
    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }
    public Integer getCfmflag() {
        return cfmflag;
    }

    public void setCfmflag(Integer cfmflag) {
        this.cfmflag = cfmflag;
    }
    public Long getCfmmanid() {
        return cfmmanid;
    }

    public void setCfmmanid(Long cfmmanid) {
        this.cfmmanid = cfmmanid;
    }
    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }
    public Integer getApproveopn1() {
        return approveopn1;
    }

    public void setApproveopn1(Integer approveopn1) {
        this.approveopn1 = approveopn1;
    }
    public Long getApprovemanid1() {
        return approvemanid1;
    }

    public void setApprovemanid1(Long approvemanid1) {
        this.approvemanid1 = approvemanid1;
    }
    public Date getApprovedate1() {
        return approvedate1;
    }

    public void setApprovedate1(Date approvedate1) {
        this.approvedate1 = approvedate1;
    }
    public Long getApprovemanid2() {
        return approvemanid2;
    }

    public void setApprovemanid2(Long approvemanid2) {
        this.approvemanid2 = approvemanid2;
    }
    public Date getApprovedate2() {
        return approvedate2;
    }

    public void setApprovedate2(Date approvedate2) {
        this.approvedate2 = approvedate2;
    }
    public Long getApprovemanid3() {
        return approvemanid3;
    }

    public void setApprovemanid3(Long approvemanid3) {
        this.approvemanid3 = approvemanid3;
    }
    public Date getApprovedate3() {
        return approvedate3;
    }

    public void setApprovedate3(Date approvedate3) {
        this.approvedate3 = approvedate3;
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
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
    public Long getBusidtlqty() {
        return busidtlqty;
    }

    public void setBusidtlqty(Long busidtlqty) {
        this.busidtlqty = busidtlqty;
    }
    public Long getCnotaccqty() {
        return cnotaccqty;
    }

    public void setCnotaccqty(Long cnotaccqty) {
        this.cnotaccqty = cnotaccqty;
    }
    public Long getCaccqty() {
        return caccqty;
    }

    public void setCaccqty(Long caccqty) {
        this.caccqty = caccqty;
    }
    public Long getUpqty() {
        return upqty;
    }

    public void setUpqty(Long upqty) {
        this.upqty = upqty;
    }
    public Long getSalesqtyperm() {
        return salesqtyperm;
    }

    public void setSalesqtyperm(Long salesqtyperm) {
        this.salesqtyperm = salesqtyperm;
    }
    public Long getApproveopn2() {
        return approveopn2;
    }

    public void setApproveopn2(Long approveopn2) {
        this.approveopn2 = approveopn2;
    }
    public Long getApproveopn3() {
        return approveopn3;
    }

    public void setApproveopn3(Long approveopn3) {
        this.approveopn3 = approveopn3;
    }
    public Long getNeedlv() {
        return needlv;
    }

    public void setNeedlv(Long needlv) {
        this.needlv = needlv;
    }
    public Integer getAutoconfirm() {
        return autoconfirm;
    }

    public void setAutoconfirm(Integer autoconfirm) {
        this.autoconfirm = autoconfirm;
    }
    public String getAutoconfirmmemo() {
        return autoconfirmmemo;
    }

    public void setAutoconfirmmemo(String autoconfirmmemo) {
        this.autoconfirmmemo = autoconfirmmemo;
    }
    public Long getPinstanceid() {
        return pinstanceid;
    }

    public void setPinstanceid(Long pinstanceid) {
        this.pinstanceid = pinstanceid;
    }

    @Override
    public String toString() {
        return "ZxBmsSuOverbatchApply{" +
            "applyid=" + applyid +
            ", goodsid=" + goodsid +
            ", batchqty=" + batchqty +
            ", finishqty=" + finishqty +
            ", jhreasonid=" + jhreasonid +
            ", cgreasonid=" + cgreasonid +
            ", defaultapprovemanid=" + defaultapprovemanid +
            ", memo=" + memo +
            ", targetrgdate=" + targetrgdate +
            ", targetsadate=" + targetsadate +
            ", usestatus=" + usestatus +
            ", inputmanid=" + inputmanid +
            ", inputdate=" + inputdate +
            ", applymanid=" + applymanid +
            ", applydate=" + applydate +
            ", cfmflag=" + cfmflag +
            ", cfmmanid=" + cfmmanid +
            ", cfmdate=" + cfmdate +
            ", approveopn1=" + approveopn1 +
            ", approvemanid1=" + approvemanid1 +
            ", approvedate1=" + approvedate1 +
            ", approvemanid2=" + approvemanid2 +
            ", approvedate2=" + approvedate2 +
            ", approvemanid3=" + approvemanid3 +
            ", approvedate3=" + approvedate3 +
            ", invalidmanid=" + invalidmanid +
            ", invaliddate=" + invaliddate +
            ", typename=" + typename +
            ", busidtlqty=" + busidtlqty +
            ", cnotaccqty=" + cnotaccqty +
            ", caccqty=" + caccqty +
            ", upqty=" + upqty +
            ", salesqtyperm=" + salesqtyperm +
            ", approveopn2=" + approveopn2 +
            ", approveopn3=" + approveopn3 +
            ", needlv=" + needlv +
            ", autoconfirm=" + autoconfirm +
            ", autoconfirmmemo=" + autoconfirmmemo +
            ", pinstanceid=" + pinstanceid +
        "}";
    }
}
