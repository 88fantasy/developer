package com.gzmpc.business.developer.rule.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.business.developer.rule.enums.RuleStatus;

/**
* @author rwe
* @version 创建时间：2021年4月28日 下午2:16:37
* 规则运算实例
*/
@TableName("rule_package_instance")
public class RulePackageInstance {
	
	private static final long serialVersionUID = 2855509679952227823L;

	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	
	@TableField
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
	
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private RuleStatus status;
	
	@TableField
	private Date startTime;
	
	@TableField
	private Date endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public RuleStatus getStatus() {
		return status;
	}

	public void setStatus(RuleStatus status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

}
