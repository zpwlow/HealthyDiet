package com.hstc.service.Impl;

import com.hstc.dao.UserMapper;
import com.hstc.pojo.User;
import com.hstc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 增加用户
    * */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /*
    * 修改用户个人信息
    * */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /*
    * 根据用户的ID查询用户信息
    * */
    @Override
    public User selectUserById(String  id) {
        return userMapper.selectUserById(id);
    }

    /*
    * 查询所有用户数据
    * */
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    /*
    *根据用户id删除用户信息
    * */
    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUser(id);
    }

}
