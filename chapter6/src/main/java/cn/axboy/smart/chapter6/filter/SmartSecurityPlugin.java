package cn.axboy.smart.chapter6.filter;

import org.apache.shiro.web.env.EnvironmentLoaderListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/18 00:09
 */
public class SmartSecurityPlugin implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("shiroConfigLocations", "class-path:smart-security.ini");
        servletContext.addListener(EnvironmentLoaderListener.class);
        FilterRegistration.Dynamic smartFilter = servletContext.addFilter("smartFilter", SmartSecurityFilter.class);
        smartFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
