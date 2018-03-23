package cn.axboy.smart.chapter4.annotation;

import java.lang.annotation.*;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:29
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inject {
}
