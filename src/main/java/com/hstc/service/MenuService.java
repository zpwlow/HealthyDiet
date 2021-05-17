package com.hstc.service;

import com.hstc.pojo.Menu;
import com.hstc.utils.Page;

import java.util.List;

public interface MenuService {

    //查询所有Menu，返回一个List
    Page<Menu> queryAllMenu(int page, int rows, String category, String menuName);

    //查询Menu总数
    int queryMenuCount(String category, String menuName);


    //根据Menu名称进行模糊查询
    List<Menu> queryMenuByName(String menuName);

    //修改Menu数据
    Integer updateMenu(Menu menu);

    //根据Menu的id删除Menu数据
    Integer deleteMenuById(int menuId);

    //根据Menu名称进行模糊查询
    List<Menu> queryUserMenuByName(String menuName);

    //增加一个菜谱
    Integer addMenu(Menu menu);

    //推荐用户菜谱
    List<Menu> recommendMenuList(String diseases, String flavor);

    //查询用户收藏菜谱
    List<Menu> queryCollectionMenuList(String userId);

    //根据菜谱id 查询菜谱
    Menu queryMenuById(Integer menuId);

}
