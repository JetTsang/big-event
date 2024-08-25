package com.jettsang.controller;

import com.jettsang.pojo.Result;
import com.jettsang.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleContorller {

//    获取所有的文章数据
    @GetMapping("/list")
    public Result list(@RequestHeader("Authorization") String token, HttpServletResponse response){
//        try{
//            //        验证token，从cookies 里面获取到，
//            Map<String,Object> claims =  JWTUtil.parseToken(token);
//        }catch (Exception e){
//            response.setStatus(401);
//            return Result.error("错误！需要登录" + e.getMessage());
//        }


        return Result.success("成功了，这是列表");
    }

}
