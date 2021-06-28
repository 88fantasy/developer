package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月25日 上午9:14:05
* PubDdl
*/

@TableName("pub_company_license")
public class PubDdl {

	@TableField
	private Long ddlid;
	
	@TableField
	private String ddlname;
	
	@TableField
	private String keyword;

	public Long getDdlid() {
		return ddlid;
	}

	public void setDdlid(Long ddlid) {
		this.ddlid = ddlid;
	}

	public String getDdlname() {
		return ddlname;
	}

	public void setDdlname(String ddlname) {
		this.ddlname = ddlname;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
