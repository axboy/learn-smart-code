package cn.axboy.smart.helper;

import cn.axboy.smart.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 15:23
 * bean助手类
 */
public final class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        beanClassSet.forEach(beanClass -> {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        });
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取 bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        Object bean = BEAN_MAP.get(cls);
        if (bean == null) {
            throw new RuntimeException("can not get bean by class: " + cls.getName());
        }
        return (T) bean;
    }

    /**
     * 设置 bean 实例
     */
    public static void setBean(Class<?> cls, Object bean) {
        BEAN_MAP.put(cls, bean);
    }
}
