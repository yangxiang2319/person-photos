package com.yx.photo.loginservice;

import com.yx.photo.user.User;

/**
 * 登录服务接口
 * @author yangxiang
 * @date 2018/7/18 16:53
 */
public interface LoginService {

    /**
     * 查询用户账户信息
     * @author yangxiang
     * @date 2018/7/18 17:25
     * @param userName
     * @return
     */
    User getUser(String userName);
}
