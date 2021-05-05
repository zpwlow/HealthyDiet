package com.hstc.service;

import com.hstc.pojo.DailyEnergy;
import com.hstc.utils.Page;

import java.util.List;

public interface DailyEnergyService {
    //根据用户id查询用户的每日能量信息
    Page<DailyEnergy> queryDailyEnergyById(int userId, int start, int count);

    //增加用户每日能量信息
    int addDailyEnergy(DailyEnergy dailyEnergy);

    //修改用户每日能量信息
    int updateDailyEnergy(DailyEnergy dailyEnergy);
}
