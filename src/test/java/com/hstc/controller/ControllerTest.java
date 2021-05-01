package com.hstc.controller;

import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
