package com.liu.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    //serialVersionUID来验证的版本一致的
    private static final long serialVersionUID = -40356785423868312L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String depart;

}
