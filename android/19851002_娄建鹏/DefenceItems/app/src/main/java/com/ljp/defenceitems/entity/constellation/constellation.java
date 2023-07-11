package com.ljp.defenceitems.entity.constellation;

import java.util.Date;

public class constellation {
    private String name;
    private String datetime;
    private Date date;
    private String all;
    private String color;
    private String health;
    private String love;
    private String money;
    private int number;
    private String QFriend;
    private String summary;
    private String work;
    private int error_code;

    //today，tomorrow的返回调用
    public String toString() {
            return "星座名称：" + name + '\n' +
                    "日期1：" + datetime + '\n' +
                    "日期2：" + date +'\n'+
                    "综合指数：" + all + '\n' +
                    "幸运色：" + color + '\n' +
                    "健康指数：" + health + '\n' +
                    "爱情指数：" + love + '\n' +
                    "财运指数：" + money + '\n' +
                    "幸运数字：" + number +'\n' +
                    "速配星座：" + QFriend + '\n' +
                    "今日概述：" + summary + '\n' +
                    "工作指数：" + work ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQFriend() {
        return QFriend;
    }

    public void setQFriend(String QFriend) {
        this.QFriend = QFriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    }
