package com.ljp.demo.entity;

//数据统计第一二个数据
public class DataView {

    private int totalNum;
    private int todayNum;
    private int todayTime;
    private int totalTime;
    private int dayTime;

    public DataView(int totalNum, int todayNum, int todayTime, int totalTime, int dayTime) {
        this.totalNum = totalNum;
        this.todayNum = todayNum;
        this.todayTime = todayTime;
        this.totalTime = totalTime;
        this.dayTime = dayTime;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTodayNum() {
        return todayNum;
    }

    public void setTodayNum(int todayNum) {
        this.todayNum = todayNum;
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

    public int getDayTime() {
        return dayTime;
    }

    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }
}
