package com.ljp.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.NoticeService;
import com.ljp.demo.utils.QueryPageParam;
import com.ljp.demo.utils.Result;
import com.ljp.demo.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通知(Notice)表控制层
 *
 * @author makejava
 * @since 2023-04-04 16:32:08
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    //接收方级联选择
    @GetMapping("/username")
    public Result<List<Options>> username(){
        //查询学生用户名
        List<User> users=noticeService.selectUsernamae();
        List<Options> options1=new ArrayList<Options>();
        for (int i=0;i<users.size();i++){
            String value=users.get(i).getUsername();
            String label=users.get(i).getUsername();
            Options options=new Options(value,label);
            options1.add(options);
        }
//        System.out.println(options1);
//        Options options1=new Options("个人","个人");
//        //查询班级
//        List<Student> class1=noticeService.selectClass();
//        Options options2=new Options("班级","班级",class1);
//        //查询专业
//        List<Student> major=noticeService.selectMajor();
//        Options options3=new Options("专业","专业",major);
//        //查询学院
//        List<Student> academy=noticeService.selectAcademy();
//        Options options4=new Options("学院","学院",academy);
//        //学校
//        Options options5=new Options("学校","学校");
        try {
//            List<Options> list = null;
//            System.out.println(options5);
////            list.add(options1);
////            list.add(options2);
////            list.add(options3);
////            list.add(options4);
////            list.add(options5);
            return Result.suc(options1);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    @GetMapping("/class1")
    public Result<List<Options>> class1(){
        //查询班级
        List<Student> class1=noticeService.selectClass();
        List<Options> options2=new ArrayList<Options>(); ;
        for (int i=0;i<class1.size();i++){
            String value=class1.get(i).getClassName();
            String label=class1.get(i).getClassName();
            Options options=new Options(value,label);
            options2.add(options);
        }
//        System.out.println(options2);
        try {
            return Result.suc(options2);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    @GetMapping("/major")
    public Result<List<Options>> major(){
        //查询专业
        List<Student> major=noticeService.selectMajor();
        List<Options> options3=new ArrayList<Options>(); ;
        for (int i=0;i<major.size();i++){
            String value=major.get(i).getMajor();
            String label=major.get(i).getMajor();
            Options options=new Options(value,label);
            options3.add(options);
        }
//        System.out.println(options3);
        try {
            return Result.suc(options3);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    @GetMapping("/academy")
    public Result<List<Options>> academy(){
        //查询学院
        List<Student> academy=noticeService.selectAcademy();
        List<Options> options4=new ArrayList<Options>(); ;
        for (int i=0;i<academy.size();i++){
            String value=academy.get(i).getAcademy();
            String label=academy.get(i).getAcademy();
            Options options=new Options(value,label);
            options4.add(options);
        }
//        System.out.println(options4);
        try {
            return Result.suc(options4);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //发布通知
    @PostMapping("/addtz")
    public Result addtz(@RequestBody Map<String, String> data)  {
        //接收参数
        String username = data.get("username");
        String title = data.get("title");
        String reusername = data.get("reusername");
        String type = data.get("type");
        String textarea = data.get("textarea");
        Date now=new Date();
        try{
            Notice notice=new Notice(0,title,type,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师查询通知列表
    @PostMapping("/tzList1")
    public Result<List<Notice>> tzList1(@RequestBody QueryPageParam query){
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String type = (String)param.get("type");
        Page<Notice> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        try{
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(type)){
                List<Notice> list=noticeService.selectList2(page,username,type);
                Long total=noticeService.selectnum2(username,type);
                return Result.suc(list,total);
            }else if(!StringUtils.isEmpty(username)){
                List<Notice> list=noticeService.selectList3(page,username);
                Long total=noticeService.selectnum3(username);
                return Result.suc(list,total);
            }
            else if (!StringUtils.isEmpty(type)){
                List<Notice> list=noticeService.selectList1(page,type);
                Long total=noticeService.selectnum1(type);
                return Result.suc(list,total);
            }
            else{
                IPage<Notice> result = noticeService.findByAllPage(page);
//            System.out.println(result.getRecords());
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //删除通知
    @PostMapping("/deltz")
    public Result deltz(@RequestBody String data){
        int noticeId;
        //将数据字符串转换为JSON对象
        JSONObject jsonObject = (JSONObject) JSONObject.parse(data);
        //将selectedRows对应的值转换为JSON数组
        JSONArray jsonArray = (JSONArray) jsonObject.get("selectedRows");
        try{
            for (int i=0;i<jsonArray.size();i++){
                //将每个元素转换为JSON对象
                JSONObject row = (JSONObject) jsonArray.get(i);
                noticeId = (int) row.get("noticeId");
//                System.out.println(username);
                noticeService.deltz(noticeId);
            }
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //教师置顶
    @PostMapping("/zhiding")
    public Result<List<Notice>> zhiding(@RequestBody Map<String, String> data){
        int noticeId = Integer.parseInt(data.get("noticeId"));
        int level=1;
        try{
            Notice notice=new Notice(noticeId,level);
            noticeService.updateLevel(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //取消置顶
    @PostMapping("/zhiding1")
    public Result<List<Notice>> zhiding1(@RequestBody Map<String, String> data){
        int noticeId = Integer.parseInt(data.get("noticeId"));
        int level=0;
        try{
            Notice notice=new Notice(noticeId,level);
            noticeService.updateLevel(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    //查询通知列表
    @PostMapping("/tzList")
    public Result tzList(@RequestBody Map<String, String> data){
        String reusername = data.get("reusername");
        String username = data.get("username");
        String type = data.get("type");
        Notice list1;
        try{
            if (type.equals("全部")){
                List<Notice> list=noticeService.selectLists(reusername);
                //查询xsnotice中为用户名的列表
                List<XsNotice> xsNotices=noticeService.selectXsList1(username);
                //如果两个表的通知id一样就赋值为1，否则为0
                for (int i=0;i<list.size();i++){
                    int num=0;
                    if (xsNotices.size()==0){
                        list.get(i).setReceived(0);
                        list.get(i).setXslevel(0);
                    }else{
                        for (int j=0;j<xsNotices.size();j++){
                            if (num==1){
                                continue;
                            }
                            else if (list.get(i).getNoticeId()==xsNotices.get(j).getNoticeId()){
                                list.get(i).setReceived(xsNotices.get(j).getReceived());
                                list.get(i).setXslevel(xsNotices.get(j).getXslevel());
                                num++;
                            }else {
                                list.get(i).setReceived(0);
                                list.get(i).setXslevel(0);
                            }
                        }
                    }
                }
                //根据level和xslevel进行排序
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        //教师置顶放在最上边
                        if (list.get(j).getLevel() == 1) {
                            continue;
                        }
                        if (list.get(j).getXslevel() < list.get(j + 1).getXslevel()) {
                            list1= list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j + 1,list1);
                        }
                    }
                }
                return Result.suc(list);
            } else{
                List<Notice> list=noticeService.selectList(reusername,type);
                //查询xsnotice中为用户名的列表
                List<XsNotice> xsNotices=noticeService.selectXsList1(username);
                //如果两个表的通知id一样就赋值为1，否则为0
                for (int i=0;i<list.size();i++){
                    int num=0;
                    if (xsNotices.size()==0){
                        list.get(i).setReceived(0);
                        list.get(i).setXslevel(0);
                    }else{
                        for (int j=0;j<xsNotices.size();j++){
                            if (num==1){
                                continue;
                            }
                            else if (list.get(i).getNoticeId()==xsNotices.get(j).getNoticeId()){
                                list.get(i).setReceived(xsNotices.get(j).getReceived());
                                list.get(i).setXslevel(xsNotices.get(j).getXslevel());
                                num++;
                            }else {
                                list.get(i).setReceived(0);
                                list.get(i).setXslevel(0);
                            }
                        }
                    }
                }
                //根据level和xslevel进行排序
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        //教师置顶放在最上边
                        if (list.get(j).getLevel() == 1) {
                            continue;
                        }
                        if (list.get(j).getXslevel() < list.get(j + 1).getXslevel()) {
                            list1= list.get(j);
                            list.set(j, list.get(j + 1));
                            list.set(j+1,list1);
                        }
                    }
                }
                return Result.suc(list);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //确认收到
    @PostMapping("/qrsftz")
    public Result<List<Notice>> qrsftz(@RequestBody Map<String, String> data){
        int noticeId = Integer.parseInt(data.get("noticeId"));
        String username = data.get("username");
        //发布人用户名
        String reusername = data.get("reusername");
        int sd = Integer.parseInt(data.get("sd"));
        //查询是否有该id和用户名的人创建确认收到
        List<XsNotice> list=noticeService.selectXsList(noticeId,username);
        try{
            if (list.size()!=0){
                int level=list.get(0).getXslevel();
                XsNotice xsnotice=new XsNotice(noticeId,username,level,sd);
                noticeService.updateXsSd(xsnotice);
                //收到人数加1
                List<Notice> notices=noticeService.selectNoticeid(noticeId);
                int qrsd=notices.get(0).getReceivedNum()+1;
//                Notice notice=new Notice(noticeId,qrsd);
                Notice notice=new Notice(noticeId,qrsd,reusername);
                noticeService.updateReceived(notice);
                return Result.suc();
            }else{
                XsNotice xsnotice=new XsNotice(0,noticeId,username,0,sd);
                noticeService.insertXsSd(xsnotice);
                //收到人数加1
                List<Notice> notices=noticeService.selectNoticeid(noticeId);
                int qrsd=notices.get(0).getReceivedNum()+1;
//                Notice notice=new Notice(noticeId,qrsd);
                Notice notice=new Notice(noticeId,qrsd,reusername);
                noticeService.updateReceived(notice);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //置顶
    @PostMapping("/xszhiding")
    public Result<List<Notice>> xszhiding(@RequestBody Map<String, String> data){
        int noticeId = Integer.parseInt(data.get("noticeId"));
        String username = data.get("username");
        int level = Integer.parseInt(data.get("level"));
        //查询是否有该id和用户名的人创建置顶
        List<XsNotice> list=noticeService.selectXsList(noticeId,username);
        try{
            if (list.size()!=0){
                int sd=list.get(0).getReceived();
                XsNotice xsnotice=new XsNotice(noticeId,username,level,sd);
                noticeService.updateXsSd(xsnotice);
                return Result.suc();
            }else{
                XsNotice xsnotice=new XsNotice(0,noticeId,username,level,0);
                noticeService.insertXsSd(xsnotice);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //取消置顶
    @PostMapping("/xszhiding1")
    public Result<List<Notice>> xszhiding1(@RequestBody Map<String, String> data){
        int noticeId = Integer.parseInt(data.get("noticeId"));
        String username = data.get("username");
        int level1 = Integer.parseInt(data.get("level1"));
        //查询是否有该id和用户名的人创建置顶
        List<XsNotice> list=noticeService.selectXsList(noticeId,username);
        try{
            if (list.size()!=0){
                int sd=list.get(0).getReceived();
                XsNotice xsnotice=new XsNotice(noticeId,username,level1,sd);
                noticeService.updateXsSd(xsnotice);
                return Result.suc();
            }else{
                XsNotice xsnotice=new XsNotice(0,noticeId,username,level1,0);
                noticeService.insertXsSd(xsnotice);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //学生删除通知
    @PostMapping("/xsdeltz")
    public Result xsdeltz(@RequestBody Map<String, String> data){
        int noticeId= Integer.parseInt(data.get("noticeId"));
        try{
            noticeService.deltz(noticeId);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}

