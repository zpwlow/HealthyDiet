package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Expose
    private int user_id; //用户id
    @Expose
    private String sex;  // 用户性别
    @Expose
    private int age;    // 用户年龄
    @Expose
    private double height;  //用户身高
    @Expose
    private double weight;  //用户体重
    @Expose
    private String flavor;  //口味
    @Expose
    private String convalescent; //疗养疾病
    @Expose
    private String medical_history; //以往病史
}
