package com.ljp.defenceitems.entity.constellation;

import java.util.List;

public class constellation_year {
    private String name;
    private String date;
    private int year;
    private String resultcode;
    private int error_code;
    private constellation_year_mima mima;
    private List<String> career;
    private List<String> love;
    private List<String> finance;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }
    public String getResultcode() {
        return resultcode;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public int getError_code() {
        return error_code;
    }

    public constellation_year_mima getMima() {
        return mima;
    }

    public void setMima(constellation_year_mima mima) {
        this.mima = mima;
    }

    public void setCareer(List<String> career) {
        this.career = career;
    }
    public List<String> getCareer() {
        return career;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }
    public List<String> getLove() {
        return love;
    }

    public void setFinance(List<String> finance) {
        this.finance = finance;
    }
    public List<String> getFinance() {
        return finance;
    }



    @Override
    public String toString() {
        return "星座名称：" + name + '\n' +
                "日期1：" + date + '\n' +
                "日期2：" + year + '\n' +
                "年度密码：" + mima.toString()+ '\n' +
                "事业运：" + career + '\n' +
                "感情运：" + love + '\n' +
                "财运：" + finance+'\n';
    }
}
