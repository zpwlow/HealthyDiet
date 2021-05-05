package com.hstc.dao;

import com.hstc.pojo.DailyEnergy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyEnergyMapper {

    //根据用户id查询用户的每日能量信息
    List<DailyEnergy> queryDailyEnergyById(@Param("userId") String userId,
                                           @Param("start") int start,
                                           @Param("rows") int rows);

    // 根据用户id查询该用户的每日能量信息数量
    Integer selectDailyEnergyCount(@Param("userId") String userId);

    //增加用户每日能量信息
    int addDailyEnergy(DailyEnergy dailyEnergy);

    //修改用户每日能量信息
    int updateDailyEnergy(DailyEnergy dailyEnergy);
}
