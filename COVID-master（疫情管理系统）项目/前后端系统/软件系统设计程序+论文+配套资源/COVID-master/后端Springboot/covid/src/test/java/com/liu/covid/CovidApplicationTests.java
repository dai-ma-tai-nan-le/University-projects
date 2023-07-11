package com.liu.covid;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.covid.entity.User;
import com.liu.covid.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class CovidApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        try{

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            String nowdate=format.format(new Date());//当前月份
            Date d1 = new SimpleDateFormat("yyyy-MM").parse("2018-01");//定义起始日期
            Date d2 = new SimpleDateFormat("yyyy-MM").parse(nowdate);//定义结束日期 可以去当前月也可以手动写日期。
            Calendar dd = Calendar.getInstance();//定义日期实例
            dd.setTime(d1);//设置日期起始时间
            while (dd.getTime().before(d2)) {//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String str = sdf.format(dd.getTime());
                System.out.println(str);//输出日期结果
                dd.add(Calendar.MONTH, 1);//进行当前日期月份加1
            }
            System.out.println(nowdate);//输出日期结果
        }catch (Exception e){
            System.out.println("异常"+e.getMessage());
        }

    }

}
