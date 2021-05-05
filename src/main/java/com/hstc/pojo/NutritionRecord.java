package com.hstc.pojo;

import com.google.gson.annotations.Expose;
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
    @Expose
    private String user_id; //用户id
    @Expose
    private String name; //营养素名
    @Expose
    private Double content; //含量
    @Expose
    private Time time; //时间
}
