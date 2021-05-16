package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.NutritionRecord;
import com.hstc.service.NutritionRecordService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zpwlow
 * @date 2021年05月16  8:42
 */
@RestController
@RequestMapping("/userReq")
public class NutritionRecordReqController {
    @Autowired
    private NutritionRecordService nutritionRecordService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


    /*
     * 用户请求每日营养记录
     * */
    @RequestMapping(value = "/queryNutritionRecordByUser",method = RequestMethod.GET)
    public String queryNutritionRecordByUser(@RequestParam String nutritionRecordinfo){
        NutritionRecord nutritionRecord =
                gson.fromJson(nutritionRecordinfo, NutritionRecord.class);
        List<NutritionRecord> nutritionRecords =
                nutritionRecordService.queryNutritionRecordByUser(nutritionRecord);
        Result result;
        if(nutritionRecords == null || nutritionRecords.size()==0){
            result = new Result(404,"失败",null);
        }else {
            result = new Result(200,"成功",nutritionRecords);
        }
        System.out.println("菜谱："+nutritionRecords);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }
}
