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

@TableName("zx_jj_goods_msg")
public class ZxCutPriceGoodsMsg implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long goodsid;
	
	@TableField
	private String salemsg;
	
	@TableField
	private String sumsg;

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getSalemsg() {
		return salemsg;
	}

	public void setSalemsg(String salemsg) {
		this.salemsg = salemsg;
	}

	public String getSumsg() {
		return sumsg;
	}

	public void setSumsg(String sumsg) {
		this.sumsg = sumsg;
	}
}
