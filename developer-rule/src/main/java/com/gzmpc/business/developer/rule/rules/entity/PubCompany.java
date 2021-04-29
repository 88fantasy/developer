package com.gzmpc.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午5:52:35
* 类说明
*/

@TableName("pub_company")
public class PubCompany implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long companyid;
	
	@TableField
	private String companyopcode;
	
	@TableField
	private String companyname;
	
	@TableField
	private Integer usestatus;

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getCompanyopcode() {
		return companyopcode;
	}

	public void setCompanyopcode(String companyopcode) {
		this.companyopcode = companyopcode;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	
}
