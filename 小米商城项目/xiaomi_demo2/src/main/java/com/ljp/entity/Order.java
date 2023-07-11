package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Order {
    private static  final long serialVersionUID = 1L;
    private String oid;
    private int uid;
    private int aid;
    private Address address;
    private BigDecimal ocount; //订单总金额
    private Date otime;
    private int ostate; //订单状态 0 未付款，1已经付款未发货 2发货待收货 3 收货待评价 4订单完成 5 退货状态
    private List<OrderDetail> items;

    public Order(String oid, int uid, int aid, BigDecimal ocount, Date otime, int ostate) {
        this.oid = oid;
        this.uid = uid;
        this.aid = aid;
        this.ocount = ocount;
        this.otime = otime;
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", uid=" + uid +
                ", aid=" + aid +
                ", address=" + address +
                ", ocount=" + ocount +
                ", otime=" + otime +
                ", ostate=" + ostate +
                ", items=" + items +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getOcount() {
        return ocount;
    }

    public void setOcount(BigDecimal ocount) {
        this.ocount = ocount;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public void setItems(List<OrderDetail> items) {
        this.items = items;
    }
}
