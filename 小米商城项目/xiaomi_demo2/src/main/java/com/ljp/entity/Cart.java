package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Cart {
    private static final long serialVersionUID = 1L;
    private int cid;
    private int uid;
    private int pid;
    private int cnum = 0;  //购车商品数量
    private BigDecimal ccount; //购物车小计
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Cart(){}
    public Cart(int cid, int uid, int pid, BigDecimal ccount ,int cnum) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.ccount = ccount;
        this.cnum = cnum;
    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", cnum=" + cnum +
                ", ccount=" + ccount +
                ", goods=" + goods +
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
}
