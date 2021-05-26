package com.hstc.service;

import com.hstc.pojo.RecommendMenu;
import com.hstc.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMenuService {

    //根据用户id和用户名查询推荐菜谱记录
    Page<RecommendMenu> queryAllRecommendMenu(int page, int rows, String userId, String username);

    //根据用户id和用户名查询推荐菜谱记录总数
    int queryRecommendMenuCount(String userId, String username);

    //根据用户id，菜谱id和时间删除推荐菜谱记录
    int deleteRecommendMenu(String userId, int menuId, String time);

    //增加用户历史推荐菜谱记录
    Integer addRecommendMenuMapper(RecommendMenu recommendMenu);

    //根据用户id 查询该用户的历史推荐菜谱记录并分页
    Page<RecommendMenu> queryRecommendMenuMapperById(String userId, int start, int count);

    //修改用户历史推荐菜谱记录
    Integer updateRecommendMenu(RecommendMenu recommendMenu);

    //根据用户id和时间查看推荐菜谱
    List<RecommendMenu> queryRecommendMenuByIdTime(String userId, String time);
}
