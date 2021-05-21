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

@TableName("pub_goods")
public class PubGoods implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long goodsid;
	
	@TableField
	private String opcode;
	
	@TableField
	private String goodsname;
	
	@TableField
	private boolean usestatus;
	
	@TableField
	private String no01;

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public boolean isUsestatus() {
		return usestatus;
	}

	public void setUsestatus(boolean usestatus) {
		this.usestatus = usestatus;
	}

	public String getNo01() {
		return no01;
	}

	public void setNo01(String no01) {
		this.no01 = no01;
	}
}
