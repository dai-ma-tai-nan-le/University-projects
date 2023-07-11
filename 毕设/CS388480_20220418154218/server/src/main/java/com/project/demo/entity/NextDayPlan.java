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
 *次日计划：(NextDayPlan)表实体类
 *
 */
@TableName("`next_day_plan`")
@Data
@EqualsAndHashCode(callSuper = false)
public class NextDayPlan implements Serializable {

    //NextDayPlan编号
    @TableId(value = "next_day_plan_id", type = IdType.AUTO)
    private Integer next_day_plan_id;
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
    // 次日任务
    @TableField(value = "`next_day_task`")
    private String next_day_task;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
