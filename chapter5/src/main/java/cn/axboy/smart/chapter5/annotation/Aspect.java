package cn.axboy.smart.chapter5.annotation;

import java.lang.annotation.*;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/23 18:38
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Aspect {
    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
