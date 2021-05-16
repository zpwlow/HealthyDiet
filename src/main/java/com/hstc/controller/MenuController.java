package com.hstc.controller;

import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list.action" )
    public String queryMenuAll(@RequestParam(defaultValue="0")Integer page,
                               @RequestParam(defaultValue="6")Integer rows,
                               @RequestParam(defaultValue="所有类别")String category,
                               @RequestParam(defaultValue="")String menuName,
                               HttpServletRequest request,
                               Model model) {
        try{
            page = Integer.parseInt(request.getParameter("start"))-1;  //从前台获取 开始数据的索引
            rows = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
            category = request.getParameter("category");
            menuName = request.getParameter("menuName");
        }catch (Exception e){
        }
        model.addAttribute("category", category);
        model.addAttribute("search", menuName);
        if (category.equals("所有类别")){
            category = null;
        }
        if (menuName.equals("")){
            menuName = null;
        }
        Page<Menu> menuPage = menuService.queryAllMenu(page,rows,category,menuName);
        model.addAttribute("page", menuPage);
        return "menu";
    }

    @RequestMapping("/queryMenuById.action")
    @ResponseBody
    public Menu queryMenuById(int menuId) {
        Menu menu = menuService.queryMenuById(menuId);
        return menu;
    }

    @RequestMapping(value = "/update.action")
    @ResponseBody
    public String updateMenu(Menu menu){
        int rows = menuService.updateMenu(menu);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }

    @RequestMapping(value = "/delete.action")
    @ResponseBody
    public String deleteMenuById(int menuId){
        int rows = menuService.deleteMenuById(menuId);
        if(rows > 0){
            return "OK";
        }else{
            return "FALSE";
        }
    }

}
