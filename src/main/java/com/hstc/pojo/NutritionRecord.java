package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionRecord {
    /*
    * 用户营养素表
    * */
    private int user_id; //用户id
    private String name; //营养素名
    private Double content; //含量
    private Time time; //时间
}
