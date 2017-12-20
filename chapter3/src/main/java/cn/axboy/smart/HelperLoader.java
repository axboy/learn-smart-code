package cn.axboy.smart;

import cn.axboy.smart.helper.BeanHelper;
import cn.axboy.smart.helper.ClassHelper;
import cn.axboy.smart.helper.ControllerHelper;
import cn.axboy.smart.util.ClassUtil;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/20 15:19
 * 加载Helper类
 */
public final class HelperLoader {

    public static void initHelper() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
//                AopHelper.class,
//                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
