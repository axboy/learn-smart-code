package cn.axboy.smart.helper;

import cn.axboy.smart.annotation.RequestMapping;
import cn.axboy.smart.annotation.RequestMethod;
import cn.axboy.smart.bean.Handler;
import cn.axboy.smart.bean.Request;
import cn.axboy.smart.util.ArrayUtil;
import cn.axboy.smart.util.StringUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 12:27
 * 控制器助手类
 */
public final class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();

    static {
        //获取所有的Controller
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        controllerClassSet.forEach(controllerClass -> {
            String requestPath = "";
            //如果Controller上有RequestMapping
            if (controllerClass.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = controllerClass.getAnnotation(RequestMapping.class);
                if (StringUtil.isNotEmpty(requestMapping.value())) {
                    requestPath += requestMapping.value();
                }
            }
            //获取Controller中的所有方法
            Method[] methods = controllerClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    if (StringUtil.isNotEmpty(requestMapping.value()) &&
                            ArrayUtil.isNotEmpty(requestMapping.method())) {
                        RequestMethod[] requestMethods = requestMapping.method();
                        for (RequestMethod requestMethod : requestMethods) {
                            Request request = new Request(requestMethod, requestPath + requestMapping.value());
                            Handler handler = new Handler(controllerClass, method);
                            ACTION_MAP.put(request, handler);
                        }
                    }
                }
            }
        });
    }

    /**
     * 获取 Handler
     */
    public static Handler getHandler(RequestMethod requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
