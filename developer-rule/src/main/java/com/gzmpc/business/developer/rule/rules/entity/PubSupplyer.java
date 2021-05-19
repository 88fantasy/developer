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

@TableName("pub_supplyer")
public class PubSupplyer implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long supplyid;
	
	@TableField
	private String supplyopcode;
	
	@TableField
	private String supplyname;
	
	@TableField
	private Integer usestatus;
	
	@TableField
	private String no01;
	
	@TableField
	private String no05;

	public Long getSupplyid() {
		return supplyid;
	}

	public void setSupplyid(Long supplyid) {
		this.supplyid = supplyid;
	}

	public String getSupplyopcode() {
		return supplyopcode;
	}

	public void setSupplyopcode(String supplyopcode) {
		this.supplyopcode = supplyopcode;
	}

	public String getSupplyname() {
		return supplyname;
	}

	public void setSupplyname(String supplyname) {
		this.supplyname = supplyname;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	public String getNo01() {
		return no01;
	}

	public void setNo01(String no01) {
		this.no01 = no01;
	}

	public String getNo05() {
		return no05;
	}

	public void setNo05(String no05) {
		this.no05 = no05;
	}
	
}
