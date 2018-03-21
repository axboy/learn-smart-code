package cn.axboy.smart.bean;

import java.io.InputStream;

/**
 * 封装文件上传封装
 *
 * @author zcw
 * @version 1.0.0
 * @date 2018/3/21 23:21
 */
public class FileParam {

    private String fieldName;

    private String fileName;

    private Long fileSzie;

    private String contenttype;

    private InputStream inputStream;

    public FileParam(String fieldName, String fileName, Long fileSzie,
                     String contenttype, InputStream inputStream) {
        this.fieldName = fieldName;
        this.fileName = fileName;
        this.fileSzie = fileSzie;
        this.contenttype = contenttype;
        this.inputStream = inputStream;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFileName() {
        return fileName;
    }

    public Long getFileSzie() {
        return fileSzie;
    }

    public String getContenttype() {
        return contenttype;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
