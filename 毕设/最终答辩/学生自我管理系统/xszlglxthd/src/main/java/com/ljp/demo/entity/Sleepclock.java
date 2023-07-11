package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 打卡(Sleepclock)实体类
 *
 * @author makejava
 * @since 2023-03-25 16:37:08
 */
@TableName("sleepclock")
public class Sleepclock{
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
     * 睡眠打卡时间
     */
    @TableField(value = "sleep_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sleepTime;

    public Sleepclock() {
    }

    public Sleepclock(Integer clockId, String username, Date sleepTime) {
        this.clockId = clockId;
        this.username = username;
        this.sleepTime = sleepTime;
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

    public Date getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Date sleepTime) {
        this.sleepTime = sleepTime;
    }

}

