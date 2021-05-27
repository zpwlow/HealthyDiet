package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hstc.pojo.Comment;
import com.hstc.pojo.DailyEnergy;
import com.hstc.service.CommentService;
import com.hstc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zpwlow
 * @date 2021年05月27  9:53
 */
@RestController
@RequestMapping("/userReq")
public class ReqCommentController {
    @Autowired
    private CommentService commentService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /*
     * 增加用户每日能量信息
     * */
    @RequestMapping(value = "/addComment",method = RequestMethod.GET)
    public String addComment(@RequestParam String commentinfo){
        Comment comment = gson.fromJson(commentinfo, Comment.class);
        Integer integer = commentService.addComment(comment);
        return getString(integer);
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
