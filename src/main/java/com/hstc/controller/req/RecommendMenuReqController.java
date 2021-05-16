package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Menu;
import com.hstc.pojo.MenuNutrient;
import com.hstc.pojo.NutritionRecord;
import com.hstc.pojo.RecommendMenu;
import com.hstc.service.MenuService;
import com.hstc.service.NutritionRecordService;
import com.hstc.service.RecommendMenuService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zpwlow
 * @date 2021年05月16  8:37
 */
@RestController
@RequestMapping("/userReq")
public class RecommendMenuReqController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RecommendMenuService recommendMenuService;

    @Autowired
    private NutritionRecordService nutritionRecordService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


    /*
     * 修改用户用户历史推荐菜谱记录
     * */
    @RequestMapping(value = "/updateRecommendMenu", method = RequestMethod.GET)
    public String updateRecommendMenu(@RequestParam String recommendMenuinfo){
        RecommendMenu recommendMenu =
                gson.fromJson(recommendMenuinfo, RecommendMenu.class);
        System.out.println(recommendMenu);
        Integer i = recommendMenuService.updateRecommendMenu(recommendMenu);
        Menu menu = menuService.queryMenuById(recommendMenu.getMenu_id());
        List<MenuNutrient> menuNutrientList = menu.getMenuNutrientList();
        if (i == 1){
            saveNutrition(recommendMenu,  menuNutrientList);
        }else {
            Integer integer = recommendMenuService.addRecommendMenuMapper(recommendMenu);
            if (integer==1){
                saveNutrition(recommendMenu,  menuNutrientList);
            }
        }
        return getString(i);
    }

    private void saveNutrition(RecommendMenu recommendMenu, List<MenuNutrient> menuNutrientList) {
        java.util.Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = format.format(date);
        for (MenuNutrient menuNutrient:menuNutrientList){
            NutritionRecord nutritionRecord =
                    new NutritionRecord(recommendMenu.getUser_id(),
                            menuNutrient.getName(),
                            Double.parseDouble(menuNutrient.getWeight()), datestr);
            int i1 = nutritionRecordService.updateNutritionRecord(nutritionRecord);
            if(i1 != 1){
                nutritionRecordService.addNutritionRecord(nutritionRecord);
            }
        }
    }

    private String getString(int i) {
        Result result;
        if(i!=1){
            result = new Result(404,"失败",null);
        }else {
            result = new Result(200,"成功",null);
        }
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }
}
