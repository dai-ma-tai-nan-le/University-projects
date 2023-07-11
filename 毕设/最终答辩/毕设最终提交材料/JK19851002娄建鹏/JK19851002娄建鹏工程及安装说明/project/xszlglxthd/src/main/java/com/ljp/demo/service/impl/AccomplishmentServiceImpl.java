package com.ljp.demo.service.impl;

import com.ljp.demo.entity.Accomplishment;
import com.ljp.demo.dao.AccomplishmentDao;
import com.ljp.demo.service.AccomplishmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 成就(Accomplishment)表服务实现类
 *
 * @author makejava
 * @since 2023-04-26 16:53:14
 */
@Service("accomplishmentService")
public class AccomplishmentServiceImpl implements AccomplishmentService {
    @Resource
    private AccomplishmentDao accomplishmentDao;

    //查询该用户有没有这个成就
    @Override
    public List<Accomplishment> selectCj(@Param("username")String username,@Param("name") String name) {
        return accomplishmentDao.selectCj(username,name);
    }
    //添加成就
    @Override
    public void insertCj(Accomplishment accomplishment) {
        accomplishment.setCreateTime(new Date());
        accomplishmentDao.insertCj(accomplishment);
    }



    //查询该用户的成就
    @Override
    public List<Accomplishment> selectAllcj(@Param("username")String username) {
        return accomplishmentDao.selectAllcj(username);
    }
}
