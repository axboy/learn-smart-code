package cn.axboy.smart.chapter3.util;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:15
 * 数组工具类
 */
public final class ArrayUtil {
    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
}
