package com.hstc.pojo;

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
    private int user_id; //用户id
    private int menu_id; //菜谱id
    private boolean wheter; //是否收藏
}
