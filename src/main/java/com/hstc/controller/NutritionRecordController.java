package com.hstc.controller;

import com.hstc.service.NutritionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nutrition")
public class NutritionRecordController {

    @Autowired
    private NutritionRecordService nutritionRecordService;
}
