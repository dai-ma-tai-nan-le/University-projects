package com.ljp.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Notice;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.service.GoalPlanService;
import com.ljp.demo.service.NoticeService;
import com.ljp.demo.utils.QueryPageParam;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目标计划(GoalPlan)表控制层
 *
 * @author makejava
 * @since 2023-03-24 19:47:54
 */
@RestController
@RequestMapping("/goalPlan")
public class GoalPlanController {
    /**
     * 服务对象
     */
    @Resource
    private GoalPlanService goalPlanService;
    @Autowired
    private NoticeService noticeService;

    ////查询未来目标列表
    @PostMapping("/wlmbList")
    public Result wlmbList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<Goal_plan> list=goalPlanService.selectList(username);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    ////修改目标
    @PostMapping("/modplan")
    public Result modplan(@RequestBody Map<String, String> data){
        int goalPlanId = Integer.parseInt(data.get("goalPlanId"));
        String goalname = data.get("goalname");
        String description = data.get("description");
        String endTime =data.get("value1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (endTime.equals("")||endTime==null){
            Date endTime1 = null;
            try{
                Goal_plan study_plan=new Goal_plan(goalPlanId,goalname,description,endTime1);
                goalPlanService.modplan(study_plan);
                return Result.suc();
            }catch (Exception e){
                e.printStackTrace();
                return Result.fail();
            }
        }else {
            try{
                Date endTime1 = simpleDateFormat.parse(endTime);
                Goal_plan study_plan=new Goal_plan(goalPlanId,goalname,description,endTime1);
                goalPlanService.modplan(study_plan);
                return Result.suc();
            }catch (Exception e){
                e.printStackTrace();
                return Result.fail();
            }
        }
    }
    //添加学习计划
    @PostMapping("/addplan")
    public Result addplan(@RequestBody Map<String, String> data) throws ParseException {
        String username = data.get("username");
        String goalname = data.get("goalname");
        String description = data.get("description");
        String endTime =data.get("value1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (endTime.equals("")||endTime==null){
            try {
                Date endTime1 = null;
                Goal_plan study_plan=new Goal_plan(0,username,goalname,description,endTime1);
                goalPlanService.addplan(study_plan);
                return Result.suc();
            } catch (Exception e) {
                e.printStackTrace();
                return Result.fail();
            }
        }else {
            Date endTime1 = simpleDateFormat.parse(endTime);
            try {
                Goal_plan study_plan=new Goal_plan(0,username,goalname,description,endTime1);
                goalPlanService.addplan(study_plan);
                return Result.suc();
            } catch (Exception e) {
                e.printStackTrace();
                return Result.fail();
            }
        }
    }
    //查重名
    @GetMapping("/findplanname")
    public Result findplanname(@RequestParam Map<String, String> data){
        String username = data.get("username");
        String goalname = data.get("goalname");
        List<Goal_plan> list= goalPlanService.selectplanlist(goalname,username);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
    //删除学习计划
    @PostMapping("/delplan")
    public Result delplan(@RequestBody Map<String, String> data){
        int goalPlanId = Integer.parseInt(data.get("goalPlanId"));
        try{
            goalPlanService.delplan(goalPlanId);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师查询学习计划列表
    @PostMapping("/wlmbList1")
    public Result<List<Goal_plan>> wlmbList1(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String goalName = (String)param.get("goal_name");
        String userGroup = (String)param.get("userGroup");
        String academy = (String)param.get("academy");
        Page<Goal_plan> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if (userGroup.equals("教师")){
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(goalName)){
                List<Goal_plan> list=goalPlanService.selectList4(page,username,goalName,academy);
                Long total=goalPlanService.selectnum4(username,goalName,academy);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                List<Goal_plan> list=goalPlanService.selectList5(page,username,academy);
                Long total=goalPlanService.selectnum5(username,academy);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(goalName)){
                List<Goal_plan> list=goalPlanService.selectList6(page,goalName,academy);
                Long total=goalPlanService.selectnum6(goalName,academy);
                return Result.suc(list,total);
            }
            else{
                IPage<Goal_plan> result = goalPlanService.findByAllPage1(page,academy);
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }else{
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(goalName)){
                List<Goal_plan> list=goalPlanService.selectList2(page,username,goalName);
                Long total=goalPlanService.selectnum2(username,goalName);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                List<Goal_plan> list=goalPlanService.selectList3(page,username);
                Long total=goalPlanService.selectnum3(username);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(goalName)){
                List<Goal_plan> list=goalPlanService.selectList1(page,goalName);
                Long total=goalPlanService.selectnum1(goalName);
                return Result.suc(list,total);
            }
            else{
                IPage<Goal_plan> result = goalPlanService.findByAllPage(page);
                System.out.println(result.getRecords());
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }
    }


    //教师删除未来目标
    @PostMapping("/jsdelmb")
    public Result jsdelmb(@RequestBody Map<String, String> data){
        int goalPlanId = Integer.parseInt(data.get("goalPlanId"));
        String username = data.get("username");
        String reusername = data.get("reusername");
        String goalName = data.get("goalName");
        Date now=new Date();
        String type ="提醒";
        String title="删除提醒";
        String textarea=username+"你好：由于你创建的未来目标与我们相关政策不符，我们已经删除了您目标名称为"+goalName+"的未来目标，请您端正自身。如有疑问，请联系你的老师或管理员。";
        try{
            goalPlanService.delplan(goalPlanId);
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师激励学生
    @PostMapping("/jili")
    public Result jili(@RequestBody Map<String, String> data) throws ParseException {
        String username = data.get("username");
        String reusername = data.get("reusername");
        String goalName = data.get("goalName");
        String endTime =data.get("endTime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now=new Date();
        Date endTime1 = simpleDateFormat.parse(endTime);
        String textarea;
        //剩余天数
        if (now.getTime()<endTime1.getTime()){
            long until = endTime1.getTime()/1000/60/60/24 -now.getTime()/1000/60/60/24;
             textarea="坚持一件事情并不容易，你需要让自己感到好奇。将目标视为一个探险过程，你会发现完成目标的过程十分有趣，而且付出努力并达成目标的感觉也是无与伦比。"
                     +"距离您目标名称为"+goalName +"的目标还剩余"+until+"天。"+
                     "请坚持每天学习。完成目标有很多的方法，但最好的方法之一就是让目标对你个人有意义。确保你从目标中获得的回报是符合你的需要和价值观的，" +
                     "这样就能够真正激励你超越自己的极限，达成目标。";
        }else {
            long until = now.getTime()/1000/60/60/24 -endTime1.getTime()/1000/60/60/24;
            textarea="坚持一件事情并不容易，你需要让自己感到好奇。将目标视为一个探险过程，你会发现完成目标的过程十分有趣，而且付出努力并达成目标的感觉也是无与伦比。"
                    +"距离您目标名称为"+goalName +"的目标虽然已经过去了"+until+"天。"+
                    "失败只是成功的第一步。无论你是否实现了你的目标，你都在前进向着它。不要让短暂的挫折打击你的动力。学习失败，分析失败并继续前进。";
        }
        String type ="提醒";
        String title="目标激励";
        try{
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


}

