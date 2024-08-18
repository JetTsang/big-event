package com.jettsang.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final String key = "lulu";

    public static String  getToken(Map<String ,Object> claims){
//        生成token
        return JWT.create()
                .withClaim("claims",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 12 ))
                .sign(Algorithm.HMAC256(key));
    }

//    获取到token的信息
    public static Map<String ,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

}
