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
        menu.setStart((page-1) * rows) ;
        // 每页数
        menu.setRows(rows);
        // 查询客户列表
        List<Menu> menuList = menuMapper.queryAllMenu(menu);
        // 查询客户列表总记录数
        Integer count = menuMapper.selectMenuListCount(menu);
        // 创建Page返回对象
        Page<Menu> result = new Page<>();
        result.setPage(page);
        result.setRows(menuList);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public List<Menu> queryMenuByName(String menuName) {
        return this.menuMapper.queryMenuByName(menuName);
    }


//    @Override
//    public int addMenu(Menu menu) {
//        return 0;
//    }
//
//    @Override
//    public int deleteMenu(int id) {
//        return 0;
//    }
//
//    @Override
//    public int updateMenu(Menu menu) {
//        return 0;
//    }
//

//    @Override
//    public Menu queryMenuByName(String menu_name) {
//        return null;
//    }
}
