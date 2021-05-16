package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.User;
import com.hstc.service.UserService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
* @RestController //有请求时，将返回的数据输出前端
* 用户请求个人信息
* */
@RestController
@RequestMapping("/userReq")
public class ReqUserController {

    @Autowired
    private UserService userService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

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
    * 用户请求: 根据用户ID 查询用户是否存在，存在时返回用户信息，不存在时请求失败。
    * */
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam("userId") String userId){
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
            result = new Result(404,"失败",null);
        }else {
            result = new Result(200,"成功",null);
        }
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }


}
