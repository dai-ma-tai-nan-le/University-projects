package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@TableName("study_room")
public class Study_room {
    /**
     * 自习室ID
     */
    @TableField(value = "study_room_id")
    private Integer studyRoomId;
    /**
     * 加入码
     */
    private String code;
    /**
     * 是否公开
     */
    private String type;
    /**
     * 自习室名称
     */
    @TableField(value = "room_name")
    private String roomName;
    /**
     * 自习室简介
     */
    @TableField(value = "room_introduce")
    private String roomIntroduce;
    /**
     * 密码：由6-16位数字或英文组成
     */
    private String password;
    /**
     * 加入人数
     */
    @TableField(value = "join_num")
    private Integer joinNum;
    /**
     * 限定人数
     */
    @TableField(value = "limit_num")
    private Integer limitNum;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //排名
    private int ranking;
    //房主
    private String homeowner;
    //成员信息
    List<RoomPeople> list;
    //资料信息
//    List<Upload> uploads;
    //问题信息


    public Study_room() {
    }

    public Study_room(Integer studyRoomId, Integer joinNum) {
        this.studyRoomId = studyRoomId;
        this.joinNum = joinNum;
    }

    public Study_room(Integer studyRoomId, String type, String roomName, String roomIntroduce, String password, Integer limitNum) {
        this.studyRoomId = studyRoomId;
        this.type = type;
        this.roomName = roomName;
        this.roomIntroduce = roomIntroduce;
        this.password = password;
        this.limitNum = limitNum;
    }

    public Study_room(Integer studyRoomId, String code, String type, String roomName, String roomIntroduce, String password, Integer joinNum, Integer limitNum) {
        this.studyRoomId = studyRoomId;
        this.code = code;
        this.type = type;
        this.roomName = roomName;
        this.roomIntroduce = roomIntroduce;
        this.password = password;
        this.joinNum = joinNum;
        this.limitNum = limitNum;
    }



    public int getRanking() {
        return ranking;
    }

    public String getHomeowner() {
        return homeowner;
    }

    public void setHomeowner(String homeowner) {
        this.homeowner = homeowner;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public List<RoomPeople> getList() {
        return list;
    }

    public void setList(List<RoomPeople> list) {
        this.list = list;
    }

    public Integer getStudyRoomId() {
        return studyRoomId;
    }

    public void setStudyRoomId(Integer studyRoomId) {
        this.studyRoomId = studyRoomId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomIntroduce() {
        return roomIntroduce;
    }

    public void setRoomIntroduce(String roomIntroduce) {
        this.roomIntroduce = roomIntroduce;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
