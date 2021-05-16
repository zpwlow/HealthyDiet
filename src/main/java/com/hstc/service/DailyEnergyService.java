package com.hstc.service;

import com.hstc.pojo.DailyEnergy;
import com.hstc.utils.Page;

public interface DailyEnergyService {

    //根据用户id和用户名查询每日能量记录
    Page<DailyEnergy> queryAllDailyEnergy(int page, int rows, String userId, String username);

    //根据用户id和用户名查询每日能量记录总数
    int queryDailyEnergyCount(String userId, String username);

    //根据用户id和时间删除每日能量记录
    int deleteDailyEnergy(String userId, String time);

    //根据用户id查询用户的每日能量信息
    Page<DailyEnergy> queryDailyEnergyById(String userId, int start, int count);

    //增加用户每日能量信息
    Integer addDailyEnergy(DailyEnergy dailyEnergy);

    //修改用户每日能量信息
    Integer updateDailyEnergy(DailyEnergy dailyEnergy);

    //根据用户id 和时间查询用户的每日能量信息
    DailyEnergy queryDailyEnergyByUser(DailyEnergy dailyEnergy);
}
