package com.ljp.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Study_plan;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 目标计划(GoalPlan)表服务接口
 *
 * @author makejava
 * @since 2023-03-24 19:47:54
 */
public interface GoalPlanService {

    ////查询未来目标列表
    List<Goal_plan> selectList(@Param("username")String username);
    //修改计划
    void modplan(Goal_plan study_plan);
    //添加计划
    void addplan(Goal_plan study_plan);
    //查重名
    List<Goal_plan> selectplanlist(@Param("goalname") String goalname,@Param("username") String username);
    //删除计划
    void delplan(@Param("goalPlanId")int goalPlanId);

    //分页查询计划的
    IPage<Goal_plan> findByAllPage(Page<Goal_plan> page);
    //分页模糊查询用户名计划人数的
    List<Goal_plan> selectList3(Page<Goal_plan> page, @Param("username") String username);
    //分页模糊查询计划的
    List<Goal_plan> selectList1(Page<Goal_plan> page, @Param("goalName") String goalName);
    //分页模糊查询教师姓名的
    List<Goal_plan> selectList2(Page<Goal_plan> page, @Param("username") String username, @Param("goalName") String goalName);
    //查询长度
    Long selectnum2(@Param("username") String username, @Param("goalName") String goalName);
    Long selectnum1(@Param("goalName") String goalName);
    Long selectnum3(@Param("username") String username);



    //分页查询计划的
    IPage<Goal_plan> findByAllPage1(Page<Goal_plan> page, @Param("academy") String academy);
    //分页模糊查询用户名计划人数的
    List<Goal_plan> selectList5(Page<Goal_plan> page, @Param("username") String username, @Param("academy") String academy);
    //分页模糊查询计划的
    List<Goal_plan> selectList6(Page<Goal_plan> page, @Param("goalName") String goalName, @Param("academy") String academy);
    //分页模糊查询教师姓名的
    List<Goal_plan> selectList4(Page<Goal_plan> page, @Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy);
    //查询长度
    Long selectnum4(@Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy);
    Long selectnum6(@Param("goalName") String goalName, @Param("academy") String academy);
    Long selectnum5(@Param("username") String username, @Param("academy") String academy);
}
