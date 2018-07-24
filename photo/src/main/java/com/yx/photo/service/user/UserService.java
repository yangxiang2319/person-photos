package com.yx.photo.service.user;

import com.alibaba.fastjson.JSONObject;
import com.yx.photo.user.User;

/**
 * 用户信息服务接口
 * @author yangxiang
 * @date 2018/7/18 20:06
 */
public interface UserService {

    /**
     * 验证登录信息
     * @author yangxiang
     * @date 2018/7/18 20:12
     * @param user
     * @return
     */
    JSONObject getUser(User user);
}
