package cn.axboy.smart.chapter5.controller;

import cn.axboy.smart.chapter5.annotation.Controller;
import cn.axboy.smart.chapter5.annotation.Inject;
import cn.axboy.smart.chapter5.annotation.RequestMapping;
import cn.axboy.smart.chapter5.annotation.RequestMethod;
import cn.axboy.smart.chapter5.bean.Data;
import cn.axboy.smart.chapter5.bean.FileParam;
import cn.axboy.smart.chapter5.bean.Param;
import cn.axboy.smart.chapter5.service.HomeService;

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
    public Data index() {
        //测试依赖注入
        homeService.test();
        return new Data("hello world by HomeController in chapter 4");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public Data upload(Param param) {
        FileParam fileParam = param.getFile("file");
        if (fileParam != null) {
            return new Data("fileName: " + fileParam.getFileName());
        }
        return new Data("Upload success");
    }
}