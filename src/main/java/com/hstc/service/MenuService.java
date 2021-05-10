package com.hstc.service;

import com.hstc.pojo.Menu;
import com.hstc.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    //查询所有Menu,返回一个List
    Page<Menu> queryAllMenu(Integer page, Integer count);

    //根据菜谱名查询，返回一个Menu
    List<Menu> queryMenuByName(String menuName);

    //根据id删除一个Menu
    int deleteMenuById(int id);

    //增加一个菜谱
    int addMenu(Menu menu);

    //更新Menu
    int updateMenu(Menu menu);

    //推荐用户菜谱
    List<Menu> recommendMenuList(String diseases, String flavor);

    //查询用户收藏菜谱
    List<Menu> queryCollectionMenuList(String userId);


}
