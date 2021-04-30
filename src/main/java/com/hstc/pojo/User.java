package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id; //用户id
    private String sex;  // 用户性别
    private int age;    // 用户年龄
    private double height;  //用户身高
    private double weight;  //用户体重
    private String flavor;  //口味
    private String convalescent; //疗养疾病
    private String medical_history; //以往病史
}
