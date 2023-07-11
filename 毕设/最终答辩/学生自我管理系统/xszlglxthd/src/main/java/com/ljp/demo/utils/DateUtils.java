package com.ljp.demo.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

//sprringboot中怎么判断两个日期再同一天
public class DateUtils {
//    public static boolean isSameDay(LocalDate date1, LocalDate date2) {
//        return date1.isEqual(date2);
//    }

    public static boolean isSameDay(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

    public static boolean isSameDay1(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }

    //springboot怎么把string类型的"2023-03-28T13:30:26.000Z"转化为date类型的2023-03-28 13:30:26
    public static Date parseDate(String dateStr, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }


    //sprringboot中怎么判断两个日期再同一个月
    public static boolean isSameMonth(Date date3, Date date5) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date3);
        cal2.setTime(date5);
        boolean sameMonth = cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return sameMonth;
    }
}
