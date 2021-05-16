package com.hstc.controller;


import com.hstc.pojo.CollectionMenu;
import com.hstc.service.CollectionMenuService;
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
public class CollectionMenuController {
    @Autowired
    private CollectionMenuService collectionMenuService;

    @RequestMapping(value = "/collectionMenu.action" )
    public String queryAllCollectionMenu(@RequestParam(defaultValue="0")Integer page,
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
        Page<CollectionMenu> collectionMenuPage = collectionMenuService.queryAllCollectionMenu(page, rows, userId, username);
        model.addAttribute("page", collectionMenuPage);
        return "collectionMenu";
    }

    @RequestMapping(value = "/collectionMenu/delete.action")
    @ResponseBody
    public String deleteCollectionMenu(String userId, int menuId){
        CollectionMenu collectionMenu = new CollectionMenu(userId, menuId);
        int rows = collectionMenuService.deleteCollectionMenu(collectionMenu);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }
}
