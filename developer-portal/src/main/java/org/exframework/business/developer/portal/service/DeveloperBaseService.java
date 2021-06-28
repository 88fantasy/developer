package org.exframework.business.developer.portal.service;

import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.exframework.support.jdbc.mapper.ExBaseMapper;
import org.exframework.support.jdbc.service.ExBaseService;

/**
 * @author rwe
 * @version 创建时间：2021年3月27日 上午11:03:35 
 * 基础 CRUD 服务
 */

public class DeveloperBaseService<M extends ExBaseMapper<T>, T> extends ExBaseService<M, T> {

	@Autowired
	protected M baseMapper;

	@Override
	public M getBaseMapper() {
		return baseMapper;
	}

	protected Class<T> entityClass = currentModelClass();

	@Override
	public Class<T> getEntityClass() {
		return entityClass;
	}

	protected Class<M> mapperClass = currentMapperClass();

	
	public boolean saveOrUpdateDTO(Object dto) {
		return saveOrUpdateDTO(dto, null);
	}
	
	public boolean saveOrUpdateDTO(Object dto, Function<Object,T> translate) {
		return saveOrUpdateDTO(dto, translate, null);
	}
	
	public boolean saveOrUpdateDTO(Object dto, Function<Object,T> translate, Consumer<T> after) {
		T t = BeanUtils.instantiateClass(entityClass);
		if(translate != null) {
			t = translate.apply(dto);
		}
		else {
			BeanUtils.copyProperties(dto, t);
		}
		return saveOrUpdateBeforeAndAfter(t, null, null, after);
	}
}
