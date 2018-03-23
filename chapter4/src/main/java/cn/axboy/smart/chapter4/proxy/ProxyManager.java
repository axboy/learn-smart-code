package cn.axboy.smart.chapter4.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/23 18:16
 */
public class ProxyManager {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                ProxyChain proxyChain = new ProxyChain(targetClass, target, method, args, methodProxy, proxyList);
                proxyChain.doProxyChain();
                return proxyChain.getMethodResult();
            }
        });
    }
}
