package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendMenu {
    /*
    * 历史推荐菜谱记录
    * */
    @Expose
    private String user_id; //用户id
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String time;  //时间
    @Expose
    private boolean whether; //用户是否选择菜谱


}
