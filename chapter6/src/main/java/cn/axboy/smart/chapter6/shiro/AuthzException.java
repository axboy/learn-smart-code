package cn.axboy.smart.chapter6.shiro;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/17 23:57
 * 授权异常，权限无效时抛出
 */
public class AuthzException extends Exception {

    public AuthzException() {
        super();
    }

    public AuthzException(String msg) {
        super(msg);
    }

    public AuthzException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
