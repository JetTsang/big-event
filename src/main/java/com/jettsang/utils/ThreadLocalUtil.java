package com.jettsang.utils;

public class ThreadLocalUtil {
    static private final ThreadLocal THREAD_LOCAL = new ThreadLocal();

//    获取
    public static <T> T get(){

        return (T) THREAD_LOCAL.get();
    }
//    设置
    public static void  set(Object value){
        THREAD_LOCAL.set(value);
    }
//    删除
    public static  void  remove(){
        THREAD_LOCAL.remove();
    }
}
