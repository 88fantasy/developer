package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjf
 * @since 2021-05-06
 */
@TableName("zx_supply_license")
public class ZxSupplyLicense implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("COMPANYID")
    private Long companyid;

    @TableField("LICENSEID")
    private Long licenseid;

    @TableField("LICENSENAM")
    private String licensenam;

    @TableField("LICENSEDTL")
    private String licensedtl;

    @TableField("LICENSEBEGIN")
    private Date licensebegin;

    @TableField("LICENSEEND")
    private Date licenseend;

    @TableField("LICENSENO")
    private String licenseno;

    @TableField("MEMO")
    private String memo;

    @TableField("PERMITSALE")
    private String permitsale;

    @TableField("SALEMETHOD")
    private String salemethod;

    @TableField("CHKDATE")
    private String chkdate;

    @TableField("NO01")
    private Integer no01;

    @TableField("NO02")
    private Integer no02;

    @TableField("NO03")
    private Integer no03;

    @TableField("NO04")
    private Integer no04;

    @TableField("NO05")
    private Integer no05;

    @TableField("NO06")
    private Integer no06;

    @TableField("NO07")
    private Integer no07;

    @TableField("NO08")
    private Integer no08;

    @TableField("NO09")
    private Integer no09;

    @TableField("NO10")
    private Integer no10;

    @TableField("NO11")
    private Integer no11;

    @TableField("NO12")
    private Integer no12;

    @TableField("LICENSEINVALIDATE")
    private Date licenseinvalidate;

    @TableField("LASTSUDATE")
    private Date lastsudate;

    @TableField("WTRANGE")
    private String wtrange;

    @TableField("VALIDSUFLAG")
    private Integer validsuflag;

    @TableId("SEQID")
    private Long seqid;

    @TableField("LASTCHECKDATE")
    private Date lastcheckdate;

    @TableField("LASTSALEDATE")
    private Date lastsaledate;

    @TableField("CREATEMANID")
    private Long createmanid;

    @TableField("MODIDATE")
    private Date modidate;

    @TableField("ACCMANID")
    private Long accmanid;

    @TableField("ACCDATE")
    private Date accdate;

    @TableField("EXCEEDSETFLAG")
    private Integer exceedsetflag;

    @TableField("LASTSETDATE")
    private Date lastsetdate;

    @TableField("LASTSETGOOD")
    private String lastsetgood;

    @TableField("LASTSETINVNO")
    private String lastsetinvno;

    @TableField("LASTSETDTLID")
    private Long lastsetdtlid;

    @TableField("PICFLAG")
    private Integer picflag;

    @TableField("CAPITAL")
    private BigDecimal capital;

    @TableField("RETURNMEMO")
    private String returnmemo;

    @TableField("MEMO1")
    private String memo1;

    @TableField("SALERACCMANID")
    private Long saleraccmanid;

    @TableField("SALERACCDATE")
    private Date saleraccdate;

    @TableField("OVERDUESTATUS")
    private Integer overduestatus;

    @TableField("ATTORNEYFLAG")
    private Integer attorneyflag;

    @TableField("SPECIALFLAG")
    private Integer specialflag;

    @TableField("SECONDFLAG")
    private Integer secondflag;

    /**
     * 法人受托人签订合同资质
     */
    @TableField("CONTRACTQUANLIFTY")
    private Integer contractquanlifty;

    /**
     * 最后修改人id
     */
    @TableField("LASTMODIMANID")
    private Long lastmodimanid;

    /**
     * 最后修改人名
     */
    @TableField("LASTMODIMANNAME")
    private String lastmodimanname;

    /**
     * 最后修改日期
     */
    @TableField("LASTMODIDATE")
    private Date lastmodidate;

    /**
     * 法人受托人
     */
    @TableField("REPRESENTMAN")
    private String representman;

    /**
     * 法人受托人证件号
     */
    @TableField("REPRESENTNO")
    private String representno;

    public  Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }
    public Long getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(Long licenseid) {
        this.licenseid = licenseid;
    }
    public String getLicensenam() {
        return licensenam;
    }

    public void setLicensenam(String licensenam) {
        this.licensenam = licensenam;
    }
    public String getLicensedtl() {
        return licensedtl;
    }

    public void setLicensedtl(String licensedtl) {
        this.licensedtl = licensedtl;
    }
    public Date getLicensebegin() {
        return licensebegin;
    }

    public void setLicensebegin(Date licensebegin) {
        this.licensebegin = licensebegin;
    }
    public Date getLicenseend() {
        return licenseend;
    }

    public void setLicenseend(Date licenseend) {
        this.licenseend = licenseend;
    }
    public String getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(String licenseno) {
        this.licenseno = licenseno;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getPermitsale() {
        return permitsale;
    }

    public void setPermitsale(String permitsale) {
        this.permitsale = permitsale;
    }
    public String getSalemethod() {
        return salemethod;
    }

    public void setSalemethod(String salemethod) {
        this.salemethod = salemethod;
    }
    public String getChkdate() {
        return chkdate;
    }

    public void setChkdate(String chkdate) {
        this.chkdate = chkdate;
    }
    public Integer getNo01() {
        return no01;
    }

    public void setNo01(Integer no01) {
        this.no01 = no01;
    }
    public Integer getNo02() {
        return no02;
    }

    public void setNo02(Integer no02) {
        this.no02 = no02;
    }
    public Integer getNo03() {
        return no03;
    }

    public void setNo03(Integer no03) {
        this.no03 = no03;
    }
    public Integer getNo04() {
        return no04;
    }

    public void setNo04(Integer no04) {
        this.no04 = no04;
    }
    public Integer getNo05() {
        return no05;
    }

    public void setNo05(Integer no05) {
        this.no05 = no05;
    }
    public Integer getNo06() {
        return no06;
    }

    public void setNo06(Integer no06) {
        this.no06 = no06;
    }
    public Integer getNo07() {
        return no07;
    }

    public void setNo07(Integer no07) {
        this.no07 = no07;
    }
    public Integer getNo08() {
        return no08;
    }

    public void setNo08(Integer no08) {
        this.no08 = no08;
    }
    public Integer getNo09() {
        return no09;
    }

    public void setNo09(Integer no09) {
        this.no09 = no09;
    }
    public Integer getNo10() {
        return no10;
    }

    public void setNo10(Integer no10) {
        this.no10 = no10;
    }
    public Integer getNo11() {
        return no11;
    }

    public void setNo11(Integer no11) {
        this.no11 = no11;
    }
    public Integer getNo12() {
        return no12;
    }

    public void setNo12(Integer no12) {
        this.no12 = no12;
    }
    public Date getLicenseinvalidate() {
        return licenseinvalidate;
    }

    public void setLicenseinvalidate(Date licenseinvalidate) {
        this.licenseinvalidate = licenseinvalidate;
    }
    public Date getLastsudate() {
        return lastsudate;
    }

    public void setLastsudate(Date lastsudate) {
        this.lastsudate = lastsudate;
    }
    public String getWtrange() {
        return wtrange;
    }

    public void setWtrange(String wtrange) {
        this.wtrange = wtrange;
    }
    public Integer getValidsuflag() {
        return validsuflag;
    }

    public void setValidsuflag(Integer validsuflag) {
        this.validsuflag = validsuflag;
    }
    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }
    public Date getLastcheckdate() {
        return lastcheckdate;
    }

    public void setLastcheckdate(Date lastcheckdate) {
        this.lastcheckdate = lastcheckdate;
    }
    public Date getLastsaledate() {
        return lastsaledate;
    }

    public void setLastsaledate(Date lastsaledate) {
        this.lastsaledate = lastsaledate;
    }
    public Long getCreatemanid() {
        return createmanid;
    }

    public void setCreatemanid(Long createmanid) {
        this.createmanid = createmanid;
    }
    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }
    public Long getAccmanid() {
        return accmanid;
    }

    public void setAccmanid(Long accmanid) {
        this.accmanid = accmanid;
    }
    public Date getAccdate() {
        return accdate;
    }

    public void setAccdate(Date accdate) {
        this.accdate = accdate;
    }
    public Integer getExceedsetflag() {
        return exceedsetflag;
    }

    public void setExceedsetflag(Integer exceedsetflag) {
        this.exceedsetflag = exceedsetflag;
    }
    public Date getLastsetdate() {
        return lastsetdate;
    }

    public void setLastsetdate(Date lastsetdate) {
        this.lastsetdate = lastsetdate;
    }
    public String getLastsetgood() {
        return lastsetgood;
    }

    public void setLastsetgood(String lastsetgood) {
        this.lastsetgood = lastsetgood;
    }
    public String getLastsetinvno() {
        return lastsetinvno;
    }

    public void setLastsetinvno(String lastsetinvno) {
        this.lastsetinvno = lastsetinvno;
    }
    public Long getLastsetdtlid() {
        return lastsetdtlid;
    }

    public void setLastsetdtlid(Long lastsetdtlid) {
        this.lastsetdtlid = lastsetdtlid;
    }
    public Integer getPicflag() {
        return picflag;
    }

    public void setPicflag(Integer picflag) {
        this.picflag = picflag;
    }
    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }
    public String getReturnmemo() {
        return returnmemo;
    }

    public void setReturnmemo(String returnmemo) {
        this.returnmemo = returnmemo;
    }
    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }
    public Long getSaleraccmanid() {
        return saleraccmanid;
    }

    public void setSaleraccmanid(Long saleraccmanid) {
        this.saleraccmanid = saleraccmanid;
    }
    public Date getSaleraccdate() {
        return saleraccdate;
    }

    public void setSaleraccdate(Date saleraccdate) {
        this.saleraccdate = saleraccdate;
    }
    public Integer getOverduestatus() {
        return overduestatus;
    }

    public void setOverduestatus(Integer overduestatus) {
        this.overduestatus = overduestatus;
    }
    public Integer getAttorneyflag() {
        return attorneyflag;
    }

    public void setAttorneyflag(Integer attorneyflag) {
        this.attorneyflag = attorneyflag;
    }
    public Integer getSpecialflag() {
        return specialflag;
    }

    public void setSpecialflag(Integer specialflag) {
        this.specialflag = specialflag;
    }
    public Integer getSecondflag() {
        return secondflag;
    }

    public void setSecondflag(Integer secondflag) {
        this.secondflag = secondflag;
    }
    public Integer getContractquanlifty() {
        return contractquanlifty;
    }

    public void setContractquanlifty(Integer contractquanlifty) {
        this.contractquanlifty = contractquanlifty;
    }
    public Long getLastmodimanid() {
        return lastmodimanid;
    }

    public void setLastmodimanid(Long lastmodimanid) {
        this.lastmodimanid = lastmodimanid;
    }
    public String getLastmodimanname() {
        return lastmodimanname;
    }

    public void setLastmodimanname(String lastmodimanname) {
        this.lastmodimanname = lastmodimanname;
    }
    public Date getLastmodidate() {
        return lastmodidate;
    }

    public void setLastmodidate(Date lastmodidate) {
        this.lastmodidate = lastmodidate;
    }
    public String getRepresentman() {
        return representman;
    }

    public void setRepresentman(String representman) {
        this.representman = representman;
    }
    public String getRepresentno() {
        return representno;
    }

    public void setRepresentno(String representno) {
        this.representno = representno;
    }

    @Override
    public String toString() {
        return "ZxSupplyLicense{" +
            "companyid=" + companyid +
            ", licenseid=" + licenseid +
            ", licensenam=" + licensenam +
            ", licensedtl=" + licensedtl +
            ", licensebegin=" + licensebegin +
            ", licenseend=" + licenseend +
            ", licenseno=" + licenseno +
            ", memo=" + memo +
            ", permitsale=" + permitsale +
            ", salemethod=" + salemethod +
            ", chkdate=" + chkdate +
            ", no01=" + no01 +
            ", no02=" + no02 +
            ", no03=" + no03 +
            ", no04=" + no04 +
            ", no05=" + no05 +
            ", no06=" + no06 +
            ", no07=" + no07 +
            ", no08=" + no08 +
            ", no09=" + no09 +
            ", no10=" + no10 +
            ", no11=" + no11 +
            ", no12=" + no12 +
            ", licenseinvalidate=" + licenseinvalidate +
            ", lastsudate=" + lastsudate +
            ", wtrange=" + wtrange +
            ", validsuflag=" + validsuflag +
            ", seqid=" + seqid +
            ", lastcheckdate=" + lastcheckdate +
            ", lastsaledate=" + lastsaledate +
            ", createmanid=" + createmanid +
            ", modidate=" + modidate +
            ", accmanid=" + accmanid +
            ", accdate=" + accdate +
            ", exceedsetflag=" + exceedsetflag +
            ", lastsetdate=" + lastsetdate +
            ", lastsetgood=" + lastsetgood +
            ", lastsetinvno=" + lastsetinvno +
            ", lastsetdtlid=" + lastsetdtlid +
            ", picflag=" + picflag +
            ", capital=" + capital +
            ", returnmemo=" + returnmemo +
            ", memo1=" + memo1 +
            ", saleraccmanid=" + saleraccmanid +
            ", saleraccdate=" + saleraccdate +
            ", overduestatus=" + overduestatus +
            ", attorneyflag=" + attorneyflag +
            ", specialflag=" + specialflag +
            ", secondflag=" + secondflag +
            ", contractquanlifty=" + contractquanlifty +
            ", lastmodimanid=" + lastmodimanid +
            ", lastmodimanname=" + lastmodimanname +
            ", lastmodidate=" + lastmodidate +
            ", representman=" + representman +
            ", representno=" + representno +
        "}";
    }
}
