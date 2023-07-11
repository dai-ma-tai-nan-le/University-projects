package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Time {
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
    @TableField(value = "goal_plan_id")
    private int goalPlanId;
    @TableField(value = "goal_name")
    private String goalName;
    @TableField(value = "goal_describe")
    private String goalDescribe;
    @TableField(value = "end_time")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;

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

    public int getGoalPlanId() {
        return goalPlanId;
    }

    public void setGoalPlanId(int goalPlanId) {
        this.goalPlanId = goalPlanId;
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
}
