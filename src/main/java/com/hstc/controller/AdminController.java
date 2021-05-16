package com.hstc.controller;

import com.hstc.pojo.Admin;
import com.hstc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String userName, String password, Model model,
                        HttpSession session) {
        // 通过账号和密码查询用户
        Admin admin = adminService.findAdmin(userName, password);
        if(admin != null){
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", admin);
            // 跳转到主页面
            return "redirect:/menu/list.action";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        // 返回到登录页面
        return "login";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 返回到登录页面
        return "login";
    }

    @RequestMapping(value = "/changePassword.action")
    public String changePassword() {
        return "changePassword";
    }

    @RequestMapping(value = "/update.action")
    @ResponseBody
    public String updatePassword(String userName, String password,HttpSession session) {
        int rows = adminService.changePassword(userName, password);
        Admin admin = new Admin(userName, password);

        if(rows > 0){
            session.setAttribute("USER_SESSION", admin);
            return "OK";
        }else{
            return "FALSE";
        }
    }

}
