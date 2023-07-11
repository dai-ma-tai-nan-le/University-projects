package com.ljp.demo.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@TableName("goal_plan")
public class Goal_plan {
    @TableField(value = "goal_plan_id")
    private int goalPlanId;
    private String username;
    @TableField(value = "goal_name")
    private String goalName;
    @TableField(value = "goal_describe")
    private String goalDescribe;
    @TableField(value = "end_time")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Goal_plan() {
    }

    public Goal_plan(int goalPlanId, String username, String goalName, String goalDescribe, Date endTime) {
        this.goalPlanId = goalPlanId;
        this.username = username;
        this.goalName = goalName;
        this.goalDescribe = goalDescribe;
        this.endTime = endTime;
    }

    public Goal_plan(int goalPlanId, String goalname, String description, Date endTime1) {
        this.goalPlanId = goalPlanId;
        this.goalName = goalname;
        this.goalDescribe = description;
        this.endTime = endTime1;
    }

    public int getGoalPlanId() {
        return goalPlanId;
    }

    public void setGoalPlanId(int goalPlanId) {
        this.goalPlanId = goalPlanId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalDescribe() {
        return goalDescribe;
    }

    public void setGoalDescribe(String goalDescribe) {
        this.goalDescribe = goalDescribe;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
}
