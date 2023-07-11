package com.liu.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.covid.entity.Department;
import org.springframework.stereotype.Repository;

@Repository  //不只是将类识别为Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
            // 告诉Spring，让Spring创建一个名字叫类名Impl实例。
public interface DepartMapper extends BaseMapper<Department> {
}



//别名： dao层
//用途： 对数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的，主要实现一些增删改查操作，在mybatis中方法主要与与xxx.xml内相互一一映射。