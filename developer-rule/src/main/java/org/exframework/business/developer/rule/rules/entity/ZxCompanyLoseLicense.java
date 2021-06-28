package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjf
 * @since 2021-05-07
 */
public class ZxCompanyLoseLicense implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("COMPANYID")
    private Long companyid;

    @TableField("LICENSEID")
    private Integer licenseid;

    @TableField("FLAG")
    private Integer flag;

    @TableField("COMPANYFLAG")
    private Integer companyflag;

    @TableField("CHKDATE")
    private Date chkdate;

    @TableField("GOODSFLAG")
    private Integer goodsflag;

    public Long getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Long companyid) {
        this.companyid = companyid;
    }
    public Integer getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(Integer licenseid) {
        this.licenseid = licenseid;
    }
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    public Integer getCompanyflag() {
        return companyflag;
    }

    public void setCompanyflag(Integer companyflag) {
        this.companyflag = companyflag;
    }
    public Date getChkdate() {
        return chkdate;
    }

    public void setChkdate(Date chkdate) {
        this.chkdate = chkdate;
    }
    public Integer getGoodsflag() {
        return goodsflag;
    }

    public void setGoodsflag(Integer goodsflag) {
        this.goodsflag = goodsflag;
    }

    @Override
    public String toString() {
        return "ZxCompanyLoseLicense{" +
            "companyid=" + companyid +
            ", licenseid=" + licenseid +
            ", flag=" + flag +
            ", companyflag=" + companyflag +
            ", chkdate=" + chkdate +
            ", goodsflag=" + goodsflag +
        "}";
    }
}
