package com.yx.photo.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import com.yx.photo.loginservice.LoginService;
import com.yx.photo.service.user.UserService;
import com.yx.photo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务接口实现
 * @author yangxiang
 * @date 2018/7/18 20:05
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private LoginService loginService;

    /**
     * 验证登录信息
     * @author yangxiang
     * @date 2018/7/18 20:13
     * @param user
     * @return
     */
    @Override
    public JSONObject getUser(User user) {

        JSONObject rst = new JSONObject();
        log.info("开始根据登录信息获取用户账户信息，参数信息：{}", JSONObject.toJSON(user));
        log.info("向登录服务发起请求");

        User backUser = null;
        try {
            backUser = loginService.getUser(user.getUserName());
        } catch (Exception e) {
            log.error("登录服务出错了",e);
            rst.put("code","2");
            rst.put("msg","系统出错了");
        }

        if(backUser == null && !"2".equals(rst.getString("code"))){
            log.info("{}用户信息不存在",user.getUserName());
            rst.put("code","1");
            rst.put("msg","用户名或密码错误");
        }else if(backUser != null){
            log.info("{}用户信息:{}",user.getUserName(),JSONObject.toJSON(backUser));
            rst.put("code","0");
            rst.put("user",backUser);
        }

        return rst;
    }
}
