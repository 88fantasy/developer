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

@TableName("zx_license_to_goods")
public class ZxLicenseToGoods implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long rowsid;
	
	@TableField
	private Long licenseid;
	
	@TableField
	private String goodsno;
	
	@TableField
	private String ddlname;

	public Long getRowsid() {
		return rowsid;
	}

	public void setRowsid(Long rowsid) {
		this.rowsid = rowsid;
	}

	public Long getLicenseid() {
		return licenseid;
	}

	public void setLicenseid(Long licenseid) {
		this.licenseid = licenseid;
	}

	public String getGoodsno() {
		return goodsno;
	}

	public void setGoodsno(String goodsno) {
		this.goodsno = goodsno;
	}

	public String getDdlname() {
		return ddlname;
	}

	public void setDdlname(String ddlname) {
		this.ddlname = ddlname;
	}
}
