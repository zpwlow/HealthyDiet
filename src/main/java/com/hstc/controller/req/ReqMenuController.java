package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.dao.RecommendMenuMapper;
import com.hstc.pojo.Menu;
import com.hstc.pojo.RecommendMenu;
import com.hstc.pojo.User;
import com.hstc.service.RecommendMenuService;
import com.hstc.service.UserService;
import com.hstc.utils.Result;
import com.hstc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author zpwlow
 * @date 2021年05月16  8:19
 */
@RestController
@RequestMapping("/userReq")
public class ReqMenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RecommendMenuService recommendMenuService;

    @Autowired
    private UserService userService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


    /**
     * 用户请求，根据菜谱名查询，返回用户菜谱的详细信息
     * produces = "text/plain;charset=utf-8" //防止中文乱码
     */
    @RequestMapping(value = "/queryByMname",method = RequestMethod.GET)
    public String selectMenuByName(@RequestParam("name") String name){
        String menuName = "%" + name +"%";
        List<Menu> menuList = menuService.queryMenuByName(menuName);
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
}
