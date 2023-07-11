package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liu.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "material_manage")//实现实体类型和数据库中的表实现映射
public class MaterialManage {


    @TableId(type = IdType.AUTO)//数据库自增ID
    private Long id;
    private String name;
    private int count;
    private String type;
    @TableField(value = "isImp")  //数据库字段名，实现自动填充
    private ImpEnum isImp;
    private String charge;
    private Long cnum;
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)   //数据库字段名，实现自动填充
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
//为了便于date类型字段的序列化和反序列化，需要在数据结构的Date、Timestamp、DateTime类型的字段上用JsonFormat注解进行注解
//1.pattern 指定转化的格式SSSZ(S指的是微秒，Z指时区)，此处的pattern和java.text.SimpleDateFormat中的Time Patterns一致
//2.locale主要指语言，如果中文的话，月份输出是五月，但是英文就是May，尤其是在反序列化的时候特别重要
//3.timezone主要解决“8小时”问题
