package com.hstc.service.Impl;

import com.hstc.dao.RecommendMenuMapper;
import com.hstc.pojo.RecommendMenu;
import com.hstc.service.RecommendMenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("secommendMenuService")
@Transactional
public class RecommendMenuServiceImpl implements RecommendMenuService {
    /*
    * 增加用户历史推荐菜谱记录
    * */
    @Autowired
    private RecommendMenuMapper recommendMenuMapper;

    /*
    * 根据用户id 查询该用户的历史推荐菜谱记录并分页
    * */
    @Override
    public Integer addRecommendMenuMapper(RecommendMenu recommendMenu) {
        return recommendMenuMapper.addRecommendMenuMapper(recommendMenu);
    }

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

}
