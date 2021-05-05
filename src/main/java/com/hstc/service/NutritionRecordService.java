package com.hstc.service;

import com.hstc.pojo.NutritionRecord;
import com.hstc.utils.Page;


public interface NutritionRecordService {

    //根据用户id查询用户的营养素表
    Page<NutritionRecord> queryNutritionRecordById(String userId, int start, int count);


    //增加用户每日营养素表
    int addNutritionRecord(NutritionRecord nutritionRecord);

    //修改用户每日营养素表
    int updateNutritionRecord(NutritionRecord nutritionRecord);
}
