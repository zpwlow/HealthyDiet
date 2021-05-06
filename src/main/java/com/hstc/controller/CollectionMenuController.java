package com.hstc.controller;


import com.hstc.service.CollectionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collection")
public class CollectionMenuController {
    @Autowired
    private CollectionMenuService collectionMenuService;
}
