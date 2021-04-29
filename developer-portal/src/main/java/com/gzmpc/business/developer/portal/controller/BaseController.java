package com.gzmpc.business.developer.portal.controller;

import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.gzmpc.portal.web.dto.PostConditionQueryRequest;
import com.gzmpc.support.common.util.BeanUtils;
import com.gzmpc.support.jdbc.service.ExBaseService;
import com.gzmpc.support.rest.entity.ApiResponseData;
import com.gzmpc.support.rest.entity.ApiResponsePage;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年3月30日 上午12:17:11
* 类说明
 * @param <T>
 * @param <M>
*/

public class BaseController<S extends ExBaseService<?,T>, D, T> {

	@Autowired
	protected S exBaseService;
	
	protected Class<D> entityClass = currentModelClass();

	@SuppressWarnings("unchecked")
	private Class<D> currentModelClass() {
		 return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
	}
	
	@ApiOperation(value = "获取")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponseData<?> getById(
			@ApiParam(value = "Id", required = true)  @PathVariable( value = "id", required = true) String id) {
			return new ApiResponseData<>(BeanUtils.copyTo(exBaseService.getById(id), entityClass));
	}
	
	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApiResponsePage<?> query(@ApiParam(value = "查询dto")@Valid @RequestBody(required = true) PostConditionQueryRequest request) {
		return new ApiResponsePage<>(exBaseService.getBaseMapper().query(request.getConditions(), request.getPage(), getTranslator(), entityClass));
	}
	
	public Function<T,D> getTranslator() {
		return exBaseService.getBaseMapper().getTranslator(entityClass);
	}
}
