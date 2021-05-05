package com.hstc.dao;

import com.hstc.pojo.CollectionMenu;
import com.hstc.pojo.RecommendMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMenuMapper {
    //增加用户历史推荐菜谱记录
    Integer addRecommendMenuMapper(RecommendMenu recommendMenu);

    //根据用户id 查询该用户的历史推荐菜谱记录并分页
    List<RecommendMenu> queryRecommendMenuMapperById(@Param("userId") String userId,
                                                     @Param("start") int start,
                                                     @Param("rows") int rows);

    //根据用户id 查询该用户的历史推荐菜谱记录数
    Integer queryRecommendMenuMapperListCount(@Param("userId") String userId);
}
