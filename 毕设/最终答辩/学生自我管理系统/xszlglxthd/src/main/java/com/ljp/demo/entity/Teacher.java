package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

@TableName("teacher")
public class Teacher {
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
//    @TableField(value = "login_time",fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date loginTime;
    /**
     * 手机号码：[0,11]用户的手机号码，用于找回密码时或登录时
     */
    private String phone;
    /**
     * 用户名：[0,16]用户登录时所用的账户名称
     */
//    private String username;
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
    @TableField(value = "tea_id")
    private int teaId;
    @TableField(value = "tea_number")
    private int teaNumber;
    @TableField(value = "tea_name")
    private String teaName;
    private String gender;
    private String courses;
    private String faculties;
    @TableField(value = "examine_tate")
    private String examineState;
    private String username;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    public Teacher(){}
    //总构造
    public Teacher(int teaId, int teaNumber, String teaName, String gender, String courses, String faculties, String examineState, String username,Date createTime, Date updateTime) {
        this.teaId = teaId;
        this.teaNumber = teaNumber;
        this.teaName = teaName;
        this.gender = gender;
        this.courses = courses;
        this.faculties = faculties;
        this.examineState = examineState;
        this.username = username;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    //教师插入//教师修改
    public Teacher(int teaId, int teaNumber, String teaName, String gender, String courses, String faculties, String examineState,String username) {
        this.teaId = teaId;
        this.teaNumber = teaNumber;
        this.teaName = teaName;
        this.gender = gender;
        this.courses = courses;
        this.faculties = faculties;
        this.examineState = examineState;
        this.username = username;
    }

    public Teacher(int teaId, int teaNumber, String teaName, String faculties, String examineState, String username) {
        this.teaId = teaId;
        this.teaNumber = teaNumber;
        this.teaName = teaName;
        this.faculties = faculties;
        this.examineState = examineState;
        this.username = username;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public int getTeaNumber() {
        return teaNumber;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setTeaNumber(int teaNumber) {
        this.teaNumber = teaNumber;
    }

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

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getFaculties() {
        return faculties;
    }

    public void setFaculties(String faculties) {
        this.faculties = faculties;
    }

    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState;
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
