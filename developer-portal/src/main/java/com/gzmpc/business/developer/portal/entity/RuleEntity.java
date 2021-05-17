package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.gzmpc.portal.metadata.dict.Dictionary;
import com.gzmpc.portal.metadata.dict.DictionaryEnum;
import com.gzmpc.portal.metadata.dict.DictionaryEnumClass;
import com.gzmpc.portal.metadata.entity.EntityClass;

/**
 * @author rwe
 * @version 创建时间：2021年4月25日 下午1:43:28 
 * 规则
 */

@EntityClass
@TableName(value = "rule", autoResultMap = true)
public class RuleEntity implements Serializable, DictionaryEnumClass {

	private static final long serialVersionUID = 1164183277078920803L;

	/**
	 * 代码
	 */
	@TableId(type = IdType.INPUT)
	private String code;

	/**
	 * 名称
	 */
	@TableField
	private String name;

	/**
	 * 描述
	 */
	@TableField
	@ColumnType(value = MySqlTypeConstant.TEXT)
	private String description;

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

	/**
	 * 优先级
	 */
	@TableField
	private Integer priority;

	/**
	 * 类型
	 */
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private RuleType type;

	/**
	 * 条件表达式(SPEL或MVEL)
	 */
	@TableField
	@ColumnType(value = MySqlTypeConstant.TEXT)
	private String expression;

	/**
	 * 执行代码(SPEL或MVEL)
	 */
	@TableField(typeHandler = FastjsonTypeHandler.class)
	@ColumnType(value = MySqlTypeConstant.JSON)
	private List<String> action;
	

	public RuleEntity() {

	}

	public RuleEntity(String code, String name, String description, Integer priority, RuleType type) {
		this(code, name, description, priority, type, null, null);
	}

	public RuleEntity(String code, String name, String description, Integer priority, RuleType type, String expression,
			List<String> action) {
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

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<String> getAction() {
		return action;
	}

	public void setAction(List<String> action) {
		this.action = action;
	}

	@Dictionary(value = "ruleType", name = "规则类型")
	public enum RuleType implements DictionaryEnum {

		/**
		 * 程序规则
		 */
		CODE("程序规则"),

		/**
		 * Spring 表达式
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

	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends DictionaryEnum>[] enums() {
		return new Class[] { RuleType.class };
	}
}
