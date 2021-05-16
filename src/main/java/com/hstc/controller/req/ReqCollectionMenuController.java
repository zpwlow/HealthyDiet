package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.CollectionMenu;
import com.hstc.pojo.Menu;
import com.hstc.service.CollectionMenuService;
import com.hstc.service.MenuService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zpwlow
 * @date 2021年05月16  8:23
 * 用户请求菜谱收藏记录
 */
@RestController
@RequestMapping("/userReq")
public class ReqCollectionMenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CollectionMenuService collectionMenuService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


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
     * 用户请求收藏菜谱记录
     * */
    @RequestMapping(value = "/queryCollectionMenuList", method = RequestMethod.GET)
    public String queryCollectionMenuList(@RequestParam("userId") String userId){
        List<Menu> menuList = menuService.queryCollectionMenuList(userId);
        return getMenuJson(menuList);
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
