package com.hstc.dao;

import com.hstc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询所有User，返回一个List
    List<User> queryAllUser(@Param("start") int start, @Param("rows") int rows, @Param("category") String category, @Param("username") String username);

    //查询User总数
    int queryUserCount(@Param("category") String category, @Param("username") String username);

    //根据User的id获取对应的User信息
    User queryUserById(@Param("userId") String userId);

    //根据User名称进行模糊查询
    List<User> queryUserByName(@Param("username") String username);


    //根据User的id删除User数据
    int deleteUserById(@Param("userId") String userId);

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



}
