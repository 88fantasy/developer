package com.gzmpc.business.developer.portal.entity;


import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;


/**
 * @author rwe
 * @version 创建时间：2021年4月19日 上午11:22:04 
 * LDAP帐号
 */

@Entry(base = "ou=user,dc=gzmpc,dc=com",objectClasses="Developer")
public class Person {

	@Id
	private Name id;
	
	@Attribute(name = "uid")
	private String uid;
	
	@DnAttribute(value = "cn")
	private String commonName;
	
	@Attribute(name = "sn")
	private String suerName;
	
	@Attribute(name = "mail")
	private String mail;
	
	@Attribute(name = "description")
	private String description;
	
	@Attribute(name = "userPassword")
	private String userPassword;

	public Name getId() {
		return id;
	}

	public void setId(Name id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getSuerName() {
		return suerName;
	}

	public void setSuerName(String suerName) {
		this.suerName = suerName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
