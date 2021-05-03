package com.hstc.pojo;

import com.google.gson.annotations.Expose;
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
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String name; //食材名
    @Expose
    private String weight; //重量
}
