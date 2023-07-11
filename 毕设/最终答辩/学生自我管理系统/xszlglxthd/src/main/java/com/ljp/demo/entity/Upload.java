package com.ljp.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Upload)实体类
 *
 * @author makejava
 * @since 2023-04-19 20:55:39
 */
@TableName("upload")
public class Upload {
    /**
     * 上传ID
     */
    @TableField(value = "upload_id")
    private Integer uploadId;
    /**
     * 文件名
     */
    private String name;
    /**
     * 自习室ID
     */
    private Integer id;
    /**
     * 上传者
     */
    private String username;
    //唯一编码
    private String code;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 文件大小
     */
    private Long docSize;
    /**
     * 下载次数
     */
    private Integer downloadNum;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Upload(Integer uploadId, String name, Integer id, String username,String code, String type, Long docSize, Integer downloadNum) {
        this.uploadId = uploadId;
        this.name = name;
        this.code = code;
        this.id = id;
        this.username = username;
        this.type = type;
        this.docSize = docSize;
        this.downloadNum = downloadNum;
    }

    public Upload(String name, String code, Integer downloadNum) {
        this.name = name;
        this.code = code;
        this.downloadNum = downloadNum;
    }

    public Upload() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUploadId() {
        return uploadId;
    }

    public void setUploadId(Integer uploadId) {
        this.uploadId = uploadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDocSize() {
        return docSize;
    }

    public void setDocSize(Long docSize) {
        this.docSize = docSize;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
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

