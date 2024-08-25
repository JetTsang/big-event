package com.jettsang.controller;

import com.jettsang.pojo.Result;
import com.jettsang.service.UserService;
import com.jettsang.utils.JWTUtil;
import com.jettsang.utils.Md5Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.jettsang.pojo.User;

import java.util.HashMap;
import java.util.Map;

//
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
//    注入controller
    @Autowired
    private UserService userService;

//    使用RequrestParams 进行参数重命名
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username ,@Pattern(regexp = "^\\S{5,16}$") @RequestParam("password") String pwd){
//    TODO: 这里有异常了，需要进行全局异常处理
    User user = userService.findByUserName(username);
    if(user == null){
        userService.register(username,pwd);
        return Result.success();
    }else{
//        被占用了
    return Result.error("被占用了");
    }



    }

//    登录接口
    @PostMapping("/login")
    public Result login(String username,String password){
        User user = userService.findByUserName(username);
        if(user == null){
            return Result.error("用户名或密码错误");
        }
        ;
        if(Md5Util.checkPassword(password,user.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
            String token = JWTUtil.getToken(claims);
            return Result.success(token);
        }
        return Result.error("未知错误");
    }

    @GetMapping("/userInfo")
    public Result userInfo(@RequestHeader("Authorization") String token){
//        解析token
        Map<String,Object> claims = JWTUtil.parseToken(token);
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
