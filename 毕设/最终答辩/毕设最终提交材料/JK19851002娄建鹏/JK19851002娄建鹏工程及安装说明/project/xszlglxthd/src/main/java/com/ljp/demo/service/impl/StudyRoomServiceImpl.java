package com.ljp.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.dao.StudyRoomDao;
import com.ljp.demo.entity.*;
import com.ljp.demo.service.StudyRoomService;
import com.ljp.demo.utils.Md5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 自习室(StudyRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-04-15 15:59:38
 */
@Service("studyRoomService")
public class StudyRoomServiceImpl implements StudyRoomService {
    @Resource
    private StudyRoomDao studyRoomDao;


    ////查询自习室重名
    @Override
    public List<Study_room> selectroomlist(@Param("roomname")String roomname) {
        return studyRoomDao.selectroomlist(roomname);
    }
    //创建自习室
    @Override
    public void insertRoom(Study_room study_room) {
        study_room.setCreateTime(new Date());
        study_room.setUpdateTime(new Date());
        study_room.setPassword(Md5Utils.md5(study_room.getPassword()));
        studyRoomDao.insertRoom(study_room);
    }
    @Override
    public void insertPeople(RoomPeople roomPeople) {
        roomPeople.setCreateTime(new Date());
        roomPeople.setUpdateTime(new Date());
        studyRoomDao.insertPeople(roomPeople);
    }


    //查询用户是否加入自习室
    @Override
    public List<RoomPeople> selectPeople(@Param("username")String username) {
        return studyRoomDao.selectPeople(username);
    }
    //查询是否有这个加入码
    @Override
    public List<Study_room> selectCode(@Param("code")String code) {
        return studyRoomDao.selectCode(code);
    }
    //查询自习室
    @Override
    public List<Study_room> selectroomlist1(@Param("roomname")String roomname) {
        return studyRoomDao.selectroomlist1(roomname);
    }
    @Override
    public List<Study_room> selectroomlist2() {
        return studyRoomDao.selectroomlist2();
    }
    //查询每个自习室里有多少人
    @Override
    public List<RoomPeople> selectPeoNum(@Param("id")int id) {
        return studyRoomDao.selectPeoNum(id);
    }
    //自习室人数+1
    @Override
    public void updateNum(Study_room study_room) {
        studyRoomDao.updateNum(study_room);
    }
    //通过id查询自习室
    @Override
    public List<Study_room> selectId(@Param("id")int id) {
        return studyRoomDao.selectId(id);
    }



    //查询该用户今天的起床时间
    @Override
    public List<Upclock> selectClock(@Param("username")String username,@Param("dateStr") String dateStr) {
        return studyRoomDao.selectClock(username,dateStr);
    }
    //根据用户名查询心得
    @Override
    public List<Experience> selectDay(@Param("name")String name) {
        return studyRoomDao.selectDay(name);
    }
    //修改专注内容对自习室好友可见
    @Override
    public void updateSeen(RoomPeople people) {
        studyRoomDao.updateSeen(people);
    }
    //移除成员
    @Override
    public void delpeople(@Param("username")String username) {
        studyRoomDao.depeople(username);
    }
    //查询今天时长不为0的计划
    @Override
    public List<Study_plan> selectList1(@Param("username")String username,@Param("dateStr") String dateStr) {
        return studyRoomDao.selectList1(username,dateStr);
    }
    //修改自习室资料
    @Override
    public void updateZxs(Study_room study_room) {
        study_room.setPassword(Md5Utils.md5(study_room.getPassword()));
        studyRoomDao.updateZxs(study_room);
    }
    //删除自习室
    @Override
    public void delRoom(@Param("id")int id) {
        studyRoomDao.delRoom(id);
    }



    //根据id查询资料
    @Override
    public List<Upload> selectDoc(@Param("id")int id) {
        return studyRoomDao.selectDoc(id);
    }
    @Override
    public List<Upload> selectDoc1(@Param("id")int id,@Param("document") String document, @Param("type")String type) {
        return studyRoomDao.selectDoc1(id,document,type);
    }
    @Override
    public List<Upload> selectDoc2(@Param("id")int id,@Param("document") String document) {
        return studyRoomDao.selectDoc2(id,document);
    }
    @Override
    public List<Upload> selectDoc3(@Param("id")int id,@Param("type") String type) {
        return studyRoomDao.selectDoc3(id,type);
    }
    //资料删除
    @Override
    public void delDoc(@Param("id")int id) {
        studyRoomDao.delDoc(id);
    }
    //下载资料
    @Override
    public List<Upload> selectDocId(@Param("uploadId")int uploadId) {
        return studyRoomDao.selectDocId(uploadId);
    }



    //发布问题
    @Override
    public void insertWt(Wt wt) {
        wt.setCreateTime(new Date());
        wt.setUpdateTime(new Date());
        studyRoomDao.insertWt(wt);
    }
    //查询问题
    @Override
    public List<Wt> selectWt1(@Param("id")int id,@Param("question") String question) {
        return studyRoomDao.selectWt1(id,question);
    }
    @Override
    public List<Wt> selectWt(@Param("id")int id) {
        return studyRoomDao.selectWt(id);
    }
    //删除问题
    @Override
    public void delwt(@Param("id")int id) {
        studyRoomDao.delwt(id);
    }
    //根据id查询问题
    @Override
    public List<Wt> selectWt2(@Param("id")int id) {
        return studyRoomDao.selectWt2(id);
    }



    //教师查询自习室
    @Override
    public IPage<Study_room> selectZxsList(Page<Study_room> page) {
        return studyRoomDao.selectZxsList(page);
    }
    @Override
    public List<Study_room> selectZxsList1(Page<Study_room> page,@Param("roomName") String roomName, @Param("type")String type) {
        return studyRoomDao.selectZxsList1(page,roomName,type);
    }
    @Override
    public List<Study_room> selectZxsList2(Page<Study_room> page,@Param("roomName") String roomName) {
        return studyRoomDao.selectZxsList2(page,roomName);
    }
    @Override
    public List<Study_room> selectZxsList3(Page<Study_room> page,@Param("type") String type) {
        return studyRoomDao.selectZxsList3(page,type);
    }
    @Override
    public Long selectZxsnum1(@Param("roomName")String roomName, @Param("type")String type) {
        return studyRoomDao.selectZxsnum1(roomName,type);
    }
    @Override
    public Long selectZxsnum2(@Param("roomName")String roomName) {
        return studyRoomDao.selectZxsnum2(roomName);
    }
    @Override
    public Long selectZxsnum3(@Param("type")String type) {
        return studyRoomDao.selectZxsnum3(type);
    }



    //根据id查询wt列表
    @Override
    public List<Wt> selectWt4(@Param("jlid")int jlid) {
        return studyRoomDao.selectWt4(jlid);
    }


}
