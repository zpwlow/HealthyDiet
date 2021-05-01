package com.hstc.dao;

import com.hstc.pojo.MenuIngredients;

import java.util.List;

public interface MenuIngredientsMapper {
    public List<MenuIngredients> getMenuIngredientsListByMid(Integer menu_id);
}
