package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuIngredients {
    /*
    * 菜谱食材表
    * */
    private int menu_id; //菜谱id
    private String name; //食材名
    private String weight; //重量
}
