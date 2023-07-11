package com.ljp.demo.utils;

import java.util.Base64;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/7 15:04
 */
public class Base64Utils {
    //加密
    public static String encode(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
    //解密
    public static String decode(String msg){
        return new String(Base64.getDecoder().decode(msg));
    }
}
