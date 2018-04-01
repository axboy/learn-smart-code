package cn.axboy.smart.chapter4.helper;

import cn.axboy.smart.chapter4.ConfigConstant;
import cn.axboy.smart.chapter4.util.PropsUtil;

import java.util.Properties;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 12:49
 * 属性文件助手类
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取jsp文件路径
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
    }
}