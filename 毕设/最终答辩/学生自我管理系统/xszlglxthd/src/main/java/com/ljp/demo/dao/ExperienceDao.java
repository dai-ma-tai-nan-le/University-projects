package com.ljp.demo.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljp.demo.entity.Communication;
import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Goal_plan;
import com.ljp.demo.entity.Study_plan;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * 心得(Experience)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-28 12:53:28
 */
@Mapper
public interface ExperienceDao {

    //添加心得
    @Insert("insert into experience values(null,#{username},#{planName},#{startTime},#{endTime},#{content},#{createTime},#{updateTime})")
    void addxd(Experience experience);


    ////查询心得列表
    @Select("select * from experience where username=#{username} and create_time>=#{value1} and create_time<#{value2}")
    List<Experience> selectList(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2);
    //修改心得
    @Update("update experience set content=#{content} where experience_id=#{experienceId}")
    void modxd(Experience experience);
    //删除心得
    @Delete("delete from experience where experience_id=#{experienceId}")
    void delxd(@Param("experienceId")int experienceId);



    ////分页查询教师人数的
    @Select("select * from experience as u,student as t where u.username=t.username and u.create_time>=#{date} and u.create_time<#{date2} order by experience_id desc")
    IPage<Experience> findByAllPage(Page<Experience> page,@Param("date") Date date,@Param("date2") Date date2);
    ////分页模糊查询教师人数的
    @Select("select * from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and u.create_time>=#{date} and u.create_time<#{date2} and u.username=t.username")
    List<Experience> selectList3(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2);
    ////分页模糊查询教师姓名的
    @Select("select * from experience as u,student as t where u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    List<Experience> selectList1(Page<Experience> page, @Param("value1") Date value1,@Param("value2") Date value2);
    ////分页模糊查询教师姓名的
    @Select("select * from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    List<Experience> selectList2(Page<Experience> page,@Param("username") String username,  @Param("value1") Date value1,@Param("value2") Date value2);
    //查询长度
    @Select("select count(*) from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and u.create_time>=#{date} and u.create_time<#{date2} and u.username=t.username")
    Long selectnum3(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2);
    @Select("select count(*) from experience as u,student as t where u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    Long selectnum1( @Param("value1") Date value1,@Param("value2") Date value2);
    @Select("select count(*) from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    Long selectnum2(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2);


    //分享心得
    @Insert("insert into communication values(null,#{planName},#{username},#{reusername},#{content},#{createTime},#{updateTime})")
    void fxxd(Communication communication);



    ////分页查询教师人数的
    @Select("select * from experience as u,student as t where u.username=t.username and academy=#{academy} and u.create_time>=#{date} and u.create_time<#{date2} order by experience_id desc")
    IPage<Experience> findByAllPage1(Page<Experience> page,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);
    ////分页模糊查询教师人数的
    @Select("select * from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.create_time>=#{date} and u.create_time<#{date2} and u.username=t.username")
    List<Experience> selectList5(Page<Experience> page, @Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from experience as u,student as t where u.create_time>=#{value1} and academy=#{academy} and u.create_time<#{value2} and u.username=t.username")
    List<Experience> selectList6(Page<Experience> page, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    ////分页模糊查询教师姓名的
    @Select("select * from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    List<Experience> selectList4(Page<Experience> page,@Param("username") String username,  @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    //查询长度
    @Select("select count(*) from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.create_time>=#{date} and u.create_time<#{date2} and u.username=t.username")
    Long selectnum5(@Param("username") String username,@Param("date") Date date,@Param("date2") Date date2, @Param("academy") String academy);
    @Select("select count(*) from experience as u,student as t where u.create_time>=#{value1} and u.create_time<#{value2} and academy=#{academy} and u.username=t.username")
    Long selectnum6( @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);
    @Select("select count(*) from experience as u,student as t where u.username like CONCAT('%',#{username},'%') and academy=#{academy} and u.create_time>=#{value1} and u.create_time<#{value2} and u.username=t.username")
    Long selectnum4(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("academy") String academy);




    //    查看指定心得
    @Select("select * from experience where username=#{username} and create_time>=#{value1} and create_time<#{value2} and plan_name=#{planName}")
    List<Experience> selectListPname(@Param("username") String username, @Param("value1") Date value1,@Param("value2") Date value2, @Param("planName")String planName);
}

