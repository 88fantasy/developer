package com.gzmpc.business.developer.portal.dependency;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.gzmpc.portal.metadata.dict.Dictionary;
import com.gzmpc.portal.metadata.dict.DictionaryEnum;
import com.gzmpc.portal.metadata.dict.DictionaryEnumClass;
import com.gzmpc.portal.metadata.entity.EntityClass;

/**
* @author rwe
* @version 创建时间：2021年4月28日 下午2:16:37
* 规则运算实例
*/

@EntityClass
@TableName( value = "rule_package_instance", autoResultMap = true)
public class RulePackageInstance implements Serializable, DictionaryEnumClass {
	
	private static final long serialVersionUID = 2855509679952227823L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	
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
	private RuleStatus status;
	
	@TableField
	private Date startTime;
	
	@TableField
	private Date endTime;
	
	@TableField
	private String ip;
	
	@TableField
	private String sourceId;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	private Map<String,Object> input;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	private Map<String,Object> output;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Map<String, Object> getInput() {
		return input;
	}

	public void setInput(Map<String, Object> input) {
		this.input = input;
	}

	public Map<String, Object> getOutput() {
		return output;
	}

	public void setOutput(Map<String, Object> output) {
		this.output = output;
	}

	@Dictionary( value = "ruleStatus", name = "规则实例状态")
	public enum RuleStatus implements DictionaryEnum {

		/**
		 *  开始
		 */
		START("开始"),
		
		/**
		 * 不执行
		 */
		NEEDNOT("不执行"),

		/**
		 * 进行中
		 */
		PROCESSING("进行中"),

		/**
		 * 完成
		 */
		FINISHED("完成"),
		
		/**
		 * 失败
		 */
		FAILED("失败"),

		;

		private String label;

		private RuleStatus(String label) {
				this.label = label;
			}

		public String getLabel() {
			return label;
		}

	}

	@Override
	public Class<? extends DictionaryEnum>[] enums() {
		return new Class[] {RuleStatus.class};
	}
	

}