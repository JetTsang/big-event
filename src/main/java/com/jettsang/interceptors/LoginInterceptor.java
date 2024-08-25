package com.jettsang.interceptors;

import com.jettsang.utils.JWTUtil;
import com.jettsang.utils.ThreadLocalUtil;
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
//            加入到 threadlocal里面
            ThreadLocalUtil.set(claims);
            System.out.printf(claims.toString());
            return true;
        }catch (Exception e){

            response.setStatus(401);
            return false;
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        移除对应存储的内容，防止内存泄漏
        ThreadLocalUtil.remove();
    }

    //    先编写方法
//    然后到config里面注册
}
