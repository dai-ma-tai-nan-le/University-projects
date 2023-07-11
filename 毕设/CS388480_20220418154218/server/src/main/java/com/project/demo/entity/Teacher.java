package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *教师：(Teacher)表实体类
 *
 */
@TableName("`teacher`")
@Data
@EqualsAndHashCode(callSuper = false)
public class Teacher implements Serializable {

    //Teacher编号
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacher_id;
    // 教师编号
    @TableField(value = "`teacher_number`")
    private String teacher_number;
    // 教师姓名
    @TableField(value = "`teacher_name`")
    private String teacher_name;
    // 性别
    @TableField(value = "`gender`")
    private String gender;
    // 所教课程
    @TableField(value = "`courses_taught`")
    private String courses_taught;
    // 班级名称
    @TableField(value = "`class_name`")
    private String class_name;
    // 用户编号
    @TableField(value = "user_id")
    private Integer userId;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
