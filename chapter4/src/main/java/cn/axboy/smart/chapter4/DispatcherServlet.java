package cn.axboy.smart.chapter4;

import cn.axboy.smart.chapter4.annotation.RequestMethod;
import cn.axboy.smart.chapter4.bean.Data;
import cn.axboy.smart.chapter4.bean.Handler;
import cn.axboy.smart.chapter4.bean.Param;
import cn.axboy.smart.chapter4.bean.View;
import cn.axboy.smart.chapter4.helper.BeanHelper;
import cn.axboy.smart.chapter4.helper.ConfigHelper;
import cn.axboy.smart.chapter4.helper.ControllerHelper;
import cn.axboy.smart.chapter4.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestMethod requestMethod = RequestMethod.valueOf(req.getMethod().toUpperCase());
        String requestPath = req.getPathInfo();
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Method actionMethod = handler.getActionMethod();
            Object controllerBean = BeanHelper.getBean(controllerClass);

            Map<String, Object> paramMap = new HashMap<>();
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String key = parameterNames.nextElement();
                String value = req.getParameter(key);
                paramMap.put(key, value);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = body.split("&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = param.split("=");
                        if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                            paramMap.put(array[0], array[1]);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                        return;
                    }
                    Map<String, Object> model = view.getModel();
                    model.forEach((key, value) -> {
                        req.setAttribute(key, value);
                    });
                    req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
                }
            } else if (result instanceof Data) {
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter pw = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    pw.write(json);
                    pw.flush();
                    pw.close();
                }
            }
            return;
        }
        resp.setContentType("text/json; charset=UTF-8");
        resp.getOutputStream().write("404".getBytes("utf-8"));
    }
}
