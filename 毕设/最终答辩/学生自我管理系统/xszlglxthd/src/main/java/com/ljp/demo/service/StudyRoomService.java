package com.ljp.demo.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自习室(StudyRoom)表服务接口
 *
 * @author makejava
 * @since 2023-04-15 15:59:38
 */
public interface StudyRoomService {

    ////查询自习室重名
    List<Study_room> selectroomlist(@Param("roomname")String roomname);
    //创建自习室
    void insertRoom(Study_room study_room);
    void insertPeople(RoomPeople roomPeople);


    //查询用户是否加入自习室
    List<RoomPeople> selectPeople(@Param("username")String username);
    //查询是否有这个加入码
    List<Study_room> selectCode(@Param("code")String code);
    //查询自习室
    List<Study_room> selectroomlist1(@Param("roomname")String roomname);
    List<Study_room> selectroomlist2();
    //查询每个自习室里有多少人
    List<RoomPeople> selectPeoNum(@Param("id")int id);
    //自习室人数+1
    void updateNum(Study_room study_room);
    //通过id查询自习室
    List<Study_room> selectId(@Param("id")int id);


    //查询该用户今天的起床时间
    List<Upclock> selectClock(@Param("username")String username,@Param("dateStr") String dateStr);
    //根据用户名查询心得
    List<Experience> selectDay(@Param("name")String name);
    //修改专注内容对自习室好友可见
    void updateSeen(RoomPeople people);
    //移除成员
    void delpeople(@Param("username")String username);
    //查询今天时长不为0的计划
    List<Study_plan> selectList1(@Param("username")String username,@Param("dateStr") String dateStr);
    //修改自习室资料
    void updateZxs(Study_room study_room);
    //删除自习室
    void delRoom(@Param("id")int id);


    //根据id查询资料
    List<Upload> selectDoc(@Param("id")int id);
    List<Upload> selectDoc1(@Param("id")int id,@Param("document") String document, @Param("type")String type);
    List<Upload> selectDoc2(@Param("id")int id,@Param("document") String document);
    List<Upload> selectDoc3(@Param("id")int id,@Param("type")String type);
    //资料删除
    void delDoc(@Param("id")int id);
    //下载资料
    List<Upload> selectDocId(@Param("uploadId")int uploadId);


    //发布问题
    void insertWt(Wt wt);
    //查询问题
    List<Wt> selectWt1(@Param("id")int id, @Param("question")String question);
    List<Wt> selectWt(@Param("id")int id);
    //删除问题
    void delwt(@Param("id")int id);
    //根据id查询问题
    List<Wt> selectWt2(@Param("id")int id);



    //教师查询自习室
    IPage<Study_room> selectZxsList(Page<Study_room> page);
    List<Study_room> selectZxsList1(Page<Study_room> page, @Param("roomName")String roomName,@Param("type") String type);
    List<Study_room> selectZxsList2(Page<Study_room> page, @Param("roomName")String roomName);
    List<Study_room> selectZxsList3(Page<Study_room> page, @Param("type")String type);
    Long selectZxsnum1(@Param("roomName")String roomName, @Param("type")String type);
    Long selectZxsnum2(@Param("roomName")String roomName);
    Long selectZxsnum3(@Param("type")String type);


    //根据id查询wt列表
    List<Wt> selectWt4(@Param("jlid")int jlid);
}
