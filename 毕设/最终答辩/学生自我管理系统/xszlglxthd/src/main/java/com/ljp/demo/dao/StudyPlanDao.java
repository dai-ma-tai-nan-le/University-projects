package com.ljp.demo.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Study_plan;
import com.ljp.demo.entity.Teacher;
import com.ljp.demo.entity.Time;
import com.ljp.demo.entity.Upload;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 学习计划(StudyPlan)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-23 15:25:21
 */
@Mapper
public interface StudyPlanDao {

    //查询学习计划列表
    @Select("select * from study_plan where username=#{username}")
    List<Study_plan> selectList( @Param("username")String username);
    //修改计划
    @Update("update study_plan set plan_name=#{planName},time_trend=#{timeTrend},plan_time=#{planTime} where study_plan_id=#{studyPlanId}")
    void modplan(Study_plan study_plan);
    //添加计划
    @Insert("insert into study_plan values(null,#{planName},#{timeTrend},#{planTime},#{todayNum},#{totalNum},#{todayTime},#{totalTime},#{username},#{createTime},#{updateTime})")
    void addplan(Study_plan study_plan);
    //查重名
    @Select("select * from study_plan where username=#{username} and plan_name=#{planName}")
    List<Study_plan> selectplanlist(@Param("planName") String planName,@Param("username") String username);
    //删除计划
    @Delete("delete from study_plan where study_plan_id=#{studyPlanId}")
    void delplan(@Param("studyPlanId")int studyPlanId);


    ////分页查询教师人数的
    @Select("select * from study_plan as u,student as t where u.username=t.username order by study_plan_id desc")
    IPage<Study_plan> findByAllPage(Page<Study_plan> page);
    ////分页模糊查询教师人数的
    @Select("select * from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    List<Study_plan> selectList3(Page<Study_plan> page, @Param("username") String username);
    ////分页模糊查询教师姓名的
    @Select("select * from study_plan as u,student as t where plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    List<Study_plan> selectList1(Page<Study_plan> page, @Param("planName") String planName);
    ////分页模糊查询教师姓名的
    @Select("select * from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    List<Study_plan> selectList2(Page<Study_plan> page,@Param("username") String username, @Param("planName") String planName);
    //查询长度
    @Select("select count(*) from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and u.username=t.username")
    Long selectnum3(@Param("username") String username);
    @Select("select count(*) from study_plan as u,student as t where plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    Long selectnum1(@Param("planName") String planName);
    @Select("select count(*) from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    Long selectnum2(@Param("username") String username, @Param("planName") String planName);


    //查询学习计划
    @Select("select * from study_plan where study_plan_id=#{studyPlanId}")
    List<Time> selectTime(@Param("studyPlanId")int studyPlanId);
    //查询计划
    @Select("select * from study_plan where study_plan_id=#{studyPlanId}")
    List<Study_plan> queryplan(@Param("studyPlanId")int studyPlanId);
    //更新时长等等
    @Update("update study_plan set today_num=#{todayNum},total_num=#{totalNum},today_time=#{todayTime},total_time=#{totalTime} where study_plan_id=#{studyPlanId}")
    void updateplan(Study_plan study_plans);





    ////分页查询教师人数的
    @Select("select * from study_plan as u,student as t where u.username=t.username and academy=#{academy} order by study_plan_id desc")
    IPage<Study_plan> findByAllPage1(Page<Study_plan> page, @Param("academy") String academy);
    ////分页模糊查询教师人数的
    @Select("select * from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.username=t.username")
    List<Study_plan> selectList5(Page<Study_plan> page, @Param("username") String username, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from study_plan as u,student as t where plan_name like CONCAT('%',#{planName},'%') and academy=#{academy} and u.username=t.username")
    List<Study_plan> selectList6(Page<Study_plan> page, @Param("planName") String planName, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    List<Study_plan> selectList4(Page<Study_plan> page,@Param("username") String username, @Param("planName") String planName, @Param("academy") String academy);
    //查询长度
    @Select("select count(*) from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.username=t.username")
    Long selectnum5(@Param("username") String username, @Param("academy") String academy);
    @Select("select count(*) from study_plan as u,student as t where plan_name like CONCAT('%',#{planName},'%') and academy=#{academy} and u.username=t.username")
    Long selectnum6(@Param("planName") String planName, @Param("academy") String academy);
    @Select("select count(*) from study_plan as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and plan_name like CONCAT('%',#{planName},'%') and u.username=t.username")
    Long selectnum4(@Param("username") String username, @Param("planName") String planName, @Param("academy") String academy);




    //查询音乐
    @Select("select * from upload where username=#{username} and id=-1")
    List<Upload> selectMusic(@Param("username")String username);
}

