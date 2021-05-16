package com.hstc.service.Impl;

import com.hstc.dao.MenuMapper;
import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Page<Menu> queryAllMenu(int page, int rows, String category, String menuName) {
        int start = page * rows;
        // 查询菜谱列表
        List<Menu> menuList = menuMapper.queryAllMenu(start, rows, category, menuName);

        // 查询菜谱列表总记录数
        int total = queryMenuCount(category, menuName);
        // 创建Page返回对象
        Page<Menu> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(menuList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryMenuCount(String category, String menuName) {
        return this.menuMapper.queryMenuCount(category, menuName);
    }


    @Override
    public List<Menu> queryMenuByName(String menuName) {
        return this.menuMapper.queryMenuByName(menuName);
    }

    @Override
    public Integer updateMenu(Menu menu) {
        return this.menuMapper.updateMenu(menu);
    }

    @Override
    public Integer deleteMenuById(int menuId) {
        return this.menuMapper.deleteMenuById(menuId);
    }


    /*
     * 添加菜谱
     * */
    @Override
    public Integer addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }


    @Override
    public List<Menu> recommendMenuList(String diseases, String flavor) {
        return menuMapper.recommendMenuList(diseases,flavor);
    }


    @Override
    public List<Menu> queryCollectionMenuList(String userId) {
        return menuMapper.queryCollectionMenuList(userId);
    }

    @Override
    public Menu queryMenuById(Integer menuId) {
        return menuMapper.queryMenuById(menuId);
    }


}
