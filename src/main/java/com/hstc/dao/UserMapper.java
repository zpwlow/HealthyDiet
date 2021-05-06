package com.hstc.dao;

import com.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //增加一个一个用户
    Integer addUser(User user);

    //更新用户信息
    Integer updateUser(User user);

    //查询用户
    User selectUserById(@Param("userId") String id);

    //管理员查询所有用户
    List<User> selectAllUser(@Param("start") int start,
                             @Param("rows") int rows);

    Integer selectUserCount();

    //管理员删除用户
    Integer deleteUser(@Param("userId") String id);

}
