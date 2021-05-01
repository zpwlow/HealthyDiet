package com.hstc.dao;

import com.hstc.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    //增加一个菜单
   int addMenu(Menu menu);

   //根据id删除一个Menu
    int deleteMenu(@Param("menuId") int id);

    //更新Menu
    int updateMenu(Menu menu);

    //根据id查询，返回一个Menu
    Menu queryMenuById(@Param("menuId") int id);

    //查询所有Menu,返回一个List
    List<Menu> queryAllMenu();

    //根据菜谱名查询
    Menu queryMenuByName(@Param("menuName") String menu_name);
}
