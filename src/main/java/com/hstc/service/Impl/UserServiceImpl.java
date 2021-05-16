package com.hstc.service.Impl;

import com.hstc.dao.UserMapper;
import com.hstc.pojo.User;
import com.hstc.service.UserService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> queryAllUser(int page, int rows, String category, String username) {
        int start = page * rows;
        // 查询用户列表
        List<User> userList = userMapper.queryAllUser(start, rows, category, username);
        // 查询用户列表总记录数
        int total = queryUserCount(category, username);
        // 创建Page返回对象
        Page<User> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(userList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryUserCount(String category, String username) {
        return this.userMapper.queryUserCount(category, username);
    }

    @Override
    public User queryUserById(String userId) {
        return this.userMapper.queryUserById(userId);
    }

    @Override
    public List<User> queryUserByName(String username) {
        return this.userMapper.queryUserByName(username);
    }


    @Override
    public int deleteUserById(String userId) {
        return this.userMapper.deleteUserById(userId);
    }


    /*
     * 增加用户
     * */
    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    /*
     * 修改用户个人信息
     * */
    @Override
    public Integer updateUser(User user) {
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
    public Page<User> selectAllUser(int start, int count) {
        List<User> userList = userMapper.selectAllUser(start, count);
        Integer total = userMapper.selectUserCount();
        Page<User> userPage = new Page<>();
        userPage.setStart(start);
        userPage.setCount(count);
        userPage.setTotal(total);
        userPage.setRows(userList);
        return userPage;
    }



}
