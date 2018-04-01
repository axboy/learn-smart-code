package cn.axboy.smart.chapter5.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/4/2 01:34
 */
public final class ServletHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletHelper.class);

    private static final ThreadLocal<ServletHelper> holder = new ThreadLocal<>();

    private HttpServletRequest request;

    private HttpServletResponse response;

    private ServletHelper(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static void init(HttpServletRequest request, HttpServletResponse response) {
        holder.set(new ServletHelper(request, response));
    }

    public static void destory() {
        holder.remove();
    }

    private static HttpServletRequest getRequest() {
        return holder.get().request;
    }

    private static HttpServletResponse getResponse() {
        return holder.get().response;
    }

    private static HttpSession getSession() {
        return getRequest().getSession();
    }

    private static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }


    public static void setRequestAttribute(String key, Object value) {
        getRequest().setAttribute(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getRequestAttribute(String key) {
        return (T) getRequest().getAttribute(key);
    }

    public static void removeRequestAttribute(String key) {
        getRequest().removeAttribute(key);
    }

    public static void sendRedirect(String location) {
        try {
            getResponse().sendRedirect(getRequest().getContextPath() + location);
        } catch (IOException e) {
            LOGGER.error("Redirect failure", e);
            throw new RuntimeException(e);
        }
    }

    public static void setSessionAttribute(String key, Object value) {
        getServletContext().setAttribute(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSessionAttribute(String key) {
        return (T) getRequest().getSession().getAttribute(key);
    }

    public static void removeSessionAttribute(String key) {
        getRequest().getSession().removeAttribute(key);
    }

    public static void invalidateSession() {
        getRequest().getSession().invalidate();
    }
}
