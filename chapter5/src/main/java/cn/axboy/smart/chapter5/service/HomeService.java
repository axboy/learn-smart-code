package cn.axboy.smart.chapter5.service;

import cn.axboy.smart.chapter5.annotation.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/21 18:16
 */
@Component
public class HomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeService.class);

    public void test() {
        LOGGER.debug("test inject");
    }
}
