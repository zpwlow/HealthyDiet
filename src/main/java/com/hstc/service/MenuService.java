package com.hstc.service;

import com.hstc.pojo.Menu;
import com.hstc.utils.Page;

import java.util.List;

public interface MenuService {


    //查询所有Menu,返回一个List
    Page<Menu> queryAllMenu(Integer page, Integer rows);

    //根据id查询，返回一个Menu
    List<Menu> queryMenuByName(String menuName);

    //根据id删除一个Menu
    int deleteMenuById(int id);



    //    //增加一个菜单
//    int addMenu(Menu menu);
//

//
//    //更新Menu
//    int updateMenu(Menu menu);
//
//
//    //根据菜谱名查询
//    Menu queryMenuByName(String menu_name);
}
