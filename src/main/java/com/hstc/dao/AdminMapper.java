package com.hstc.dao;

import com.hstc.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * 通过账号和密码查询用户
     */
    Admin findAdmin(@Param("userName") String userName, @Param("password") String password);

    int changePassword(@Param("userName") String userName, @Param("password") String password);

}
