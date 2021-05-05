package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Menu;
import com.hstc.pojo.Result;
import com.hstc.pojo.User;
import com.hstc.service.MenuService;
import com.hstc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* @RestController //有请求时，将返回的数据输出前端
* */
@RestController
@RequestMapping("/userReq")
public class UserReqController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /**
     * 用户请求，根据菜谱名查询，返回用户菜谱的详细信息
     * produces = "text/plain;charset=utf-8" //防止中文乱码
     */
    @RequestMapping(value = "/queryByMname",method = RequestMethod.GET)
    public String selectMenuByName(@RequestParam("name") String name){
        String menuName = "%" + name +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        Result result;
        if(menuList == null){
            result = new Result(404,"资源不存在",null);
        }else {
            result = new Result(200,"成功",menuList);
        }
        System.out.println("菜谱："+menuList);
        //将List转换成json数据

        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }

    /*
    * 用户请求，获取用户个人信息保存到数据库中
    * */
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.addUser(user);
        return getString(i);
    }

    /*
    * 用户请求：用户修改个人信息
    * */
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.updateUser(user);
        return getString(i);
    }

    /*
    * 用户请求: 根据用户ID 查询用户是否存在，存在时返回用户信息，不存在请求失败。
    * */
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam("userId") int userId){
        User user = userService.selectUserById(userId);
        Result result;
        if(user == null){
            result = new Result(404,"用户不存在",null);
        }else {
            result = new Result(200,"成功",user);
        }
        System.out.println("用户："+user);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;

    }

    private String getString(int i) {
        Result result;
        if(i!=1){
            result = new Result(404,"用户信息未保存成功",null);
        }else {
            result = new Result(200,"成功",null);
        }
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }


}
