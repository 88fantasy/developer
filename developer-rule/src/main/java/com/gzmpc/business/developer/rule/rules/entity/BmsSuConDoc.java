package com.gzmpc.business.developer.rule.rules.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年5月10日 下午5:52:35
* 类说明
*/

@TableName("bms_su_con_doc")
public class BmsSuConDoc implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long supplyid;
	
	@TableField
	private Long suconid;
	
	@TableField
	private String suconno;
	
	@TableField
	private Date signdate;

	public Long getSupplyid() {
		return supplyid;
	}

	public void setSupplyid(Long supplyid) {
		this.supplyid = supplyid;
	}

	public Long getSuconid() {
		return suconid;
	}
	
	public String getSuconno() {
		return suconno;
	}

	public void setSuconno(String suconno) {
		this.suconno = suconno;
	}

	public void setSuconid(Long suconid) {
		this.suconid = suconid;
	}

	public Date getSigndate() {
		return signdate;
	}

	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
}
