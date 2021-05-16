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
    private String user_id; //用户id
    @Expose
    private String username;  //用户名
    @Expose
    private int menu_id; //菜谱id
    @Expose
    private String menu_name;  //菜谱名
    @Expose
    private boolean whether; //是否收藏

    public CollectionMenu(String user_id, int menu_id) {
        this.user_id = user_id;
        this.menu_id = menu_id;
    }

    public CollectionMenu(String user_id, int menu_id, boolean whether) {
        this.user_id = user_id;
        this.menu_id = menu_id;
        this.whether = whether;
    }
}
