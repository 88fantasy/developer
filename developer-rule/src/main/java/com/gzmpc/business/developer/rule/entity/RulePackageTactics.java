package com.gzmpc.business.developer.rule.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午2:21:57
* 类说明
*/

@TableName("rule_package_tactics")
public class RulePackageTactics implements Serializable {

	private static final long serialVersionUID = -4671972524474974829L;

	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	
	@TableField
	private String packageCode;
	
	@TableField
	private String ruleCode;
	
	@TableField
	private Integer priority;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
