package cn.axboy.smart.chapter3.controller;

import cn.axboy.smart.chapter3.annotation.Controller;
import cn.axboy.smart.chapter3.annotation.Inject;
import cn.axboy.smart.chapter3.annotation.RequestMapping;
import cn.axboy.smart.chapter3.annotation.RequestMethod;
import cn.axboy.smart.chapter3.bean.Data;
import cn.axboy.smart.chapter3.bean.Param;
import cn.axboy.smart.chapter3.service.HomeService;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/21 00:01
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Inject
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public Data index(Param param) {
        //测试依赖注入
        homeService.test();
        return new Data("hello world by HomeController in chapter 3");
    }
}
