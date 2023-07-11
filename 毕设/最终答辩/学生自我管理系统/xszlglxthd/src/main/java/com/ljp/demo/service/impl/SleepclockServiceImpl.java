package com.ljp.demo.service.impl;

import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.dao.SleepclockDao;
import com.ljp.demo.entity.Upclock;
import com.ljp.demo.service.SleepclockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 打卡(Sleepclock)表服务实现类
 *
 * @author makejava
 * @since 2023-03-25 16:37:09
 */
@Service("sleepclockService")
public class SleepclockServiceImpl implements SleepclockService {
    @Resource
    private SleepclockDao sleepclockDao;

    //插入打卡
    @Override
    public void insertclock(Sleepclock upclock) {
        sleepclockDao.insertclock(upclock);
    }
    //查询打卡
    @Override
    public List<Sleepclock> selectname(@Param("username") String username) {
        return sleepclockDao.selectname(username);
    }
}
