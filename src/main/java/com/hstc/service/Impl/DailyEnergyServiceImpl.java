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

    @Override
    public Page<DailyEnergy> queryAllDailyEnergy(int page, int rows, String userId, String username) {
        int start = page * rows;
        // 查询用户列表
        List<DailyEnergy> dailyEnergyList = dailyEnergyMapper.queryAllDailyEnergy(start, rows, userId, username);
        // 查询用户列表总记录数
        int total = queryDailyEnergyCount(userId, username);
        // 创建Page返回对象
        Page<DailyEnergy> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(dailyEnergyList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryDailyEnergyCount(String userId, String username) {
        return this.dailyEnergyMapper.queryDailyEnergyCount(userId, username);
    }

    @Override
    public int deleteDailyEnergy(String userId, String time) {
        return this.dailyEnergyMapper.deleteDailyEnergy(userId, time);
    }


    /*
    * 根据用户id查询用户的每日能量信息并进行分页
    * */
    @Override
    public Page<DailyEnergy> queryDailyEnergyById(String userId,int start, int count) {
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
    public Integer addDailyEnergy(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.addDailyEnergy(dailyEnergy);
    }

    /*
    * 修改用户每日能量信息
    * */
    @Override
    public Integer updateDailyEnergy(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.updateDailyEnergy(dailyEnergy);
    }

    @Override
    public DailyEnergy queryDailyEnergyByUser(DailyEnergy dailyEnergy) {
        return dailyEnergyMapper.queryDailyEnergyByUser(dailyEnergy);
    }
}
