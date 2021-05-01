package com.hstc.pojo;

import com.google.gson.annotations.Expose;
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
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String effect; //菜谱作用
}
