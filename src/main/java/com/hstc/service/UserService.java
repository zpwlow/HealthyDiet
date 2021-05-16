package com.hstc.service;

import com.hstc.pojo.User;
import com.hstc.utils.Page;

import java.util.List;

public interface UserService {

    //查询所有User，返回一个List
    Page<User> queryAllUser(int page, int rows, String category, String username);

    //查询User总数
    int queryUserCount(String category, String username);

    //根据User的id获取对应的User信息
    User queryUserById(String userId);

    //根据User名称进行模糊查询
    List<User> queryUserByName(String username);


    //根据User的id删除User数据
    int deleteUserById(String userId);

    //增加一个一个用户
    Integer addUser(User user);

    //更新用户信息
    Integer updateUser(User user);

    //查询用户
    User selectUserById(String  id);

    //管理员查询所有用户并分页
    Page<User> selectAllUser(int start, int count);


}
