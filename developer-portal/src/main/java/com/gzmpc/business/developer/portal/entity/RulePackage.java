package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.business.developer.portal.annotation.AutoCurrentAccount;
import com.gzmpc.support.jdbc.annotation.AutoCreateTime;
import com.gzmpc.support.jdbc.annotation.AutoUpdateTime;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午1:37:29
* 规则包
*/

@TableName(value = "rule_package", autoResultMap = true)
public class RulePackage implements Serializable {

	private static final long serialVersionUID = 1043835579030499358L;
	
	@TableId(type = IdType.INPUT)
	private String code;
	
	@TableField
	private String name;
	
	@TableField
	private String description;
	
	@TableField
	private Boolean skipOnFirstAppliedRule;
	
	@TableField
	private Boolean skipOnFirstFailedRule;
	
	@TableField
	private Boolean skipOnFirstNonTriggeredRule;
	
	@TableField
	private Integer rulePriorityThreshold;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	@ColumnType(value = MySqlTypeConstant.JSON)
	private List<String> tactics;
	
	@AutoCurrentAccount
	@TableField(fill = FieldFill.INSERT)
	private String creator;
	
	@AutoCreateTime
	@TableField(fill = FieldFill.INSERT)
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date createTime;
	
	@AutoCurrentAccount
	@TableField(fill = FieldFill.UPDATE)
	private String updator;
	
	@AutoUpdateTime
	@TableField(fill = FieldFill.UPDATE)
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date updateTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSkipOnFirstAppliedRule() {
		return skipOnFirstAppliedRule;
	}

	public void setSkipOnFirstAppliedRule(Boolean skipOnFirstAppliedRule) {
		this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
	}

	public Boolean getSkipOnFirstFailedRule() {
		return skipOnFirstFailedRule;
	}

	public void setSkipOnFirstFailedRule(Boolean skipOnFirstFailedRule) {
		this.skipOnFirstFailedRule = skipOnFirstFailedRule;
	}

	public Boolean getSkipOnFirstNonTriggeredRule() {
		return skipOnFirstNonTriggeredRule;
	}

	public void setSkipOnFirstNonTriggeredRule(Boolean skipOnFirstNonTriggeredRule) {
		this.skipOnFirstNonTriggeredRule = skipOnFirstNonTriggeredRule;
	}

	public Integer getRulePriorityThreshold() {
		return rulePriorityThreshold;
	}

	public void setRulePriorityThreshold(Integer rulePriorityThreshold) {
		this.rulePriorityThreshold = rulePriorityThreshold;
	}
	
	public List<String> getTactics() {
		return tactics == null ? new ArrayList<>() : tactics;
	}

	public void setTactics(List<String> tactics) {
		this.tactics = tactics == null ? new ArrayList<>() : tactics;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
