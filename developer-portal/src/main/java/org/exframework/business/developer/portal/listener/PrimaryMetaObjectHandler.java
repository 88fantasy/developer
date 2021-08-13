package org.exframework.business.developer.portal.listener;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.exframework.support.jdbc.listener.CurrentTimeMetaObjectHandler;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author rwe
 * @version 创建时间：2021年5月21日 下午5:02:36 类说明
 */

@Component
public class PrimaryMetaObjectHandler implements MetaObjectHandler {

    private MetaObjectHandler[] handlers = new MetaObjectHandler[]{new CurrentTimeMetaObjectHandler(),
            new CurrentAccountMetaObjectHandler()};

    @Override
    public void insertFill(MetaObject metaObject) {
        Arrays.stream(handlers).forEach(o -> o.insertFill(metaObject));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Arrays.stream(handlers).forEach(o -> o.updateFill(metaObject));
    }

}
