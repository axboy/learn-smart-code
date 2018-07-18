package cn.axboy.smart.chapter6.controller;

import cn.axboy.smart.annotation.Controller;
import cn.axboy.smart.annotation.RequestMapping;
import cn.axboy.smart.annotation.RequestMethod;
import cn.axboy.smart.bean.Data;
import cn.axboy.smart.bean.Param;
import cn.axboy.smart.chapter6.shiro.SecurityHelper;

/**
 * @author zcw
 * @version 1.0.0
 * @date 2018/7/18 00:02
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public Data index() {
        return new Data("hello world by HomeController in chapter 6");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Data login(Param param) {
        String userName = param.getString("userName");
        String password = param.getString("password");
        SecurityHelper.login(userName, password);
        return new Data("Login success");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public Data logout(Param param) {
        SecurityHelper.logout();
        return new Data("Logout success");
    }
}
