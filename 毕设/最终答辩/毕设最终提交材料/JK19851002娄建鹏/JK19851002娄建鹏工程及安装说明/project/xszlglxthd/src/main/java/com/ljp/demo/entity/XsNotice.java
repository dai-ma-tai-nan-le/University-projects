package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 通知(XsNotice)实体类
 *
 * @author makejava
 * @since 2023-04-07 17:26:12
 */
@TableName("notice")
public class XsNotice {
    /**
     * 学生通知ID
     */
    @TableField(value = "xsnotice_id")
    private Integer xsnoticeId;
    /**
     * 通知id
     */
    @TableField(value = "notice_id")
    private Integer noticeId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 级别（置顶）
     */
    private Integer xslevel;
    /**
     * 是否确认收到
     */
    private Integer received;

    public XsNotice(Integer noticeId, String username, Integer xslevel, Integer received) {
        this.noticeId = noticeId;
        this.username = username;
        this.xslevel = xslevel;
        this.received = received;
    }


    public XsNotice(Integer xsnoticeId, Integer noticeId, String username, Integer xslevel, Integer received) {
        this.xsnoticeId = xsnoticeId;
        this.noticeId = noticeId;
        this.username = username;
        this.xslevel = xslevel;
        this.received = received;
    }

    public Integer getXsnoticeId() {
        return xsnoticeId;
    }

    public void setXsnoticeId(Integer xsnoticeId) {
        this.xsnoticeId = xsnoticeId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getXslevel() {
        return xslevel;
    }

    public void setXslevel(Integer xslevel) {
        this.xslevel = xslevel;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

}

