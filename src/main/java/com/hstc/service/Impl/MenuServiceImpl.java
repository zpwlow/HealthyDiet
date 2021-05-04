package com.hstc.service.Impl;

import com.hstc.dao.MenuMapper;
import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Page<Menu> queryAllMenu(Integer page, Integer rows) {
        //创建一个Menu
        Menu menu = new Menu();
        // 当前页
        menu.setStart((page) * rows) ;
        // 每页数
        menu.setRows(rows);
        // 查询客户列表
        List<Menu> menuList = menuMapper.queryAllMenu(menu);
        // 查询客户列表总记录数
        Integer total = menuMapper.selectMenuListCount();
        // 创建Page返回对象
        Page<Menu> result = new Page<>();
        result.setStart(page);
        result.setRows(menuList);
        result.setCount(rows);
        result.setTotal(total);
        return result;
    }

    @Override
    public List<Menu> queryMenuByName(String menuName) {
        return menuMapper.queryMenuByName(menuName);
    }

    @Override
    public int deleteMenuById(int id) {
        return menuMapper.deleteMenuById(id);
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }



}
