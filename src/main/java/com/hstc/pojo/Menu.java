package com.hstc.pojo;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    /*
    * 菜谱
    * */
    @Expose
    private int menu_id;
    @Expose
    private String menu_name;
    @Expose
    private String flavor;
    @Expose
    private String calorie;
    @Expose
    private String technology;
    @Expose
    private String make_time;
    @Expose
    private String diseases;
    @Expose
    private String menu_url;
    @Expose
    private List<MenuEffect> menuEffectList;
    @Expose
    private List<MenuIngredients> menuIngredientsList;
    @Expose
    private List<MenuNutrient> menuNutrientList;
    @Expose
    private List<MenuMake> menuMakeList;

}
