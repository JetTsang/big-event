package com.jettsang.interceptors;

import com.jettsang.utils.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
//    前置拦截器，主要作用就是检查token是否合格。

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("Authorization");
            Map<String,Object> claims =  JWTUtil.parseToken(token);
            System.out.printf(claims.toString());
            return true;
        }catch (Exception e){

            response.setStatus(401);
            return false;
        }

    }

//    先编写方法
//    然后到config里面注册
}
