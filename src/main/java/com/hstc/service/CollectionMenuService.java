package com.hstc.service;

import com.hstc.pojo.CollectionMenu;
import com.hstc.utils.Page;

public interface CollectionMenuService {
    //增加或修改用户菜谱收藏记录
    Integer addCollectionMenu(CollectionMenu collectionMenu);

    //根据用户id 查询该用户的菜谱收藏记录并分页
    Page<CollectionMenu> queryCollectionMenuById(String userId, Integer start, Integer count);

    //根据用户id 和菜谱id 查询用户是否收藏
    CollectionMenu queryCollectionMenu(CollectionMenu collectionMenu);


    //根据用户id和用户名查询收藏菜谱记录
    Page<CollectionMenu> queryAllCollectionMenu(int page, int rows, String userId, String username);

    //根据用户id和用户名查询收藏菜谱记录总数
    int queryCollectionMenuCount(String userId, String username);

    //修改用户菜谱收藏记录
    Integer deleteCollectionMenu(CollectionMenu collectionMenu);

}
