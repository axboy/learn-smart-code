package cn.axboy.smart.chapter3.annotation;

import java.lang.annotation.*;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
