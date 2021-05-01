package com.hstc.dao;

import com.hstc.pojo.MenuEffect;

import java.util.List;

public interface MenuEffectMapper {
    //通过useId查询当前user的task列表
    List<MenuEffect> getMenuEffectListByMid(Integer menu_id);
}
