package com.jettsang.exception;

import com.jettsang.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//处理全局异常
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e ){
//        在控制台打印错误堆栈信息
        e.printStackTrace();
//        判断是否错误对象有对应的信息，没有则默认错误信息
        String msg = StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "系统错误";
        return Result.error(msg);
    }
}
