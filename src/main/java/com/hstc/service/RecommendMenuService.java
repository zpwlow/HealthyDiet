package com.hstc.service;

import com.hstc.pojo.RecommendMenu;
import com.hstc.utils.Page;

public interface RecommendMenuService {
    //增加用户历史推荐菜谱记录
    Integer addRecommendMenuMapper(RecommendMenu recommendMenu);

    //根据用户id 查询该用户的历史推荐菜谱记录并分页
    Page<RecommendMenu> queryRecommendMenuMapperById(String userId, int start, int count);

    //修改用户历史推荐菜谱记录
    Integer updateRecommendMenu(RecommendMenu recommendMenu);
}
