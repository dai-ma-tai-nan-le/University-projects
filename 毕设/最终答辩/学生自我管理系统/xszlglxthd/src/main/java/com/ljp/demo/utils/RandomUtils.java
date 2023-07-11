package com.ljp.demo.utils;

        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Random;

/**
 * @author wgy
 * @version v1.0
 * @date 2022/9/7 14:46
 */
public class RandomUtils {
    public static String createActiveNumber(){
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        String s1 = sdf.format(new Date());
        String s2= Integer.toHexString(new Random().nextInt(99999));
        return s2;
    }

    //生成自习室加入码
    public static String createRoomNumber(){
        String s1= Integer.toHexString(new Random().nextInt(99999));
        String s2= Integer.toHexString(new Random().nextInt(99999));
        String s3= Integer.toHexString(new Random().nextInt(99999));
        String s4=s1+s2+s3;
        String s5=s4.substring(0,8);
        return s5;
    }
}
