package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.dao.DailyEnergyMapper;
import com.hstc.pojo.CollectionMenu;
import com.hstc.pojo.DailyEnergy;
import com.hstc.pojo.Menu;
import com.hstc.pojo.User;
import com.hstc.service.CollectionMenuService;
import com.hstc.service.DailyEnergyService;
import com.hstc.service.MenuService;
import com.hstc.service.UserService;
import com.hstc.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DailyEnergyMapper dailyEnergyMapper;

    @Autowired
    private DailyEnergyService dailyEnergyService;

    @Autowired
    private CollectionMenuService collectionMenuService;

    /*
    * 根据菜谱名模糊查询菜谱
    * */
    @Test
    public void selectMenuByMnameTest(){
        String menuName = "%" + "奶香豌豆" +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        System.out.println("菜谱："+menuList);

    }

    /*
    * 查询所有菜谱信息
    * */
    @Test
    public void selectAllMenuTest(){
        int page = 1;
        int  rows = 10;
        Page<Menu> menuPage = menuService.queryAllMenu(page, rows);
        System.out.println(menuPage);
    }

    /*
    * 根据菜谱id 删除菜谱
    * */
    @Test
    public void deleteMenuByidTest(){
        int i = menuService.deleteMenuById(1);
        System.out.println("删除的数据数据量为："+i);
    }

    /*
    * 增加菜谱信息
    * */
    @Test
    public void insertMenuTest(){
        Menu menu = new Menu();
        int i = menuService.addMenu(menu);
        System.out.println("添加数据的数据量为："+ i);
    }

    /*
    * 修改菜谱信息
    * */
    @Test
    public void updateMenuTest(){
        Menu menu = new Menu();
        int i = menuService.updateMenu(menu);
        System.out.println("修改的数据量为："+i);
    }

    /*
    * 增加用户信息
    * */
    @Test
    public void addUserTest(){
        User user = new User("1","zhong","男",20,
                163.1,64.2,"甜",
                "冠心病","冠心病");
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(user);
        System.out.println("Json："+json);
        int i = userService.addUser(user);
        System.out.println("保存的用户数据为："+1);
    }


    /*
    * 修改用户信息
    * */
    @Test
    public void updateUserTest(){
        User user = new User("1","zhong","男",21,
                163.1,64.2,"辣",
                "冠心病","冠心病");
        int i = userService.updateUser(user);
        System.out.println("增加用户数为："+i);
    }

    /*
    * 根据用户id 查询用户信息
    * */
    @Test
    public void selectUserByIdTest(){
        User user = userService.selectUserById("1");
        System.out.println("user: " +user);
    }

    /*
    * 查询所有用户信息
    * */
    @Test
    public void selectAllUserTest(){
        Page<User> users = userService.selectAllUser(0,10);
        System.out.println(users);
    }

    /*
    * 根据用户的id 删除用户
    * */
    @Test
    public void deleteUserByIdTest(){
        int i = userService.deleteUserById("1");
        System.out.println("删除的用户数为："+i);
    }

    /*
    * 根据用户id查询用户每日能量信息
    * */
    @Test
    public void queryDailyEnergyByIdTest(){
        Page<DailyEnergy> dailyEnergies =
                dailyEnergyService.queryDailyEnergyById("1",0,10);
        System.out.println(dailyEnergies);
    }

    /*
    * 根据用户id查询用户每日能量信息数量
    * */
    @Test
    public void queryCountById(){
        Integer integer = dailyEnergyMapper.selectDailyEnergyCount("1");
        System.out.println("用户的每日能量数为："+integer);
    }

    /*
    * 增加用户每日能量信息
    * */
    @Test
    public void addDailyEnergyTest(){
        DailyEnergy dailyEnergy = new DailyEnergy();
        int i = dailyEnergyService.addDailyEnergy(dailyEnergy);
        System.out.println("增加的数据数量为"+i);
    }

    /*
    * 修改用户每日能量信息
    * */
    @Test
    public void  updateDailyEnergyTest(){
        DailyEnergy dailyEnergy = new DailyEnergy();
        int i = dailyEnergyService.updateDailyEnergy(dailyEnergy);
        System.out.println("修改的用户信息数量为："+i);
    }

    @Test
    public void addCollectionMenuTest(){
        CollectionMenu collectionMenu = new CollectionMenu("1",2,false);
        Integer integer = collectionMenuService.addCollectionMenu(collectionMenu);
        System.out.println("操作的数据数为："+integer);
    }
}
