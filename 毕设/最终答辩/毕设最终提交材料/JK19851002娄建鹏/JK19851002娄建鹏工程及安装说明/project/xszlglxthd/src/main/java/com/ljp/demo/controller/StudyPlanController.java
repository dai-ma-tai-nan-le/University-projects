package com.ljp.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.*;
import com.ljp.demo.utils.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学习计划(StudyPlan)表控制层
 *
 * @author makejava
 * @since 2023-03-23 15:25:21
 */
@RestController
@RequestMapping("/studyPlan")
public class StudyPlanController {
    /**
     * 服务对象
     */
    @Resource
    private StudyPlanService studyPlanService;
    @Autowired
    private GoalPlanService goalPlanService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccomplishmentService accomplishmentService;


    ////查询学习计划列表
    @PostMapping("/xxjhList")
    public Result xxjhList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<Study_plan> list=studyPlanService.selectList(username);
            int sum=0,sumtime=0;
            for (int i=0;i<list.size();i++){
                sum+=list.get(i).getTotalNum();
                sumtime+=list.get(i).getTotalTime();
            }
            if (sum==1){
                String name="小试牛刀";
                String tj="总计完成次数等于1次时获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc1(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (sum==10){
                String name="初有成效";
                String tj="总计完成次数等于10次时获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc2(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (sum==100){
                String name="100次的坚持";
                String tj="总计完成次数等于100次时获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc3(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (sum==1000){
                String name="持之以恒";
                String tj="总计完成次数等于1000次时获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc4(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (sum==10000){
                String name="优秀是一种习惯";
                String tj="总计完成次数等于10000次时获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc5(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (10<=sumtime&&sumtime<100){
                String name="初出茅庐";
                String tj="总计完成时间大于10分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc6(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (100<=sumtime&&sumtime<1000){
                String name="水滴石穿";
                String tj="总计完成时间大于100分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc7(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (1000<=sumtime&&sumtime<10000){
                String name="铁杵成针";
                String tj="总计完成时间大于1000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc8(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (10000<=sumtime&&sumtime<100000){
                String name="运筹帷幄";
                String tj="总计完成时间大于10000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc9(list);
                }else{
                    return Result.suc(list);
                }
            }
            else if (100000<=sumtime){
                String name="人生赢家";
                String tj="总计完成时间大于100000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc10(list);
                }else{
                    return Result.suc(list);
                }
            }
            else{
                return Result.suc(list);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    ////修改计划
    @PostMapping("/modplan")
    public Result modplan(@RequestBody Map<String, String> data){
        int studyPlanId = Integer.parseInt(data.get("studyPlanId"));
        String planName = data.get("planName");
        String timeTrend = data.get("timeTrend");
        int planTime = Integer.parseInt(data.get("planTime"));
        try{
            Study_plan study_plan=new Study_plan(studyPlanId,planName,timeTrend,planTime);
            studyPlanService.modplan(study_plan);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    //添加学习计划
    @PostMapping("/addplan")
    public Result addplan(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String planName = data.get("planName");
        String timeTrend = data.get("timeTrend");
        int planTime = Integer.parseInt(data.get("planTime"));
        try{
            Study_plan study_plan=new Study_plan(planName,timeTrend,planTime,username);
            studyPlanService.addplan(study_plan);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    @GetMapping("/findplanname")
    public Result findplanname(@RequestParam Map<String, String> data){
        String username = data.get("username");
        String planName = data.get("planName");
        List<Study_plan> list= studyPlanService.selectplanlist(planName,username);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
    //删除学习计划
    @PostMapping("/delplan")
    public Result delplan(@RequestBody Map<String, String> data){
        int studyPlanId = Integer.parseInt(data.get("studyPlanId"));
        try{
            studyPlanService.delplan(studyPlanId);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师查询学习计划列表
    @PostMapping("/xxjhList1")
    public Result<List<Study_plan>> xxjhList1(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        Date date1,date2;
        String username = (String)param.get("username");
        String planName = (String)param.get("plan_name");
        String userGroup = (String)param.get("userGroup");
        String academy = (String)param.get("academy");
        Page<Study_plan> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        date1=new Date();
        if (userGroup.equals("教师")){
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(planName)){
                List<Study_plan> list=studyPlanService.selectList4(page,username,planName,academy);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum4(username,planName,academy);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                List<Study_plan> list=studyPlanService.selectList5(page,username,academy);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum5(username,academy);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(planName)){
                List<Study_plan> list=studyPlanService.selectList6(page,planName,academy);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum6(planName,academy);
                return Result.suc(list,total);
            }
            else{
                IPage<Study_plan> result = studyPlanService.findByAllPage1(page,academy);
                //判断是否是今天
                for (int i = 0; i < result.getSize(); i++) {
                    date2 = result.getRecords().get(i).getUpdateTime();
                    boolean b = DateUtils.isSameDay(date1, date2);
                    if (!b) {
                        result.getRecords().get(i).setTodayNum(0);
                        result.getRecords().get(i).setTodayTime(0);
                    }
                }
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }else {
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(planName)){
                List<Study_plan> list=studyPlanService.selectList2(page,username,planName);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum2(username,planName);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                List<Study_plan> list=studyPlanService.selectList3(page,username);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum3(username);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(planName)){
                List<Study_plan> list=studyPlanService.selectList1(page,planName);
                //判断是否是今天
                for (int i=0;i<list.size();i++){
                    date2=list.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        list.get(i).setTodayNum(0);
                        list.get(i).setTodayTime(0);
                    }
                }
                Long total=studyPlanService.selectnum1(planName);
                return Result.suc(list,total);
            }
            else{
                IPage<Study_plan> result = studyPlanService.findByAllPage(page);
                //判断是否是今天
                for (int i = 0; i < result.getSize(); i++) {
                    date2 = result.getRecords().get(i).getUpdateTime();
                    boolean b = DateUtils.isSameDay(date1, date2);
                    if (!b) {
                        result.getRecords().get(i).setTodayNum(0);
                        result.getRecords().get(i).setTodayTime(0);
                    }
                }
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }
    }


    //进行计时
    @PostMapping("/selectplan")
    public Result selectplan(@RequestBody Map<String, String> data){
        int studyPlanId = Integer.parseInt(data.get("studyPlanId"));
        String username = data.get("username");
        try {
            List<Time> times=studyPlanService.selectTime(studyPlanId);
            List<Goal_plan> list=goalPlanService.selectList(username);
//            System.out.println(times);
//            System.out.println(list);
            for (int i=0;i<list.size();i++){
                if (list.get(i).getEndTime().getTime()>new Date().getTime()){
                    times.get(0).setGoalName(list.get(i).getGoalName());
                    times.get(0).setEndTime(list.get(i).getEndTime());
                    break;
                }
            }
            //创建OkHttpClient对象
            OkHttpClient client = new OkHttpClient();
            //创建Request对象
            Request request = new Request.Builder()
                    .url("https://v.api.aa1.cn/api/yiyan/index.php")
//                    .url("https://www.mxnzp.com/api/daily_word/recommend")
//                    .url("https://v1.hitokoto.cn/")
                    .build();
            //创建Call对象
            Response response  = client.newCall(request).execute();
            String context=response.body().string();
            return Result.suc(times,context);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
    //更新学习计划的时间和次数
    @PostMapping("/updateplan")
    public Result updateplan(@RequestBody Map<String, String> data){
        int studyPlanId = Integer.parseInt(data.get("studyPlanId"));
        int time = Integer.parseInt(data.get("time"));
        String username = data.get("username");
        int totalNum,todayTime,todayNum,totalTime;
        Date date1,date2;
        try {
            //先获取本计划
            List<Study_plan> list=studyPlanService.queryplan(studyPlanId);
            totalNum=list.get(0).getTotalNum()+1;
            totalTime=list.get(0).getTotalTime()+time;
            date1=new Date();
            date2=list.get(0).getUpdateTime();
            boolean b= DateUtils.isSameDay(date1,date2);
            if (b){
                todayNum=list.get(0).getTodayNum()+1;
                todayTime=list.get(0).getTodayTime()+time;
            }else {
                todayNum=1;
                todayTime=time;
            }
            Study_plan study_plans=new Study_plan(studyPlanId,todayNum,totalNum,todayTime,totalTime);
            studyPlanService.updateplan(study_plans);
            if (totalNum==1){
                String name="有条不紊";
                String tj="单项计划完成1次获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc11();
                }else{
                    return Result.suc();
                }
            }
            else if (totalNum==10){
                String name="牛刀小试";
                String tj="单项计划完成10次获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc12();
                }else{
                    return Result.suc();
                }
            }
            else if (totalNum==100){
                String name="毅力超人";
                String tj="单项计划完成100次获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc13();
                }else{
                    return Result.suc();
                }
            }
            else if (totalNum==365){
                String name="多一度热爱";
                String tj="单项计划完成365次获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc14();
                }else{
                    return Result.suc();
                }
            }
            else if (totalNum==1000){
                String name="习惯成自然";
                String tj="单项计划完成1000次获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc15();
                }else{
                    return Result.suc();
                }
            }
            else if (10<=totalTime&&totalTime<100){
                String name="效果初显";
                String tj="单项计划完成时间大于10分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc16();
                }else{
                    return Result.suc();
                }
            }
            else if (100<=totalTime&&totalTime<1000){
                String name="乘风破浪";
                String tj="单项计划完成时间大于100分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc17();
                }else{
                    return Result.suc();
                }
            }
            else if (1000<=totalTime&&totalTime<10000){
                String name="屹立不倒";
                String tj="单项计划完成时间大于1000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc18();
                }else{
                    return Result.suc();
                }
            }
            else if (10000<=totalTime&&totalTime<100000){
                String name="冰冻三尺";
                String tj="单项计划完成时间大于10000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc19();
                }else{
                    return Result.suc();
                }
            }
            else if (100000<=totalTime){
                String name="沧海桑田";
                String tj="单项计划完成时间大于100000分钟获得";
                List<Accomplishment> accomplishments=accomplishmentService.selectCj(username,name);
                if (accomplishments.size()==0){
                    //添加成就
                    Accomplishment accomplishment=new Accomplishment(0,username,name,tj);
                    accomplishmentService.insertCj(accomplishment);
                    return Result.suc20();
                }else{
                    return Result.suc();
                }
            }else{
                return Result.suc();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师删除学习计划
    @PostMapping("/jsdeljh")
    public Result jsdeljh(@RequestBody Map<String, String> data){
        int studyPlanId = Integer.parseInt(data.get("studyPlanId"));
        String username = data.get("username");
        String reusername = data.get("reusername");
        String planName = data.get("planName");
        Date now=new Date();
        String type ="提醒";
        String title="删除提醒";
        String textarea=username+"你好：由于你创建的计划与我们相关政策不符，我们已经删除了您计划名称为"+planName+"的计划，请您端正自身。如有疑问，请联系你的老师或管理员。";
        try{
            studyPlanService.delplan(studyPlanId);
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师提醒学习
    @PostMapping("/txxxjh")
    public Result txxxjh(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String reusername = data.get("reusername");
        String planName = data.get("planName");
        String email;
        Date now=new Date();
        String type ="提醒";
        String title="计划学习提醒";
        String textarea=username+"你好："+"你今天还没有开始学习您计划名称为"+planName+"的计划，或者你的学习时间没有超过20分钟，请坚持每天学习，不断进步。学习不是一蹴而就的，需要持之以恒。";
        try{
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            List<User> users=userService.findUserByUsername(reusername);
            email=users.get(0).getEmail();
            EmailUtils1.sendEmail(username,email,reusername,planName);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //查询音乐
    @PostMapping("/selectmusic")
    public Result selectmusic(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String name="admin";
        try{
            List<Upload> list1=studyPlanService.selectMusic(name);
            List<Upload> list2=studyPlanService.selectMusic(username);
            if (list2.size()==0){
                return Result.suc(list1);
            }else{
                List<Upload> list = Lists.newArrayList();
                list.addAll(list1);
                list.addAll(list2);
                return Result.suc(list);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}

