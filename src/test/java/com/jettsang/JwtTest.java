package com.jettsang;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testToken(){
//        测试生成和解析
        String token = JwtTest.testGen();
        //        解析刚生成的token
        JwtTest.testParse(token);
    }

    //@Test
    public static String testGen() {
//        token:
//              head: 加密算法 令牌类型   base64格式的
//              payload: 用户的信息，不敏感的  base64格式的
//              签名： 防止被篡改的，根据加密盐和加密算法，即head和payload ，加密得出
//
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000))//添加过期时间
                .sign(Algorithm.HMAC256("itheima"));//指定算法,配置秘钥

        System.out.println(token);


        return token;
    }
    public static void testParse() {
        //定义字符串,模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE2OTQzMjUzMzB9.dFmeOG04w6EfnCue4CFS-x-XMRv145EfsY8wnchbxL4";

//    1。生成一个解密er：    传入加密方法和密钥
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token,生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        //如果篡改了头部和载荷部分的数据,那么验证失败
        //如果秘钥改了,验证失败
        //token过期
    }
    //@Test
    public static void testParse(String token) {

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token,生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
