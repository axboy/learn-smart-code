package cn.axboy.smart.chapter6.filter;

import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/18 00:16
 */
public class SmartSecurityFilter extends ShiroFilter {

    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager manager = super.getSecurityManager();
        setRealms(manager);
        setCache(manager);
    }

    private void setRealms(WebSecurityManager manager) {
        //todo
    }

    private void setCache(WebSecurityManager manager) {
        //todo
    }
}
