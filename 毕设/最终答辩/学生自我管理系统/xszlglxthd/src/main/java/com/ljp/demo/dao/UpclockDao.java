package com.ljp.demo.dao;

import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 打卡(Upclock)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-25 16:38:10
 */
@Mapper
public interface UpclockDao {

    //插入打卡
    @Insert("insert into upclock values(null,#{username},#{upTime})")
    void insertclock(Upclock upclock);
    //查询打卡
    @Select("select * from upclock where username=#{username}")
    List<Upclock> selectname(@Param("username") String username);
}

