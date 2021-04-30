package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEffect {
    /*
    *  菜谱作用
    * */
    private int menu_id; //菜谱id
    private String effect; //菜谱作用
}
