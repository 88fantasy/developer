package org.exframework.business.developer.portal.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.exframework.support.common.util.BeanUtils;
import org.exframework.support.jdbc.service.ExBaseService;
import org.exframework.support.rest.entity.ApiResponseData;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年6月10日 下午4:42:22
* 查询和获取
*/

public class QueryAndGetController<S extends ExBaseService<?,T>, D, T> extends QueryController<S, D, T> {


	@ApiOperation(value = "获取")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<?> getById(
			@ApiParam(value = "Id", required = true)  @PathVariable( value = "id", required = true) String id) {
			return new ApiResponseData<>(BeanUtils.copyTo(exBaseService.getById(id), entityClass));
	}
}
