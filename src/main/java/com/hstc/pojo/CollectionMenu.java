package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollectionMenu {
    /*
    * 用户收藏菜谱记录
    * */
    @Expose
    private int user_id; //用户id
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private boolean wheter; //是否收藏
}
