package com.ljp.entity;

import com.alipay.api.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderDetail {
    private static  final long serialVersionUID = 1L;
    private int iid;
    private String oid;
    private int pid;
    private Goods product;
    private BigDecimal icount;
    private int inum;

    public OrderDetail(int iid, String oid, int pid,  BigDecimal icount,int inum) {
        this.iid = iid;
        this.oid = oid;
        this.pid = pid;
        this.icount = icount;
        this.inum = inum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "iid=" + iid +
                ", oid='" + oid + '\'' +
                ", pid=" + pid +
                ", product=" + product +
                ", icount=" + icount +
                ", inum=" + inum +
                '}';
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Goods getProduct() {
        return product;
    }

    public void setProduct(Goods product) {
        this.product = product;
    }

    public BigDecimal getIcount() {
        return icount;
    }

    public void setIcount(BigDecimal icount) {
        this.icount = icount;
    }

    public int getInum() {
        return inum;
    }

    public void setInum(int inum) {
        this.inum = inum;
    }
}
