package com.hstc.service;

import com.hstc.pojo.DailyEnergy;

import java.util.List;

public interface DailyEnergyService {
    //根据用户id查询用户的每日能量信息
    List<DailyEnergy> queryDailyEnergyById(int userId);
}
