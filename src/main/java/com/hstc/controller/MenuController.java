package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/queryByMname")
    public String selectMenuByName(@RequestParam("name") String name, Model model){
        String menuName = "%" + name +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        System.out.println("菜谱："+menuList);
        //将List转换成json数据
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(menuList);
        System.out.println("菜谱："+json);
        return "menu";
    }


}
