package com.gzmpc.business.developer.portal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

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
* @version 创建时间：2021年5月18日 下午5:35:27
* 类说明
*/

@TableName(value = "rule_instance", autoResultMap = true)
@EntityClass
public class RuleInstance  implements Serializable, DictionaryEnumClass {

	private static final long serialVersionUID = -1670268842529871692L;

	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	
	@TableField
	private Long packageInstanceId;
	
	@TableField
	private String name;
	
	@TableField
	private String description;
	
	@TableField
	private Integer priority;
	
	@TableField
	@EnumValue
	@ColumnType(value = MySqlTypeConstant.VARCHAR)
	private RuleStatus status;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date startTime;
	
	@TableField
	@ColumnType(value = MySqlTypeConstant.DATETIME)
	private Date endTime;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	@ColumnType(value = MySqlTypeConstant.JSON)
	private Map<String,Object> input;
	
	@TableField(typeHandler = FastjsonTypeHandler.class)
	@ColumnType(value = MySqlTypeConstant.JSON)
	private Map<String,Object> output;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPackageInstanceId() {
		return packageInstanceId;
	}

	public void setPackageInstanceId(Long packageInstanceId) {
		this.packageInstanceId = packageInstanceId;
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
	
	@Dictionary( value = "accountDataSource", name = "帐号来源")
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
