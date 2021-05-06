package com.hstc.controller;


import com.hstc.service.DailyEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/energy")
public class DailyEnergyController {

    @Autowired
    private DailyEnergyService dailyEnergyService;
}
