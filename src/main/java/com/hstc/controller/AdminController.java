package com.hstc.controller;

import com.hstc.pojo.Admin;
import com.hstc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String userName, String password,Boolean rememberMe, Model model,
                        HttpSession session) {
        // 通过账号和密码查询用户
        Admin admin = adminService.findAdmin(userName, password);
        System.out.println("查找的用户"+rememberMe);
        if(admin != null){
            // 将用户对象添加到Session
            session.setAttribute("USER_SESSION", admin);

            // 跳转到主页面
//			return "menu";
            return "redirect:/menu/list.action";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        // 返回到登录页面
        return "login";
    }

    /**
     * 模拟其他类中跳转到客户管理页面的方法
     */
//    @RequestMapping(value = "/toCustomer")
//    public String toCustomer() {
//        return "customer";
//    }
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:login.action";
    }
    /**
     * 向用户登陆页面跳转
     */
    @RequestMapping(value = "/login.action" , method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

}
