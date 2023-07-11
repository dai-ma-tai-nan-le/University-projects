package com.ljp.demo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/7 14:35
 */
public class Md5Utils {
    //md5摘要算法
    public static String md5(String s){
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            md5.update(s.getBytes("utf-8"));
            byte[] digest = md5.digest();//散列之后数据
            return new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
