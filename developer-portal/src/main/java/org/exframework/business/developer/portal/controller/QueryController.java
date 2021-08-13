package org.exframework.business.developer.portal.controller;

import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import org.exframework.portal.web.dto.PostConditionQueryRequest;
import org.exframework.support.jdbc.service.ExBaseService;
import org.exframework.support.rest.entity.ApiResponsePage;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* @author rwe
* @version 创建时间：2021年3月30日 上午12:17:11
* 类说明
 * @param <T>
 * @param <S>
 * @param <D>
*/

public class QueryController<S extends ExBaseService<?,T>, D, T> {

	@Autowired
	protected S exBaseService;
	
	protected Class<D> entityClass = currentModelClass();

	@SuppressWarnings("unchecked")
	private Class<D> currentModelClass() {
		 return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), QueryController.class, 1);
	}
	
	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponsePage<?> query(@ApiParam(value = "查询dto")@Valid @RequestBody PostConditionQueryRequest request) {
		return new ApiResponsePage<>(exBaseService.getBaseMapper().query(request.getConditions(), request.getPage(), getTranslator(), entityClass));
	}
	
	public Function<T,D> getTranslator() {
		return exBaseService.getBaseMapper().getTranslator(entityClass);
	}
}
