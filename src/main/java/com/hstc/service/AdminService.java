package com.hstc.service;

import com.hstc.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    Admin findAdmin(String userName, String password);

    int changePassword(String userName, String password);
}
