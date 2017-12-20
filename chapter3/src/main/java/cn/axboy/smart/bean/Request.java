package cn.axboy.smart.bean;

import cn.axboy.smart.annotation.RequestMethod;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 12:29
 * 封装的请求信息
 */
public class Request {
    private RequestMethod requestMethod;

    private String requestPath;

    public Request(RequestMethod requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        //TODO 修改
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //TODO 修改
        return super.equals(obj);
    }
}
