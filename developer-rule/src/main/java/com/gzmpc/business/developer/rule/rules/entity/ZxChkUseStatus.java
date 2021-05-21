package com.gzmpc.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午5:52:35
* 类说明
*/

@TableName("zx_chkusestatus")
public class ZxChkUseStatus implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long opid;
	
	@TableField
	private Integer usestatus;
	
	@TableField
	private String field;
	
	@TableField
	private String actmsg;
	
	@TableField
	private Integer retcode;

	public Long getOpid() {
		return opid;
	}

	public void setOpid(Long opid) {
		this.opid = opid;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getActmsg() {
		return actmsg;
	}

	public void setActmsg(String actmsg) {
		this.actmsg = actmsg;
	}

	public Integer getRetcode() {
		return retcode;
	}

	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}
}
