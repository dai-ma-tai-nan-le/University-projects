package com.ljp.demo.dao;

import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface DataViewDao {

    //查看每日的专注时长
    @Select("select * from experience where username=#{username} and create_time like CONCAT('%',#{date},'%')")
    List<Experience> selectList(@Param("username")String username, @Param("date") String date);
    //不重复的
    @Select("select distinct plan_name from experience where username=#{username} and create_time like CONCAT('%',#{date},'%')")
    List<Experience> selectList1(@Param("username")String username, @Param("date") String date);
    //查看每周/月/年的专注时长
    @Select("select * from experience where username=#{username} and create_time>=#{date3} and create_time<#{date4}")
    List<Experience> selectList2(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);
    //不重复的
    @Select("select distinct plan_name from experience where username=#{username} and create_time>=#{date3} and create_time<#{date4}")
    List<Experience> selectList3(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);
    //查看早起/早睡的专注时长
    @Select("select * from upclock where username=#{username} and up_time>=#{date3} and up_time<#{date4}")
    List<Upclock> selectList4(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);
    @Select("select * from sleepclock where username=#{username} and sleep_time>=#{date3} and sleep_time<#{date4}")
    List<Sleepclock> selectList5(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);

}
