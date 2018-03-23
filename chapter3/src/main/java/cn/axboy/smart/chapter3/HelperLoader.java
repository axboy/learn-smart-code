package cn.axboy.smart.chapter3;

import cn.axboy.smart.chapter3.helper.BeanHelper;
import cn.axboy.smart.chapter3.helper.ClassHelper;
import cn.axboy.smart.chapter3.helper.ControllerHelper;
import cn.axboy.smart.chapter3.helper.IocHelper;
import cn.axboy.smart.chapter3.util.ClassUtil;

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
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
