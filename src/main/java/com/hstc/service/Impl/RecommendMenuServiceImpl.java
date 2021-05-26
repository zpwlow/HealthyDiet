package com.hstc.service.Impl;

import com.hstc.dao.RecommendMenuMapper;
import com.hstc.pojo.RecommendMenu;
import com.hstc.service.RecommendMenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("recommendMenuService")
@Transactional
public class RecommendMenuServiceImpl implements RecommendMenuService {

    @Autowired
    private RecommendMenuMapper recommendMenuMapper;

    @Override
    public Page<RecommendMenu> queryAllRecommendMenu(int page, int rows, String userId, String username) {
        int start = page * rows;
        // 查询用户列表
        List<RecommendMenu> recommendMenuList = recommendMenuMapper.queryAllRecommendMenu(start, rows, userId, username);
        // 查询用户列表总记录数
        int total = queryRecommendMenuCount(userId, username);
        // 创建Page返回对象
        Page<RecommendMenu> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(recommendMenuList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryRecommendMenuCount(String userId, String username) {
        return this.recommendMenuMapper.queryRecommendMenuCount(userId, username);
    }

    @Override
    public int deleteRecommendMenu(String userId, int menuId, String time) {
        return this.recommendMenuMapper.deleteRecommendMenu(userId,menuId,time);
    }

    /*
     * 增加用户历史推荐菜谱记录
     * */
    @Override
    public Integer addRecommendMenuMapper(RecommendMenu recommendMenu) {
        return recommendMenuMapper.addRecommendMenuMapper(recommendMenu);
    }

    /*
     * 根据用户id 查询该用户的历史推荐菜谱记录并分页
     * */
    @Override
    public Page<RecommendMenu> queryRecommendMenuMapperById(String userId,
                                                            int start, int count) {
        List<RecommendMenu> recommendMenuList =
                recommendMenuMapper.queryRecommendMenuMapperById(userId, start, count);
        Integer total = recommendMenuMapper.queryRecommendMenuMapperListCount(userId);
        // 创建Page返回对象
        Page<RecommendMenu> result = new Page<>();
        result.setStart(start);
        result.setRows(recommendMenuList);
        result.setCount(count);
        result.setTotal(total);
        return result;
    }

    /*
    * 修改用户历史推荐菜谱记录
    * */
    @Override
    public Integer updateRecommendMenu(RecommendMenu recommendMenu) {
        return recommendMenuMapper.updateRecommendMenu(recommendMenu);
    }

    @Override
    public List<RecommendMenu> queryRecommendMenuByIdTime(String userId, String time) {
        return recommendMenuMapper.queryRecommendMenuByIdTime(userId,time);
    }

}
