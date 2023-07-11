package com.ljp.demo.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

@TableName("notice")
public class Notice{
    @TableField(value = "notice_id")
    private int noticeId;
    private String title;
    private String type;
    private String username;
    @TableField(value = "re_username")
    private String reusername;
    @TableField(value = "publish_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;
//    @Column(length = 2000)
    private String content;
    private int level;
    @TableField(value = "received_num")
    private int receivedNum;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Notice() {
    }

    public Notice(int noticeId, int receivedNum, String username) {
        this.noticeId = noticeId;
        this.username = username;
        this.receivedNum = receivedNum;
    }

    public Notice(int noticeId, int level) {
        this.noticeId = noticeId;
        this.level = level;
    }

    public Notice(int noticeId, String title, String type, String username, String reusername, Date publishTime, String content, int level, int receivedNum) {
        this.noticeId = noticeId;
        this.title = title;
        this.type = type;
        this.username = username;
        this.reusername = reusername;
        this.publishTime = publishTime;
        this.content = content;
        this.level = level;
        this.receivedNum = receivedNum;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getReceivedNum() {
        return receivedNum;
    }

    public void setReceivedNum(int receivedNum) {
        this.receivedNum = receivedNum;
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
    /**
     * 学生通知ID
     */
    @TableField(value = "xsnotice_id")
    private Integer xsnoticeId;
    /**
     * 是否确认收到
     */
    private Integer received;
    /**
     * 级别（置顶）
     */
    private Integer xslevel;

    public Integer getXslevel() {
        return xslevel;
    }

    public void setXslevel(Integer xslevel) {
        this.xslevel = xslevel;
    }

    public Integer getXsnoticeId() {
        return xsnoticeId;
    }

    public void setXsnoticeId(Integer xsnoticeId) {
        this.xsnoticeId = xsnoticeId;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }
}
