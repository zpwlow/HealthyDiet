package com.hstc.controller;

import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
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
}
