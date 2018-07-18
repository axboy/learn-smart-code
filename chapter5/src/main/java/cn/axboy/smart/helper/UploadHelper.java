package cn.axboy.smart.helper;

import cn.axboy.smart.bean.FileParam;
import cn.axboy.smart.bean.FormParam;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.util.CollectionUtil;
import cn.axboy.smart.util.FileUtil;
import cn.axboy.smart.util.StreamUtil;
import cn.axboy.smart.util.StringUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    /**
     * 初始化
     *
     * @param servletContext
     */
    public static void init(ServletContext servletContext) {
        //Servlet缓存目录
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(
                new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository)
        );
        int uploadLimit = ConfigHelper.getAppIploadLimit();
        if (uploadLimit != 0) {
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }

    /**
     * 判断请求是否为multipart类型
     *
     * @param request
     * @return
     */
    public static boolean isMultipart(HttpServletRequest request) {
        return ServletFileUpload.isMultipartContent(request);
    }

    /**
     * 创建请求对象
     *
     * @param request
     * @return
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<>();
        List<FileParam> fileParamList = new ArrayList<>();
        try {
            Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if (CollectionUtil.isNotEmpty(fileItemListMap)) {
                for (Map.Entry<String, List<FileItem>> fileItemListEntry : fileItemListMap.entrySet()) {
                    String fieldName = fileItemListEntry.getKey();
                    List<FileItem> fileItemList = fileItemListEntry.getValue();
                    if (CollectionUtil.isNotEmpty(fileItemList)) {
                        for (FileItem fileItem : fileItemList) {
                            if (fileItem.isFormField()) {
                                String fieldValue = fileItem.getString("UTF-8");
                                formParamList.add(new FormParam(fieldName, fieldValue));
                            } else {
                                String fileName = FileUtil.getRealFileName(
                                        new String(fileItem.getName().getBytes(), "UtF-8")
                                );
                                if (StringUtil.isNotEmpty(fieldName)) {
                                    long fileSize = fileItem.getSize();
                                    String contentType = fileItem.getContentType();
                                    InputStream is = fileItem.getInputStream();
                                    fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, is));
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            LOGGER.error("Create param faulure", e);
            throw new RuntimeException(e);
        }
        return new Param(formParamList, fileParamList);
    }

    /**
     * 上传文件
     *
     * @param basePath
     * @param fileParam
     */
    public static void uploadFile(String basePath, FileParam fileParam) {
        try {
            if (fileParam != null) {
                String filePath = basePath + fileParam.getFileName();
                FileUtil.createFile(filePath);
                InputStream is = new BufferedInputStream(fileParam.getInputStream());
                OutputStream os = new BufferedOutputStream(new FileOutputStream(filePath));
                StreamUtil.copyStream(is, os);
            }
        } catch (Exception e) {
            LOGGER.error("Upload file failure", e);
            throw new RuntimeException(e);
        }
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
