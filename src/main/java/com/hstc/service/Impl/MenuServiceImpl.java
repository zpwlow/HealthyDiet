package com.hstc.service.Impl;

import com.hstc.dao.MenuMapper;
import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
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
    public int addMenu(Menu menu) {
        return 0;
    }

    @Override
    public int deleteMenu(int id) {
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        return 0;
    }

    @Override
    public Menu queryMenuById(int id) {
        return null;
    }

    @Override
    public List<Menu> queryAllMenu() {
        return null;
    }

    @Override
    public Menu queryMenuByName(String menu_name) {
        return null;
    }
}
