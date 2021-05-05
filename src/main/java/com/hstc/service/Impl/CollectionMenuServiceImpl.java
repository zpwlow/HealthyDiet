package com.hstc.service.Impl;

import com.hstc.dao.CollectionMenuMapper;
import com.hstc.pojo.CollectionMenu;
import com.hstc.pojo.DailyEnergy;
import com.hstc.service.CollectionMenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("collectionMenuService")
public class CollectionMenuServiceImpl implements CollectionMenuService {

    @Autowired
    private CollectionMenuMapper collectionMenuMapper;

    /*
    * 增加或修改用户菜谱收藏记录
    * */
    @Override
    public Integer addCollectionMenu(CollectionMenu collectionMenu) {
        Integer integer = collectionMenuMapper.updateCollectionMenu(collectionMenu);
        if(integer!=1){
            integer = collectionMenuMapper.addCollectionMenu(collectionMenu);
        }
        return integer;
    }

    /*
    * 根据用户id 查询该用户的菜谱收藏记录并分页
    * */
    @Override
    public Page<CollectionMenu> queryCollectionMenuById(String userId, int start, int count) {
        List<CollectionMenu> collectionMenuList =
                collectionMenuMapper.queryCollectionMenuById(userId, start, count);
        Integer total = collectionMenuMapper.queryCollectionMenuListCount(userId);
        Page<CollectionMenu> result = new Page<>();
        result.setStart(start);
        result.setRows(collectionMenuList);
        result.setCount(count);
        result.setTotal(total);
        return result;
    }

    /*
    * 根据用户id 和菜谱id 查询用户是否收藏
    * */
    @Override
    public CollectionMenu queryCollectionMenu(CollectionMenu collectionMenu) {
        return collectionMenuMapper.queryCollectionMenu(collectionMenu);
    }


}
