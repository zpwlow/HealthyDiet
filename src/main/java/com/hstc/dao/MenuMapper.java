package com.hstc.dao;

import com.hstc.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    //根据id查询，返回一个Menu
    List<Menu> queryMenuByName(@Param("menuName") String menuName);

    //查询所有Menu,返回一个List
    List<Menu> queryAllMenu(@Param("start") int start,
                            @Param("rows") int rows);
    // 菜谱数
    Integer selectMenuListCount();

    //根据id删除一个Menu
    int deleteMenuById(@Param("menuId") int id);

    //增加一个菜谱
   int addMenu(Menu menu);

    //更新Menu
    int updateMenu(Menu menu);


}
