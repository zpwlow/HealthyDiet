package com.hstc.controller;

import com.hstc.pojo.RecommendMenu;
import com.hstc.service.RecommendMenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userBehavior")
public class RecommendMenuController {
    @Autowired
    private RecommendMenuService recommendMenuService;

    @RequestMapping(value = "/recommendMenu.action" )
    public String queryAllRecommendMenu(@RequestParam(defaultValue="0")Integer page,
                                        @RequestParam(defaultValue="10")Integer rows,
                                        @RequestParam(defaultValue="")String userId,
                                        @RequestParam(defaultValue="")String username,
                                        HttpServletRequest request,
                                        Model model) {
        try{
            page = Integer.parseInt(request.getParameter("start"))-1;  //从前台获取 开始数据的索引
            rows = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
            userId = request.getParameter("userId");
            username = request.getParameter("username");
        }catch (Exception e){
        }
        model.addAttribute("userId", userId);
        model.addAttribute("username", username);
        if (userId.equals("")){
            userId = null;
        }
        if (username.equals("")){
            username = null;
        }
        Page<RecommendMenu> recommendMenuPage = recommendMenuService.queryAllRecommendMenu(page, rows, userId, username);
        model.addAttribute("page", recommendMenuPage);
        return "recommendMenu";
    }

    @RequestMapping(value = "/recommendMenu/delete.action")
    @ResponseBody
    public String deleteRecommendMenu(String userId, int menuId, String time){
        int rows = recommendMenuService.deleteRecommendMenu(userId,menuId,time);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }

}
