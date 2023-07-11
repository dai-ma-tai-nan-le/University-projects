package com.ljp.defenceitems.entity.constellation;

import java.util.Date;

public class constellation_month {
    private String name;
    private String date;
    private String all;
    private String happyMagic;
    private String health;
    private String love;
    private String money;
    private int month;
    private String resultcode;
    private String work;
    private int error_code;

    @Override
    public String toString() {
        return "星座名称：" + name + '\n' +
                "日期：" + date +'\n'+
                "综合运势：" + all + '\n' +
                "快乐魔法：" + happyMagic + '\n' +
                "健康运势：" + health + '\n' +
                "爱情运势：" + love + '\n' +
                "财运运势：" + money + '\n' +
                "月份：" + month + '\n' +
                "工作运势：" + work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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
