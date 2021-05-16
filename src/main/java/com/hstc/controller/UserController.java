package com.hstc.controller;

import com.hstc.pojo.User;
import com.hstc.service.UserService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list.action")
    public String queryUserAll(@RequestParam(defaultValue="0")Integer page,
                               @RequestParam(defaultValue="10")Integer rows,
                               @RequestParam(defaultValue="疗养疾病")String category,
                               @RequestParam(defaultValue="")String username,
                               HttpServletRequest request,
                               Model model) {
        try{
            page = Integer.parseInt(request.getParameter("start"))-1;  //从前台获取 开始数据的索引
            rows = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
            category = request.getParameter("category");
            username = request.getParameter("username");
        }catch (Exception e){
        }
        model.addAttribute("category", category);
        model.addAttribute("search", username);
        if (category.equals("疗养疾病")){
            category = null;
        }
        if (username.equals("")){
            username = null;
        }
        Page<User> userPage = userService.queryAllUser(page,rows,category,username);
        model.addAttribute("page", userPage);
        return "user";
    }

    @RequestMapping("/queryUserById.action")
    @ResponseBody
    public User queryUserById(String userId) {
        User user = userService.queryUserById(userId);
        return user;
    }

    @RequestMapping(value = "/update.action")
    @ResponseBody
    public String updateUser(User user){
        int rows = userService.updateUser(user);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }

    @RequestMapping(value = "/delete.action")
    @ResponseBody
    public String deleteUserById(String userId){
        int rows = userService.deleteUserById(userId);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }

}
