package cn.axboy.smart.chapter4.controller;

import cn.axboy.smart.annotation.Controller;
import cn.axboy.smart.annotation.RequestMethod;
import cn.axboy.smart.bean.Data;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.annotation.RequestMapping;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/21 00:01
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public Data index(Param param) {
        return new Data("hello world by HomeController in chapter 4");
    }
}
