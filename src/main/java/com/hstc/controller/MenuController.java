package com.hstc.controller;

import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/byId")
    public String selectMenuById(){
        Menu menu = menuService.queryMenuById(1);
        System.out.println("菜谱："+menu);
        return "menu";
    }


}
