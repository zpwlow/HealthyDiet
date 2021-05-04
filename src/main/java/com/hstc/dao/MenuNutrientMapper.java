package com.hstc.dao;

import com.hstc.pojo.MenuNutrient;

import java.util.List;

public interface MenuNutrientMapper {
    public List<MenuNutrient> getMenuNutrientListByMid(Integer menu_id);
}
