package cn.axboy.smart;

import cn.axboy.smart.annotation.RequestMethod;
import cn.axboy.smart.bean.Handler;
import cn.axboy.smart.helper.BeanHelper;
import cn.axboy.smart.helper.ControllerHelper;
import cn.axboy.smart.helper.ServletHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 12:24
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        HelperLoader.initHelper();
        ServletContext context = config.getServletContext();
//        registerServlet(servletContext);
//        UploadHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletHelper.init(req, resp);

        RequestMethod requestMethod = RequestMethod.valueOf(req.getMethod().toUpperCase());
        String requestPath = req.getPathInfo();
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Method actionMethod = handler.getActionMethod();
            Object controllerBean = BeanHelper.getBean(controllerClass);

        }
    }
}
