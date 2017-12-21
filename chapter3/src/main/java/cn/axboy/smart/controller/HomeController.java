package cn.axboy.smart.controller;

import cn.axboy.smart.annotation.Controller;
import cn.axboy.smart.annotation.Inject;
import cn.axboy.smart.annotation.RequestMapping;
import cn.axboy.smart.annotation.RequestMethod;
import cn.axboy.smart.bean.Data;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.service.HomeService;

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
