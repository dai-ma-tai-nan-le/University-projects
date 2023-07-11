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
 *每日计划：(DailyPlan)表实体类
 *
 */
@TableName("`daily_plan`")
@Data
@EqualsAndHashCode(callSuper = false)
public class DailyPlan implements Serializable {

    //DailyPlan编号
    @TableId(value = "daily_plan_id", type = IdType.AUTO)
    private Integer daily_plan_id;
    // 学生用户
    @TableField(value = "`student_user`")
    private Integer student_user;
    // 学号
    @TableField(value = "`student_number`")
    private String student_number;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
    // 日期
    @TableField(value = "`date`")
    private Timestamp date;
    // 班级名称
    @TableField(value = "`class_name`")
    private String class_name;
    // 完成情况
    @TableField(value = "`completion`")
    private String completion;
    // 自我打分
    @TableField(value = "`self_scoring`")
    private String self_scoring;
    // 教师编号
    @TableField(value = "`teacher_number`")
    private Integer teacher_number;
    // 今日任务
    @TableField(value = "`mission_today`")
    private String mission_today;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
