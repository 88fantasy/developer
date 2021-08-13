package org.exframework.business.developer.portal.listener;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccount;
import org.exframework.business.developer.portal.annotation.AutoCurrentAccountName;
import org.exframework.business.developer.portal.entity.User;
import org.exframework.business.developer.portal.service.DeveloperLoginService;
import org.exframework.support.common.util.SpringContextUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.function.Function;

/**
 * @author rwe
 * @version 创建时间：2021年5月21日 下午4:49:01
 * 自动设置当前登录帐号
 */

public class CurrentAccountMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        fill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        fill(metaObject);
    }

    private void fill(MetaObject metaObject) {
        setAccount(metaObject, AutoCurrentAccount.class, User::getAccount);
        setAccount(metaObject, AutoCurrentAccountName.class, User::getUserName);
    }

    private void setAccount(MetaObject metaObject, Class<? extends Annotation> clazz, Function<User, Object> func) {
        Object o = metaObject.getOriginalObject();
        ReflectionUtils.doWithFields(o.getClass(), field -> {
                    User current = SpringContextUtils.getBeanByClass(DeveloperLoginService.class).currentPerson();
                    Object val = func.apply(current);
                    setFieldValByName(field.getName(), val, metaObject);
                }
                , field -> field.isAnnotationPresent(clazz));
    }
}
