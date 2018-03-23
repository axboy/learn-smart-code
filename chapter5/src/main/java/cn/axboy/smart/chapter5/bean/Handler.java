package cn.axboy.smart.chapter5.bean;

import java.lang.reflect.Method;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 12:29
 */
public class Handler {
    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * Action 方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
