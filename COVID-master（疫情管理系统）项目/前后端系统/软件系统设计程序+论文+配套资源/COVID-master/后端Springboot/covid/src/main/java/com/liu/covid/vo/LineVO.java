package com.liu.covid.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//VO层的存在就是方便前端获取数据，后端将前端的需要的数据做一个整合，打包成一个类。在service中，做一个替换，然后通过controller层返给前端。
@Data//注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
public class LineVO {
    private List<String> month;
    private Map<String,List> status;
}
