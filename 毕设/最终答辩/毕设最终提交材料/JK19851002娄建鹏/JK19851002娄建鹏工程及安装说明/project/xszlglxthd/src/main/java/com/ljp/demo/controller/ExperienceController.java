package com.ljp.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.ExperienceService;
import com.ljp.demo.service.NoticeService;
import com.ljp.demo.utils.DateUtils;
import com.ljp.demo.utils.QueryPageParam;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 心得(Experience)表控制层
 *
 * @author makejava
 * @since 2023-03-28 12:53:28
 */
@RestController
@RequestMapping("/experience")
public class ExperienceController {
    /**
     * 服务对象
     */
    @Resource
    private ExperienceService experienceService;
    @Autowired
    private NoticeService noticeService;

    //添加心得
    @PostMapping("/addexperience")
    public Result addexperience(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String planName = data.get("planName");
        String startTime = data.get("startTime");
        String endTime = data.get("endTime");
        String textarea = data.get("textarea");
        try{
            Date startTime1 = DateUtils.parseDate(startTime,"yyyy-MM-dd HH:mm:ss");
            Date endTime1 = DateUtils.parseDate(endTime,"yyyy-MM-dd HH:mm:ss");
//            System.out.println(startTime1+"=================="+endTime1);
            Experience experience=new Experience(0,username,planName,startTime1,endTime1,textarea);
            experienceService.addxd(experience);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //查询心得列表
    @PostMapping("/xdList")
    public Result xdList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String value = data.get("value");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date value11 = simpleDateFormat.parse(value);
            System.out.println(value11);
            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(value11);
//            calendar.add(Calendar.DATE, 1);
//            Date value1 = calendar.getTime();
            //加1天
//            calendar.setTime(value1);
            calendar.setTime(value11);
            calendar.add(Calendar.DATE, 1);
            Date value2 = calendar.getTime();
//            System.out.println(value2);
//            List<Experience> list=experienceService.selectList(username,value1,value2);
            List<Experience> list=experienceService.selectList(username,value11,value2);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    ////修改心得
    @PostMapping("/modxd")
    public Result modxd(@RequestBody Map<String, String> data){
        int experienceId = Integer.parseInt(data.get("experienceId"));
        String textarea = data.get("textarea");
        try{
            Experience experience=new Experience(experienceId,textarea);
            experienceService.modxd(experience);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //删除心得
    @PostMapping("/delxd")
    public Result delxd(@RequestBody Map<String, String> data){
        int experienceId = Integer.parseInt(data.get("experienceId"));
        try{
            experienceService.delxd(experienceId);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师删除心得
    @PostMapping("/jsdelxd")
    public Result jsdelxd(@RequestBody Map<String, String> data){
        int experienceId = Integer.parseInt(data.get("experienceId"));
        String username=data.get("username");
        String reusername=data.get("reusername");
        String createTime=data.get("createTime");
        String planName=data.get("planName");
        Date now=new Date();
        String type ="提醒";
        String title="删除提醒";
        String textarea=username+"你好：由于你发布的心得内容与我们相关政策不符，我们已经删除了您"+createTime+"时创建的"+planName+"的心得记录，请您端正自身。如有疑问，请联系你的老师或管理员。";
        try{
            experienceService.delxd(experienceId);
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师查询心得列表
    @PostMapping("/xdList1")
    public Result<List<Experience>> wlmbList1(@RequestBody QueryPageParam query) throws ParseException {
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String value = (String)param.get("value1");
        String userGroup = (String)param.get("userGroup");
        String academy = (String)param.get("academy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Page<Experience> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if (userGroup.equals("教师")){
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(value)){
                //加一天
                Date value1 = simpleDateFormat.parse(value);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(value1);
                calendar.add(Calendar.DATE, 1);
                Date value2 = calendar.getTime();
                List<Experience> list=experienceService.selectList4(page,username,value1,value2,academy);
                Long total=experienceService.selectnum4(username,value1,value2,academy);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(new Date());
                Date date=simpleDateFormat.parse(dateStr);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(date);
                calendar1.add(Calendar.DATE, 1);
                Date date2 = calendar1.getTime();
                List<Experience> list=experienceService.selectList5(page,username,date,date2,academy);
                Long total=experienceService.selectnum5(username,date,date2,academy);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(value)){
                //加一天
                Date value1 = simpleDateFormat.parse(value);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(value1);
                calendar.add(Calendar.DATE, 1);
                Date value2 = calendar.getTime();
                List<Experience> list=experienceService.selectList6(page,value1,value2,academy);
                Long total=experienceService.selectnum6(value1,value2,academy);
                return Result.suc(list,total);
            }
            else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(new Date());
                Date date=simpleDateFormat.parse(dateStr);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(date);
                calendar1.add(Calendar.DATE, 1);
                Date date2 = calendar1.getTime();
                IPage<Experience> result = experienceService.findByAllPage1(page,date,date2,academy);
//            System.out.println(result.getRecords());
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }else{
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(value)){
                //加一天
                Date value1 = simpleDateFormat.parse(value);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(value1);
                calendar.add(Calendar.DATE, 1);
                Date value2 = calendar.getTime();
                List<Experience> list=experienceService.selectList2(page,username,value1,value2);
                Long total=experienceService.selectnum2(username,value1,value2);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(new Date());
                Date date=simpleDateFormat.parse(dateStr);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(date);
                calendar1.add(Calendar.DATE, 1);
                Date date2 = calendar1.getTime();
                List<Experience> list=experienceService.selectList3(page,username,date,date2);
                Long total=experienceService.selectnum3(username,date,date2);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(value)){
                //加一天
                Date value1 = simpleDateFormat.parse(value);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(value1);
                calendar.add(Calendar.DATE, 1);
                Date value2 = calendar.getTime();
                List<Experience> list=experienceService.selectList1(page,value1,value2);
                Long total=experienceService.selectnum1(value1,value2);
                return Result.suc(list,total);
            }
            else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateStr = sdf.format(new Date());
                Date date=simpleDateFormat.parse(dateStr);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(date);
                calendar1.add(Calendar.DATE, 1);
                Date date2 = calendar1.getTime();
                IPage<Experience> result = experienceService.findByAllPage(page,date,date2);
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }
    }


    //分享心得
    @PostMapping("/fxxd")
    public Result fxxd(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String planName = data.get("planName");
        String reusername = data.get("reusername");
        String textarea = data.get("textarea");
        try{
            Communication communication=new Communication(0,planName,username,reusername,textarea);
            experienceService.fxxd(communication);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //查询指定心得列表
    @PostMapping("/xdList2")
    public Result xdList2(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String value = data.get("value");
        String planName = data.get("planName");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date value11 = simpleDateFormat.parse(value);
            System.out.println(value11);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(value11);
//            calendar.add(Calendar.DATE, 1);
//            Date value1 = calendar.getTime();
            //加1天
//            calendar.setTime(value1);
            calendar.add(Calendar.DATE, 1);
            Date value2 = calendar.getTime();
//            List<Experience> list=experienceService.selectListPname(username,value1,value2,planName);
            List<Experience> list=experienceService.selectListPname(username,value11,value2,planName);
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}

