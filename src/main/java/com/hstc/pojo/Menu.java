package com.hstc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    /*
    * 菜谱
    * */
    private int menu_id;
    private String menu_name;
    private String flavor;
    private String technology;
    private String make_time;
    private String diseases;
    private String menu_url;
}
