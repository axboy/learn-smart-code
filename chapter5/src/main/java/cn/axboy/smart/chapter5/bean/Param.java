package cn.axboy.smart.chapter5.bean;

import cn.axboy.smart.chapter5.util.CastUtil;
import cn.axboy.smart.chapter5.util.CollectionUtil;
import cn.axboy.smart.chapter5.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 23:35
 * 请求参数对象
 */
public class Param {

    private List<FormParam> formParamList;

    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    /**
     * 获取请求参数映射
     *
     * @return
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();
        if (CollectionUtil.isEmpty(formParamList)) {
            return fieldMap;
        }
        for (FormParam formParam : formParamList) {
            String fieldName = formParam.getFieldName();
            Object fieldValue = formParam.getFieldValue();
            if (fieldMap.containsKey(fieldName)) {
                fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
            }
            fieldMap.put(fieldName, fieldValue);
        }
        return fieldMap;
    }

    /**
     * 获取上传文件映射
     *
     * @return
     */
    public Map<String, List<FileParam>> getFileMap() {
        Map<String, List<FileParam>> fileMap = new HashMap<>();
        if (CollectionUtil.isEmpty(fileParamList)) {
            return fileMap;
        }

        for (FileParam fileParam : fileParamList) {
            String fieldName = fileParam.getFieldName();
            List<FileParam> fileParamList;
            if (fileMap.containsKey(fieldName)) {
                fileParamList = fileMap.get(fieldName);
            } else {
                fileParamList = new ArrayList<>();
            }
            fileParamList.add(fileParam);
            fileMap.put(fieldName, fileParamList);
        }
        return fileMap;
    }

    /**
     * 获取所有上传文件
     *
     * @param fieldName
     * @return
     */
    public List<FileParam> getFileParamList(String fieldName) {
        return getFileMap().get(fieldName);
    }

    /**
     * 获取唯一上传文件
     *
     * @param fieldName
     * @return
     */
    public FileParam getFile(String fieldName) {
        List<FileParam> fileParamList = getFileParamList(fieldName);
        if (CollectionUtil.isNotEmpty(fileParamList) && fileParamList.size() == 1) {
            return fileParamList.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
    }

    public String getString(String name) {
        return CastUtil.castString(getFieldMap().get(name));
    }

    public Double getDouble(String name) {
        return CastUtil.castDouble(getFieldMap().get(name));
    }

    public Integer getInteger(String name) {
        return CastUtil.castInt(getFieldMap().get(name));
    }

    public Boolean getBoolean(String name) {
        return CastUtil.castBoolean(getFieldMap().get(name));
    }
}
