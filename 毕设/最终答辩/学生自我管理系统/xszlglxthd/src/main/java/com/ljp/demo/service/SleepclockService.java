package com.ljp.demo.service;

import com.ljp.demo.entity.Sleepclock;
import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 打卡(Sleepclock)表服务接口
 *
 * @author makejava
 * @since 2023-03-25 16:37:09
 */
public interface SleepclockService {

    //插入打卡
    void insertclock(Sleepclock upclock);
    //查询打卡
    List<Sleepclock> selectname(@Param("username") String username);
}
