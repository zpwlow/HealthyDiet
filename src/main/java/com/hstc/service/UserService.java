package com.hstc.service;

import com.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //增加一个一个用户
    int addUser(User user);

    //更新用户信息
    int updateUser(User user);

    //查询用户
    User selectUserById(String  id);

    //管理员查询所有用户
    List<User> selectAllUser();

    //管理员删除用户
    int deleteUserById(String  id);

}
