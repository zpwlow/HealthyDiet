package com.hstc.service.Impl;

import com.hstc.dao.DailyEnergyMapper;
import com.hstc.pojo.DailyEnergy;
import com.hstc.service.DailyEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dailyEnergyService")
@Transactional
public class DailyEnergyServiceImpl implements DailyEnergyService {

    @Autowired
    private DailyEnergyMapper dailyEnergyMapper;

    /*
    * 根据用户id查询用户的每日能量信息
    * */
    @Override
    public List<DailyEnergy> queryDailyEnergyById(int userId) {
        return dailyEnergyMapper.queryDailyEnergyById(userId);
    }

    /*
    * 增加用户每日能量信息
    * */
    @Override
    public int addDailyEnergy(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.addDailyEnergy(dailyEnergy);
    }
}
