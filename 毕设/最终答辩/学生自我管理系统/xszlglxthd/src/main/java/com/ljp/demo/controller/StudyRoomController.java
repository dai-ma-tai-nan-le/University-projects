package com.ljp.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.*;
import com.ljp.demo.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 自习室(StudyRoom)表控制层
 *
 * @author makejava
 * @since 2023-04-15 15:59:38
 */
@RestController
@RequestMapping("/studyRoom")
public class StudyRoomController {
    /**
     * 服务对象
     */
    @Resource
    private StudyRoomService studyRoomService;
    @Autowired
    private StudyPlanService studyPlanService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private CommunicationService communicationService;
//    @Autowired
//    private UpclockService upclockService;


    //查询创建自习室人的专注时长<30分钟不能创建
    @PostMapping("/cxzzsj")
    public Result cxzzsj(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int sum=0;
        try{
           List<Study_plan> list=studyPlanService.selectList(username);
           for (int i=0;i<list.size();i++){
               sum+=list.get(i).getTotalTime();
           }
           if (sum<30){
               return Result.fail9();
           }
           else{
               return Result.suc();
           }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查询自习室重名
    @GetMapping("/findroomname")
    public Result findroomname(@RequestParam Map<String, String> data){
        String roomname = data.get("roomname");
        List<Study_room> list= studyRoomService.selectroomlist(roomname);
        if (list.size()>0){
            return Result.fail();
        }else {
            return Result.suc();
        }
    }
    //创建自习室
    @PostMapping("/addzxs")
    public Result addzxs(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String roomname = data.get("roomname");
        String description = data.get("description");
        String password = data.get("password");
        String type = data.get("type");
        int num = Integer.parseInt(data.get("num"));
        String code;
        while(true){
            code= RandomUtils.createRoomNumber();
            List<Study_room> list1=studyRoomService.selectCode(code);
            if (list1.size()==0){
                break;
            }
        }
//        System.out.println(code);
        try{
            Study_room study_room=new Study_room(0,code,type,roomname,description,password,1,num);
            studyRoomService.insertRoom(study_room);
//            List<Study_room> list= studyRoomService.selectroomlist(roomname);
            List<Study_room> list=studyRoomService.selectCode(code);
            int id=list.get(0).getStudyRoomId();
            RoomPeople roomPeople=new RoomPeople(0,id,username,1,1);
            studyRoomService.insertPeople(roomPeople);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //查询用户是否加入自习室
    @PostMapping("/selectpeople")
    public Result selectpeople(@RequestBody Map<String, String> data){
        String username = data.get("username");
        try{
            List<RoomPeople> list=studyRoomService.selectPeople(username);
            if (list.size()>0){
                return Result.suc();
            }else {
                return Result.fail();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //通过加入码加入自习室
    @PostMapping("/codeadd")
    public Result codeadd(@RequestBody Map<String, String> data){
        String code =  data.get("code");
        String username =  data.get("username");
        try{
            List<Study_room> list=studyRoomService.selectCode(code);
            if (list.size()>0){
                if (list.get(0).getJoinNum()!=list.get(0).getLimitNum()){
                    int id=list.get(0).getStudyRoomId();
                    RoomPeople roomPeople=new RoomPeople(0,id,username,0,1);
                    studyRoomService.insertPeople(roomPeople);
                    //人数+1
                    int num=list.get(0).getJoinNum()+1;
                    Study_room study_room=new Study_room(id,num);
                    studyRoomService.updateNum(study_room);
                    return Result.suc();
                }else{
                    return Result.fail11();
                }
            }else {
                return Result.fail10();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查询自习室列表
    @PostMapping("/zxslist")
    public Result zxslist(@RequestBody Map<String, String> data){
        String roomName =  data.get("roomName");
        if(!StringUtils.isEmpty(roomName)){
            List<Study_room> list= studyRoomService.selectroomlist1(roomName);
//            //查询每个自习室里有多少人
//            for (int i=0;i<list.size();i++){
//                int id=list.get(i).getStudyRoomId();
//                List<RoomPeople> list1=studyRoomService.selectPeoNum(id);
//                list.get(i).setList(list1);
//            }
            int total=list.size();
            return Result.suc(list, (long) total);
        }else{
            List<Study_room> list= studyRoomService.selectroomlist2();
//            //查询每个自习室里有多少人
//            for (int i=0;i<list.size();i++){
//                int id=list.get(i).getStudyRoomId();
//                List<RoomPeople> list1=studyRoomService.selectPeoNum(id);
//                list.get(i).setList(list1);
//            }
            int total=list.size();
            return Result.suc(list, (long) total);
        }
    }
    //浏览或搜索加入自习室不需要密码
    @PostMapping("/llssadd")
    public Result llssadd(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        String username =  data.get("username");
        try{
            List<Study_room> list=studyRoomService.selectId(id);
            if (list.size()>0){
                if (list.get(0).getJoinNum()!=list.get(0).getLimitNum()){
                    RoomPeople roomPeople=new RoomPeople(0,id,username,0,1);
                    studyRoomService.insertPeople(roomPeople);
                    //人数+1
                    int num=list.get(0).getJoinNum()+1;
                    Study_room study_room=new Study_room(id,num);
                    studyRoomService.updateNum(study_room);
                    return Result.suc();
                }else{
                    return Result.fail11();
                }
            }else {
                return Result.fail10();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //浏览或搜索加入自习室需要密码
    @PostMapping("/addxymm")
    public Result addxymm(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        String username =  data.get("username");
        String password =  data.get("password");
        String password1= Md5Utils.md5(password);
        System.out.println(password1);
        try{
            List<Study_room> list=studyRoomService.selectId(id);
            System.out.println(list.get(0).getPassword());
            if (list.size()>0){
                if (list.get(0).getPassword().equals(password1)){
                    if (list.get(0).getJoinNum()!=list.get(0).getLimitNum()){
                        RoomPeople roomPeople=new RoomPeople(0,id,username,0,1);
                        studyRoomService.insertPeople(roomPeople);
                        //人数+1
                        int num=list.get(0).getJoinNum()+1;
                        Study_room study_room=new Study_room(id,num);
                        studyRoomService.updateNum(study_room);
                        return Result.suc();
                    }else{
                        return Result.fail11();
                    }
                }else{
                    return Result.fail12();
                }
            }else {
                return Result.fail10();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //根据id查询自习室里具体信息
    @PostMapping("/selectRoomId")
    public Result selectRoomId(@RequestBody Map<String, String> data){
        String username =  data.get("username");
        Date date1,date2;
        date1=new Date();
        RoomPeople people;
        try{
            List<RoomPeople> list=studyRoomService.selectPeople(username);
            int id=list.get(0).getId();
            //查询这个用户名所在的自习室
            List<Study_room> list1=studyRoomService.selectId(id);
            //查询自习室里有多少人
            List<RoomPeople> list2=studyRoomService.selectPeoNum(id);
            list1.get(0).setList(list2);
            //每个人今日起床打卡时间
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateStr=sdf.format(new Date());
//            Date date=sdf.parse(dateStr);
//            System.out.println(dateStr);
            for (int i=0;i<list2.size();i++){
                String name=list2.get(i).getUsername();
                List<Upclock> upclocks = studyRoomService.selectClock(name,dateStr);
                if (upclocks.size()!=0){
                    list2.get(i).setUpTime(upclocks.get(0).getUpTime());
                }
                else {
                    list2.get(i).setUpTime(null);
                }
            }
            //每个人今日专注时长
            for (int j=0;j<list2.size();j++){
                String name=list2.get(j).getUsername();
                List<Study_plan> study_plans=studyPlanService.selectList(name);
                //判断是否是今天
                int number=0;
                for (int i=0;i<study_plans.size();i++){
                    date2=study_plans.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        number+=0;
                    }else{
                        number+=study_plans.get(i).getTodayTime()*study_plans.get(i).getTodayNum();
                    }
                }
                list2.get(j).setTime(number);
            }
            //每人连续专注天数+总专注天数
            for (int k=0;k<list2.size();k++){
                String name=list2.get(k).getUsername();
                List<Experience> experiences=studyRoomService.selectDay(name);
                int sum=0; //总天数
                int num=0;  //连续天数
                int number=0;
                //总天数
                for (int i=0;i<experiences.size()-1;i++){
                    Date date3=experiences.get(i).getCreateTime();
                    Date date4=experiences.get(i+1).getCreateTime();
                    //前后是不是在一天中
                    boolean b= DateUtils.isSameDay(date3,date4);
                    if (!b){
                        sum+=1;
                    }else{
                        if (number==1){
                            continue;
                        }else{
                            sum+=1;
                            number++;
                        }
                    }
                }
                list2.get(k).setTotalDay(sum);
                //连续天数j
                for (int j=0;j<experiences.size();j++){
                    if (j==experiences.size()-1){
                        if (new Date().getDate()-experiences.get(j).getCreateTime().getDate()==0){
                            if (number==1){
                                continue;
                            }else{
                                num+=1;
                                number++;
                            }
                        }else{
                            num=0;
                            number=0;
                        }
                    }else if (experiences.get(j+1).getCreateTime().getDate()-experiences.get(j).getCreateTime().getDate()==1){
                        num++;
                    }else if (new Date().getDate()-experiences.get(j).getCreateTime().getDate()==0){
                        if (number==1){
                            continue;
                        }else{
                            num+=1;
                            number++;
                        }
                    }else{
                        num=0;
                        number=0;
                    }
                }
                list2.get(k).setContinumDay(num);
            }
            //排序
//            System.out.println(list2.get(3).toString()+"====================================="+list2.get(4).toString());
            for (int l=0;l<list2.size();l++){
                for (int j=0;j<list2.size()-1;j++){
                    if (list2.get(j).getTime() < list2.get(j + 1).getTime()) {
                        people= list2.get(j);
                        list2.set(j, list2.get(j + 1));
                        list2.set(j+1,people);
                    }
                }
            }
            //赋值排名
            int rank=0;
            for (int m=0;m<list2.size();m++){
                list2.get(m).setRanking(++rank);
//                System.out.println(rank+"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                if (list2.get(m).getUsername().equals(username)){
                    list1.get(0).setRanking(list2.get(m).getRanking());
                }
                if (list2.get(m).getHomeowner()==1){
                    list1.get(0).setHomeowner(list2.get(m).getUsername());
                }
            }
            return Result.suc(list1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //修改专注内容对自习室好友可见
    @PostMapping("/updateSeen")
    public Result updateSeen(@RequestBody Map<String, String> data){
        String username = data.get("username");
        boolean value = Boolean.parseBoolean(data.get("value"));
        try{
            if (value){
                int value1=1;
                RoomPeople people=new RoomPeople(username,value1);
                studyRoomService.updateSeen(people);
                return Result.suc();
            }else {
                int value1=0;
                RoomPeople people=new RoomPeople(username,value1);
                studyRoomService.updateSeen(people);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //移除成员
    @PostMapping("/delpeople")
    public Result delpeople(@RequestBody Map<String, String> data){
        String cxusername = data.get("cxusername");
        String username = data.get("username");
        String roomName = data.get("roomName");
        int id = Integer.parseInt(data.get("id"));
        Date now=new Date();
        String type ="通知";
        String title="删除通知";
        String textarea=cxusername+"你好：由于你在我("+username+")创建的名为"+roomName+"的自习室内长时间没有学习过，与我最初创建该自习室的初衷不符，我已经把您从我的自习室移除。";
        try{
            studyRoomService.delpeople(cxusername);
            Notice notice=new Notice(0,title,type,username,cxusername,now,textarea,0,0);
            noticeService.addtz(notice);
            List<Study_room> list=studyRoomService.selectId(id);
            //人数-1
            int num=list.get(0).getJoinNum()-1;
            Study_room study_room=new Study_room(id,num);
            studyRoomService.updateNum(study_room);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查看某人的专注时长
    @PostMapping("/selectPie")
    public Result selectPie(@RequestBody Map<String, String> data){
        String username = data.get("username");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(new Date());
        try{
            List<Study_plan> study_plans=studyRoomService.selectList1(username,dateStr);
            List<Pie> pies=new ArrayList<Pie>();
            for (int i=0;i<study_plans.size();i++){
                int value=study_plans.get(i).getTodayTime()*study_plans.get(i).getTodayNum();
                String name;
                if (value<60){
                    name=study_plans.get(i).getPlanName()+("("+value+"分钟)");
                    Pie pie=new Pie(value,name);
                    pies.add(pie);
                }else{
                    int hear=value/60;
                    int min=value%60;
                    name=study_plans.get(i).getPlanName()+("("+hear+"小时"+min+"分钟)");
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
    //修改自习室资料
    @PostMapping("/upzxs")
    public Result upzxs(@RequestBody Map<String, String> data){
        String roomname = data.get("roomname");
        int id = Integer.parseInt(data.get("id"));
        String description = data.get("description");
        String type = data.get("type");
        String password = data.get("password");
        int num = Integer.parseInt(data.get("num"));
        try{
            Study_room study_room=new Study_room(id,type,roomname,description,password,num);
            studyRoomService.updateZxs(study_room);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //分享自习室
    @PostMapping("/fxzxs")
    public Result fxzxs(@RequestBody Map<String, String> data){
        String reusername = data.get("reusername");
        String username = data.get("username");
        String roomName = data.get("roomName");
        int id = Integer.parseInt(data.get("id"));
        String homeOwner = data.get("homeOwner");
        Date now=new Date();
        String type ="通知";
        String title="邀请通知";
        try{
            List<Study_room> list=studyRoomService.selectId(id);
            String code=list.get(0).getCode();
            String textarea="我正在"+homeOwner+"创建的名为"+roomName+"的自习室里学习，快来加入一起组队学习吧~自习室加入码："+code+"。";
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //退出自习室
    @PostMapping("/tuichu")
    public Result tuichu(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int id = Integer.parseInt(data.get("id"));
        try{
            studyRoomService.delpeople(username);
            List<Study_room> list=studyRoomService.selectId(id);
            //人数-1
            int num=list.get(0).getJoinNum()-1;
            Study_room study_room=new Study_room(id,num);
            studyRoomService.updateNum(study_room);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //解散并退出自习室
    @PostMapping("/jiesan")
    public Result jiesan(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int id = Integer.parseInt(data.get("id"));
        String roomName = data.get("roomName");
        Date now=new Date();
        String type ="通知";
        String type1 ="回答";
        String type2 ="问题";
        String title="解散通知";
        try{
            List<RoomPeople> list=studyRoomService.selectPeoNum(id);
            for (int i=0;i<list.size();i++){
                String reusername=list.get(i).getUsername();
                String textarea=reusername+"你好。由于特殊的突发情况，房主"+username+"不得不把其创建的名为"+roomName+"的自习室解散，我非常抱歉给您带来不便，感谢您一直以来的帮助。谢谢！";
                studyRoomService.delpeople(reusername);
                if(!list.get(i).getUsername().equals(username)){
                    Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
                    noticeService.addtz(notice);
                }
            }
            //删除该自习室的资料
            List<Upload> uploads=studyRoomService.selectDoc(id);
            for (int j=0;j<uploads.size();j++){
                int fid=uploads.get(j).getUploadId();
                studyRoomService.delDoc(fid);
            }
            //删除问题
            List<Wt> wts=studyRoomService.selectWt(id);
            for (int k=0;k<wts.size();k++){
                int wtid=wts.get(k).getWtId();
                studyRoomService.delwt(wtid);
                //删除问题的点赞
                communicationService.delfxxd1(wtid,type);
                //删除回答及回答的回答及其相关点赞
                List<Comment> comments=communicationService.selectPl(wtid,type2);
                for (int i=0;i<comments.size();i++){
                    int id1=comments.get(i).getCommentId();
                    List<Comment> comments1=communicationService.selectPl(id1,type1);
                    for (int x=0;x<comments1.size();x++){
                        int id3=comments1.get(x).getCommentId();
                        List<Hits> hits=communicationService.selectHits2(id3,type1);
                        for (int j=0;j<hits.size();j++){
                            int id2=hits.get(j).getId();
                            communicationService.delfxxd1(id2,type1);
                        }
                        communicationService.zjdelpl(id3);
                    }
                    communicationService.delpl(id1,type1);
                    List<Hits> hits=communicationService.selectHits2(id1,type1);
                    for (int j=0;j<hits.size();j++){
                        int id2=hits.get(j).getId();
                        communicationService.delfxxd1(id2,type1);
                    }
                }
            }
            studyRoomService.delRoom(id);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }




    //查询资料自习室
    @PostMapping("/selectRoomId1")
    public Result selectRoomId1(@RequestBody Map<String, String> data){
        String username =  data.get("username");
        try{
            List<RoomPeople> list=studyRoomService.selectPeople(username);
            int id=list.get(0).getId();
            //查询这个用户名所在的自习室
            List<Study_room> list1=studyRoomService.selectId(id);
            //查询自习室里有多少人
            List<RoomPeople> list2=studyRoomService.selectPeoNum(id);
            //确定房主
            for (int m=0;m<list2.size();m++){
                if (list2.get(m).getHomeowner()==1){
                    list1.get(0).setHomeowner(list2.get(m).getUsername());
                }
            }
            return Result.suc(list1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查询资料
    @PostMapping("/selectDow")
    public Result selectDow(@RequestBody Map<String, String> data){
        String type =  data.get("type");
        String document =  data.get("document");
        String username =  data.get("username");
        try{
            List<RoomPeople> list1=studyRoomService.selectPeople(username);
            int id=list1.get(0).getId();
            if(!StringUtils.isEmpty(document) && !StringUtils.isEmpty(type)){
                List<Upload> list=studyRoomService.selectDoc1(id,document,type);
                int total=list.size();
                return Result.suc(list, (long) total);
            }else if(!StringUtils.isEmpty(document)){
                List<Upload> list=studyRoomService.selectDoc2(id,document);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
            else if (!StringUtils.isEmpty(type)){
                List<Upload> list=studyRoomService.selectDoc3(id,type);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
            else{
                List<Upload> list=studyRoomService.selectDoc(id);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //资料删除
    @PostMapping("/delDoc")
    public Result delDoc(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        try{
            studyRoomService.delDoc(id);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //查询问题自习室
    @PostMapping("/selectRoomId2")
    public Result selectRoomId2(@RequestBody Map<String, String> data){
        String username =  data.get("username");
        try{
            List<RoomPeople> list=studyRoomService.selectPeople(username);
            int id=list.get(0).getId();
            //查询这个用户名所在的自习室
            List<Study_room> list1=studyRoomService.selectId(id);
            //查询自习室里有多少人
            List<RoomPeople> list2=studyRoomService.selectPeoNum(id);
            //确定房主
            for (int m=0;m<list2.size();m++){
                if (list2.get(m).getHomeowner()==1){
                    list1.get(0).setHomeowner(list2.get(m).getUsername());
                }
            }
            return Result.suc(list1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //发布问题
    @PostMapping("/addwt")
    public Result addwt(@RequestBody Map<String, String> data){
        String textarea =  data.get("textarea");
        String username =  data.get("username");
        int id = Integer.parseInt(data.get("id"));
        try{
            if (textarea.equals("")){
                return Result.fail13();
            }else{
                Wt wt=new Wt(0,id,username,textarea);
                studyRoomService.insertWt(wt);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //查询问题
    @PostMapping("/selectWt")
    public Result selectWt(@RequestBody Map<String, String> data){
        String question =  data.get("question");
        String username =  data.get("username");
        String type="问题";
        int wtid;
        try{
            List<RoomPeople> list1=studyRoomService.selectPeople(username);
            int id=list1.get(0).getId();
            if(!StringUtils.isEmpty(question)){
                List<Wt> list=studyRoomService.selectWt1(id,question);
                int total=list.size();
                //赋值点赞
                for (int i=0;i<list.size();i++){
                    wtid=list.get(i).getWtId();
                    int num=0;
                    //查询点赞
                    List<Hits> hits=communicationService.selectHits1(wtid,type);
                    for (int j=0;j<hits.size();j++){
                        if (num==1){
                            continue;
                        }else if (hits.get(j).getUsername().equals(username)){
                            list.get(i).setLikes(hits.get(j).getLikes());
                            num++;
                        }else {
                            list.get(i).setLikes(0);
                        }
                    }
                    list.get(i).setHits(hits);
                }
                return Result.suc(list, (long) total);
            }
            else{
                List<Wt> list=studyRoomService.selectWt(id);
                int total=list.size();
                //赋值点赞
                for (int i=0;i<list.size();i++){
                    wtid=list.get(i).getWtId();
                    int num=0;
                    //查询点赞
                    List<Hits> hits=communicationService.selectHits1(wtid,type);
                    for (int j=0;j<hits.size();j++){
                        if (num==1){
                            continue;
                        }else if (hits.get(j).getUsername().equals(username)){
                            list.get(i).setLikes(hits.get(j).getLikes());
                            num++;
                        }else {
                            list.get(i).setLikes(0);
                        }
                    }
                    list.get(i).setHits(hits);
                }
                return Result.suc(list, (long) total);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //自己删除问题
    @PostMapping("/zjdelwt")
    public Result zjdelwt(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        String type="问题";
        String type1="回答";
        try{
            studyRoomService.delwt(id);
            //删除问题的点赞
            communicationService.delfxxd1(id,type);
            //删除回答及回答的回答及其相关点赞
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Comment> comments1=communicationService.selectPl(id1,type1);
                for (int x=0;x<comments1.size();x++){
                    int id3=comments1.get(x).getCommentId();
                    List<Hits> hits=communicationService.selectHits2(id3,type1);
                    for (int j=0;j<hits.size();j++){
                        int id2=hits.get(j).getId();
                        communicationService.delfxxd1(id2,type1);
                    }
                    communicationService.zjdelpl(id3);
                }
                communicationService.delpl(id1,type1);
                List<Hits> hits=communicationService.selectHits2(id1,type1);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type1);
                }
            }
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //房主/教师删除问题
    @PostMapping("/fzdelwt")
    public Result fzdelwt(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        String group =  data.get("group");
        String people =  data.get("people");
        String username =  data.get("username");
        String roomName =  data.get("roomName");
        String type="问题";
        String type1="回答";
        Date now=new Date();
        String types ="提醒";
        String title="删除提醒";
        String textarea;
        try{
            studyRoomService.delwt(id);
            //删除问题的点赞
            communicationService.delfxxd1(id,type);
            //删除回答及回答的回答及其相关点赞
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Comment> comments1=communicationService.selectPl(id1,type1);
                for (int x=0;x<comments1.size();x++){
                    int id3=comments1.get(x).getCommentId();
                    List<Hits> hits=communicationService.selectHits2(id3,type1);
                    for (int j=0;j<hits.size();j++){
                        int id2=hits.get(j).getId();
                        communicationService.delfxxd1(id2,type1);
                    }
                    communicationService.zjdelpl(id3);
                }
                communicationService.delpl(id1,type1);
                List<Hits> hits=communicationService.selectHits2(id1,type1);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type1);
                }
            }
            if (group.equals("房主")){
                textarea=username+"你好。因为你在我创建的名为"+roomName+"的自习室内发布的某个问题违反了我创建该自习室时的初衷，所以我删除了该问题，请您端正自身。如有疑问，请联系我。";
                Notice notice=new Notice(0,title,types,people,username,now,textarea,0,0);
                noticeService.addtz(notice);
                return Result.suc();
            }else{
                textarea=username+"你好。因为你在名为"+roomName+"的自习室内发布的某个问题与我们相关政策不符，我们已经删除了你发布的问题，请您端正自身。如有疑问，请联系你的老师或管理员。";
                Notice notice=new Notice(0,title,types,people,username,now,textarea,0,0);
                noticeService.addtz(notice);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //根据id查询问题
    @PostMapping("/wtList")
    public Result wtList(@RequestBody Map<String, String> data){
        String username =  data.get("username");
        int id= Integer.parseInt(data.get("id"));
        String type="问题";
        String type1="回答";
        int sum=0;
        int wtid;
        try{
            List<Wt> list=studyRoomService.selectWt2(id);
            //赋值点赞
            for (int i=0;i<list.size();i++){
                wtid=list.get(i).getWtId();
                int num=0;
                //查询点赞
                List<Hits> hits=communicationService.selectHits1(wtid,type);
                for (int j=0;j<hits.size();j++){
                        if (num==1){
                            continue;
                        }else if (hits.get(j).getUsername().equals(username)){
                            list.get(i).setLikes(hits.get(j).getLikes());
                            num++;
                        }else {
                            list.get(i).setLikes(0);
                        }
                    }
                list.get(i).setHits(hits);
                //查询评论
                List<Comment> comments=communicationService.selectPl(id,type);
                sum+=comments.size();
                for(int k=0;k<comments.size();k++){
                    int id1=comments.get(k).getCommentId();
                    List<Hits> hits1=communicationService.selectHits1(id1,type1);
                    int num1=0;
                    for (int r=0;r<hits1.size();r++){
                        if (num1==1){
                            continue;
                        }else if (hits1.get(r).getUsername().equals(username)){
                            comments.get(k).setLikes(hits1.get(r).getLikes());
                            num1++;
                        }else {
                            comments.get(k).setLikes(0);
                        }
                    }
                    comments.get(k).setHits(hits1);
                    //查询评论里边的评论
                    List<Comment1> comments1=communicationService.selectPl1(id1,type1);
                    sum+=comments1.size();
                    for(int t=0;t<comments1.size();t++){
                        int id2=comments1.get(t).getCommentId();
                        List<Hits> hits2=communicationService.selectHits1(id2,type1);
                        int num2=0;
                        for (int y=0;y<hits2.size();y++){
                            if (num2==1){
                                continue;
                            }else if (hits2.get(y).getUsername().equals(username)){
                                comments1.get(t).setLikes(hits2.get(y).getLikes());
                                num2++;
                            }else {
                                comments1.get(t).setLikes(0);
                            }
                        }
                        comments1.get(t).setHits(hits2);
                    }
                    comments.get(k).setComments(comments1);
                }
                list.get(0).setCommentList(comments);
                list.get(0).setPlts(sum);
            }
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //教师查询自习室
    @PostMapping("/jszxslist")
    public Result<List<Study_room>> jszxslist(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String roomName = (String)param.get("roomName");
        String type = (String)param.get("type");
        Page<Study_room> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if(!StringUtils.isEmpty(roomName) && !StringUtils.isEmpty(type)){
            List<Study_room> list=studyRoomService.selectZxsList1(page,roomName,type);
            Long total=studyRoomService.selectZxsnum1(roomName,type);
            return Result.suc(list, total);
        }else if(!StringUtils.isEmpty(roomName)){
            List<Study_room> list=studyRoomService.selectZxsList2(page,roomName);
            Long total=studyRoomService.selectZxsnum2(roomName);
            return Result.suc(list, total);
        }else if (!StringUtils.isEmpty(type)){
            List<Study_room> list=studyRoomService.selectZxsList3(page,type);
            Long total=studyRoomService.selectZxsnum3(type);
            return Result.suc(list, total);
        }else{
            IPage<Study_room> result = studyRoomService.selectZxsList(page);
            return Result.suc(result.getRecords(),result.getTotal());
        }
    }
    //教师解散并退出自习室
    @PostMapping("/jsjiesan")
    public Result jsjiesan(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int id = Integer.parseInt(data.get("id"));
        String roomName = data.get("roomName");
        Date now=new Date();
        String type ="通知";
        String type1 ="回答";
        String type2 ="问题";
        String title="解散通知";
        try{
            List<RoomPeople> list=studyRoomService.selectPeoNum(id);
            for (int i=0;i<list.size();i++){
                String reusername=list.get(i).getUsername();
                String textarea;
                studyRoomService.delpeople(reusername);
                if (list.get(i).getHomeowner()==1){
                    textarea=reusername+"你好。由于你创建的自习室与我们相关政策不符，我们已经把你创建的名为"+roomName+"的自习室解散，我非常抱歉给您带来不便。";
                    Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
                    noticeService.addtz(notice);
                }else{
                    textarea=reusername+"你好。由于你所在的自习室与我们相关政策不符，我们已经把你所在的名为"+roomName+"的自习室解散，我非常抱歉给您带来不便。";
                    Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
                    noticeService.addtz(notice);
                }
            }
            //删除该自习室的资料
            List<Upload> uploads=studyRoomService.selectDoc(id);
            for (int j=0;j<uploads.size();j++){
                int fid=uploads.get(j).getUploadId();
                studyRoomService.delDoc(fid);
            }
            //删除问题
            List<Wt> wts=studyRoomService.selectWt(id);
            for (int k=0;k<wts.size();k++){
                int wtid=wts.get(k).getWtId();
                studyRoomService.delwt(wtid);
                //删除问题的点赞
                communicationService.delfxxd1(wtid,type);
                //删除回答及回答的回答及其相关点赞
                List<Comment> comments=communicationService.selectPl(wtid,type2);
                for (int i=0;i<comments.size();i++){
                    int id1=comments.get(i).getCommentId();
                    List<Comment> comments1=communicationService.selectPl(id1,type1);
                    for (int x=0;x<comments1.size();x++){
                        int id3=comments1.get(x).getCommentId();
                        List<Hits> hits=communicationService.selectHits2(id3,type1);
                        for (int j=0;j<hits.size();j++){
                            int id2=hits.get(j).getId();
                            communicationService.delfxxd1(id2,type1);
                        }
                        communicationService.zjdelpl(id3);
                    }
                    communicationService.delpl(id1,type1);
                    List<Hits> hits=communicationService.selectHits2(id1,type1);
                    for (int j=0;j<hits.size();j++){
                        int id2=hits.get(j).getId();
                        communicationService.delfxxd1(id2,type1);
                    }
                }
            }
            studyRoomService.delRoom(id);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师根据id查询自习室里具体信息
    @PostMapping("/selectRoomId3")
    public Result selectRoomId3(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        Date date1,date2;
        date1=new Date();
        RoomPeople people;
        try{
            //查询这个id所在的自习室
            List<Study_room> list1=studyRoomService.selectId(id);
            //查询自习室里有多少人
            List<RoomPeople> list2=studyRoomService.selectPeoNum(id);
            list1.get(0).setList(list2);
            //每个人今日起床打卡时间
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateStr=sdf.format(new Date());
            for (int i=0;i<list2.size();i++){
                String name=list2.get(i).getUsername();
                List<Upclock> upclocks = studyRoomService.selectClock(name,dateStr);
                if (upclocks.size()!=0){
                    list2.get(i).setUpTime(upclocks.get(0).getUpTime());
                }
                else {
                    list2.get(i).setUpTime(null);
                }
            }
            //每个人今日专注时长
            for (int j=0;j<list2.size();j++){
                String name=list2.get(j).getUsername();
                List<Study_plan> study_plans=studyPlanService.selectList(name);
                //判断是否是今天
                int number=0;
                for (int i=0;i<study_plans.size();i++){
                    date2=study_plans.get(i).getUpdateTime();
                    boolean b= DateUtils.isSameDay(date1,date2);
                    if (!b){
                        number+=0;
                    }else{
                        number+=study_plans.get(i).getTodayTime()*study_plans.get(i).getTodayNum();
                    }
                }
                list2.get(j).setTime(number);
            }
            //每人连续专注天数+总专注天数
            for (int k=0;k<list2.size();k++){
                String name=list2.get(k).getUsername();
                List<Experience> experiences=studyRoomService.selectDay(name);
                int sum=0; //总天数
                int num=0;  //连续天数
                int number=0;
                //总天数
                for (int i=0;i<experiences.size()-1;i++){
                    Date date3=experiences.get(i).getCreateTime();
                    Date date4=experiences.get(i+1).getCreateTime();
                    //前后是不是在一天中
                    boolean b= DateUtils.isSameDay(date3,date4);
                    if (!b){
                        sum+=1;
                    }else{
                        if (number==1){
                            continue;
                        }else{
                            sum+=1;
                            number++;
                        }
                    }
                }
                list2.get(k).setTotalDay(sum);
                //连续天数
                for (int j=0;j<experiences.size();j++){
                    if (j==experiences.size()-1){
                        if (new Date().getDate()-experiences.get(j).getCreateTime().getDate()==0){
                            if (number==1){
                                continue;
                            }else{
                                num+=1;
                                number++;
                            }
                        }else{
                            num=0;
                            number=0;
                        }
                    }else if (experiences.get(j+1).getCreateTime().getDate()-experiences.get(j).getCreateTime().getDate()==1){
                        num++;
                    }else if (new Date().getDate()-experiences.get(j).getCreateTime().getDate()==0){
                        if (number==1){
                            continue;
                        }else{
                            num+=1;
                            number++;
                        }
                    }else{
                        num=0;
                        number=0;
                    }
                }
                list2.get(k).setContinumDay(num);
            }
            //排序
//            System.out.println(list2.get(3).toString()+"====================================="+list2.get(4).toString());
            for (int l=0;l<list2.size();l++){
                for (int j=0;j<list2.size()-1;j++){
                    if (list2.get(j).getTime() < list2.get(j + 1).getTime()) {
                        people= list2.get(j);
                        list2.set(j, list2.get(j + 1));
                        list2.set(j+1,people);
                    }
                }
            }
            //赋值排名
            int rank=0;
            for (int m=0;m<list2.size();m++){
                list2.get(m).setRanking(++rank);
                if (list2.get(m).getHomeowner()==1){
                    list1.get(0).setHomeowner(list2.get(m).getUsername());
                }
            }
            return Result.suc(list1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师查询自习室
    @PostMapping("/selectRoomId4")
    public Result selectRoomId4(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("id"));
        try{
            //查询这个id所在的自习室
            List<Study_room> list1=studyRoomService.selectId(id);
            //查询自习室里有多少人
            List<RoomPeople> list2=studyRoomService.selectPeoNum(id);
            //确定房主
            for (int m=0;m<list2.size();m++){
                if (list2.get(m).getHomeowner()==1){
                    list1.get(0).setHomeowner(list2.get(m).getUsername());
                }
            }
            return Result.suc(list1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师查询资料
    @PostMapping("/selectDow1")
    public Result selectDow1(@RequestBody Map<String, String> data){
        String type =  data.get("type");
        String document =  data.get("document");
        int id = Integer.parseInt(data.get("id"));
        try{
            if(!StringUtils.isEmpty(document) && !StringUtils.isEmpty(type)){
                List<Upload> list=studyRoomService.selectDoc1(id,document,type);
                int total=list.size();
                return Result.suc(list, (long) total);
            }else if(!StringUtils.isEmpty(document)){
                List<Upload> list=studyRoomService.selectDoc2(id,document);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
            else if (!StringUtils.isEmpty(type)){
                List<Upload> list=studyRoomService.selectDoc3(id,type);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
            else{
                List<Upload> list=studyRoomService.selectDoc(id);
                int total=list.size();
                return Result.suc(list, (long) total);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师查询问题
    @PostMapping("/selectWt1")
    public Result selectWt1(@RequestBody Map<String, String> data){
        String question =  data.get("question");
        String username =  data.get("username");
        int id = Integer.parseInt(data.get("id"));
        String type="问题";
        int wtid;
        try{
            if(!StringUtils.isEmpty(question)){
                List<Wt> list=studyRoomService.selectWt1(id,question);
                int total=list.size();
                //赋值点赞
                for (int i=0;i<list.size();i++){
                    wtid=list.get(i).getWtId();
                    int num=0;
                    //查询点赞
                    List<Hits> hits=communicationService.selectHits1(wtid,type);
                    for (int j=0;j<hits.size();j++){
                        if (num==1){
                            continue;
                        }else if (hits.get(j).getUsername().equals(username)){
                            list.get(i).setLikes(hits.get(j).getLikes());
                            num++;
                        }else {
                            list.get(i).setLikes(0);
                        }
                    }
                    list.get(i).setHits(hits);
                }
                return Result.suc(list, (long) total);
            }
            else{
                List<Wt> list=studyRoomService.selectWt(id);
                int total=list.size();
                //赋值点赞
                for (int i=0;i<list.size();i++){
                    wtid=list.get(i).getWtId();
                    int num=0;
                    //查询点赞
                    List<Hits> hits=communicationService.selectHits1(wtid,type);
                    for (int j=0;j<hits.size();j++){
                        if (num==1){
                            continue;
                        }else if (hits.get(j).getUsername().equals(username)){
                            list.get(i).setLikes(hits.get(j).getLikes());
                            num++;
                        }else {
                            list.get(i).setLikes(0);
                        }
                    }
                    list.get(i).setHits(hits);
                }
                return Result.suc(list, (long) total);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}