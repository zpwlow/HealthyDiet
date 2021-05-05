package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Menu;
import com.hstc.pojo.User;
import com.hstc.service.MenuService;
import com.hstc.service.UserService;
import com.hstc.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Test
    public void selectMenuByIdTest(){
        String menuName = "%" + "奶香豌豆" +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        System.out.println("菜谱："+menuList);

    }

    @Test
    public void selectAllMenuTest(){
        int page = 1;
        int  rows = 10;
        Page<Menu> menuPage = menuService.queryAllMenu(page, rows);
        System.out.println(menuPage);
    }

    @Test
    public void deleteMenuByidTest(){
        int i = menuService.deleteMenuById(1);
        System.out.println("删除的数据数据量为："+i);
    }

    @Test
    public void insertMenuTest(){
        Menu menu = new Menu();
        int i = menuService.addMenu(menu);
        System.out.println("添加数据的数据量为："+ i);
    }

    @Test
    public void updateMenuTest(){
        Menu menu = new Menu();
        int i = menuService.updateMenu(menu);
        System.out.println("修改的数据量为："+i);
    }

    @Test
    public void addUserTest(){
        User user = new User(1,"zhong","男",20,
                163.1,64.2,"甜",
                "冠心病","冠心病");
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(user);
        System.out.println("Json："+json);
        int i = userService.addUser(user);
        System.out.println("保存的用户数据为："+1);
    }

    @Test
    public void updateUserTest(){
        User user = new User(1,"zhong","男",21,
                163.1,64.2,"辣",
                "冠心病","冠心病");
        int i = userService.updateUser(user);
        System.out.println("增加用户数为："+i);
    }

    @Test
    public void selectUserTest(){
        User user = userService.selectUserById(1);
        System.out.println("user: " +user);
    }

    @Test
    public void selectAllUserTest(){
        List<User> users = userService.selectAllUser();
        System.out.println(users);
    }

    @Test
    public void deleteUserByIdTest(){
        int i = userService.deleteUserById(1);
        System.out.println("删除的用户数为："+i);
    }
}
