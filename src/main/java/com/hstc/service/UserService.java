package com.hstc.service;

import com.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    //增加一个一个用户
    int addUser(User user);

    //更新用户信息
    int updateUser(User user);

    //查询用户
    User selectUserById(int id);
}
