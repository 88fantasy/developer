package org.exframework.business.developer.rule.rules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author dhx
* @version 创建时间：2021年4月25日 上午9:14:05
* PubDdl
*/

@TableName("zx_company_jyfw")
public class ZxManageRange {

	@TableField
	private Long jyfwid;
	
	@TableField
	private Long companyid;
	
	@TableField
	private String jyfw;
	
	@TableField
	private String no01;

	public Long getJyfwid() {
		return jyfwid;
	}

	public void setJyfwid(Long jyfwid) {
		this.jyfwid = jyfwid;
	}

	public String getJyfw() {
		return jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getNo01() {
		return no01;
	}

	public void setNo01(String no01) {
		this.no01 = no01;
	}
}
