package com.hstc.service.Impl;

import com.hstc.dao.AdminMapper;
import com.hstc.pojo.Admin;
import com.hstc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    // 注入AdminDao
    @Autowired
    private AdminMapper adminMapper;

    // 通过账号和密码查询用户
    @Override
    public Admin findAdmin(String userName, String password) {
        return adminMapper.findAdmin(userName, password);
    }
}
