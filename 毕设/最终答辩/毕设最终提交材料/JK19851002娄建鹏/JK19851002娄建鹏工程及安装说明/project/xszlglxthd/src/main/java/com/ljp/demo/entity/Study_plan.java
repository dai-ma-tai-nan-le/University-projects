package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("study_plan")
public class Study_plan {

    @TableField(value = "study_plan_id")
    private int studyPlanId;
    @TableField(value = "plan_name")
    private String planName;
    @TableField(value = "time_trend")
    private String timeTrend;
    @TableField(value = "plan_time")
    private int planTime;
    @TableField(value = "today_num")
    private int todayNum;
    @TableField(value = "total_num")
    private int totalNum;
    @TableField(value = "today_time")
    private int todayTime;
    @TableField(value = "total_time")
    private int totalTime;
    private String username;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    private int tx=0;

    public Study_plan() {
    }

    public Study_plan(int studyPlanId, String planName, String timeTrend, int planTime) {
        this.planName = planName;
        this.timeTrend = timeTrend;
        this.planTime = planTime;
        this.studyPlanId = studyPlanId;
    }

    public Study_plan(String planName, String timeTrend, int planTime, String username) {
        this.planName = planName;
        this.timeTrend = timeTrend;
        this.planTime = planTime;
        this.username=username;
    }

    public Study_plan(int studyPlanId, int todayNum, int totalNum, int todayTime, int totalTime) {
        this.studyPlanId = studyPlanId;
        this.todayNum = todayNum;
        this.totalNum = totalNum;
        this.todayTime = todayTime;
        this.totalTime = totalTime;
    }

    public int getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(int studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTimeTrend() {
        return timeTrend;
    }

    public void setTimeTrend(String timeTrend) {
        this.timeTrend = timeTrend;
    }

    public int getPlanTime() {
        return planTime;
    }

    public void setPlanTime(int planTime) {
        this.planTime = planTime;
    }

    public int getTodayNum() {
        return todayNum;
    }

    public void setTodayNum(int todayNum) {
        this.todayNum = todayNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTodayTime() {
        return todayTime;
    }

    public void setTodayTime(int todayTime) {
        this.todayTime = todayTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

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

