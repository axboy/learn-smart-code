package cn.axboy.smart.chapter5.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/23 18:16
 * 切面代理
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public final Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure", e);
            error(cls, method, params, e);
            throw e;
        } finally {
            end();
        }
        return result;
    }

    protected void begin() {
    }

    protected boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    protected void before(Class<?> cls, Method method, Object[] params) {
    }

    protected void after(Class<?> cls, Method method, Object[] params, Object result) {
    }

    protected void error(Class<?> cls, Method method, Object[] params, Throwable e) {
    }

    protected void end() {
    }
}