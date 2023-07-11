package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Address {
    private static final long serialVersionUID =1L;
    private int aid;
    private int uid;
    private String aname;
    private String aphone;
    private String adetail;
    private int astate;

    public Address(int aid, int uid, String aname, String aphone, String adetail, int astate) {
        this.aid = aid;
        this.uid = uid;
        this.aname = aname;
        this.aphone = aphone;
        this.adetail = adetail;
        this.astate = astate;
    }
}
