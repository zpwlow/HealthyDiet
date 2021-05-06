package com.hstc.service;

import com.hstc.pojo.User;
import com.hstc.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //增加一个一个用户
    Integer addUser(User user);

    //更新用户信息
    Integer updateUser(User user);

    //查询用户
    User selectUserById(String  id);

    //管理员查询所有用户并分页
    Page<User> selectAllUser(int start, int count);

    //管理员删除用户
    Integer deleteUserById(String  id);

}
