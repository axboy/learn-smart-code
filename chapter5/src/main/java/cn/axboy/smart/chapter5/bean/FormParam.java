package cn.axboy.smart.chapter5.bean;

/**
 * 封装表单参数
 *
 * @author zcw
 * @version 1.0.0
 * @date 2018/3/22 00:17
 */
public class FormParam {

    private String fieldName;

    private Object fieldValue;

    public FormParam(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
