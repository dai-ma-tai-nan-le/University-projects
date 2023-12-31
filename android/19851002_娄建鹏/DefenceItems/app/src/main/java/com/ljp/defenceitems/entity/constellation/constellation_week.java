package com.ljp.defenceitems.entity.constellation;

public class constellation_week {
    private String name;
    private String date;
    private int weekth;
    private String health;
    private String job;
    private String love;
    private String money;
    private String work;
    private String resultcode;
    private int error_code;

    @Override
    public String toString() {
        return "星座名称：" + name + '\n' +
                "日期：" + date + '\n' +
                "周指数：" + weekth +'\n' +
                "健康运势：" + health + '\n' +
                "工作运势：" + job + '\n' +
                "恋情运势：" + love + '\n' +
                "财运运势：" + money + '\n' +
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

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
