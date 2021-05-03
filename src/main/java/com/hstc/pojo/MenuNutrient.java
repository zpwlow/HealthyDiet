package com.hstc.pojo;

import com.google.gson.annotations.Expose;
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
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String name; // 营养素名
    @Expose
    private String weight; //含量
}
