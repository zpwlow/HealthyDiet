package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendMenu {
    /*
    * 历史推荐菜谱记录
    * */
    private int user_id; //用户id
    private int menu_id; //菜谱id
    private Time time;  //时间
    private boolean whether; //用户是否选择菜谱
}
