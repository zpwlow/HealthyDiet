package com.hstc.controller.req;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hstc.pojo.OpenId;
import com.hstc.pojo.User;
import com.hstc.service.UserService;
import com.hstc.utils.Result;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


/*
* @RestController //有请求时，将返回的数据输出前端
* 用户请求个人信息
* */
@RestController
@RequestMapping("/userReq")
public class ReqUserController {

    @Autowired
    private UserService userService;

    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /*
    * 用户请求，获取用户个人信息保存到数据库中
    * */
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.addUser(user);
        return getString(i);
    }

    /*
    * 用户请求：用户修改个人信息
    * */
    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(@RequestParam String userinfo){
        User user = gson.fromJson(userinfo, User.class);  //json串转为对象
        System.out.println(user);
        int i = userService.updateUser(user);
        return getString(i);
    }

    /*
    * 用户请求: 根据用户ID 查询用户是否存在，存在时返回用户信息，不存在时请求失败。
    * */
    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public String queryUserById(@RequestParam("userId") String userId){
        User user = userService.selectUserById(userId);
        Result result;
        if(user == null){
            result = new Result(404,"用户不存在",null);
        }else {
            result = new Result(200,"成功",user);
        }
        System.out.println("用户："+user);
        //将List转换成json数据
        String json = gson.toJson(result);
        System.out.println("Json："+json);
        return json;
    }


    /*
    * 获取用户OpenId
    * */
    @RequestMapping(value = "/queryOpenId")
    public String queryOpenId(@RequestParam String openIdinfo){
        OpenId openId = gson.fromJson(openIdinfo, OpenId.class);
        System.out.println(openId);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String result="";//访问返回结果
        BufferedReader read=null;//读取访问结果
        try {
            //创建url
            URL realurl=new URL(url+"?appid="
                    +openId.getAppId()+"&secret="+openId.getSecret()
                    +"&js_code="+openId.getJs_code()+"&grant_type="+openId.getGrant_type());
            //打开连接
            URLConnection connection=realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段，获取到cookies等
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;//循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(read!=null){//关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("result:"+result);
        return result;



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
