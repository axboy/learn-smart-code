package cn.axboy.smart.chapter4.proxy;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/23 18:09
 * 代理接口
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
