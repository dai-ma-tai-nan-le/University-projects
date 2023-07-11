package com.ljp.demo.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 自习室(StudyRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-15 15:59:38
 */
@Mapper
public interface StudyRoomDao {

    ////查询自习室重名
    @Select("select * from study_room where room_name=#{roomname}")
    List<Study_room> selectroomlist(@Param("roomname")String roomname);
    //创建自习室
    @Insert("insert into study_room values(null,#{code},#{type},#{roomName},#{roomIntroduce},#{password},#{joinNum},#{limitNum},#{createTime},#{updateTime})")
    void insertRoom(Study_room study_room);
    @Insert("insert into room_people values(null,#{id},#{username},#{homeowner},#{seen},#{createTime},#{updateTime})")
    void insertPeople(RoomPeople roomPeople);


    //查询用户是否加入自习室
    @Select("select * from room_people where username=#{username}")
    List<RoomPeople> selectPeople(@Param("username")String username);
    //查询是否有这个加入码
    @Select("select * from study_room where code=#{code}")
    List<Study_room> selectCode(@Param("code")String code);
    //查询自习室
    @Select("select * from study_room where room_name like CONCAT('%',#{roomname},'%')")
    List<Study_room> selectroomlist1(@Param("roomname")String roomname);
    @Select("select * from study_room")
    List<Study_room> selectroomlist2();
    //查询每个自习室里有多少人
    @Select("select * from room_people as r,user as u where id=#{id} and r.username=u.username")
    List<RoomPeople> selectPeoNum(@Param("id")int id);
    //自习室人数+1
    @Update("update study_room set join_num=#{joinNum} where study_room_id=#{studyRoomId}")
    void updateNum(Study_room study_room);
    //通过id查询自习室
    @Select("select * from study_room where study_room_id=#{id}")
    List<Study_room> selectId(@Param("id")int id);


    //查询该用户今天的起床时间
    @Select("select * from upclock where username=#{username} and up_time like CONCAT('%',#{dateStr},'%')")
    List<Upclock> selectClock(@Param("username")String username,@Param("dateStr") String dateStr);
    //根据用户名查询心得
    @Select("select * from experience where username=#{name}")
    List<Experience> selectDay(@Param("name")String name);
    //修改专注内容对自习室好友可见
    @Update("update room_people set seen=#{seen} where username=#{username}")
    void updateSeen(RoomPeople people);
    //移除成员
    @Delete("delete from room_people where username=#{username}")
    void depeople(String username);
    //查询今天时长不为0的计划
    @Select("select * from study_plan where username=#{username} and today_time!=0 and update_time like CONCAT('%',#{dateStr},'%')")
    List<Study_plan> selectList1(@Param("username")String username,@Param("dateStr") String dateStr);
    //修改自习室资料
    @Update("update study_room set type=#{type},room_name=#{roomName},room_introduce=#{roomIntroduce},password=#{password},limit_num=#{limitNum} where study_room_id=#{studyRoomId}")
    void updateZxs(Study_room study_room);
    //删除自习室
    @Delete("delete from study_room where study_room_id=#{id}")
    void delRoom(@Param("id")int id);


    //根据id查询资料
    @Select("select * from upload where id=#{id} order by upload_id desc")
    List<Upload> selectDoc(@Param("id")int id);
    @Select("select * from upload where id=#{id} and name like CONCAT('%',#{document},'%') and type like CONCAT('%',#{type},'%')")
    List<Upload> selectDoc1(@Param("id")int id,@Param("document") String document, @Param("type")String type);
    @Select("select * from upload where id=#{id} and name like CONCAT('%',#{document},'%')")
    List<Upload> selectDoc2(@Param("id")int id,@Param("document") String document);
    @Select("select * from upload where id=#{id} and type like CONCAT('%',#{type},'%')")
    List<Upload> selectDoc3(@Param("id")int id, @Param("type")String type);
    //资料删除
    @Delete("delete from upload where upload_id=#{id}")
    void delDoc(@Param("id")int id);
    //下载资料
    @Select("select * from upload where upload_id=#{uploadId}")
    List<Upload> selectDocId(@Param("uploadId")int uploadId);



    //发布问题
    @Insert("insert into wt values(null,#{id},#{username},#{content},#{createTime},#{updateTime})")
    void insertWt(Wt wt);
    //查询问题
    @Select("select * from wt as w,user as u where id=#{id} and content like CONCAT('%',#{question},'%') and w.username=u.username")
    List<Wt> selectWt1(@Param("id")int id,@Param("question") String question);
    @Select("select * from wt as w,user as u where id=#{id} and w.username=u.username")
    List<Wt> selectWt(@Param("id")int id);
    //删除问题
    @Delete("delete from wt where wt_id=#{id}")
    void delwt(@Param("id")int id);
    //根据id查询问题
    @Select("select * from wt as w,user as u where wt_id=#{id} and w.username=u.username")
    List<Wt> selectWt2(@Param("id")int id);




    //教师查询自习室
    @Select("select * from study_room order by study_room_id desc")
    IPage<Study_room> selectZxsList(Page<Study_room> page);
    @Select("select * from study_room where room_name like CONCAT('%',#{roomName},'%') and type like CONCAT('%',#{type},'%')")
    List<Study_room> selectZxsList1(Page<Study_room> page,@Param("roomName") String roomName,@Param("type") String type);
    @Select("select * from study_room where room_name like CONCAT('%',#{roomName},'%')")
    List<Study_room> selectZxsList2(Page<Study_room> page,@Param("roomName") String roomName);
    @Select("select * from study_room where type like CONCAT('%',#{type},'%')")
    List<Study_room> selectZxsList3(Page<Study_room> page,@Param("type") String type);
    @Select("select count(*) from study_room where room_name like CONCAT('%',#{roomName},'%') and type like CONCAT('%',#{type},'%')")
    Long selectZxsnum1(@Param("roomName")String roomName, @Param("type")String type);
    @Select("select count(*) from study_room where room_name like CONCAT('%',#{roomName},'%')")
    Long selectZxsnum2(@Param("roomName")String roomName);
    @Select("select count(*) from study_room where type like CONCAT('%',#{type},'%')")
    Long selectZxsnum3(@Param("type")String type);



    //根据id查询wt列表
    @Select("select * from wt where wt_id=#{jlid}")
    List<Wt> selectWt4(@Param("jlid")int jlid);
}

