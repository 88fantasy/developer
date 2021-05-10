package com.gzmpc.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年5月10日 下午5:52:35
* 类说明
*/

@TableName("bms_su_con_dtl")
public class BmsSuConDtl implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long goodsid;
	
	@TableField
	private Long suconid;
	
	@TableField
	private String realrgcompany;
	
	@TableField
	private Long wtps_dtlid;

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getSuconid() {
		return suconid;
	}

	public void setSuconid(Long suconid) {
		this.suconid = suconid;
	}

	public String getRealrgcompany() {
		return realrgcompany;
	}

	public void setRealrgcompany(String realrgcompany) {
		this.realrgcompany = realrgcompany;
	}

	public Long getWtps_dtlid() {
		return wtps_dtlid;
	}

	public void setWtps_dtlid(Long wtps_dtlid) {
		this.wtps_dtlid = wtps_dtlid;
	}
}
