package com.jettsang.controller;

import com.jettsang.pojo.Result;
import com.jettsang.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jettsang.pojo.User;
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

}
