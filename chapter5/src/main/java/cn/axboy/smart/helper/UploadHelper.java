package cn.axboy.smart.helper;

import cn.axboy.smart.bean.FileParam;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.util.CollectionUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 文件助手上传类
 *
 * @author zcw
 * @version 1.0.0
 * @date 2018/3/22 00:50
 */
public final class UploadHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadHelper.class);

    //Apache提供的Servlet文件上传对象
    private static ServletFileUpload servletFileUpload;

    public static void init(ServletContext servletContext) {
        //todo
    }

    public static boolean isMultipart(HttpServletRequest request) {
        return ServletFileUpload.isMultipartContent(request);
    }

    public static Param createParam(HttpServletRequest request) {
        //todo
        return null;
    }

    public static void uploadFile(String basePath, FileParam fileParam) {
        //todo
    }

    public static void uploadFile(String basePath, List<FileParam> fileParamList) {
        try {
            if (CollectionUtil.isNotEmpty(fileParamList)) {
                for (FileParam fileParam : fileParamList) {
                    uploadFile(basePath, fileParam);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Upload file failure", e);
            throw new RuntimeException(e);
        }
    }

}
