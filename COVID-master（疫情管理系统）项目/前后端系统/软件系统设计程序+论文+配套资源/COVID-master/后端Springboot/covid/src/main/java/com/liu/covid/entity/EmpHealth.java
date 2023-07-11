package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liu.covid.entity.Enum.GenderEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName("emp_health")
public class EmpHealth {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private GenderEnum sex;
    private Long phonenum;
    private float temp;
    private String risk;
    private String health;
    private String content;
    private String depart;
    @TableField(value = "createTime" ,fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
}
