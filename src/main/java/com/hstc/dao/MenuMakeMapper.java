package com.hstc.dao;

import com.hstc.pojo.MenuMake;

import java.util.List;

public interface MenuMakeMapper {
    public List<MenuMake> getMenuMakeListByMid(Integer menu_id);
}
