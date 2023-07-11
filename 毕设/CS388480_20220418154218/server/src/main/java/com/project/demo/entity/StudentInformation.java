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
 *学生信息：(StudentInformation)表实体类
 *
 */
@TableName("`student_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentInformation implements Serializable {

    //StudentInformation编号
    @TableId(value = "student_information_id", type = IdType.AUTO)
    private Integer student_information_id;
    // 班级号
    @TableField(value = "`class_number`")
    private String class_number;
    // 学号
    @TableField(value = "`student_number`")
    private String student_number;
    // 学生姓名
    @TableField(value = "`student_name`")
    private String student_name;
    // 电话
    @TableField(value = "`telephone`")
    private String telephone;
    // 专业
    @TableField(value = "`major`")
    private String major;
    // 教师编号
    @TableField(value = "`teacher_number`")
    private Integer teacher_number;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
