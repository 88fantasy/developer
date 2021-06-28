package org.exframework.business.developer.core.dto;

import javax.validation.constraints.NotNull;

import org.exframework.business.developer.common.dto.GlobalDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 16, 2020 11:08:52 AM
* 元数据基类 DTO
*/

@ApiModel(value = "元数据基类DTO")
public class MetaDataDTO extends GlobalDTO {

	/**
	 * 代码
	 */
	@ApiModelProperty(value = "代码", required = true)
	@NotNull
	private String code;
	
	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称", required = true)
	@NotNull
	private String name;
	
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注", required = true)
	@NotNull
	private String comment;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
