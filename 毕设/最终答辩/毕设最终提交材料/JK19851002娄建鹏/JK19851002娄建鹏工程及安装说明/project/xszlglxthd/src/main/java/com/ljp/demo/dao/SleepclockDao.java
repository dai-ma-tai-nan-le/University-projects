package com.ljp.demo.dao;

import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 打卡(Sleepclock)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-25 16:37:08
 */
@Mapper
public interface SleepclockDao {

    //插入打卡
    @Insert("insert into sleepclock values(null,#{username},#{sleepTime})")
    void insertclock(Sleepclock upclock);
    //查询打卡
    @Select("select * from sleepclock where username=#{username}")
    List<Sleepclock> selectname(@Param("username") String username);

}

