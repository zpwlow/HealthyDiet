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
    private String username;  //用户名
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String menu_name;  //菜谱名
    @Expose
    private String time;  //时间
    @Expose
    private boolean whether; //用户是否选择菜谱

    public RecommendMenu(String user_id, int menu_id, String time, boolean whether) {
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.time = time;
        this.whether = whether;
    }
}
