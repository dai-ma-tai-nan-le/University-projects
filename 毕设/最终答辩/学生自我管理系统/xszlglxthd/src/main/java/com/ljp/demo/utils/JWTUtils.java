package com.ljp.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//jwt工具类
public class JWTUtils {
    //签名
    private static final String SECERT="ljp";

    //生成token信息
    public static String getToken(String username){
        JWTCreator.Builder builder=JWT.create();
        //设置过期时间
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Map<String,Object> header=new HashMap<>();
        header.put("alg","HS256");
        header.put("typ","JWT");
        return builder.withHeader(header)
                .withAudience(username)//作为载荷
                .withExpiresAt(calendar.getTime())
//                .withExpiresAt(null)//为永久
                .sign(Algorithm.HMAC256(SECERT));

    }

    //校验token是否合法,合法返回DecodedJWT对象
    public static DecodedJWT verify(String token) {
        DecodedJWT verify=null;
        try{
            verify=JWT.require(Algorithm.HMAC256(SECERT)).build().verify(token);
        }catch(Exception e){
            e.printStackTrace();
        }
        return verify;
    }

}
