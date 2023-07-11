package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 解惑(Communication)实体类
 *
 * @author makejava
 * @since 2023-04-09 14:33:46
 */
@TableName("communication")
public class Communication{
    /**
     * 解惑ID
     */
    @TableField(value = "communication_id")
    private Integer communicationId;
    /**
     * 计划名称
     */
    @TableField(value = "plan_name")
    private String planName;
    /**
     * 分享用户名
     */
    private String username;
    /**
     * 被分享的人
     */
    @TableField(value = "re_username")
    private String reusername;
    /**
     * 心得内容
     */
    private String content;
    /**
     * 创建时间：
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    //点赞列表
    List<Hits> hits;
//    是否点赞
    private Integer likes;
    //添加评论按钮
    private Integer pl=0;
    List<Comment> commentList;
    private Integer plts=0;

    public Communication(Integer communicationId, String planName, String username, String reusername, String content) {
        this.communicationId = communicationId;
        this.planName = planName;
        this.username = username;
        this.reusername = reusername;
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Integer getPlts() {
        return plts;
    }

    public void setPlts(Integer plts) {
        this.plts = plts;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getPl() {
        return pl;
    }

    public void setPl(Integer pl) {
        this.pl = pl;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }

    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReusername() {
        return reusername;
    }

    public void setReusername(String reusername) {
        this.reusername = reusername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}

