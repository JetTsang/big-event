package com.jettsang.controller;

import com.jettsang.pojo.Result;
import com.jettsang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jettsang.pojo.User;
//
@RestController
@RequestMapping("/user")
public class UserController {
//    注入controller
    @Autowired
    private UserService userService;

//    使用RequrestParams 进行参数重命名
    @PostMapping("/register")
    public Result register(String username , @RequestParam("password") String pwd){
//  TODO:  查询用户，判断是否占用
    User user = userService.findByUserName(username);
    if(user == null){
//  TODO: 注册逻辑
        userService.register(username,pwd);
        return Result.success();
    }else{
//        被占用了
    return Result.error("被占用了");
    }



    }

}
