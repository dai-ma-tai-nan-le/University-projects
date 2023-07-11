package com.ljp.demo.service;

import com.ljp.demo.entity.Upclock;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 打卡(Upclock)表服务接口
 *
 * @author makejava
 * @since 2023-03-25 16:38:10
 */
public interface UpclockService {


    //插入打卡
    void insertclock(Upclock upclock);
    //查询打卡
    List<Upclock> selectname(@Param("username") String username);
}
