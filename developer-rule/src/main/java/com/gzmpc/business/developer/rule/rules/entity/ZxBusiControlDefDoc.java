package com.gzmpc.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author dhx
 * @since 2021-05-11
 */
@TableName("ZX_BUSICONTROL_DEF_DOC")
public class ZxBusiControlDefDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId
	private Long opid;
	
	@TableField
	private String columnname;
	
	@TableField
	private Integer controlflag;
	
	@TableField
	private String jyfwmsg;
	
	@TableField
	private String msg;
	
	@TableField
	private Integer optype;
	
	@TableField
	private Integer companytype;
	
	@TableField
	private Long approvemanid;

	public Long getOpid() {
		return opid;
	}

	public void setOpid(Long opid) {
		this.opid = opid;
	}

	public String getColumnname() {
		return columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public String getJyfwmsg() {
		return jyfwmsg;
	}

	public void setJyfwmsg(String jyfwmsg) {
		this.jyfwmsg = jyfwmsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getOptype() {
		return optype;
	}

	public void setOptype(Integer optype) {
		this.optype = optype;
	}
	
	public Long getApprovemanid() {
		return approvemanid;
	}

	public void setApprovemanid(Long approvemanid) {
		this.approvemanid = approvemanid;
	}

	public Integer getControlflag() {
		return controlflag;
	}

	public void setControlflag(Integer controlflag) {
		this.controlflag = controlflag;
	}

	public Integer getCompanytype() {
		return companytype;
	}

	public void setCompanytype(Integer companytype) {
		this.companytype = companytype;
	}
}
