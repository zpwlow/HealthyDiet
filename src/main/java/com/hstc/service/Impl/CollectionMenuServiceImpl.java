package com.hstc.service.Impl;

import com.hstc.dao.CollectionMenuMapper;
import com.hstc.pojo.CollectionMenu;
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
    * 增加或删除用户菜谱收藏记录
    * */
    @Override
    public Integer addCollectionMenu(CollectionMenu collectionMenu) {
        Integer integer = collectionMenuMapper.deleteCollectionMenu(collectionMenu);
        if(integer!=1){
            integer = collectionMenuMapper.addCollectionMenu(collectionMenu);
        }
        return integer;
    }

    /*
    * 根据用户id 查询该用户的菜谱收藏记录并分页
    * */
    @Override
    public Page<CollectionMenu> queryCollectionMenuById(String userId, Integer start, Integer count) {
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

    @Override
    public Page<CollectionMenu> queryAllCollectionMenu(int page, int rows, String userId, String username) {
        int start = page * rows;
        // 查询用户列表
        List<CollectionMenu> collectionMenuList = collectionMenuMapper.queryAllCollectionMenu(start, rows, userId, username);
        // 查询用户列表总记录数
        int total = queryCollectionMenuCount(userId, username);
        // 创建Page返回对象
        Page<CollectionMenu> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(collectionMenuList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryCollectionMenuCount(String userId, String username) {
        return this.collectionMenuMapper.queryCollectionMenuCount(userId, username);
    }

    @Override
    public Integer deleteCollectionMenu(CollectionMenu collectionMenu) {
        return collectionMenuMapper.deleteCollectionMenu(collectionMenu);
    }


}
