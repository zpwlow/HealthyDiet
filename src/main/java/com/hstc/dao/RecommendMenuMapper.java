package com.hstc.dao;

import com.hstc.pojo.RecommendMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMenuMapper {

    //根据用户id和用户名查询推荐菜谱记录
    List<RecommendMenu> queryAllRecommendMenu(@Param("start") int start, @Param("rows") int rows, @Param("userId") String userId, @Param("username") String username);

    //根据用户id和用户名查询推荐菜谱记录总数
    int queryRecommendMenuCount(@Param("userId") String userId, @Param("username") String username);

    //根据用户id，菜谱id和时间删除推荐菜谱记录
    int deleteRecommendMenu(@Param("userId") String userId, @Param("menuId") int menuId, @Param("time") String time);

    //增加用户历史推荐菜谱记录
    Integer addRecommendMenuMapper(RecommendMenu recommendMenu);

    //修改用户历史推荐菜谱记录
    Integer updateRecommendMenu(RecommendMenu recommendMenu);

    //根据用户id 查询该用户的历史推荐菜谱记录并分页
    List<RecommendMenu> queryRecommendMenuMapperById(@Param("userId") String userId,
                                                     @Param("start") int start,
                                                     @Param("rows") int rows);

    //根据用户id 查询该用户的历史推荐菜谱记录数
    Integer queryRecommendMenuMapperListCount(@Param("userId") String userId);

}
