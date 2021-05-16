package com.hstc.dao;

import com.hstc.pojo.CollectionMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMenuMapper {

    //根据用户id和用户名查询收藏菜谱记录
    List<CollectionMenu> queryAllCollectionMenu(@Param("start") int start, @Param("rows") int rows, @Param("userId") String userId, @Param("username") String username);

    //根据用户id和用户名查询收藏菜谱记录总数
    int queryCollectionMenuCount(@Param("userId") String userId, @Param("username") String username);


    //增加用户菜谱收藏记录
    Integer addCollectionMenu(CollectionMenu collectionMenu);

    //修改用户菜谱收藏记录
    Integer deleteCollectionMenu(CollectionMenu collectionMenu);

    //根据用户id 查询该用户的菜谱收藏记录并分页
    List<CollectionMenu> queryCollectionMenuById(@Param("userId") String userId,
                                                 @Param("start") Integer start,
                                                 @Param("rows") Integer rows);

    //根据用户id 查询该用户的收藏菜谱总记录数
    Integer queryCollectionMenuListCount(@Param("userId") String userId);

    //根据用户id 和菜谱id 查询用户是否收藏
    CollectionMenu queryCollectionMenu(CollectionMenu collectionMenu);

}
