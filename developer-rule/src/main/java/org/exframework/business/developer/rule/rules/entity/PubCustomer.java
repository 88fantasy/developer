package org.exframework.business.developer.rule.rules.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月24日 下午5:52:35
* 类说明
*/

@TableName("pub_customer")
public class PubCustomer implements Serializable {

	private static final long serialVersionUID = 6713841030463877990L;

	@TableId
	private Long customid;
	
	@TableField
	private String customopcode;
	
	@TableField
	private String customname;
	
	@TableField
	private Integer usestatus;
	
	@TableField
	private String no01;

	public Long getCustomid() {
		return customid;
	}

	public void setCustomid(Long customid) {
		this.customid = customid;
	}
	
	public String getNo01() {
		return no01;
	}

	public void setNo01(String no01) {
		this.no01 = no01;
	}

	public String getCustomopcode() {
		return customopcode;
	}

	public void setCustomopcode(String customopcode) {
		this.customopcode = customopcode;
	}

	public String getCustomname() {
		return customname;
	}

	public void setCustomname(String customname) {
		this.customname = customname;
	}

	public Integer getUsestatus() {
		return usestatus;
	}

	public void setUsestatus(Integer usestatus) {
		this.usestatus = usestatus;
	}

	
	
}
