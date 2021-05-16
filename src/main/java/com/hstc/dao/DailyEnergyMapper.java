package com.hstc.dao;

import com.hstc.pojo.DailyEnergy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyEnergyMapper {

    //根据用户id和用户名查询每日能量记录
    List<DailyEnergy> queryAllDailyEnergy(@Param("start") int start, @Param("rows") int rows, @Param("userId") String userId, @Param("username") String username);

    //根据用户id和用户名查询每日能量记录总数
    int queryDailyEnergyCount(@Param("userId") String userId, @Param("username") String username);

    //根据用户id和时间删除每日能量记录
    int deleteDailyEnergy(@Param("userId") String userId, @Param("time") String time);

    //根据用户id查询用户的每日能量信息
    List<DailyEnergy> queryDailyEnergyById(@Param("userId") String userId,
                                           @Param("start") int start,
                                           @Param("rows") int rows);

    // 根据用户id查询该用户的每日能量信息数量
    Integer selectDailyEnergyCount(@Param("userId") String userId);

    //增加用户每日能量信息
    Integer addDailyEnergy(DailyEnergy dailyEnergy);

    //修改用户每日能量信息
    Integer updateDailyEnergy(DailyEnergy dailyEnergy);

    //根据用户id 和时间查询用户的每日能量信息
    DailyEnergy queryDailyEnergyByUser(DailyEnergy dailyEnergy);

}
