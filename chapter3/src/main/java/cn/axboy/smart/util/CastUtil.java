package cn.axboy.smart.util;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:16
 * 转型操作工具类
 */
public final class CastUtil {

    /**
     * 转为String，需提供默认值
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为String，空则为null
     */
    public static String castString(Object obj) {
        return castString(obj, null);
    }

    /**
     * 转为Double，需提供默认值
     */
    public static Double castDouble(Object obj, Double defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String strValue = castString(obj, "");
        if (StringUtil.isEmpty(strValue)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(strValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 转为Double，默认为null
     */
    public static Double castDouble(Object obj) {
        return castDouble(obj, null);
    }

    public static Long castLong(Object obj, Long defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String strValue = castString(obj, "");
        if (StringUtil.isEmpty(strValue)) {
            return defaultValue;
        }
        try {
            return Long.parseLong(strValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 转为Long
     */
    public static Long castLong(Object obj) {
        return castLong(obj, null);
    }

    /**
     * 转为Integer，需提供默认值
     */
    public static Integer castInt(Object obj, Integer defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        String strValue = castString(obj, "");
        if (StringUtil.isEmpty(strValue)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(strValue);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 转为Integer，默认为null
     */
    public static Integer castInt(Object obj) {
        return castInt(obj, null);
    }

    /**
     * 转为布尔值，需提供默认值
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(castString(obj, ""));
    }

    /**
     * 转为布尔值，默认值为false
     */
    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }
}
