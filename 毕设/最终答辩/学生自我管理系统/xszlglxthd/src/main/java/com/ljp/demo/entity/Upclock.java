package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.Map;

/**
 * 打卡(Upclock)实体类
 *
 * @author makejava
 * @since 2023-03-25 16:38:10
 */
@TableName("upclock")
public class Upclock{
    /**
     * 打卡ID
     */
    @TableField(value = "clock_id")
    private Integer clockId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 起床打卡时间
     */
    @TableField(value = "up_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date upTime;

    public Upclock() {
    }

    public Upclock(Integer clockId, String username, Date upTime) {
        this.clockId = clockId;
        this.username = username;
        this.upTime = upTime;
    }

    public Upclock(int i, String username, Map<String, String> data) {
    }


    public Integer getClockId() {
        return clockId;
    }

    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

}

