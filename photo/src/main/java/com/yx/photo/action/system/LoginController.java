package com.yx.photo.action.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 * @author yangxiang
 * @date 2018/6/8 8:08
 */
@Controller
@RequestMapping("/goLogin")
public class LoginController {

    /**
     *  返回登录页面
     * @author yangxiang
     * @date 2018/7/17 22:49
     * @param
     * @return
     */
    @RequestMapping("/login.do")
    public String login(){
        return "login";
    }
}
