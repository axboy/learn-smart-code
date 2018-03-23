package cn.axboy.smart.chapter4.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 23:40
 * 返回视图对象
 */
public class View {

    private String path;

    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
