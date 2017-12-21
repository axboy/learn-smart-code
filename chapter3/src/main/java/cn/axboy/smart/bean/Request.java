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
        return (requestMethod.hashCode() & 0xffff0000) | requestPath.hashCode() >> 16;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Request) {
            Request req = (Request) obj;
            return req.requestMethod == requestMethod && req.requestPath.equals(requestPath);
        }
        return false;
    }
}
