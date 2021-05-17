package com.hstc.dao;

import com.hstc.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {

    //查询所有Menu，返回一个List
    List<Menu> queryAllMenu(@Param("start") int start, @Param("rows") int rows, @Param("category") String category, @Param("menuName") String menuName);

    //查询Menu总数
    Integer queryMenuCount(@Param("category") String category, @Param("menuName") String menuName);


    //根据Menu名称进行模糊查询
    List<Menu> queryMenuByName(@Param("menuName") String menuName);

    //根据Menu名称进行模糊查询
    List<Menu> queryUserMenuByName(@Param("menuName") String menuName);

    //修改Menu数据
    Integer updateMenu(Menu menu);

    //根据Menu的id删除Menu数据
    Integer deleteMenuById(@Param("menuId") int menuId);



    // 菜谱数
    Integer selectMenuListCount();

    //增加一个菜谱
    Integer addMenu(Menu menu);

    //推荐用户菜谱
    List<Menu> recommendMenuList(@Param("diseases") String diseases,
                                 @Param("flavor") String flavor);

    //查询用户收藏菜谱
    List<Menu> queryCollectionMenuList(@Param("userId") String userId);

    //根据菜谱id 查询菜谱
    Menu queryMenuById(@Param("menuId") Integer menuId);

}
