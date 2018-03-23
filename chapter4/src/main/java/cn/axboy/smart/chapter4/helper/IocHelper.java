package cn.axboy.smart.chapter4.helper;

import cn.axboy.smart.chapter4.annotation.Inject;
import cn.axboy.smart.chapter4.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 15:51
 * 依赖注入助手类
 */
public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        beanMap.forEach((Class<?> beanClass, Object beanInstance) -> {
            Field[] beanFields = beanClass.getDeclaredFields();
            for (Field beanField : beanFields) {
                if (beanField.isAnnotationPresent(Inject.class)) {
                    Class<?> beanFieldClass = beanField.getType();
                    Object beanFieldInstance = beanMap.get(beanFieldClass);
                    if (beanFieldInstance != null) {
                        ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                    }
                }
            }
        });
    }
}
