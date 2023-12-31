package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private static  final long serialVersionUID = 1L;
    private int pid;
    private String pname;
    private Date  ptime; //商品的上架时间！ 数据库date --> java.util.Date
    private String pimage; //商品的图片名称
    private int pstate; //商品的热门指数
    private String pinfo; //商品的描述
    private BigDecimal pprice; //价格
    private int tid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public int getPstate() {
        return pstate;
    }

    public void setPstate(int pstate) {
        this.pstate = pstate;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", ptime=" + ptime +
                ", pimage='" + pimage + '\'' +
                ", pstate=" + pstate +
                ", pinfo='" + pinfo + '\'' +
                ", pprice=" + pprice +
                ", tid=" + tid +
                '}';
    }
}
