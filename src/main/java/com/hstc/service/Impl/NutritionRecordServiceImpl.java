package com.hstc.service.Impl;

import com.hstc.dao.NutritionRecordMapper;
import com.hstc.pojo.NutritionRecord;
import com.hstc.service.NutritionRecordService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("nutritionRecordService")
@Transactional
public class NutritionRecordServiceImpl implements NutritionRecordService {

    @Autowired
    private NutritionRecordMapper nutritionRecordMapper;

    @Override
    public Page<NutritionRecord> queryAllNutritionRecord(int page, int rows, String userId, String username) {
        int start = page * rows;
        // 查询用户列表
        List<NutritionRecord> nutritionRecordList = nutritionRecordMapper.queryAllNutritionRecord(start, rows, userId, username);
        // 查询用户列表总记录数
        int total = queryNutritionRecordCount(userId, username);
        // 创建Page返回对象
        Page<NutritionRecord> result = new Page<>();
        result.setStart(page);
        result.setCount(rows);
        result.setRows(nutritionRecordList);
        result.setTotal(total);
        return result;
    }

    @Override
    public int queryNutritionRecordCount(String userId, String username) {
        return this.nutritionRecordMapper.queryNutritionRecordCount(userId, username);
    }

    @Override
    public int deleteNutritionRecord(String userId, String name, String time) {
        return this.nutritionRecordMapper.deleteNutritionRecord(userId, name, time);
    }

    /*
    * 根据用户id 查询用户营养数据表。
    * */
    @Override
    public Page<NutritionRecord> queryNutritionRecordById(String userId,
                                                          int start, int count) {
        List<NutritionRecord> nutritionRecords =
                nutritionRecordMapper.queryNutritionRecordById(userId, start, count);
        Integer total = nutritionRecordMapper.selectNutritionRecordCount(userId);
        Page<NutritionRecord> result = new Page<>();
        result.setStart(start);
        result.setRows(nutritionRecords);
        result.setCount(count);
        result.setTotal(total);
        return result;
    }


    /*
    * 增加用户每日营养素表
    * */
    @Override
    public int addNutritionRecord(NutritionRecord nutritionRecord) {
        return nutritionRecordMapper.addNutritionRecord(nutritionRecord);
    }

    /*
    * 修改用户每日营养素表
    * */
    @Override
    public int updateNutritionRecord(NutritionRecord nutritionRecord) {
        return nutritionRecordMapper.updateNutritionRecord(nutritionRecord);
    }

    @Override
    public List<NutritionRecord> queryNutritionRecordByUser(NutritionRecord nutritionRecord) {
        return nutritionRecordMapper.queryNutritionRecordByUser(nutritionRecord);
    }


}
