package cn.axboy.smart.chapter5.controller;

import cn.axboy.smart.bean.Data;
import cn.axboy.smart.bean.FileParam;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.annotation.Controller;
import cn.axboy.smart.annotation.RequestMapping;
import cn.axboy.smart.annotation.RequestMethod;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2017/12/21 00:01
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public Data index() {
        return new Data("hello world by HomeController in chapter 5");
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
