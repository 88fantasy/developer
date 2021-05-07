package com.gzmpc.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年4月24日 下午5:52:35
* 类说明
*/

@TableName("zx_supplyer_controlmsg")
public class PubSupplyerControlMsg implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long supplyid;
	
	@TableField
	private String msgcontent;
	
	@TableField
	private boolean controlflag;

	public Long getSupplyid() {
		return supplyid;
	}

	public void setSupplyid(Long supplyid) {
		this.supplyid = supplyid;
	}

	public String getMsgcontent() {
		return msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

	public boolean isControlflag() {
		return controlflag;
	}

	public void setControlflag(boolean controlflag) {
		this.controlflag = controlflag;
	}
}
