package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.DailyEnergy;
import com.hstc.service.DailyEnergyService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpwlow
 * @date 2021年05月16  8:27
 */
@RestController
@RequestMapping("/userReq")
public class DailyEnergyReqController {

    @Autowired
    private DailyEnergyService dailyEnergyService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


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
     * 根据用户id 和时间查询用户的每日能量信息
     * */
    @RequestMapping(value = "/queryDailyEnergyByUser",method = RequestMethod.GET)
    public String queryDailyEnergyByUser(@RequestParam String dailyEnergyinfo){
        DailyEnergy dailyEnergy = gson.fromJson(dailyEnergyinfo, DailyEnergy.class);
        DailyEnergy dailyEnergyList = dailyEnergyService.queryDailyEnergyByUser(dailyEnergy);
        Result result;
        if(dailyEnergyList == null){
            result = new Result(404,"失败",null);
        }else {
            result = new Result(200,"成功",dailyEnergyList);
        }
        System.out.println("菜谱："+dailyEnergyList);
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
