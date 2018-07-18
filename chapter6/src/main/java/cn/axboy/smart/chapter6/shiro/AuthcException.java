package cn.axboy.smart.chapter6.shiro;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/17 23:57
 * 认证异常，非法访问时抛出
 */
public class AuthcException extends Exception {

    public AuthcException() {
        super();
    }

    public AuthcException(String msg) {
        super(msg);
    }

    public AuthcException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
