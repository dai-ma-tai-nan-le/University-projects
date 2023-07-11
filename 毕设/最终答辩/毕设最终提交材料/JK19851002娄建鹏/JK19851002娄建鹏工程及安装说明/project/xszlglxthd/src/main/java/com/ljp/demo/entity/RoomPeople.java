package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 自习室(RoomPeople)实体类
 *
 * @author makejava
 * @since 2023-04-15 22:04:54
 */
@TableName("room_people")
public class RoomPeople{
    /**
     * 加入自习室ID
     */
    @TableField(value = "room_people_id")
    private Integer roomPeopleId;
    /**
     * 自习室id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 是否是房主
     */
    private Integer homeowner;
    /**
     * 专注内容是否对自习室好友可见
     */
    private Integer seen;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //连续专注天数
    private int continumDay;
    //总专注天数
    private int totalDay;
    //今日专注时长
    private int time;
    //排名
    private int ranking;
    //今天起床时间
    @TableField(value = "up_time")
    @JsonFormat(pattern="HH:mm",timezone="GMT+8")
    private Date upTime;

    public RoomPeople() {
    }

    public RoomPeople(String username, Integer seen) {
        this.username = username;
        this.seen = seen;
    }

    public RoomPeople(Integer roomPeopleId, Integer id, String username, Integer homeowner, Integer seen) {
        this.roomPeopleId = roomPeopleId;
        this.id = id;
        this.username = username;
        this.homeowner = homeowner;
        this.seen = seen;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getContinumDay() {
        return continumDay;
    }

    public void setContinumDay(int continumDay) {
        this.continumDay = continumDay;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Integer getRoomPeopleId() {
        return roomPeopleId;
    }

    public void setRoomPeopleId(Integer roomPeopleId) {
        this.roomPeopleId = roomPeopleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHomeowner() {
        return homeowner;
    }

    public void setHomeowner(Integer homeowner) {
        this.homeowner = homeowner;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer seen) {
        this.seen = seen;
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

    /**
     * 用户ID：[0,8388607]用户获取其他与用户相关的数据
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 所在用户组：[0,32767]决定用户身份和权限
     */
    @TableField(value = "user_group")
    private String userGroup;
    /**
     * 登录时间：
     */
    @TableField(value = "login_time",fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date loginTime;
    /**
     * 手机号码：[0,11]用户的手机号码，用于找回密码时或登录时
     */
    private String phone;
    /**
     * 密码：[0,32]用户登录所需的密码，由6-16位数字或英文组成
     */
    private String password;
    //账号状态
    private String status;
    /**
     * 邮箱：[0,64]用户的邮箱，用于找回密码时或登录时
     */
    private String email;
    /**
     * 头像地址：[0,255]
     */
    private String avatar;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "RoomPeople{" +
                "roomPeopleId=" + roomPeopleId +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", homeowner=" + homeowner +
                ", seen=" + seen +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", continumDay=" + continumDay +
                ", totalDay=" + totalDay +
                ", time=" + time +
                ", ranking=" + ranking +
                ", upTime=" + upTime +
                ", userId=" + userId +
                ", userGroup='" + userGroup + '\'' +
                ", loginTime=" + loginTime +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

