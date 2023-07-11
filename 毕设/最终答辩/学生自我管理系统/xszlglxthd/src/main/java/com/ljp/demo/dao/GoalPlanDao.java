package com.ljp.demo.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Study_plan;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 目标计划(GoalPlan)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-24 19:47:54
 */
@Mapper
public interface GoalPlanDao {

    //查询学习计划列表
    @Select("select * from goal_plan where username=#{username}")
    List<Goal_plan> selectList(@Param("username")String username);
    //修改计划
    @Update("update goal_plan set goal_name=#{goalName},goal_describe=#{goalDescribe},end_time=#{endTime} where goal_plan_id=#{goalPlanId}")
    void modplan(Goal_plan study_plan);
    //添加计划
    @Insert("insert into goal_plan values(null,#{username},#{goalName},#{goalDescribe},#{endTime},#{createTime},#{updateTime})")
    void addplan(Goal_plan study_plan);
    //查重名
    @Select("select * from goal_plan where username=#{username} and goal_name=#{goalname}")
    List<Goal_plan> selectplanlist(@Param("goalname") String goalname,@Param("username") String username);
    //删除计划
    @Delete("delete from goal_plan where goal_plan_id=#{goalPlanId}")
    void delplan(@Param("goalPlanId")int goalPlanId);


    ////分页查询教师人数的
    @Select("select * from goal_plan as u,student as t where u.username=t.username order by goal_plan_id desc")
    IPage<Goal_plan> findByAllPage(Page<Goal_plan> page);
    ////分页模糊查询教师人数的
    @Select("select * from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    List<Goal_plan> selectList3(Page<Goal_plan> page, @Param("username") String username);
    ////分页模糊查询教师姓名的
    @Select("select * from goal_plan as u,student as t where goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    List<Goal_plan> selectList1(Page<Goal_plan> page, @Param("goalName") String goalName);
    ////分页模糊查询教师姓名的
    @Select("select * from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    List<Goal_plan> selectList2(Page<Goal_plan> page,@Param("username") String username, @Param("goalName") String goalName);
    //查询长度
    @Select("select count(*) from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    Long selectnum3(@Param("username") String username);
    @Select("select count(*) from goal_plan as u,student as t where goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    Long selectnum1(@Param("goalName") String goalName);
    @Select("select count(*) from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    Long selectnum2(@Param("username") String username, @Param("goalName") String goalName);



    ////分页查询教师人数的
    @Select("select * from goal_plan as u,student as t where u.username=t.username and academy=#{academy} order by goal_plan_id desc")
    IPage<Goal_plan> findByAllPage1(Page<Goal_plan> page, @Param("academy") String academy);
    ////分页模糊查询教师人数的
    @Select("select * from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and u.username=t.username and academy=#{academy}")
    List<Goal_plan> selectList5(Page<Goal_plan> page, @Param("username") String username, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from goal_plan as u,student as t where goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username and academy=#{academy}")
    List<Goal_plan> selectList6(Page<Goal_plan> page, @Param("goalName") String goalName, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    List<Goal_plan> selectList4(Page<Goal_plan> page,@Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy);
    //查询长度
    @Select("select count(*) from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.username=t.username")
    Long selectnum5(@Param("username") String username, @Param("academy") String academy);
    @Select("select count(*) from goal_plan as u,student as t where goal_name like CONCAT('%',#{goalName},'%') and academy=#{academy} and u.username=t.username")
    Long selectnum6(@Param("goalName") String goalName, @Param("academy") String academy);
    @Select("select count(*) from goal_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and goal_name like CONCAT('%',#{goalName},'%') and u.username=t.username")
    Long selectnum4(@Param("username") String username, @Param("goalName") String goalName, @Param("academy") String academy);
}

