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
    private String username;  //用户名
    @Expose
    private String name; //营养素名
    @Expose
    private Double content; //含量
    @Expose
    private String time; //时间

    public NutritionRecord(String user_id, String time) {
        this.user_id = user_id;
        this.time = time;
    }

    public NutritionRecord(String user_id, String name, Double content, String time) {
        this.user_id = user_id;
        this.name = name;
        this.content = content;
        this.time = time;
    }
}
