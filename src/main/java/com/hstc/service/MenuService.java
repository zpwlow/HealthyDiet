package com.hstc.service;

import com.hstc.pojo.Menu;

import java.util.List;

public interface MenuService {

    //根据id查询，返回一个Menu
    Menu queryMenuById(int id);

//    //增加一个菜单
//    int addMenu(Menu menu);
//
//    //根据id删除一个Menu
//    int deleteMenu(int id);
//
//    //更新Menu
//    int updateMenu(Menu menu);
//
//    //查询所有Menu,返回一个List
//    List<Menu> queryAllMenu();
//
//    //根据菜谱名查询
//    Menu queryMenuByName(String menu_name);
}
