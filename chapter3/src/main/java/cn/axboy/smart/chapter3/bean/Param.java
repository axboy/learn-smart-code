package cn.axboy.smart.chapter3.bean;

import cn.axboy.smart.chapter3.util.CastUtil;

import java.util.Map;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 23:35
 * 请求参数对象
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 获取所有字段信息
     *
     * @return
     */
    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    /**
     * 根据参数获取Long形参数
     *
     * @param name
     * @return
     */
    public Long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
}
