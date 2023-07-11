package com.ljp.demo.service;

import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DataViewService  {

    //查看每日的专注时长
    List<Experience> selectList(@Param("username")String username, @Param("date") String date);
    //不重复的
    List<Experience> selectList1(@Param("username")String username, @Param("date") String date);
    //查看每周/月/年的专注时长
    List<Experience> selectList2(@Param("username")String username, @Param("date3") Date date3,@Param("date4") Date date4);
    //不重复的
    List<Experience> selectList3(@Param("username")String username, @Param("date3") Date date3,@Param("date4") Date date4);
    //查看早起/早睡的专注时长
    List<Upclock> selectList4(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);
    List<Sleepclock> selectList5(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4);
}
