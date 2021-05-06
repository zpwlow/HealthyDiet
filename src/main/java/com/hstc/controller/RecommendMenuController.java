package com.hstc.controller;

import com.hstc.service.RecommendMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommend")
public class RecommendMenuController {
    @Autowired
    private RecommendMenuService recommendMenuService;
}
