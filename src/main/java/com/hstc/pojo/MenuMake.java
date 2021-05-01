package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuMake {
    /*
    * 菜谱做法步骤
    * */
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private int step;  // 步骤
    @Expose
    private String make; //做法
    @Expose
    private String url; //图片url
}
