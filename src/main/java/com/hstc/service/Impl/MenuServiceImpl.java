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

    /*
    * 查询所有菜谱做分页
    * */
    @Override
    public Page<Menu> queryAllMenu(Integer page, Integer count) {
        // 查询客户列表
        List<Menu> menuList = menuMapper.queryAllMenu(page,count);
        // 查询客户列表总记录数
        Integer total = menuMapper.selectMenuListCount();
        // 创建Page返回对象
        Page<Menu> result = new Page<>();
        result.setStart(page);
        result.setRows(menuList);
        result.setCount(count);
        result.setTotal(total);
        return result;
    }

    /*
    * 根据菜谱名查询菜谱
    * */
    @Override
    public List<Menu> queryMenuByName(String menuName) {
        return menuMapper.queryMenuByName(menuName);
    }

    /*
    * 根据菜谱id删除菜谱
    * */
    @Override
    public int deleteMenuById(int id) {
        return menuMapper.deleteMenuById(id);
    }

    /*
    * 添加菜谱
    * */
    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    /*
    * 修改菜谱
    * */
    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public List<Menu> recommendMenuList(String diseases, String flavor) {
        return menuMapper.recommendMenuList(diseases,flavor);
    }


}
