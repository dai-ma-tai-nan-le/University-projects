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
 *每周计划：(WeeklyPlan)表实体类
 *
 */
@TableName("`weekly_plan`")
@Data
@EqualsAndHashCode(callSuper = false)
public class WeeklyPlan implements Serializable {

    //WeeklyPlan编号
    @TableId(value = "weekly_plan_id", type = IdType.AUTO)
    private Integer weekly_plan_id;
    // 学生用户
    @TableField(value = "`student_user`")
    private Integer student_user;
    // 学号
    @TableField(value = "`student_number`")
    private String student_number;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
    // 周号
    @TableField(value = "`zhou_hao`")
    private String zhou_hao;
    // 班级名称
    @TableField(value = "`class_name`")
    private String class_name;
    // 开始时间
    @TableField(value = "`start_time`")
    private Timestamp start_time;
    // 结束时间
    @TableField(value = "`end_time`")
    private Timestamp end_time;
    // 完成情况
    @TableField(value = "`completion`")
    private String completion;
    // 自我打分
    @TableField(value = "`self_scoring`")
    private String self_scoring;
    // 教师编号
    @TableField(value = "`teacher_number`")
    private Integer teacher_number;
    // 本周任务
    @TableField(value = "`tasks_this_week`")
    private String tasks_this_week;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
