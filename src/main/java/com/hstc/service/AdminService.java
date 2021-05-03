package com.hstc.service;

import com.hstc.pojo.Admin;

public interface AdminService {
    Admin findAdmin(String userName, String password);
}
