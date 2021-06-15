package com.gzmpc.business.developer.portal.listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.ReflectionUtils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.gzmpc.business.developer.portal.annotation.AutoCurrentAccount;
import com.gzmpc.business.developer.portal.entity.DeveloperAccount;
import com.gzmpc.business.developer.portal.service.DeveloperLoginService;
import com.gzmpc.support.common.util.SpringContextUtils;

/**
* @author rwe
* @version 创建时间：2021年5月21日 下午4:49:01
* 自动设置当前登录帐号
*/

public class CurrentAccountMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		setAccount(metaObject, AutoCurrentAccount.class);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		setAccount(metaObject, AutoCurrentAccount.class);
	}

	private void setAccount(MetaObject metaObject, Class<? extends Annotation> clazz) {
		Object o = metaObject.getOriginalObject();
		ReflectionUtils.doWithFields(o.getClass(), new ReflectionUtils.FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
//				ReflectionUtils.makeAccessible(field);
				DeveloperAccount account = SpringContextUtils.getBeanByClass(DeveloperLoginService.class).currentPerson();
				setFieldValByName(field.getName(), account.getAccount(),metaObject);
			}
		}, new ReflectionUtils.FieldFilter() {
			@Override
			public boolean matches(Field field) {
				return field.isAnnotationPresent(clazz);
			}
		});
	}
}
