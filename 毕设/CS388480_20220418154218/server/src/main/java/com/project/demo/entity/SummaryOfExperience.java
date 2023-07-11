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
 *心得总结：(SummaryOfExperience)表实体类
 *
 */
@TableName("`summary_of_experience`")
@Data
@EqualsAndHashCode(callSuper = false)
public class SummaryOfExperience implements Serializable {

    //SummaryOfExperience编号
    @TableId(value = "summary_of_experience_id", type = IdType.AUTO)
    private Integer summary_of_experience_id;
    // 学生用户
    @TableField(value = "`student_user`")
    private Integer student_user;
    // 学号
    @TableField(value = "`student_number`")
    private String student_number;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
    // 班级名称
    @TableField(value = "`class_name`")
    private String class_name;
    // 周号
    @TableField(value = "`zhou_hao`")
    private String zhou_hao;
    // 本周总结
    @TableField(value = "`summary_of_this_week`")
    private String summary_of_this_week;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
