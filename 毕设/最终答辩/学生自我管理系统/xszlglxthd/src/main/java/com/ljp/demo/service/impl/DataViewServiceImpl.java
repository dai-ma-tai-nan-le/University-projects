package com.ljp.demo.service.impl;

import com.ljp.demo.dao.DataViewDao;
import com.ljp.demo.entity.Experience;
import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import com.ljp.demo.service.DataViewService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("dataViewService")
public class DataViewServiceImpl implements DataViewService{
    @Resource
    private DataViewDao dataViewDao;

    //查看每日的专注时长
    @Override
    public List<Experience> selectList(@Param("username")String username, @Param("date") String date) {
        return dataViewDao.selectList(username,date);
    }
    //不重复的
    @Override
    public List<Experience> selectList1(@Param("username")String username, @Param("date") String date) {
        return dataViewDao.selectList1(username,date);
    }
    //查看每周/月/年的专注时长
    @Override
    public List<Experience> selectList2(@Param("username")String username, @Param("date3") Date date3,@Param("date4") Date date4) {
        return dataViewDao.selectList2(username,date3,date4);
    }
    //不重复的
    @Override
    public List<Experience> selectList3(@Param("username")String username, @Param("date3") Date date3,@Param("date4") Date date4) {
        return dataViewDao.selectList3(username,date3,date4);
    }
    //查看早起/早睡的专注时长
    @Override
    public List<Upclock> selectList4(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4) {
        return dataViewDao.selectList4(username,date3,date4);
    }
    @Override
    public List<Sleepclock> selectList5(@Param("username")String username, @Param("date3") Date date3, @Param("date4") Date date4) {
        return dataViewDao.selectList5(username,date3,date4);
    }

}
