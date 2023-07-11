package com.ljp.demo.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@TableName("student")
public class Student {
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
     * 用户名：[0,16]用户登录时所用的账户名称
     */
    private String username;
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
    @TableField(value = "stu_id")
    private int stuId;
    @TableField(value = "stu_number")
    private int stuNumber;
    @TableField(value = "stu_name")
    private String stuName;
    private String gender;
    private String academy;
    private String major;
    @TableField(value = "class_name")
    private String className;
    @TableField(value = "tea_number")
    private int teaNumber;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Student() {
    }
    //学生插入/修改
    public Student(int stuId, int stuNumber, String stuName, String gender, String academy, String major, String className, int teaNumber,String username) {
        this.username = username;
        this.stuId = stuId;
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.gender = gender;
        this.academy = academy;
        this.major = major;
        this.className = className;
        this.teaNumber = teaNumber;
    }

    public Student(int stuId, int stuNumber, String stuName, String gender, String academy, String major, String className, int teaNumber, String username, Date createTime, Date updateTime) {
        this.username = username;
        this.stuId = stuId;
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.gender = gender;
        this.academy = academy;
        this.major = major;
        this.className = className;
        this.teaNumber = teaNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Student(int stuId, int stuNumber, String stuName, String academy, int teaNumber, String username) {
        this.username = username;
        this.stuId = stuId;
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.academy = academy;
        this.teaNumber = teaNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeaNumber() {
        return teaNumber;
    }

    public void setTeaNumber(int teaNumber) {
        this.teaNumber = teaNumber;
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
