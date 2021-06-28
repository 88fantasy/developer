package org.exframework.business.developer.rule.rules.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月25日 上午8:51:13
* PubCompanyLicense
*/

@TableName("pub_company_license")
public class PubCompanyLicense {

	@TableField
	private Long companyid;
	
	@TableField
	private Long licenseid;
	
	@TableField
	private String licensedtl;
	
	@TableField
	private Date licensebegin;
	
	@TableField
	private Date licenseend;
	
	@TableField
	private Date licenseinvalidate;

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public Long getLicenseid() {
		return licenseid;
	}

	public void setLicenseid(Long licenseid) {
		this.licenseid = licenseid;
	}

	public String getLicensedtl() {
		return licensedtl;
	}

	public void setLicensedtl(String licensedtl) {
		this.licensedtl = licensedtl;
	}

	public Date getLicensebegin() {
		return licensebegin;
	}

	public void setLicensebegin(Date licensebegin) {
		this.licensebegin = licensebegin;
	}

	public Date getLicenseend() {
		return licenseend;
	}

	public void setLicenseend(Date licenseend) {
		this.licenseend = licenseend;
	}

	public Date getLicenseinvalidate() {
		return licenseinvalidate;
	}

	public void setLicenseinvalidate(Date licenseinvalidate) {
		this.licenseinvalidate = licenseinvalidate;
	}

}
