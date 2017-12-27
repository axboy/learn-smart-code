package cn.axboy.smart.aspect;

import cn.axboy.smart.annotation.Aspect;
import cn.axboy.smart.annotation.Controller;
import cn.axboy.smart.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/27 17:22
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private Long begin;

    @Override
    protected void begin() {
        begin = System.currentTimeMillis();
    }

    @Override
    protected void after(Class<?> cls, Method method, Object[] params, Object result) {
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
    }
}
