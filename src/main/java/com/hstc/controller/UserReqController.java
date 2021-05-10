package com.hstc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.*;
import com.hstc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/*
* @RestController //有请求时，将返回的数据输出前端
* */
@RestController
@RequestMapping("/userReq")
public class UserReqController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollectionMenuService collectionMenuService;

    @Autowired
    private DailyEnergyService dailyEnergyService;

    @Autowired
    private RecommendMenuService recommendMenuService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private final String datetime=null;

    /**
     * 用户请求，根据菜谱名查询，返回用户菜谱的详细信息
     * produces = "text/plain;charset=utf-8" //防止中文乱码
     */
    @RequestMapping(value = "/queryByMname",method = RequestMethod.GET)
    public String selectMenuByName(@RequestParam("name") String name){
        String menuName = "%" + name +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
        return getMenuJson(menuList);
    }

    /*
    * 用户请求，获取用户个人信息保存到数据库中
    * */
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.addUser(user);
        return getString(i);
    }

    /*
    * 用户请求：用户修改个人信息
    * */
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.updateUser(user);
        return getString(i);
    }

    /*
    * 用户请求: 根据用户ID 查询用户是否存在，存在时返回用户信息，不存在时请求失败。
    * */
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam("userId") String userId){
        User user = userService.selectUserById(userId);
        Result result;
        if(user == null){
            result = new Result(404,"用户不存在",null);
        }else {
            result = new Result(200,"成功",user);
        }
        System.out.println("用户："+user);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }

    /*
    * 用户请求：增加或删除用户菜谱收藏记录
    * */
    @RequestMapping(value = "/addCollectionMenu",method = RequestMethod.GET)
    public String addCollectionMenu(@RequestParam String collectionMenuinfo){
        CollectionMenu collectionMenu =
                gson.fromJson(collectionMenuinfo, CollectionMenu.class);
        System.out.println(collectionMenu);
        Integer integer = collectionMenuService.addCollectionMenu(collectionMenu);
        return getString(integer);
    }

    /*
     * 根据用户id 和菜谱id 查询用户是否收藏
     * */
    @RequestMapping(value = "/queryCollectionMenu",method = RequestMethod.GET)
    public String queryCollectionMenu(@RequestParam String collectionMenuinfo){
        CollectionMenu collectionMenu =
                gson.fromJson(collectionMenuinfo, CollectionMenu.class);
        System.out.println(collectionMenu);
        CollectionMenu collectionMenu1 =
                collectionMenuService.queryCollectionMenu(collectionMenu);
        Result result;
        if(collectionMenu1 == null){
            result = new Result(404,"未收藏",null);
        }else {
            result = new Result(200,"成功",collectionMenu1);
        }
        System.out.println("收藏菜谱信息："+collectionMenu1);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }

    /*
     * 增加用户每日能量信息
     * */
    @RequestMapping(value = "/addDailyEnergy",method = RequestMethod.GET)
    public String addDailyEnergy(@RequestParam String dailyEnergyinfo){
        DailyEnergy dailyEnergy = gson.fromJson(dailyEnergyinfo, DailyEnergy.class);
        int i = dailyEnergyService.addDailyEnergy(dailyEnergy);
        return getString(i);
    }

    /*
     * 修改用户每日能量信息
     * */
    @RequestMapping(value = "/updateDailyEnergy",method = RequestMethod.GET)
    public String updateDailyEnergy(@RequestParam String dailyEnergyinfo){
        DailyEnergy dailyEnergy = gson.fromJson(dailyEnergyinfo, DailyEnergy.class);
        int i = dailyEnergyService.updateDailyEnergy(dailyEnergy);
        return getString(i);
    }

    /*
    * 推荐用户早餐
    * */
    @RequestMapping(value = "/queryBreakfast", method = RequestMethod.GET)
    public String querBreakfast(@RequestParam("userId") String userId){
        List<Menu> menuList = menuService.recommendMenuList("早餐", null);
        saveCollectionMenu(userId,menuList);
        return getMenuJson(menuList);
    }

    /*
     * 推荐用户午餐
     * */
    @RequestMapping(value = "/queryLunch", method = RequestMethod.GET)
    public String queryLunch(@RequestParam("userId") String userId){
        User user = userService.selectUserById(userId);
        System.out.println(user);
        String diseases = user.getConvalescent();
        String medical_history = user.getMedical_history();
        String flavor = user.getFlavor();
        if(diseases.equals("无")){
            diseases=null;
        }
        if(Objects.equals(diseases, "无") && !medical_history.equals("无")){
            diseases = medical_history;
        }
        flavor = "%" +flavor +"%";
        System.out.println("diseases"+diseases+"   flavor:" +flavor);
        List<Menu> menuList = menuService.recommendMenuList(diseases, flavor);
        if (menuList == null || menuList.size()==0){
            menuList = menuService.recommendMenuList(null, flavor);
        }
        saveCollectionMenu(userId,menuList);
        return getMenuJson(menuList);
    }

    /*
    * 修改用户用户历史推荐菜谱记录
    * */
    @RequestMapping(value = "/updateRecommendMenu", method = RequestMethod.GET)
    public String updateRecommendMenu(@RequestParam String recommendMenuinfo){
        RecommendMenu recommendMenu =
                gson.fromJson(recommendMenuinfo, RecommendMenu.class);
        System.out.println(recommendMenu);
        Integer i = recommendMenuService.updateRecommendMenu(recommendMenu);
        return getString(i);
    }

    /*
    * 用户请求收藏菜谱记录
    * */
    @RequestMapping(value = "/queryCollectionMenuList", method = RequestMethod.GET)
    public String queryCollectionMenuList(@RequestParam("userId") String userId){
        List<Menu> menuList = menuService.queryCollectionMenuList(userId);
        return getMenuJson(menuList);
    }


    /*
    * 推荐用户每日食谱后保存数据库
    * */
    private void saveCollectionMenu(String userId, List<Menu> menuList){
        java.util.Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = format.format(date);
        for (Menu menu:menuList){
            RecommendMenu recommendMenu =
                    new RecommendMenu(userId, menu.getMenu_id(), datestr, false);
            recommendMenuService.addRecommendMenuMapper(recommendMenu);
        }
    }

    private String getMenuJson(List<Menu> menuList){
        Result result;
        if(menuList == null || menuList.size()==0){
            result = new Result(404,"失败",null);
        }else {
            result = new Result(200,"成功",menuList);
        }
        System.out.println("菜谱："+menuList);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
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
