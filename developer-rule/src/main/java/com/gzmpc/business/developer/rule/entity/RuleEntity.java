package com.gzmpc.business.developer.rule.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
* @author rwe
* @version 创建时间：2021年4月25日 下午1:43:28
* 规则
*/

@TableName("rule")
public class RuleEntity implements Serializable {

	private static final long serialVersionUID = 1164183277078920803L;

	@TableId(type = IdType.INPUT)
	private String code;
	
	@TableField
	private String name;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.TEXT)
	private String description;
	
	@TableField
	private Integer priority;
	
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private RuleType type;
	
	/**
	 * 输入
	 */
	@TableField
	private String input;
	
	/**
	 * 输出
	 */
	@TableField
	private String output;
	
	/**
	 * 标签
	 */
	@TableField
	private String tags;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.TEXT)
	private String expression;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.TEXT)
	private String action;
	
	public RuleEntity() {
	}


	public RuleEntity(String code, String name, String description, Integer priority, RuleType type) {
		this(code, name, description, priority, type, null, null);
	}


	public RuleEntity(String code, String name, String description, Integer priority, RuleType type, String expression, String action) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.type = type;
		this.expression = expression;
		this.action = action;
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


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public RuleType getType() {
		return type;
	}


	public void setType(RuleType type) {
		this.type = type;
	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}


	public String getOutput() {
		return output;
	}


	public void setOutput(String output) {
		this.output = output;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public String getExpression() {
		return expression;
	}


	public void setExpression(String expression) {
		this.expression = expression;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public enum RuleType {

		/**
		 *  程序规则
		 */
		CODE("程序规则"),

		/**
		 *  Spring 表达式
		 */
		SPEL("Spring 表达式"),
		
		/**
		 * MVEL 表达式
		 */
		MVEL("MVEL 表达式"),
		
		/**
		 * 组合规则
		 */
		GROUP("组合规则")

		;

		private String label;

		private RuleType(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

	}
}
