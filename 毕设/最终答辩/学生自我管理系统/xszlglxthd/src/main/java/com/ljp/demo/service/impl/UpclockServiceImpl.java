package com.ljp.demo.service.impl;

import com.ljp.demo.entity.Upclock;
import com.ljp.demo.dao.UpclockDao;
import com.ljp.demo.service.UpclockService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 打卡(Upclock)表服务实现类
 *
 * @author makejava
 * @since 2023-03-25 16:38:10
 */
@Service("upclockService")
public class UpclockServiceImpl implements UpclockService {
    @Resource
    private UpclockDao upclockDao;

//插入打卡
    @Override
    public void insertclock(Upclock upclock) {
        upclockDao.insertclock(upclock);
    }
    //查询打卡
    @Override
    public List<Upclock> selectname(@Param("username") String username) {
        return upclockDao.selectname(username);
    }
}
