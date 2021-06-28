package org.exframework.business.developer.portal.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author rwe
* @version 创建时间：Oct 16, 2020 10:46:37 AM
* 删除路由信息DTO
*/

@ApiModel(value = "删除路由信息DTO")
public class GatewayRouteDeleteDTO {

	@ApiModelProperty(value = "路由Id", required = true)
	@NotNull
	private List<String> ids;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}
