package cn.axboy.smart.chapter5.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 11:20
 * 集合工具类
 */
public final class CollectionUtil {

    /**
     * 判断 Collection 是否为空
     */
    public static boolean isEmpty(Collection<?> coll){
        return coll == null || coll.isEmpty();
    }

    /**
     * 判断 Collection 是否非空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断 Map 是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断 Map 是否非空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
