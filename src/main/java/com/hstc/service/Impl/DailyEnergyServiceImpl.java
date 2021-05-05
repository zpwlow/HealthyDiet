package com.hstc.service.Impl;

import com.hstc.dao.DailyEnergyMapper;
import com.hstc.pojo.DailyEnergy;
import com.hstc.service.DailyEnergyService;
import com.hstc.utils.Page;
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
    public Page<DailyEnergy> queryDailyEnergyById(int userId,int start, int count) {
        List<DailyEnergy> dailyEnergyList =
                dailyEnergyMapper.queryDailyEnergyById(userId, start, count);
        Integer total = dailyEnergyMapper.selectDailyEnergyCount(userId);
        Page<DailyEnergy> result = new Page<>();
        result.setStart(start);
        result.setRows(dailyEnergyList);
        result.setCount(count);
        result.setTotal(total);
        return result;
    }

    /*
    * 增加用户每日能量信息
    * */
    @Override
    public int addDailyEnergy(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.addDailyEnergy(dailyEnergy);
    }

    /*
    * 修改用户每日能量信息
    * */
    @Override
    public int updateDailyEnergy(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.updateDailyEnergy(dailyEnergy);
    }
}
