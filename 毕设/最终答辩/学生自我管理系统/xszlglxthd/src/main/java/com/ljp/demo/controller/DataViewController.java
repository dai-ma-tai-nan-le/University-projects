package com.ljp.demo.controller;


import com.ljp.demo.entity.*;
import com.ljp.demo.service.DataViewService;
import com.ljp.demo.service.StudyPlanService;
import com.ljp.demo.service.StudyRoomService;
import com.ljp.demo.utils.DateUtils;
import com.ljp.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/dataview")
public class DataViewController {
    @Resource
    private DataViewService dataViewService;
    @Autowired
    private StudyPlanService studyPlanService;
    @Autowired
    private StudyRoomService studyRoomService;

    ////查询学习计划列表
    @PostMapping("/xxjhList")
    public Result xxjhList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        Date date1,date2;
        date1=new Date();
        int totalNum=0,todayNum=0,todayTime=0,totalTime=0,dayTime,day=0;
        try{
            List<DataView> dataViews=new ArrayList<DataView>();
            List<Study_plan> list=studyPlanService.selectList(username);
            if (list.size()==0){
                return Result.suc(dataViews);
            }else {
                for (int i=0;i<list.size();i++){
                    //判断是否是今天
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (b){
                        todayNum+=list.get(i).getTodayNum();
                        totalNum+=list.get(i).getTotalNum();
                        todayTime+=list.get(i).getTodayTime()*list.get(i).getTodayNum();
                        totalTime+=list.get(i).getTotalTime();
                    }else{
                        totalNum+=list.get(i).getTotalNum();
                        totalTime+=list.get(i).getTotalTime();
                    }
                }
                //总天数
                List<Experience> experiences=studyRoomService.selectDay(username);
                int number=0;
                for (int j=0;j<experiences.size()-1;j++){
                    Date date3=experiences.get(j).getCreateTime();
                    Date date4=experiences.get(j+1).getCreateTime();
                    //前后是不是在一天中
                    boolean b1= DateUtils.isSameDay(date3,date4);
                    if (!b1){
                        day+=1;
                    }else{
                        if (number==1){
                            continue;
                        }else{
                            day+=1;
                            number++;
                        }
                    }
                }
                dayTime=Math.round(totalTime/day);
                DataView dataView=new DataView(totalNum,todayNum,todayTime,totalTime,dayTime);
                dataViews.add(dataView);
                return Result.suc(dataViews);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    @PostMapping("/xxjhList1")
    public Result xxjhList1(@RequestBody Map<String, String> data){
        String username = data.get("username");
        Integer  id= Integer.parseInt(data.get("id"));
        Date date1,date2;
        date1=new Date();
        int totalNum=0,todayNum=0,todayTime=0,totalTime=0,dayTime,day=0;
        try{
            List<DataView> dataViews=new ArrayList<DataView>();
            //总天数
            List<Experience> experiences=studyRoomService.selectDay(username);
            int number=0;
            for (int j=0;j<experiences.size()-1;j++){
                Date date3=experiences.get(j).getCreateTime();
                Date date4=experiences.get(j+1).getCreateTime();
                //前后是不是在一天中
                boolean b1= DateUtils.isSameDay(date3,date4);
                if (!b1){
                    day+=1;
                }else{
                    if (number==1){
                        continue;
                    }else{
                        day+=1;
                        number++;
                    }
                }
            }
            //累计时长
            List<Study_plan> list=studyPlanService.selectList(username);
            for (int i=0;i<list.size();i++){
                totalNum+=list.get(i).getTotalNum();
                totalTime+=list.get(i).getTotalTime();
            }
            dayTime=Math.round(totalTime/day);
            //具体id
            List<Study_plan> list1=studyPlanService.queryplan(id);
            //判断是否是今天
            date2=list1.get(0).getUpdateTime();
            boolean b= DateUtils.isSameDay(date1,date2);
            if (b){
                todayNum+=list1.get(0).getTodayNum();
                todayTime+=list1.get(0).getTodayTime()*list1.get(0).getTodayNum();
            }else{
                todayNum=0;
                todayTime=0;
            }
            DataView dataView=new DataView(totalNum,todayNum,todayTime,totalTime,dayTime);
            dataViews.add(dataView);
            return Result.suc(dataViews);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //查看每日的专注时长
    @PostMapping("/selectPie")
    public Result selectPie(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String date1 = data.get("date");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date2 = simpleDateFormat.parse(date1);
            String date=simpleDateFormat.format(date2);
            List<Experience> experiences=dataViewService.selectList(username,date);
            List<Pie> pies=new ArrayList<Pie>();
            //不重复的个数
            List<Experience> experiences1=dataViewService.selectList1(username,date);
            //求每一个的值
            for (int i=0;i<experiences1.size();i++){
                int value=0;
                for (int j=0;j<experiences.size();j++){
                    if (experiences1.get(i).getPlanName().equals(experiences.get(j).getPlanName())){
                         value+= (int) ((experiences.get(j).getEndTime().getTime()-experiences.get(j).getStartTime().getTime())/(60*1000));
                    }
                }
                String name;
                if (value<60){
                    name=experiences1.get(i).getPlanName()+("("+value+"分钟)");
                    Pie pie=new Pie(value,name);
                    pies.add(pie);
                }else{
                    int hear=value/60;
                    int min=value%60;
                    name=experiences1.get(i).getPlanName()+("("+hear+"小时"+min+"分钟)");
                    Pie pie=new Pie(value,name);
                    pies.add(pie);
                }
            }
            return Result.suc(pies);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查看每周/月/年的专注时长
    @PostMapping("/selectPie1")
    public Result selectPie1(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String date1 = data.get("date1");
        String date2 = data.get("date2");
//        System.out.println(date1);
//        System.out.println(date2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date3 = simpleDateFormat.parse(date1);
            Date date4 = simpleDateFormat.parse(date2);
//            Date date5 = simpleDateFormat.parse(date2);
//            //加一天
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(date5);
//            calendar.add(Calendar.DATE, 1);
//            Date date4 = calendar.getTime();
//            String date=simpleDateFormat.format(date2);
            List<Experience> experiences=dataViewService.selectList2(username,date3,date4);
            List<Pie> pies=new ArrayList<Pie>();
            //不重复的个数
            List<Experience> experiences1=dataViewService.selectList3(username,date3,date4);
            //求每一个的值
            for (int i=0;i<experiences1.size();i++){
                int value=0;
                for (int j=0;j<experiences.size();j++){
                    if (experiences1.get(i).getPlanName().equals(experiences.get(j).getPlanName())){
                        value+= (int) ((experiences.get(j).getEndTime().getTime()-experiences.get(j).getStartTime().getTime())/(60*1000));
                    }
                }
                String name;
                if (value<60){
                    name=experiences1.get(i).getPlanName()+("("+value+"分钟)");
                    Pie pie=new Pie(value,name);
                    pies.add(pie);
                }else{
                    int hear=value/60;
                    int min=value%60;
                    name=experiences1.get(i).getPlanName()+("("+hear+"小时"+min+"分钟)");
                    Pie pie=new Pie(value,name);
                    pies.add(pie);
                }
            }
            return Result.suc(pies);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //根据id查看今日的专注时长
    @PostMapping("/selectPie2")
    public Result selectPie2(@RequestBody Map<String, String> data){
//        String username = data.get("username");
        int id= Integer.parseInt(data.get("id"));
        Date date1,date2;
        date1=new Date();
        try{
            List<Study_plan> study_plans=studyPlanService.queryplan(id);
            List<Pie> pies=new ArrayList<Pie>();
            //判断是否是今天
            date2=study_plans.get(0).getUpdateTime();
            boolean b= DateUtils.isSameDay(date1,date2);
            int value=0;
            if (b){
                value+=study_plans.get(0).getTodayTime()*study_plans.get(0).getTodayNum();
            }else{
                return Result.suc(pies);
            }
            String name;
            if (value<60){
                name=study_plans.get(0).getPlanName()+("("+value+"分钟)");
                Pie pie=new Pie(value,name);
                pies.add(pie);
            }else{
                int hear=value/60;
                int min=value%60;
                name=study_plans.get(0).getPlanName()+("("+hear+"小时"+min+"分钟)");
                Pie pie=new Pie(value,name);
                pies.add(pie);
            }
            return Result.suc(pies);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //查看每月/年专注时长统计
    @PostMapping("/selectLine")
    public Result selectLine(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String date1 = data.get("date1");
        String date2 = data.get("date2");
        int day = Integer.parseInt(data.get("day"));
//        System.out.println(date1);
//        System.out.println(date2);
        Date date5;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int value=0;
        try{
            Date date3 = simpleDateFormat.parse(date1);
            Date date4 = simpleDateFormat.parse(date2);
            List<Experience> experiences=dataViewService.selectList2(username,date3,date4);
            List<Line> lines=new ArrayList<Line>();
            //求每一个的值
            if (day==12){
                for (int i=0;i<day;i++){
                    for (int j=0;j<experiences.size();j++){
                        //判断是否是今天
                        date5=experiences.get(j).getCreateTime();
                        boolean b= DateUtils.isSameMonth(date3,date5);
                        if (b){
                            value+= (int) ((experiences.get(j).getEndTime().getTime()-experiences.get(j).getStartTime().getTime())/(60*1000));
                        }
                    }
                    //加1天
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(Calendar.MONTH, 1);
                    date3 = calendar.getTime();
                    Line line=new Line(value);
                    lines.add(line);
                    value=0;
                }
            }else{
                for (int i=0;i<day;i++){
                    for (int j=0;j<experiences.size();j++){
                        //判断是否是今天
                        date5=experiences.get(j).getCreateTime();
                        boolean b= DateUtils.isSameDay(date3,date5);
                        if (b){
                            value+= (int) ((experiences.get(j).getEndTime().getTime()-experiences.get(j).getStartTime().getTime())/(60*1000));
                        }
                    }
                    //加1天
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(Calendar.DATE, 1);
                    date3 = calendar.getTime();
                    Line line=new Line(value);
                    lines.add(line);
                    value=0;
                }
            }
            return Result.suc(lines);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
//    //查看每年专注时长统计
//    @PostMapping("/selectLine1")
//    public Result selectLine1(@RequestBody Map<String, String> data){
//        String username = data.get("username");
//        String date1 = data.get("date1");
//        String date2 = data.get("date2");
//        int day = Integer.parseInt(data.get("day"));
//        Date date5;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
//        int value=0;
//        try{
//            Date date3 = simpleDateFormat.parse(date1);
//            Date date4 = simpleDateFormat.parse(date2);
//            List<Experience> experiences=dataViewService.selectList2(username,date3,date4);
//            List<Line> lines=new ArrayList<Line>();
//            //求每一个的值
//            for (int i=0;i<day;i++){
//                for (int j=0;j<experiences.size();j++){
//                    //判断是否是今天
//                    date5=experiences.get(j).getCreateTime();
//                    boolean b= DateUtils.isSameMonth(date3,date5);
//                    if (b){
//                        value+= (int) ((experiences.get(j).getEndTime().getTime()-experiences.get(j).getStartTime().getTime())/(60*1000));
//                    }
//                }
//                //加1天
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date3);
//                calendar.add(Calendar.MONTH, 1);
//                date3 = calendar.getTime();
//                Line line=new Line(value);
//                lines.add(line);
//                value=0;
//            }
//            return Result.suc(lines);
//        }catch (Exception e){
//            e.printStackTrace();
//            return Result.fail();
//        }
//    }
    //查看每月/年专注时长统计
    @PostMapping("/selectLine2")
    public Result selectLine2(@RequestBody Map<String, String> data){
    String username = data.get("username");
    String date1 = data.get("date1");
    String date2 = data.get("date2");
    int day = Integer.parseInt(data.get("day"));
    String type = data.get("type");
    Date date5;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int number=0,sum=0;
    int time1=0,time2=0;
    try{
        Date date3 = simpleDateFormat.parse(date1);
        Date date4 = simpleDateFormat.parse(date2);
//        List<Line1> lines=new ArrayList<Line1>();
        List<String> lines=new ArrayList<String>();
        int value1=0,value2=0;
        if (type.equals("早起")){
            List<Upclock> upclocks=dataViewService.selectList4(username,date3,date4);
            System.out.println(lines);
            if (upclocks.size()==0){
                return Result.suc(lines);
            }else {
                //求每一个的值
                for (int i=0;i<day;i++){
                    for (int j=0;j<upclocks.size();j++){
                        //判断是否是今天
                        date5=upclocks.get(j).getUpTime();
                        boolean b= DateUtils.isSameDay(date3,date5);
                        if (b){
                            if (number==1){
                                continue;
                            }else{
                                number++;sum++;
                                time1+=upclocks.get(j).getUpTime().getHours();
                                time2+=upclocks.get(j).getUpTime().getMinutes();
                                value1= upclocks.get(j).getUpTime().getHours();
                                value2=upclocks.get(j).getUpTime().getMinutes();
                            }
                        }
                    }
                    number=0;
                    //加1天
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(Calendar.DATE, 1);
                    date3 = calendar.getTime();
//                    Line1 line=new Line1(value1,value2);
//                    Line1 line = new Line1(value1+":"+value2);
                    lines.add(value1+"."+value2);
                    value1=0;value2=0;
                }
                //求平均时间
                String avg= time1/sum+":"+time2/sum;
//                System.out.println(avg+"===========================");
                return Result.suc(lines,avg);
            }
        }else{
            List<Sleepclock> upclocks=dataViewService.selectList5(username,date3,date4);
            if (upclocks.size()==0){
                return Result.suc(lines);
            }else {
                //求每一个的值
                for (int i=0;i<day;i++){
                    for (int j=0;j<upclocks.size();j++){
                        //判断是否是今天
                        date5=upclocks.get(j).getSleepTime();
                        boolean b= DateUtils.isSameDay(date3,date5);
                        if (b){
                            if (number==1){
                                continue;
                            }else{
                                number++;sum++;
                                time1+=upclocks.get(j).getSleepTime().getHours();
                                time2+=upclocks.get(j).getSleepTime().getMinutes();
                                value1= upclocks.get(j).getSleepTime().getHours();
                                value2=upclocks.get(j).getSleepTime().getMinutes();
                            }
                        }
                    }
                    number=0;
                    //加1天
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(Calendar.DATE, 1);
                    date3 = calendar.getTime();
//                    Line1 line = new Line1(value1+":"+value2);
                    lines.add(value1+"."+value2);
                    value1=0;value2=0;
                }
                //求平均时间
                String avg= time1/sum+":"+time2/sum;
                return Result.suc(lines,avg);
            }
        }
    }catch (Exception e){
        e.printStackTrace();
        return Result.fail();
    }
}
//    //查看每月/年专注时长统计
//    @PostMapping("/selectLine2")
//    public Result selectLine2(@RequestBody Map<String, String> data){
//        String username = data.get("username");
//        String date1 = data.get("date1");
//        String date2 = data.get("date2");
//        int day = Integer.parseInt(data.get("day"));
//        String type = data.get("type");
//        Date date5;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        int number=0,sum=0;
//        int time1=0,time2=0;
//        try{
//            Date date3 = simpleDateFormat.parse(date1);
//            Date date4 = simpleDateFormat.parse(date2);
//            List<List<Integer>> lines=new ArrayList<List<Integer>>();
//            int value1=0,value2=0;
//            if (type.equals("早起")){
//                List<Upclock> upclocks=dataViewService.selectList4(username,date3,date4);
//                System.out.println(lines);
//                if (upclocks.size()==0){
//                    return Result.suc(lines);
//                }else {
//                    //求每一个的值
//                    for (int i=0;i<day;i++){
//                        for (int j=0;j<upclocks.size();j++){
//                            //判断是否是今天
//                            date5=upclocks.get(j).getUpTime();
//                            boolean b= DateUtils.isSameDay(date3,date5);
//                            if (b){
//                                if (number==1){
//                                    continue;
//                                }else{
//                                    number++;sum++;
//                                    time1+=upclocks.get(j).getUpTime().getHours();
//                                    time2+=upclocks.get(j).getUpTime().getMinutes();
//                                    value1= upclocks.get(j).getUpTime().getHours();
//                                    value2=upclocks.get(j).getUpTime().getMinutes();
//                                }
//                            }
//                        }
//                        number=0;
//                        //加1天
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(date3);
//                        calendar.add(Calendar.DATE, 1);
//                        date3 = calendar.getTime();
////                    Line1 line=new Line1(value1,value2);
//                        List<Integer> line = new ArrayList<Integer>();
//                        line.add(value1);
//                        line.add(value2);
//                        lines.add(line);
//                        value1=0;value2=0;
//                    }
//                    //求平均时间
//                    String avg= time1/sum+":"+time2/sum;
////                System.out.println(avg+"===========================");
//                    return Result.suc(lines,avg);
//                }
//            }else{
//                List<Sleepclock> upclocks=dataViewService.selectList5(username,date3,date4);
//                if (upclocks.size()==0){
//                    return Result.suc(lines);
//                }else {
//                    //求每一个的值
//                    for (int i=0;i<day;i++){
//                        for (int j=0;j<upclocks.size();j++){
//                            //判断是否是今天
//                            date5=upclocks.get(j).getSleepTime();
//                            boolean b= DateUtils.isSameDay(date3,date5);
//                            if (b){
//                                if (number==1){
//                                    continue;
//                                }else{
//                                    number++;sum++;
//                                    time1+=upclocks.get(j).getSleepTime().getHours();
//                                    time2+=upclocks.get(j).getSleepTime().getMinutes();
//                                    value1= upclocks.get(j).getSleepTime().getHours();
//                                    value2=upclocks.get(j).getSleepTime().getMinutes();
//                                }
//                            }
//                        }
//                        number=0;
//                        //加1天
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.setTime(date3);
//                        calendar.add(Calendar.DATE, 1);
//                        date3 = calendar.getTime();
//                        List<Integer> line = new ArrayList<Integer>();
//                        line.add(value1);
//                        line.add(value2);
//                        lines.add(line);
//                        value1=0;value2=0;
//                    }
//                    //求平均时间
//                    String avg= time1/sum+":"+time2/sum;
//                    return Result.suc(lines,avg);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return Result.fail();
//        }
//    }
}