package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    /*
    * 管理员账号信息类
    * */
    private int id;  //管理员id
    private String userName; //账号
    private String password; //密码
    private int state;  //状态：1为正常，0为异常

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
