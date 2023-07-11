package com.ljp.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.CommunicationService;
import com.ljp.demo.service.NoticeService;
import com.ljp.demo.service.StudyRoomService;
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
import java.util.*;

/**
 * 解惑(Communication)表控制层
 *
 * @author makejava
 * @since 2023-04-09 14:33:46
 */
@RestController
@RequestMapping("/communication")
public class CommunicationController {
    /**
     * 服务对象
     */
    @Resource
    private CommunicationService communicationService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private StudyRoomService studyRoomService;


    //查询心得分享列表
    @PostMapping("/xdfxList")
    public Result xdfxList(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String reusername = data.get("reusername");
        int id;
        String type="交流";
        String type1="评论";
        int sum=0;
        try{
            if (!reusername.equals("我的")){
                List<Communication> list=communicationService.selectList(reusername);
                //赋值点赞的人
                for (int i=0;i<list.size();i++){
                    id=list.get(i).getCommunicationId();
                    int num=0;
                    //查询点赞
                    List<Hits> hits=communicationService.selectHits1(id,type);
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
                    for (int k=0;k<comments.size();k++){
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
                        for (int t=0;t<comments1.size();t++){
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
                    list.get(i).setCommentList(comments);
                    list.get(i).setPlts(sum);
                }
                return Result.suc(list);
            }else {
                List<Communication> list=communicationService.selectList1(username);
                //赋值点赞的人
                for (int i=0;i<list.size();i++){
                    id=list.get(i).getCommunicationId();
                    int num=0;
                    List<Hits> hits=communicationService.selectHits1(id,type);
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
                    for (int k=0;k<comments.size();k++){
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
                        for (int t=0;t<comments1.size();t++){
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
                    list.get(i).setCommentList(comments);
                    list.get(i).setPlts(sum);
                }
                return Result.suc(list);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //点赞
    @PostMapping("/dianzhan")
    public Result dianzhan(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int id = Integer.parseInt(data.get("communicationId"));
        int dz = Integer.parseInt(data.get("dz"));
        String type=data.get("type");
        try{
            //判断是否有点赞
            List<Hits> hits=communicationService.selectHits(id,username,type);
            if (hits.size()==0){
               Hits hits1=new Hits(0,id,type,username,dz);
               communicationService.insertHits(hits1);
                return Result.suc();
            }else {
                Hits hits1=new Hits(id,type,username,dz);
                communicationService.updateHits(hits1);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //取消点赞
    @PostMapping("/qxdz")
    public Result qxdz(@RequestBody Map<String, String> data){
        String username = data.get("username");
        int id = Integer.parseInt(data.get("communicationId"));
        int dz = Integer.parseInt(data.get("qxdz"));
        String type=data.get("type");
        try{
            //判断是否有该列
            List<Hits> hits=communicationService.selectHits(id,username,type);
            if (hits.size()==0){
                Hits hits1=new Hits(0,id,type,username,dz);
                communicationService.insertHits(hits1);
                return Result.suc();
            }else {
                Hits hits1=new Hits(id,type,username,dz);
                communicationService.updateHits(hits1);
                return Result.suc();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //删除分享的心得
    @PostMapping("/scfxxd")
    public Result scfxxd(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("communicationId"));
        String type="交流";
        String type1="评论";
        try{
            communicationService.delfxxd(id);
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
            communicationService.delfxxd1(id,type);
            communicationService.delpl(id,type);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //发布评论
    @PostMapping("/fabu")
    public Result fabu(@RequestBody Map<String, String> data){
        String username = data.get("username");
        String reusername = data.get("reusername");
        int id = Integer.parseInt(data.get("communicationId"));
        String content = data.get("textarea1");
        String type=data.get("type");
        try{
            Comment comment=new Comment(0,id,type,username,reusername,content);
            communicationService.insertPl(comment);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //删除自己发的评论
    @PostMapping("/delpl")
    public Result delpl(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("commentId"));
        String type="评论";
        try{
            //查询评论
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Hits> hits=communicationService.selectHits2(id1,type);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type);
                }
                communicationService.zjdelpl(id1);
            }
            List<Hits> hits=communicationService.selectHits2(id,type);
            for (int j=0;j<hits.size();j++){
                int id2=hits.get(j).getId();
                communicationService.delfxxd1(id2,type);
            }
            communicationService.zjdelpl(id);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //教师查询心得交流列表
    @PostMapping("/xdjlList1")
    public Result<List<Communication>> xdjlList1(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String username = (String)param.get("username");
        String reusername = (String)param.get("reusername");
        String userGroup = (String)param.get("userGroup");
        String academy = (String)param.get("academy");
        Page<Communication> page = new Page<>();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        if (userGroup.equals("教师")){
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(reusername)){
                List<Communication> list=communicationService.selectList5(page,username,reusername,academy);
                Long total=communicationService.selectnum5(username,reusername,academy);
                return Result.suc(list, total);
            }else if(!StringUtils.isEmpty(username)){
                List<Communication> list=communicationService.selectList6(page,username,academy);
                Long total=communicationService.selectnum6(username,academy);
                return Result.suc(list, total);
            }
            else if (!StringUtils.isEmpty(reusername)){
                List<Communication> list=communicationService.selectList7(page,reusername,academy);
                Long total=communicationService.selectnum7(reusername,academy);
                return Result.suc(list, total);
            }
            else{
                IPage<Communication> result = communicationService.findByAllPage1(page,academy);
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }else{
            if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(reusername)){
                List<Communication> list=communicationService.selectList2(page,username,reusername);
                Long total=communicationService.selectnum1(username,reusername);
                return Result.suc(list, total);
            }else if(!StringUtils.isEmpty(username)){
                List<Communication> list=communicationService.selectList3(page,username);
                Long total=communicationService.selectnum2(username);
                return Result.suc(list, total);
            }
            else if (!StringUtils.isEmpty(reusername)){
                List<Communication> list=communicationService.selectList4(page,reusername);
                Long total=communicationService.selectnum3(reusername);
                return Result.suc(list, total);
            }
            else{
                IPage<Communication> result = communicationService.findByAllPage(page);
                return Result.suc(result.getRecords(),result.getTotal());
            }
        }
    }
    //查询心得分享列表
    @PostMapping("/xdfxList1")
    public Result xdfxList1(@RequestBody Map<String, String> data){
        int communicationId= Integer.parseInt(data.get("id"));
        String username = data.get("username");
        int id;
        String type="交流";
        String type1="评论";
        int sum=0;
        try{
            List<Communication> list=communicationService.selectJlList(communicationId);
            //赋值点赞的人
            id=list.get(0).getCommunicationId();
            //查询点赞
            List<Hits> hits=communicationService.selectHits1(id,type);
            int num=0;
            for (int j=0;j<hits.size();j++){
                if (num==1){
                    continue;
                }else if (hits.get(j).getUsername().equals(username)){
                    list.get(0).setLikes(hits.get(j).getLikes());
                    num++;
                }else {
                    list.get(0).setLikes(0);
                }
            }
            list.get(0).setHits(hits);
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
            return Result.suc(list);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师删除学生发的评论
    @PostMapping("/jsdelpl")
    public Result jsdelpl(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("commentId"));
        int jlid = Integer.parseInt(data.get("id"));
        String username=data.get("username");
        String reusername=data.get("reusername");
        String type="评论";
        Date now=new Date();
        String types ="提醒";
        String title="提删除醒";
        String textarea;
        List<Communication> list=communicationService.selectJlList(jlid);
        if(list.size()!=0){
            String planName=list.get(0).getPlanName();
            String name=list.get(0).getUsername();
            textarea=reusername+"你好：由于你在"+name+"分享的名为"+planName+"的心得中发布的评论与我们相关政策不符，我们已经删除了您发布的评论，请您端正自身。如有疑问，请联系你的老师或管理员。";
        }else{
            List<Comment> comments=communicationService.selectPl2(jlid);
            int id1=comments.get(0).getId();
            List<Communication> list1=communicationService.selectJlList(id1);
            String planName=list1.get(0).getPlanName();
            String name=list1.get(0).getUsername();
            textarea=reusername+"你好：由于你在"+name+"分享的名为"+planName+"的心得中回复的评论与我们相关政策不符，我们已经删除了您发布的评论，请您端正自身。如有疑问，请联系你的老师或管理员。";
        }
        try{
            //查询评论
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Hits> hits=communicationService.selectHits2(id1,type);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type);
                }
                communicationService.zjdelpl(id1);
            }
            List<Hits> hits=communicationService.selectHits2(id,type);
            for (int j=0;j<hits.size();j++){
                int id2=hits.get(j).getId();
                communicationService.delfxxd1(id2,type);
            }
            communicationService.zjdelpl(id);
            Notice notice=new Notice(0,title,types,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师删除分享的心得
    @PostMapping("/jsscfxxd")
    public Result jsscfxxd(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("communicationId"));
        String username=data.get("username");
        String reusername=data.get("reusername");
        String type="交流";
        String type1="评论";
        Date now=new Date();
        String types ="提醒";
        String title="提删除醒";
        List<Communication> list=communicationService.selectJlList(id);
        String planName=list.get(0).getPlanName();
        String textarea=reusername+"你好：由于你分享的名为"+planName+"的心得与我们相关政策不符，我们已经删除了您分享的心得，请您端正自身。如有疑问，请联系你的老师或管理员。";
        try{
            communicationService.delfxxd(id);
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
            communicationService.delfxxd1(id,type);
            communicationService.delpl(id,type);
            Notice notice=new Notice(0,title,types,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }



    //删除自己发的回答
    @PostMapping("/delpl1")
    public Result delpl1(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("commentId"));
        String type="回答";
        try{
            //查询评论
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Hits> hits=communicationService.selectHits2(id1,type);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type);
                }
                communicationService.zjdelpl(id1);
            }
            List<Hits> hits=communicationService.selectHits2(id,type);
            for (int j=0;j<hits.size();j++){
                int id2=hits.get(j).getId();
                communicationService.delfxxd1(id2,type);
            }
            communicationService.zjdelpl(id);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
    //教师删除学生发的评论
    @PostMapping("/jsdelpl1")
    public Result jsdelpl1(@RequestBody Map<String, String> data){
        int id = Integer.parseInt(data.get("commentId"));
        int jlid = Integer.parseInt(data.get("id"));
        String username=data.get("username");
        String reusername=data.get("reusername");
        String homeOwner=data.get("homeOwner");
        String type="回答";
        Date now=new Date();
        String types ="提醒";
        String title="提删除醒";
        String textarea;
        List<Wt> list=studyRoomService.selectWt4(jlid);
        if(list.size()!=0){
            int zxsid=list.get(0).getId();
            List<Study_room> list1=studyRoomService.selectId(zxsid);
            String roomName=list1.get(0).getRoomName();
            textarea=reusername+"你好：由于你在"+homeOwner+"创建的名为"+roomName+"的自习室中发布的回答与我们相关政策不符，我们已经删除了您发布的回答，请您端正自身。如有疑问，请联系你的老师或管理员。";
        }else{
            List<Comment> comments=communicationService.selectPl2(jlid);
            int id1=comments.get(0).getId();
            List<Wt> list1=studyRoomService.selectWt4(id1);
            int zxsid=list1.get(0).getId();
            List<Study_room> list2=studyRoomService.selectId(zxsid);
            String roomName=list2.get(0).getRoomName();
            textarea=reusername+"你好：由于你在"+homeOwner+"创建的名为"+roomName+"的自习室中回复的回答与我们相关政策不符，我们已经删除了您发布的回答，请您端正自身。如有疑问，请联系你的老师或管理员。";
        }
        try{
            //查询评论
            List<Comment> comments=communicationService.selectPl(id,type);
            for (int i=0;i<comments.size();i++){
                int id1=comments.get(i).getCommentId();
                List<Hits> hits=communicationService.selectHits2(id1,type);
                for (int j=0;j<hits.size();j++){
                    int id2=hits.get(j).getId();
                    communicationService.delfxxd1(id2,type);
                }
                communicationService.zjdelpl(id1);
            }
            List<Hits> hits=communicationService.selectHits2(id,type);
            for (int j=0;j<hits.size();j++){
                int id2=hits.get(j).getId();
                communicationService.delfxxd1(id2,type);
            }
            communicationService.zjdelpl(id);
            Notice notice=new Notice(0,title,types,username,reusername,now,textarea,0,0);
            noticeService.addtz(notice);
            return Result.suc();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }
}

