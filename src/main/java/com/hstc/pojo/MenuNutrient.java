package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuNutrient {
    /*
    * 菜谱营养素
    * */
    private int menu_id; //菜谱id
    private String name; // 营养素名
    private String weight; //含量
}
