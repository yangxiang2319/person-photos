package com.yx.photo.login.user;

import com.alibaba.fastjson.JSONObject;
import com.yx.photo.login.mapper.UserMapper;
import com.yx.photo.loginservice.LoginService;
import com.yx.photo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录服务
 * @author yangxiang
 * @date 2018/7/20 16:48
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    
    /**
     * 获取用户账户信息
     * @author yangxiang
     * @date 2018/7/20 16:48
     * @param userName
     * @return
     */
    @Override
    public User getUser(String userName) {
        log.info("收到一个查询用户账户信息请求，参数：userName:{}",userName);
        User user = userMapper.getUser(userName);
        if(user == null){
           log.info("{}用户信息不存在",userName);
        }else {
           log.info("返回用户信息：{}", JSONObject.toJSONString(user));
        }
        return user;
    }
}
