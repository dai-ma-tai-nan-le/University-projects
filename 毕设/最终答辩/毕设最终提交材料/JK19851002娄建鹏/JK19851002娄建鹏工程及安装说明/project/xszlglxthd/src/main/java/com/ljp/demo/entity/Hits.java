package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Hits)实体类
 *
 * @author makejava
 * @since 2023-04-11 21:25:53
 */
@TableName("hits")
public class Hits{
    /**
     * 点赞ID：
     */
    @TableField(value = "hits_id")
    private Integer hitsId;
    /**
     * 交流id/评论id/问题id
     */
    private Integer id;
    /**
     * id类型
     */
    private String type;
    /**
     * 点赞用户名
     */
    private String username;
    /**
     * 是否点赞
     */
    private Integer likes;
    /**
     * 创建时间：
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Hits(Integer hitsId, Integer id, String type, String username, Integer likes) {
        this.hitsId = hitsId;
        this.id = id;
        this.type = type;
        this.username = username;
        this.likes = likes;
    }

    public Hits() {
    }

    public Hits(Integer id, String type, String username, Integer likes) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.likes = likes;
    }

    public Integer getHitsId() {
        return hitsId;
    }

    public void setHitsId(Integer hitsId) {
        this.hitsId = hitsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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

}

