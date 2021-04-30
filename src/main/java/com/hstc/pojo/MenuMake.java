package com.hstc.pojo;

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
    private int menu_id; //菜谱id
    private int step;  // 步骤
    private String make; //做法
    private String url; //图片url
}
