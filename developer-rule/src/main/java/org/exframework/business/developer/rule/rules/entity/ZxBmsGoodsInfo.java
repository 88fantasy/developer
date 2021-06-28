package org.exframework.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年5月11日 下午5:52:35
* 类说明
*/

@TableName("zx_bms_goods_info")
public class ZxBmsGoodsInfo implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long goodsid;
	
	@TableField
	private boolean spj24;
	
	@TableField
	private boolean slzm24;
	
	@TableField
	private Integer flag;

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public boolean isSpj24() {
		return spj24;
	}

	public void setSpj24(boolean spj24) {
		this.spj24 = spj24;
	}

	public boolean isSlzm24() {
		return slzm24;
	}

	public void setSlzm24(boolean slzm24) {
		this.slzm24 = slzm24;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
