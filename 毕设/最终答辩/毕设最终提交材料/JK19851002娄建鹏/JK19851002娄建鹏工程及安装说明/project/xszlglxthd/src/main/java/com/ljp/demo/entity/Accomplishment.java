package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 成就(Accomplishment)实体类
 *
 * @author makejava
 * @since 2023-04-26 16:53:09
 */
@TableName("accomplishment")
public class Accomplishment{
    /**
     * 成就ID
     */
    @TableField(value = "accomplishment_id")
    private Integer accomplishmentId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 成就名称
     */
    private String name;
    /**
     * 成就简介
     */
    private String condition;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    //图标数
    private String cj;

    public String getCj() {
        return cj;
    }

    public void setCj(String cj) {
        this.cj = cj;
    }

    public Accomplishment(Integer accomplishmentId, String username, String name, String condition) {
        this.accomplishmentId = accomplishmentId;
        this.username = username;
        this.name = name;
        this.condition = condition;
    }

    public Integer getAccomplishmentId() {
        return accomplishmentId;
    }

    public void setAccomplishmentId(Integer accomplishmentId) {
        this.accomplishmentId = accomplishmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

