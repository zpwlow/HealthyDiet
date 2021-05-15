package com.hstc.dao;

import com.hstc.pojo.NutritionRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NutritionRecordMapper {

    //根据用户id查询用户的营养素表
    List<NutritionRecord> queryNutritionRecordById(@Param("userId") String userId,
                                                   @Param("start") int start,
                                                   @Param("rows") int rows);

    // 根据用户id查询该用户的每日能量信息数量
    Integer selectNutritionRecordCount(@Param("userId") String userId);

    //增加用户每日营养素表
    int addNutritionRecord(NutritionRecord nutritionRecord);

    //修改用户每日营养素表
    int updateNutritionRecord(NutritionRecord nutritionRecord);

    //根据用户信息查询用户每日营养素
    List<NutritionRecord> queryNutritionRecordByUser(NutritionRecord nutritionRecord);
}
