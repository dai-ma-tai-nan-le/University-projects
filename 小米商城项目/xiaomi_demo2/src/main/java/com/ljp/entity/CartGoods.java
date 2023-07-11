package com.ljp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CartGoods {
    private int cid;
    private int uid;
    private int pid;
    private BigDecimal ccount; //购物车小计
    private int cnum = 0;  //购车商品数量
    private String pname;
    private Date ptime; //商品的上架时间！ 数据库date --> java.util.Date
    private String pimage; //商品的图片名称
    private BigDecimal pprice; //价格
    private int pstate; //商品的热门指数
    private String pinfo; //商品的描述
    private int tid;

    public CartGoods(){}
    public CartGoods(int cid, int uid, int pid, BigDecimal ccount, int cnum, String pname, Date ptime, String pimage, BigDecimal pprice, int pstate, String pinfo, int tid) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.ccount = ccount;
        this.cnum = cnum;
        this.pname = pname;
        this.ptime = ptime;
        this.pimage = pimage;
        this.pprice = pprice;
        this.pstate = pstate;
        this.pinfo = pinfo;
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "CartGoods{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", ccount=" + ccount +
                ", cnum=" + cnum +
                ", pname='" + pname + '\'' +
                ", ptime=" + ptime +
                ", pimage='" + pimage + '\'' +
                ", pprice=" + pprice +
                ", pstate=" + pstate +
                ", pinfo='" + pinfo + '\'' +
                ", tid=" + tid +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public BigDecimal getCcount() {
        return ccount;
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
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
}
