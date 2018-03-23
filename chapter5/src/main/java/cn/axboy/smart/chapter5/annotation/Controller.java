package cn.axboy.smart.chapter5.annotation;

import java.lang.annotation.*;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:32
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {
}
