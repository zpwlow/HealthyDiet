package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Menu;
import com.hstc.pojo.Result;
import com.hstc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
* @RestController //有请求时，将返回的数据输出前端
* */
@RestController
@RequestMapping("/menu")
public class ReqMenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 用户请求
     * produces = "text/plain;charset=utf-8" //防止中文乱码
     */
    @RequestMapping(value = "/queryByMname",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectMenuByName(@RequestParam("name") String name, Model model){
        String menuName = "%" + name +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        if(menuList == null){
            Result result = new Result(404,"资源不存在",null);
        }
        Result result = new Result(200,"成功",menuList);
        System.out.println("菜谱："+menuList);
        //将List转换成json数据
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }


}
