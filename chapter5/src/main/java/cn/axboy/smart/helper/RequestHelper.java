package cn.axboy.smart.helper;

import cn.axboy.smart.bean.FormParam;
import cn.axboy.smart.bean.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求助手类
 *
 * @author zcw
 * @version 1.0.0
 * @date 2018/3/22 01:04
 */
public final class RequestHelper {

    public static Param createParam(HttpServletRequest request) {
        List<FormParam> formParamList = new ArrayList<>();
        formParamList.addAll(parseParameterNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }

    private static List<FormParam> parseParameterNames(HttpServletRequest request) {
        //todo
        return null;
    }

    private static List<FormParam> parseInputStream(HttpServletRequest request) {
        //todo
        return null;
    }
}
