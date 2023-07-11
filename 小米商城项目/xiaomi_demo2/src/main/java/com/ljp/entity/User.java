package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private static  final long serialVersionUID = 1L;
    private int uid;
    private String uname;  //对应的是数据库的uname字段
    private String upassword; //密码
    private String usex; //性别
    private String ustatus; //用户的激活状态 0 未激活 1 激活
    private String code;
    private String uemail; //对应的是数据库的uemail字段
    private int urole; //用户 0 管理员 1

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User(int uid, String uname, String upassword, String usex, String ustatus, String code, String uemail, int urole) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.usex = usex;
        this.ustatus = ustatus;
        this.code = code;
        this.uemail = uemail;
        this.urole = urole;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getUrole() {
        return urole;
    }

    public void setUrole(int urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", usex='" + usex + '\'' +
                ", ustatus='" + ustatus + '\'' +
                ", code='" + code + '\'' +
                ", email='" + uemail + '\'' +
                ", urole=" + urole +
                '}';
    }
}

