package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("user")
public class User{
    /**
     * 用户ID：[0,8388607]用户获取其他与用户相关的数据
     */
    @TableField(value = "user_id")
    private Integer userId;
    /**
     * 所在用户组：[0,32767]决定用户身份和权限
     */
    @TableField(value = "user_group")
    private String userGroup;
    /**
     * 登录时间：
     */
    @TableField(value = "login_time",fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date loginTime;
    /**
     * 手机号码：[0,11]用户的手机号码，用于找回密码时或登录时
     */
    private String phone;
    /**
     * 用户名：[0,16]用户登录时所用的账户名称
     */
    private String username;
    /**
     * 密码：[0,32]用户登录所需的密码，由6-16位数字或英文组成
     */
    private String password;
    //账号状态
    private String status;
    /**
     * 邮箱：[0,64]用户的邮箱，用于找回密码时或登录时
     */
    private String email;
    /**
     * 头像地址：[0,255]
     */
    private String avatar;
    /**
     * 创建时间：
     */
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public User() {
    }

    //修改密码
    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
    //修改头像
    public User(String userGroup, String username,String avatar) {
        this.userGroup=userGroup;
        this.username=username;
        this.avatar=avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //老师插入
    public User(int userId, String userGroup, String username, String password,String status) {
        this.userId=userId;
        this.userGroup=userGroup;
        this.username=username;
        this.password=password;
        this.status=status;
    }
    //管理员修改
    public User(int userId, String userGroup, String phone, String username, String status, String email) {
        this.userId=userId;
        this.userGroup=userGroup;
        this.phone=phone;
        this.username=username;
        this.status=status;
        this.email=email;
    }
    //总构造
    public User(int userId, String userGroup, Date loginTime, String phone, String username, String password,String status, String email, String s, Date createTime) {
        this.userId=userId;
        this.userGroup=userGroup;
        this.loginTime=loginTime;
        this.phone=phone;
        this.username=username;
        this.password=password;
        this.status=status;
        this.email=email;
        this.avatar=s;
        this.createTime=createTime;
    }
    //管理员插入
    public User(int userId, String userGroup, String phone, String username, String password,String status, String email, String s) {
        this.userId=userId;
        this.userGroup=userGroup;
        this.phone=phone;
        this.username=username;
        this.password=password;
        this.status=status;
        this.email=email;
        this.avatar=s;
    }


//    注册
    public User(int userId, String userGroup, String username, String password, String status, String email,String avatar) {
        this.userId=userId;
        this.userGroup=userGroup;
        this.username=username;
        this.password=password;
        this.status=status;
        this.email=email;
        this.avatar=avatar;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userGroup='" + userGroup + '\'' +
                ", loginTime=" + loginTime +
                ", phone=" + phone +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
