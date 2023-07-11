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
 *放松天地：(RelaxTheWorld)表实体类
 *
 */
@TableName("`relax_the_world`")
@Data
@EqualsAndHashCode(callSuper = false)
public class RelaxTheWorld implements Serializable {

    //RelaxTheWorld编号
    @TableId(value = "relax_the_world_id", type = IdType.AUTO)
    private Integer relax_the_world_id;
    // 标题
    @TableField(value = "`title`")
    private String title;
    // 类型
    @TableField(value = "`type`")
    private String type;
    // 教师编号
    @TableField(value = "`teacher_number`")
    private Integer teacher_number;
    // 发布时间
    @TableField(value = "`release_time`")
    private Timestamp release_time;
    // 内容
    @TableField(value = "`content`")
    private String content;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
