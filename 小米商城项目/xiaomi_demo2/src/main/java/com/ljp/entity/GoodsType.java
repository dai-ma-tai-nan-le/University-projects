package com.ljp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType {
    private static  final long serialVersionUID = 1L;
    private int  tid;          // '类别的主键id',
    private String tname;    // '类别的名称',
    private String tinfo;   //'类别的描述',
}
