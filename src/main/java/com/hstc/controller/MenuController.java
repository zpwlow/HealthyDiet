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

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list.action" )
    public String queryMenuAll(@RequestParam(defaultValue="0")Integer page,
                               @RequestParam(defaultValue="6")Integer rows,
                               HttpServletRequest request,
                               Model model) {
        try{
            page = Integer.parseInt(request.getParameter("start"));  //从前台获取 开始数据的索引
            rows = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
        }catch (Exception e){
        }
        System.out.println("page:"+page+"  rows:"+rows);
        Page<Menu> menuPage = menuService.queryAllMenu(page, rows);
        System.out.println(menuPage);
        model.addAttribute("page", menuPage);
        return "menu";
    }

}
