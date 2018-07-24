package com.yx.photo.login.mapper;

import com.yx.photo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息DAO
 * @author yangxiang
 * @date 2018/7/24 20:08
 */
@Mapper
public interface UserMapper {

    /**
     * 获取用户账户信息
     * @author yangxiang
     * @date 2018/7/24 20:12
     * @param userName
     * @return
     */
    User getUser(@Param("userName") String userName);
}
