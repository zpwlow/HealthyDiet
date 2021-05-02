package com.hstc.controller;

import com.hstc.pojo.Menu;
import com.hstc.service.MenuService;
import com.hstc.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list")
    public String queryMenuAll(@RequestParam(defaultValue="1")Integer page,
                               @RequestParam(defaultValue="10")Integer rows, Model model) {

        Page<Menu> menuPage = menuService.queryAllMenu(page, rows);
        model.addAttribute("page", menuPage);
        return "menu";
    }

}
