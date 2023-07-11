package com.ljp.demo.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.Time;
import com.ljp.demo.entity.Upload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学习计划(StudyPlan)表服务接口
 *
 * @author makejava
 * @since 2023-03-23 15:25:21
 */
public interface StudyPlanService {

    //查询学习计划列表
    List<Study_plan> selectList(@Param("username") String username);
    //修改计划
    void modplan(Study_plan study_plan);
    //添加计划
    void addplan(Study_plan study_plan);
    //查重名
    List<Study_plan> selectplanlist(@Param("planName") String planName,@Param("username") String username);
    //删除计划
    void delplan(@Param("studyPlanId")int studyPlanId);



    //分页查询计划的
    IPage<Study_plan> findByAllPage(Page<Study_plan> page);
    //分页模糊查询用户名计划人数的
    List<Study_plan> selectList3(Page<Study_plan> page, @Param("username") String username);
    //分页模糊查询计划的
    List<Study_plan> selectList1(Page<Study_plan> page, @Param("planName") String planName);
    //分页模糊查询教师姓名的
    List<Study_plan> selectList2(Page<Study_plan> page, @Param("username") String username, @Param("planName") String planName);
    //查询长度
    Long selectnum2(@Param("username") String username, @Param("planName") String planName);
    Long selectnum1(@Param("planName") String planName);
    Long selectnum3(@Param("username") String username);



    //查询学习计划和未来目标
    List<Time> selectTime(@Param("studyPlanId")int studyPlanId);
    //查询计划
    List<Study_plan> queryplan(@Param("studyPlanId")int studyPlanId);
    //更新时长等等
    void updateplan(Study_plan study_plans);




    //分页查询计划的
    IPage<Study_plan> findByAllPage1(Page<Study_plan> page, @Param("academy") String academy);
    //分页模糊查询用户名计划人数的
    List<Study_plan> selectList5(Page<Study_plan> page, @Param("username") String username, @Param("academy") String academy);
    //分页模糊查询计划的
    List<Study_plan> selectList6(Page<Study_plan> page, @Param("planName") String planName, @Param("academy") String academy);
    //分页模糊查询教师姓名的
    List<Study_plan> selectList4(Page<Study_plan> page, @Param("username") String username, @Param("planName") String planName, @Param("academy") String academy);
    //查询长度
    Long selectnum4(@Param("username") String username, @Param("planName") String planName, @Param("academy") String academy);
    Long selectnum6(@Param("planName") String planName, @Param("academy") String academy);
    Long selectnum5(@Param("username") String username, @Param("academy") String academy);




    //查询音乐
    List<Upload> selectMusic(@Param("username")String username);
}
