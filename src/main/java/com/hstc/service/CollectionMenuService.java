package com.hstc.service;

import com.hstc.pojo.CollectionMenu;
import com.hstc.pojo.DailyEnergy;
import com.hstc.utils.Page;

import java.util.List;

public interface CollectionMenuService {
    //增加或修改用户菜谱收藏记录
    Integer addCollectionMenu(CollectionMenu collectionMenu);

    //根据用户id 查询该用户的菜谱收藏记录并分页
    Page<CollectionMenu> queryCollectionMenuById(String userId, int start, int count);

    //根据用户id 和菜谱id 查询用户是否收藏
    CollectionMenu queryCollectionMenu(CollectionMenu collectionMenu);


}
